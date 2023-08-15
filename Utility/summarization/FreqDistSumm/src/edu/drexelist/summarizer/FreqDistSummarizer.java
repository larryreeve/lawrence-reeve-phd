package edu.drexelist.summarizer;

import java.io.*;
import java.util.*;


public class FreqDistSummarizer
{
    private enum ESimilarityFunction
    {
        COSINE,
        DICE,
        EUCLIDEAN,
        UNITFREQUENCY,
        VECTORSUBTRACTION
    }
    
    private ESimilarityFunction getSimilarityFunction(String similarityFunctionName)
    {
        if (similarityFunctionName == null || similarityFunctionName.length() == 0)
            return ESimilarityFunction.DICE;
            
        String similarityFunctionNameNormalized = similarityFunctionName.trim().toLowerCase();
        
        if (similarityFunctionNameNormalized.equalsIgnoreCase("cosine"))
            return ESimilarityFunction.COSINE;
        else if (similarityFunctionNameNormalized.equalsIgnoreCase("dice"))
            return ESimilarityFunction.DICE;
        else if (similarityFunctionNameNormalized.equalsIgnoreCase("euclidean"))
            return ESimilarityFunction.EUCLIDEAN;
        else if (similarityFunctionNameNormalized.equalsIgnoreCase("unitfrequency"))
            return ESimilarityFunction.UNITFREQUENCY;
        else if (similarityFunctionNameNormalized.equalsIgnoreCase("vectorsubtraction"))
            return ESimilarityFunction.VECTORSUBTRACTION;
            
        return ESimilarityFunction.DICE;
    }
    
    public List<Sentence> summarizeText(String textToSummarize, double compressionRatio)      
        throws Exception
    {
        ESimilarityFunction similarityFunction = getSimilarityFunction("DICE");
        
        List<Sentence> fulltextSentences = SentenceSplitter.splitTextIntoSentences(textToSummarize);
        
        List<Sentence> summarySentences = new ArrayList<Sentence>();
        
        // Determine # of sentences to extract
        int numberOfSentences = 0;
        if (compressionRatio < 1)
        {
            numberOfSentences = ((int) (fulltextSentences.size() * compressionRatio));
            if (numberOfSentences < 1)
                numberOfSentences = 1;
        }
        else
        {
            numberOfSentences = (int) compressionRatio;
        }
        
        
        // Build list of sentences: initialize sentence scores, determine # of sentences
        Map<Integer, Sentence> sentenceList = new HashMap<Integer, Sentence>();
        for (Sentence aSentence : fulltextSentences)
        {
            aSentence.setScore(0.0);
            sentenceList.put(aSentence.getSentenceNumber(), aSentence);		
        }
        
        // Get list of unit items in each sentence
        Map<Integer, ArrayList<String>> sentenceUnitItems = new HashMap<Integer, ArrayList<String>>();
        for (Integer sentenceNumber : sentenceList.keySet())
        {
            Sentence aSentence = sentenceList.get(sentenceNumber);
			
            ArrayList<String> unitItemList = (ArrayList<String>) WordSplitter.splitWithStopWords(aSentence.getSentenceText().toLowerCase());
            //for (String word : unitItemList)
            //    System.out.println(word);
            
            sentenceUnitItems.put(new Integer(aSentence.getSentenceNumber()), unitItemList);
        }
        
        // Get frequency counts of units in full-source text
        Map<String, Integer> unitItemCountsSourceText = new HashMap<String, Integer>();
        for (Integer sentenceNumber : sentenceUnitItems.keySet())
        {
            List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
			
            for (String unitItem : unitItemList)
            {
                if (unitItemCountsSourceText.containsKey(unitItem))
                {
                    Integer count = unitItemCountsSourceText.get(unitItem);
                    count++;
                    unitItemCountsSourceText.put(unitItem, count);
                }
                else
                {
                    unitItemCountsSourceText.put(unitItem, new Integer(1));
                }
            }
        }

        //
        // Score sentences
        //
		
        // Duplicate and initialize model summary entries from source text
        Map<String, Integer> unitItemCountsSummary = new HashMap<String, Integer>();
        for (String unitItem : unitItemCountsSourceText.keySet())
            unitItemCountsSummary.put(unitItem, new Integer(0));
		
        // Score each sentence
        Integer bestSentenceNumber = new Integer(-1);
        Double  bestSentenceScore = 0.0;
        Map<String, Integer> unitItemCountsCandidateSummary = new HashMap<String, Integer>();
        
        for (int sentenceScoreIdx=sentenceList.size(); sentenceScoreIdx > 0; sentenceScoreIdx--)
        {
            bestSentenceScore = 0.0;
            bestSentenceNumber = -1;
			
            for (Integer sentenceNumber : sentenceList.keySet())
            {
                Sentence aSentence = sentenceList.get(sentenceNumber);
				
                // Skip sentences already scored
                if (aSentence.getScore() > 0.0)
                    continue;
				
                // Initialize unit item counts of candidate summary to the current summary
                unitItemCountsCandidateSummary.clear();
                for (String unitItemId : unitItemCountsSummary.keySet())
                    unitItemCountsCandidateSummary.put(unitItemId, unitItemCountsSummary.get(unitItemId));
				
                // Add this sentence to the summary
                List<String> unitItemList = sentenceUnitItems.get(sentenceNumber);
                for (String unitItemId : unitItemList)
                {
                    Integer count = unitItemCountsCandidateSummary.get(unitItemId);
                    count++;
                    unitItemCountsCandidateSummary.put(unitItemId, count);
                }
								
                //
                // Evaluate candidate summary and full-text for concept distribution
                //
				
                Double sentenceScore = 0.0;
				
                if (similarityFunction == ESimilarityFunction.COSINE)
                {
                    // Cosine similarity
                    int numerator = 0;
                    int denom1 = 0;
                    int denom2 = 0;
                    for (String unitItemId : unitItemCountsSourceText.keySet())
                    {
                        Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
                        Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
                        denom1 += Math.pow(countSourceText, 2);
                        denom2 += Math.pow(countCandidateSummary, 2);
						
                        numerator += (countSourceText * countCandidateSummary);
                    }
					
                    Double denominator = Math.sqrt(denom1 * denom2);
					
                    sentenceScore = (numerator * 1.0) / denominator;
                }
                else if (similarityFunction == ESimilarityFunction.DICE)
                {
                    // Find Dice's coefficient
                    //	Find # of common terms, # of terms in each
                    int numUnitItemsSourceText = 0;
                    int numUnitItemsCandidateSummary = 0;
                    int numUnitItemsCommon = 0;
                    for (String unitItemId : unitItemCountsSourceText.keySet())
                    {
                        Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
                        Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
					
                        if (countSourceText > 0)
                            numUnitItemsSourceText++;

                        if (countCandidateSummary > 0)
                            numUnitItemsCandidateSummary++;

                        if (countSourceText > 0 && countCandidateSummary > 0)
                            numUnitItemsCommon++;
                    }
					
                    sentenceScore = numUnitItemsCommon * 1.0 / (numUnitItemsSourceText + numUnitItemsCandidateSummary) * 1.0;
                }
                else if (similarityFunction == ESimilarityFunction.EUCLIDEAN)
                {
                    // 	Find Euclidean distance between summary and full-text unit item vectors
                    for (String unitItemId : unitItemCountsSourceText.keySet())
                    {
                        Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
                        Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
					
                        sentenceScore += Math.pow((countCandidateSummary - countSourceText) * 1.0, 2);
                    }
                    sentenceScore = Math.sqrt(sentenceScore);
                }
                else if (similarityFunction == ESimilarityFunction.UNITFREQUENCY)
                {
                    // Method#4 in IR paper
                    for (String unitItemId : unitItemCountsSourceText.keySet())
                    {
                        Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
                        Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
                        sentenceScore += countCandidateSummary * countSourceText;
                    }
                }
                else if (similarityFunction == ESimilarityFunction.VECTORSUBTRACTION)
                {
                    // Vector subtraction
                    for (String unitItemId : unitItemCountsSourceText.keySet())
                    {
                        Integer countSourceText  = unitItemCountsSourceText.get(unitItemId);
                        Integer countCandidateSummary = unitItemCountsCandidateSummary.get(unitItemId);
						
                        sentenceScore += Math.abs(countSourceText - countCandidateSummary);
                    }
                }
                else
                {
                    throw new Exception("No similarity function defined");
                }
				
                //System.out.println("sentenceScore=" + sentenceScore);
				

                if (sentenceScore > bestSentenceScore)
                {
                    bestSentenceNumber = aSentence.getSentenceNumber();
                    bestSentenceScore = sentenceScore;
                }
            }
			
            // Update sentence information of best scoring sentence
            //System.out.println("bestSentenceNumber=" + bestSentenceNumber);
            if (bestSentenceNumber >= 0)
            {
                Sentence aSentence = sentenceList.get(bestSentenceNumber);
                aSentence.setScore(sentenceScoreIdx);
			
                // Update summary with the best sentence
                for (String unitItemId : unitItemCountsCandidateSummary.keySet())
                    unitItemCountsSummary.put(unitItemId, unitItemCountsCandidateSummary.get(unitItemId));
                summarySentences.add(aSentence);
                
                if (summarySentences.size() >= numberOfSentences)
                    break;
            }
        }
        
//        SentenceComparatorByScore sentenceComparatorByScore = new SentenceComparatorByScore();
//        Collections.sort(fulltextSentences, sentenceComparatorByScore);
//        
//        for (int idx=0; idx < numberOfSentences; idx++)
//        {
//            summarySentences.add(fulltextSentences.get(idx));
//        } 
//        
        SentenceComparatorBySentenceNumber sentenceComparatorBySentenceNumber = new SentenceComparatorBySentenceNumber();
        Collections.sort(summarySentences, sentenceComparatorBySentenceNumber);
        
        return summarySentences;
    }

    public List<Sentence> summarizeFile(String filename, Double compressionRatio)  
        throws Exception    
    {
        
        File fulltextFile = new File(filename);
        
        StringBuffer sbText = new StringBuffer();
        
        if (fulltextFile.exists())
        {
            String line = null;
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null)
            {
                sbText.append(line);
            }
            reader.close();            
        }
        
        return summarizeText(sbText.toString(), compressionRatio);
    }
    
    
    public static void main(String args[])
    {
        if (args.length != 2)
        {
            System.err.println("Requires 2 parameters: <filename to summarizer> <compression ratio>");
            System.err.println("\tCompression ratio can be < 1 for percentage, or >= greater 1 for number of sentences");
        }
        
        FreqDistSummarizer summarizer = new FreqDistSummarizer();
        
        try
        {
            List<Sentence> sentences = summarizer.summarizeFile(args[0], Double.parseDouble(args[1]));
        
            System.out.println("Summary has " + sentences.size() + " sentences:");
            for (Sentence aSentence : sentences)
            {
                System.out.println("Sentence#" + aSentence.getSentenceNumber() + ": " + aSentence.getSentenceText());
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
            
    }
}
