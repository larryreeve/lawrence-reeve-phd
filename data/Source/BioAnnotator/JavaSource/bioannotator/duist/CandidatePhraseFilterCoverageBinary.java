/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.List;

import bioannotator.tables.PhraseIdToWordIdsTable;
import bioannotator.tables.WordToWordIdTable;

public class CandidatePhraseFilterCoverageBinary implements ICandidatePhraseFilter
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
    public String getName()
    {
        return "CandidatePhraseFilterCoverageBinary";
    }
    
    public void initialize()
    {
    }

    public List<CandidatePhrase> filter(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems)
    {
        List<CandidatePhrase> filteredCandidatePhrases = new ArrayList<CandidatePhrase>();
        
        // Get score of source phrase
        double sourcePhraseScore = sourcePhraseWords.size();
        
        // Reset scores for candidate phrase
        for (CandidatePhrase candidatePhrase : candidatePhraseItems)
            candidatePhrase.setScore(Double.valueOf(0.0));
        
        // Score each candidate phrase item
        for (CandidatePhrase candidatePhrase : candidatePhraseItems)
        {
            double candidatePhraseScore = 0.0;

            for (SourcePhraseWord sourcePhraseWord : sourcePhraseWords)
            {
                List<Integer> candidatePhraseWordIds = candidatePhrase.getWordIds();
                for (Integer candidatePhraseWordId : candidatePhraseWordIds)
                {
                    if (candidatePhraseWordId.compareTo(sourcePhraseWord.getId()) == 0)
                    {
                        if (candidatePhraseWordIds.size() == 1)
                            candidatePhraseScore += Double.MAX_VALUE;
                        else
                            candidatePhraseScore += 1.0;
                    }
                }
            }
            
            candidatePhrase.setScore(Double.valueOf((candidatePhraseScore)));
        }
        
        // Find exact matches
        boolean foundExactMatches = false;
        List<Integer> sourcePhraseWordIds = new ArrayList<Integer>();
        for (SourcePhraseWord sourcePhraseWord : sourcePhraseWords)
            sourcePhraseWordIds.add(sourcePhraseWord.getId());
        
        for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
        {
            double candidatePhraseScore = candidatePhraseItem.getScore();
            
            if (Double.compare(candidatePhraseScore, sourcePhraseScore) == 0)
            {
                if (PhraseIdToWordIdsTable.isExactMatch(sourcePhraseWordIds, candidatePhraseItem.getWordIds()))
                {
                    foundExactMatches = true; 
                    filteredCandidatePhrases.add(candidatePhraseItem);
                }
            }
        }
        
        if (!foundExactMatches)
        {
            //System.out.println("Exact phrase match not found");
            
            double totalScore = 0.0;
            double squareSum  = 0.0;
    
            for (CandidatePhrase candidateItem : candidatePhraseItems)
            {
                double score = candidateItem.getScore();
                totalScore += score;
                squareSum += (score * score);
            }
    
            double averageScore = totalScore / candidatePhraseItems.size();
            double stdDev = Math.sqrt(squareSum / candidatePhraseItems.size() - averageScore * averageScore);
            double minScore = (averageScore + (2 * stdDev));
    
            for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
            {
                if (candidatePhraseItem.getScore() >= minScore)
                    filteredCandidatePhrases.add(candidatePhraseItem);
            }
    
            double highScore = Double.MIN_VALUE;
            if (filteredCandidatePhrases.size() == 0)
            {
                // Find highest scoring candidate phrase and select it
                for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
                {
                    double score = candidatePhraseItem.getScore();
    
                    if (score >= highScore)
                        highScore = score;
                }
    
                // Find all candidates with high score
                minScore = highScore;
                for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
                {
                    if (candidatePhraseItem.getScore() >= minScore)
                        filteredCandidatePhrases.add(candidatePhraseItem);
                }
            }
        }
        else
        {
            System.out.println("Found exact match");
        }
        
        if (filteredCandidatePhrases.size() == 0)
        {
            System.out.println("No candidate items generated in Binary filter");
            //System.out.println("\t'" + WordToWordIdTable.getWordIdsText(sourcePhraseWordIds) + "'");
            if (candidatePhraseItems.size() == 0)
                System.out.println("\t(No candidate items passed in)");
            else
                System.out.println("\t(" + candidatePhraseItems.size() + " candidate items passed in)");
        }
        else
        {
//            System.out.println("IPF candidate phrases:");
//            for (CandidatePhrase candidatePhrase : filteredCandidatePhrases)
//            {
//                System.out.println("\t" + WordToWordIdTable.getWordIdsText(candidatePhrase.getWordIds()));
//            }
        }
        
        return filteredCandidatePhrases;
    }
    
    
//    private boolean isExactMatch(List<Integer> sourcePhraseWordIds, List<Integer> candidatePhraseWordIds)
//    {
//        if (sourcePhraseWordIds.size() == candidatePhraseWordIds.size())
//        {
//            for (int idxSource=0; idxSource < sourcePhraseWordIds.size(); idxSource++)
//            {
//                boolean foundWordMatch = false;
//                Integer sourcePhraseWordId = sourcePhraseWordIds.get(idxSource);
//                for (int idxCandidate=0; idxCandidate < sourcePhraseWordIds.size(); idxCandidate++)
//                {
//                    Integer candidatePhraseWordId = candidatePhraseWordIds.get(idxCandidate);
//                    if (sourcePhraseWordId.compareTo(candidatePhraseWordId) == 0)
//                    {
//                        foundWordMatch = true;
//                        break;
//                    }
//                }
//                
//                if (!foundWordMatch)
//                    return false;
//            }
//            
//            return true;
//        }
//        
//        return false;
//    }
    
}
