/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import bioannotator.tables.ConceptLMUnigramTable;
import bioannotator.tables.LanguageModel;
import bioannotator.tables.PhraseIdToConceptIdsTable;

public class ConceptMapperUnigramLM implements IConceptMapper
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
    public String getName()
    {
        return "ConceptMapperUnigramLM";
    }
    
    public void initialize()
    {
    }

    public List<Integer> map(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems)
    {
        final double ZERO  = Double.valueOf(0.0);
        final double ONE   = Double.valueOf(1.0);
        final double LAMDA = Double.valueOf(0.5);
        
        List<Integer> mappedConceptIds = new ArrayList<Integer>();
        Map<Integer, CandidateConcept> candidateConcepts = new TreeMap<Integer, CandidateConcept>();
        LanguageModel collectionLanguageModel = ConceptLMUnigramTable.getCollectionLM();
        
        // Initialize candidate phrase scores
        for (CandidatePhrase candidatePhraseItem :  candidatePhraseItems)
            candidatePhraseItem.setScore(ZERO);
        
        // Find exact one-word matches between candidate phrase and source phrase
        if (sourcePhraseWords.size() == 1)
        {
            int sourcePhraseWordId = sourcePhraseWords.get(0).getId();
            
            for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
            {
                List<Integer> candidatePhraseWordIds = candidatePhraseItem.getWordIds();
                
                if (candidatePhraseWordIds.size() == 1)
                {
                    if (candidatePhraseWordIds.get(0).compareTo(sourcePhraseWordId) == 0)
                      candidatePhraseItem.setScore(ONE);
              }
            }
        }
        
//        for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
//        {
//            for (Integer sourcePhraseWordId : candidatePhraseItem.getWordIds())
//            {
//                List<Integer> candidatePhraseWordIds = candidatePhraseItem.getWordIds();
//                if (candidatePhraseWordIds.size() == 1)
//                {
//                    if (candidatePhraseWordIds.get(0).compareTo(sourcePhraseWordId) == 0)
//                        candidatePhraseItem.setScore(ONE);
//                }
//            }
//        }
        
        // Build list of candidate concepts
        for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
        {
            List<Integer> conceptIds = PhraseIdToConceptIdsTable.getConceptIds(candidatePhraseItem.getPhraseId());
            
            for (Integer conceptId : conceptIds)
            {
                if (!candidateConcepts.containsKey(conceptId))
                {
                    CandidateConcept candidateConceptItem = new CandidateConcept(conceptId);
                    candidateConceptItem.setScore(candidatePhraseItem.getScore());
                    candidateConcepts.put(conceptId, candidateConceptItem);
                }
                else
                {
                    CandidateConcept candidateConceptItem = candidateConcepts.get(conceptId);
                    candidateConceptItem.setScore(candidateConceptItem.getScore() + candidatePhraseItem.getScore());
                }
            }
        }
        
        //System.out.println("# candidate concepts: " + candidateConcepts.size());
        
        // Score each candidate concept
        for (CandidateConcept candidateConceptItem : candidateConcepts.values())
        {
            double candidateConceptScore = 0.0;
            
            LanguageModel conceptLanguageModel = ConceptLMUnigramTable.getConceptLM(candidateConceptItem.getConceptId());

            for (SourcePhraseWord sourcePhraseWord : sourcePhraseWords)
            {
//                System.out.println("wordId: " + wordId);
//                System.out.println("\tphraseLMProb: " + conceptLanguageModel.getItemProbability(wordId));
//                System.out.println("\tcollectionLMProb: " + collectionLanguageModel.getItemProbability(wordId));
                
                List<Integer> sourcePhraseWordIds = new ArrayList<Integer>(sourcePhraseWord.getVariantIds().size());
                for (Integer wordId : sourcePhraseWord.getVariantIds())
                    sourcePhraseWordIds.add(wordId);
                sourcePhraseWordIds.add(sourcePhraseWord.getId());
                
                double totalWordScore = 0.0;
                for (Integer wordId : sourcePhraseWordIds)
                {
                    double wordScore  = ((LAMDA * conceptLanguageModel.getItemProbability(wordId)) + 
                                         ((1.0 - LAMDA) * collectionLanguageModel.getItemProbability(wordId)));
                    
                    totalWordScore += wordScore;
                }
                
                if (totalWordScore > 0.0)
                {
                    if (candidateConceptScore > 0.0)
                        candidateConceptScore *= totalWordScore;
                    else
                        candidateConceptScore = totalWordScore;
                }
                
//                System.out.println("\twordScore=" + wordScore + ", candidateConceptScore=" + candidateConceptScore);
            }
            
            candidateConceptItem.setScore(candidateConceptItem.getScore() + candidateConceptScore);
            
//            System.out.println("candidate concept #" + candidateConceptItem.getConceptId() + ", score: " + candidateConceptItem.getScore());            
        }
        
        // Select the top concepts
        List<CandidateConcept> candidateConceptsSorted = new ArrayList<CandidateConcept>();
        for (CandidateConcept candidateConceptItem : candidateConcepts.values())
            candidateConceptsSorted.add(candidateConceptItem);

        Collections.sort(candidateConceptsSorted, 
                new Comparator<CandidateConcept>() 
                {
                    public int compare(CandidateConcept o1, CandidateConcept o2) 
                    {
                        return o2.getScore().compareTo(o1.getScore());
                    }
                });
        
        // See if there are any exact matches between source phrase words and candidate phrase words
        
        //System.out.println("LM candidate concepts:");
        for (CandidateConcept candidateConceptItem : candidateConceptsSorted)
        {
            mappedConceptIds.add(candidateConceptItem.getConceptId());
            
            //System.out.println("score: " + String.format("%.12f", candidateConceptItem.getScore()) + ", conceptId:" + candidateConceptItem.getConceptId() + "(" + ConceptIdToConceptNameTable.getConceptName(candidateConceptItem.getConceptId()) + ")");
           
            if (mappedConceptIds.size() >= 1)
                break;
        }
       
//        System.out.println();
//        System.out.println("Mapped Concepts:");
//        
        // Find highest scoring candidate concept and select it
//        double highScore = Double.MIN_VALUE; 
//        for (CandidateConcept candidateConceptItem : candidateConcepts.values())
//        {
//            double score = candidateConceptItem.getScore();
//
//            if (score > highScore)
//                highScore = score;
//        }
        
        //System.out.println("high score: " + highScore);

        // Find all candidates with high score
//        Double highScoreValue = new Double(highScore);
//        for (CandidateConcept candidateConceptItem : candidateConcepts.values())
//        {
//            if (candidateConceptItem.getScore().compareTo(highScoreValue) >= 0)
//            {
//                //System.out.println("score: " + String.format("%.12f", candidateConceptItem.getScore()) + ", conceptId:" + candidateConceptItem.getConceptId() + "(" + ConceptIdToConceptNameTable.getConceptName(candidateConceptItem.getConceptId()) + ")");
//                mappedConceptIds.add(candidateConceptItem.getConceptId());
//            }
//        }

        return mappedConceptIds;
    }
}
