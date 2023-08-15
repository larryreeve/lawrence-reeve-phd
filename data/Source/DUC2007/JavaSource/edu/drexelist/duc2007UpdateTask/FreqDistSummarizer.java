package edu.drexelist.duc2007UpdateTask;

import java.io.*;
import java.util.*;


public class FreqDistSummarizer
{
    public List<Sentence> summarizeText(List<Sentence> sourceSentences,
                                        List<Sentence> initialSummarySentences,
                                        List<Sentence> newSummarySentences,
                                        Map<String, Double>   importantWords)
        throws Exception
    {
        // Build list of sentences: initialize sentence scores, determine # of sentences
        Map<Integer, Sentence> sourceSentenceList = new HashMap<Integer, Sentence>();
        for (Sentence aSentence : sourceSentences)
        {
            aSentence.setScore(0.0);
            sourceSentenceList.put(aSentence.getSentenceNumber(), aSentence);		
        }
        
        // Get list of unit items in each sentence
        Map<Integer, List<String>> sentenceUnitItems = new HashMap<Integer, List<String>>();
        for (Integer sentenceNumber : sourceSentenceList.keySet())
        {
            Sentence aSentence = sourceSentenceList.get(sentenceNumber);
			
            List<String> unitItemList = aSentence.getWords();
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
        if (initialSummarySentences != null)
        {
            for (Sentence aSentence : initialSummarySentences)
            {
                List<String> unitItemList = aSentence.getWords();
    			
                for (String unitItem : unitItemList)
                {
                    if (unitItemCountsSummary.containsKey(unitItem))
                    {
                        Integer count = unitItemCountsSummary.get(unitItem);
                        count++;
                        unitItemCountsSummary.put(unitItem, count);
                    }
                    else
                    {
                    	unitItemCountsSummary.put(unitItem, new Integer(1));
                    }
                }
            }
        }
		
        // Score each sentence
        Integer bestSentenceNumber = new Integer(-1);
        Double  bestSentenceScore = 0.0;
        Map<String, Integer> unitItemCountsCandidateSummary = new HashMap<String, Integer>();
        int totalWordCount = 0;
        int passCount = 1;
        
        //System.out.println("New round of scoring");
        while ((totalWordCount < 80) && (passCount != 3))
        {
	        for (int sentenceScoreIdx=sourceSentenceList.size(); sentenceScoreIdx > 0; sentenceScoreIdx--)
	        {
	            bestSentenceScore = 0.0;
	            bestSentenceNumber = -1;
				
	            for (Integer sentenceNumber : sourceSentenceList.keySet())
	            {
	                Sentence aSentence = sourceSentenceList.get(sentenceNumber);
					
	                // Skip sentences already scored
	                if (aSentence.getScore() != 0.0)
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
					
	                // Find Dice's coefficient
	                //	Find # of common terms, # of terms in each
	                int numUnitItemsSourceText = 0;
	                int numUnitItemsCandidateSummary = 0;
	                int numUnitItemsCommon = 0;
	                double importantWordsScore = 0.0;
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
	                
	                importantWordsScore = 1.0;
	                if (passCount == 1)
	                {
		                if (importantWords != null)
		                {
		                	importantWordsScore = 0.0;
		                	
		                	for (String sentenceWord : aSentence.getWords())
		                	{
		                		if (importantWords.containsKey(sentenceWord))
		                		{
		                			importantWordsScore += importantWords.get(sentenceWord);
		                		}
		                	}
		                
		                	importantWordsScore /= (aSentence.getWords().size() * 1.0);
		                }
	                }
	                
	                if (importantWordsScore >= 0.10)
	                {
	                	//System.out.println("[" + aSentence.getSentenceNumber() + "] has important words (" + importantWordsScore + ")");
	                	sentenceScore = numUnitItemsCommon * 1.0 / (numUnitItemsSourceText + numUnitItemsCandidateSummary) * 1.0;
	                	
	                    // 
	                    //System.out.println("[" + aSentence.getSentenceNumber() + "] score=" + sentenceScore + ", importantWordsScore=" + importantWordsScore + ", shorter score=" + (sentenceScore / aSentence.getWordCount()));
	                    
	                    //Favor shorter sentences with more info
	                    //sentenceScore += importantWordsScore;
	                    
	                    // Adjust score based on sentence length
	                    //sentenceScore /= aSentence.getWordCount();
	                }
	                else
	                {
	                	//System.out.println("[" + aSentence.getSentenceNumber() + "] has NO important words");
	                	sentenceScore = -1.0;
	                }
	                //System.out.println("sentenceScore=" + sentenceScore);
					
	                if ((sentenceScore > bestSentenceScore) && ((totalWordCount + aSentence.getWordCount()) <= 100))
	                {
	                    bestSentenceNumber = aSentence.getSentenceNumber();
	                    bestSentenceScore = sentenceScore;
	                }
	            }
				
	            // Update sentence information of best scoring sentence
	            //System.out.println("bestSentenceNumber=" + bestSentenceNumber);
	            if (bestSentenceNumber >= 0)
	            {
	                Sentence aSentence = sourceSentenceList.get(bestSentenceNumber);
	                aSentence.setScore(sentenceScoreIdx);
				
	                // Update summary with the best sentence
	                for (String unitItemId : unitItemCountsCandidateSummary.keySet())
	                    unitItemCountsSummary.put(unitItemId, unitItemCountsCandidateSummary.get(unitItemId));
	                newSummarySentences.add(aSentence);
	                
	                totalWordCount += aSentence.getWordCount();
	                
	                if (totalWordCount >= 100)
	                    break;
	            }
	        }
	        
        	passCount++;
        }        

        SentenceComparatorBySentenceNumber sentenceComparatorBySentenceNumber = new SentenceComparatorBySentenceNumber();
        Collections.sort(newSummarySentences, sentenceComparatorBySentenceNumber);
        
        return newSummarySentences;
    }
}