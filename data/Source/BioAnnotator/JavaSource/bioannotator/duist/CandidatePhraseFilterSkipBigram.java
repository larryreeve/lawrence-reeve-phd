/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidatePhraseFilterSkipBigram implements ICandidatePhraseFilter
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
    public String getName()
    {
        return "CandidatePhraseFilterSkipBigram";
    }
    
    public void initialize()
    {
    }
    
    public List<CandidatePhrase> filter(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems)
    {
        if (candidatePhraseItems.size() <= 1)
            return candidatePhraseItems;
        
        if (sourcePhraseWords.size() <= 1)
            return candidatePhraseItems;
        
        List<CandidatePhrase> filteredCandidatePhrases = new ArrayList<CandidatePhrase>();
        
        // Reset scores for candidate phrase
        Double zero = new Double(0.0);
        for (CandidatePhrase candidatePhrase : candidatePhraseItems)
            candidatePhrase.setScore(zero);
        
//        System.out.print("Source phrase: ");
//        for (SourcePhraseWord spw: sourcePhraseWords)
//            System.out.print(spw.getId() + ",");
//        System.out.print("(");
//        for (SourcePhraseWord spw: sourcePhraseWords)
//            System.out.print(spw.getWord() + " ");
//        System.out.print(")");
//        System.out.println();
        
        // Build list of skip-bigrams for source phrase
        int sourceSkipBigramCount = 0;
        Map<String, String> skipbigramSource = new HashMap<String, String>();
        for (int wordIdx=0; wordIdx < sourcePhraseWords.size(); wordIdx++)
        {
            // Source word
            //System.out.println("wordIdx=" + wordIdx + ", sourcePhraseWords.size=" + sourcePhraseWords.size() + ", gapLen=" + gapLen);
            for (int bigramIdx=wordIdx+1; bigramIdx < sourcePhraseWords.size(); bigramIdx++)
            {
                String skipBigram = sourcePhraseWords.get(wordIdx).getId() + "," + sourcePhraseWords.get(bigramIdx).getId();
                //System.out.println("base: " + skipBigram);
//                System.out.println("base: " + WordToWordIdTable.getWordIdText(sourcePhraseWords.get(wordIdx).getId()) + "," + WordToWordIdTable.getWordIdText(sourcePhraseWords.get(bigramIdx).getId()) + "(" + skipBigram + ")");
                skipbigramSource.put(skipBigram, null);
                sourceSkipBigramCount++;
            }
            
            // Source word variants
            List<Integer> variantIds = sourcePhraseWords.get(wordIdx).getVariantIds();
            if (variantIds != null)
            {
                for (int variantWordIdx=0; variantWordIdx < variantIds.size(); variantWordIdx++)
                {
                    for (int bigramIdx=wordIdx+1; bigramIdx < sourcePhraseWords.size(); bigramIdx++)
                    {
                        String skipBigram = variantIds.get(variantWordIdx) + "," + sourcePhraseWords.get(bigramIdx).getId();
                        //System.out.println("base variant: " + skipBigram);
//                        System.out.println("base variant: " + WordToWordIdTable.getWordIdText(variantIds.get(variantWordIdx)) + "," + WordToWordIdTable.getWordIdText(sourcePhraseWords.get(bigramIdx).getId()) + "(" + skipBigram + ")");
                        skipbigramSource.put(skipBigram, null);
                    }
                }
            }
        }
        
//        System.out.println(sourceSkipBigramCount + " skip bigrams:");
//        if (skipbigramSource.size() > 0)
//        {
//            for (String skipBigram : skipbigramSource.keySet())
//            {
//                if (skipBigram == null)
//                    System.out.println("NULL");
//                else
//                    System.out.println(skipBigram);
//            }
//        }
//        System.out.println();

        for (CandidatePhrase candidatePhrase : candidatePhraseItems)
        {
//            System.out.println("candidate phrase: " + WordToWordIdTable.getWordIdsText(candidatePhrase.getWordIds()));
            
            // Get candidate phrase skip-bigram list
            //
            int candidateSkipBigramCount = 0;
            int matchCount = 0;
            if (candidatePhrase.getWordIds().size() > 1)
            {
                for (int wordIdx=0; wordIdx < candidatePhrase.getWordIds().size(); wordIdx++)
                {
                    for (int bigramIdx=wordIdx+1; bigramIdx < candidatePhrase.getWordIds().size(); bigramIdx++)
                    {
                        String skipBigram = candidatePhrase.getWordIds().get(wordIdx) + "," + candidatePhrase.getWordIds().get(bigramIdx);
                        
                        candidateSkipBigramCount++;
                        
                        if (skipbigramSource.containsKey(skipBigram))
                            matchCount++;
//                        System.out.println("candidate base: " + WordToWordIdTable.getWordIdText(candidatePhrase.getWordIds().get(wordIdx)) + "," + WordToWordIdTable.getWordIdText(candidatePhrase.getWordIds().get(bigramIdx)) + "(" + skipBigram + ")");
                    }
                }
            }
            
            // Match source skip bigram list with candidate phrase skip bigram list
            //double recallDenominator = Math.ceil(this.factorial(candidatePhrase.getWordIds().size()) / 4.0);
            double recallDenominator = candidateSkipBigramCount;
            
            //double precisionDenominator = Math.ceil(this.factorial(sourcePhraseWords.size()) / 4.0);
            double precisionDenominator = sourceSkipBigramCount;
                
            double recall = (matchCount * 1.0) / recallDenominator;
            
            double precision = (matchCount * 1.0) / precisionDenominator;
            
            double betasquared = 1.0;
            double fmeasure = (((1+betasquared) * recall) * precision) / (recall + (betasquared * precision));
            
//            System.out.println("recall=" + String.format("%.2f", recall) + ", precision=" +  String.format("%.2f", precision) + ", fmeasure=" +  String.format("%.2f", fmeasure));
            
            candidatePhrase.setScore(recall);
        }
        
        // Prune low scoring candidate phrases
        double totalScore = 0.0;
        double squareSum = 0.0;

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
    
        if (filteredCandidatePhrases.size() == 0)
        {
//            System.out.println("No candidate items generated in skip-bigram filter");
//            //System.out.println("\t'" + WordToWordIdTable.getWordIdsText(sourcePhraseWordIds) + "'");
//            if (candidatePhraseItems.size() == 0)
//                System.out.println("\t(No candidate items passed in)");
//            else
//                System.out.println("\t(" + candidatePhraseItems.size() + " candidate items passed in)");
        }
        else
        {
//        System.out.println("Skip-bigram candidate phrases:");
//        for (CandidatePhrase candidatePhrase : filteredCandidatePhrases)
//        {
//            System.out.println("\t" + WordToWordIdTable.getWordIdsText(candidatePhrase.getWordIds()));
//        }
        }
    
        if (filteredCandidatePhrases.size() >= 1)
            return filteredCandidatePhrases;
        
        return candidatePhraseItems;
    }
    
//    private static int factorial(int n) 
//    {
//        if      (n <  0) 
//            throw new RuntimeException("Underflow error in factorial");
//        else if (n > 10) 
//            throw new RuntimeException("Overflow error in factorial");
//        else if (n == 0) 
//            return 1;
//        else             
//            return n * factorial(n-1);
//    }
}
