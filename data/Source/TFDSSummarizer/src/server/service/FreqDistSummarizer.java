package server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import server.splitters.SentenceSplitter;
import server.splitters.WordSplitter;
import client.Sentence;



public class FreqDistSummarizer
{
    public static List summarize(String textToSummarize, Integer sourcePctOfSentences)
    {
        if (textToSummarize == null || textToSummarize.length() == 0)
        {
            return new ArrayList();
        }
    
        List sourceSentences = SentenceSplitter.split(textToSummarize);
        
        return FreqDistSummarizer.summarize(sourceSentences, sourcePctOfSentences);
    }
    
    public static List summarize(List sourceSentences, Integer sourcePctOfSentences)
    {
        List summarySentences = new ArrayList();
        
        if (sourceSentences == null || sourceSentences.size() == 0  || 
                sourcePctOfSentences.intValue() < 1 || sourcePctOfSentences.intValue() > 100)
        {
            return summarySentences;
        }
        
        if (sourceSentences.size() == 0)
        {
            summarySentences.add(new Sentence("No sentences were found in the source text", 0, 0));
        }
        else if (sourceSentences.size() == 1)
        {
            summarySentences.add(new Sentence("", 0, 0));
            
            summarySentences.add(sourceSentences.get(0).toString());
        }
        else
        {
            //
            // Initialization
            //

            long startSummaryTime = System.currentTimeMillis();
              
            // Initialize sentence scores and map each sentence to a sentence number
            Map sourceSentenceMap = new HashMap();
            for (int idx=0; idx < sourceSentences.size(); idx++)
            {
                Sentence sourceSentence = (Sentence) sourceSentences.get(idx);
                sourceSentence.setScore(0.0);
                sourceSentenceMap.put(new Integer(idx+1), sourceSentence);
            }
            
            int numSentencesInSummary = (int) Math.ceil((sourceSentenceMap.size() * 1.0) * (sourcePctOfSentences.intValue() / 100.0));

            // Get frequency counts of units in full-source text
            Map sourceSentenceUnitItemsMap = new HashMap();
            Map unitItemCountsSourceText = new HashMap();
            for (int idx=0; idx < sourceSentenceMap.size(); idx++)
            {
                Iterator sourceSentenceMapIt = sourceSentenceMap.keySet().iterator();
                while (sourceSentenceMapIt.hasNext())
                {
                    Integer sentenceNumber = (Integer) sourceSentenceMapIt.next();
                    
                    Sentence sentence = (Sentence) sourceSentenceMap.get(sentenceNumber);
                    
                    List unitItemList = WordSplitter.split(sentence.getSentenceText());
                    if (unitItemList == null)
                        sourceSentenceUnitItemsMap.put(sentenceNumber, new ArrayList());
                    else
                        sourceSentenceUnitItemsMap.put(sentenceNumber, unitItemList);
                    
                    for (int idxUnitItemList=0; idxUnitItemList < unitItemList.size(); idxUnitItemList++)
                    {
                        String unitItemId = (String) unitItemList.get(idxUnitItemList);
                        if (unitItemCountsSourceText.containsKey(unitItemId))
                        {
                            Integer count = (Integer) unitItemCountsSourceText.get(unitItemId);
                            unitItemCountsSourceText.put(unitItemId, new Integer(count.intValue() + 1));
                        }
                        else
                        {
                            unitItemCountsSourceText.put(unitItemId, new Integer(1));
                        }
                    }
                }
            }

        
            //
            // Score sentences
            //
            
            // Duplicate and initialize model summary entries from source text
            Map unitItemCountsSummary = new HashMap();
            Iterator unitItemCountsSourceTextIt = unitItemCountsSourceText.keySet().iterator();
            while (unitItemCountsSourceTextIt.hasNext())
            {
                String unitItemId = (String) unitItemCountsSourceTextIt.next();
                
                unitItemCountsSummary.put(unitItemId, new Integer(0));
            }
            
            // Score each sentence
            int numSentencesSelected = 0;
            int bestSentenceNumber = -1;
            double  bestSentenceScore = 0.0;
            Map unitItemCountsCandidateSummary = new HashMap();
        
            for (int sentenceScoreIdx=sourceSentenceMap.size(); sentenceScoreIdx > 0; sentenceScoreIdx--)
            {
                bestSentenceScore  = 0.0;
                bestSentenceNumber = -1;
                
                Iterator sourceSentenceMapIt = sourceSentenceMap.keySet().iterator();
                while (sourceSentenceMapIt.hasNext())
                {
                    Integer sentenceNumber = (Integer) sourceSentenceMapIt.next();
                
                    Sentence sentence = (Sentence) sourceSentenceMap.get(sentenceNumber);
                    
                    // Skip sentences already scored
                    if (sentence.getScore() > 0.0)
                        continue;
                    
                    // Initialize unit item counts of candidate summary to the current summary
                    unitItemCountsCandidateSummary.clear();
                    Iterator unitItemCountsSummaryIt = unitItemCountsSummary.keySet().iterator();
                    while (unitItemCountsSummaryIt.hasNext())
                    {
                        String unitItemId = (String) unitItemCountsSummaryIt.next();
                        
                        unitItemCountsCandidateSummary.put(unitItemId, unitItemCountsSummary.get(unitItemId));
                    }
                    
                    // Add this sentence to the summary
                    List unitItemList = (List) sourceSentenceUnitItemsMap.get(new Integer(sentence.getSentenceNumber()));
                    Iterator unitItemListIt = unitItemList.iterator();
                    while (unitItemListIt.hasNext())
                    {
                        String unitItemId = (String) unitItemListIt.next();
                        
                        Integer count = (Integer) unitItemCountsCandidateSummary.get(unitItemId);
                        unitItemCountsCandidateSummary.put(unitItemId, new Integer(count.intValue() + 1));
                    }
                    
                    double sentenceScore = 0.0;
                    
                    // Find Dice's coefficient
                    //  Find # of common terms, # of terms in each
                    int numUnitItemsSourceText = 0;
                    int numUnitItemsCandidateSummary = 0;
                    int numUnitItemsCommon = 0;
                    
                    unitItemCountsSourceTextIt = unitItemCountsSourceText.keySet().iterator();
                    while (unitItemCountsSourceTextIt.hasNext())
                    {
                        String unitItemId = (String) unitItemCountsSourceTextIt.next();
                    
                        Integer countSourceText  =  (Integer) unitItemCountsSourceText.get(unitItemId);
                        Integer countCandidateSummary = (Integer) unitItemCountsCandidateSummary.get(unitItemId);
                    
                        if (countSourceText.intValue() > 0)
                            numUnitItemsSourceText++;
    
                        if (countCandidateSummary.intValue() > 0)
                            numUnitItemsCandidateSummary++;
    
                        if (countSourceText.intValue() > 0 && countCandidateSummary .intValue()> 0)
                            numUnitItemsCommon++;
                    }
                    
                    sentenceScore = numUnitItemsCommon * 1.0 / (numUnitItemsSourceText + numUnitItemsCandidateSummary) * 1.0;
    
                    if (sentenceScore > bestSentenceScore)
                    {
                        bestSentenceNumber = sentence.getSentenceNumber();
                        bestSentenceScore = sentenceScore;
                    }
                }
                
                // Update sentence information of best scoring sentence
                //System.out.println("bestSentenceNumber=" + bestSentenceNumber);
                if (bestSentenceNumber >= 0)
                {
                    Sentence sentence = (Sentence) sourceSentenceMap.get(new Integer(bestSentenceNumber));
                    sentence.setScore(sentenceScoreIdx);
                
                    // Update summary with the best sentence
                    Iterator unitItemCountsCandidateSummaryIt = unitItemCountsCandidateSummary.keySet().iterator();
                    {
                        String unitItemId = (String) unitItemCountsCandidateSummaryIt.next();
                        
                        unitItemCountsSummary.put(unitItemId, unitItemCountsCandidateSummary.get(unitItemId));
                    }
                    
                    numSentencesSelected++;
                    if (numSentencesSelected >= numSentencesInSummary)
                        break;
                }
            }        
        
            // Sort all sentences by their score
            List sortedSentences = new ArrayList();
            Iterator sourceSentenceMapIt = sourceSentenceMap.keySet().iterator();
            while (sourceSentenceMapIt.hasNext())
            {
                Integer sentenceNumber = (Integer) sourceSentenceMapIt.next();
            
                Sentence sentence = (Sentence) sourceSentenceMap.get(sentenceNumber);
                
                sortedSentences.add(sentence);
            }
            
            Collections.sort(sortedSentences, 
                    new Comparator() 
                    {
                        public int compare(Object o1, Object o2)
                        {
                            Sentence s1 = (Sentence) o1;
                            Sentence s2 = (Sentence) o2;
                            
                            if (s1.getScore() > s2.getScore())
                                return -1;
                            if (s1.getScore() < s2.getScore())
                                return 1;
                            
                            return 0;
                        }
                    });
            
            long endSummaryTime = System.currentTimeMillis();
            long elapsedSummaryTime = endSummaryTime - startSummaryTime;
            

            //
            // Return highest-scoring sentences
            //

            StringBuffer summarizationInfo = new StringBuffer();

            // Display summary information
            summarizationInfo.append("Summary Generation Information:\n");
            summarizationInfo.append("    There are " + sourceSentences.size() + " source sentences.\n");
            summarizationInfo.append("    There are " + numSentencesInSummary + " summary sentences.\n");
            summarizationInfo.append("    Summary generation time: " + elapsedSummaryTime + " milliseconds.\n");
            summarizationInfo.append("\n\n");
              
            summarizationInfo.append("The following source sentences were selected as summary sentences:\n");
            summarizationInfo.append("  (Bracketed numbers indicate the original source sentence number)\n");
            summarizationInfo.append("\n\n");
            
            summarySentences.add(new Sentence(summarizationInfo.toString(), 0, 0));
            
            // Find requested # of sentences to return
            for (int idx=0; idx < numSentencesInSummary; idx++)
            {
                summarySentences.add((Sentence) sortedSentences.get(idx));
            }
        }        
        
        return summarySentences;
    }
}
