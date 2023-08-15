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
import java.util.TreeMap;

import bioannotator.tables.PhraseIdToWordIdsTable;
import bioannotator.tables.VariantsTable;
import bioannotator.tables.WordIdToPhraseIdsTable;
import bioannotator.tables.WordToWordIdTable;
import biocommon.util.string.StringUtility;
import biocommon.util.words.StopWordManager;
import biocommon.util.words.WordSplitter;

public class CandidatePhraseListGenerator
{
    @SuppressWarnings("unused")
    private static final String          COPYRIGHT     = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, Integer> m_stopWordIds = new TreeMap<Integer, Integer>();
    

    static
    {
        m_stopWordIds.clear();
        
        List<String> stopWords = StopWordManager.getStopWordList();
        
        for (String stopWord : stopWords)
        {
            Integer wordId = WordToWordIdTable.getWordId(stopWord);
            
            if (wordId >= 0)
                m_stopWordIds.put(wordId, null);
        }
    }
    
    public static List<SourcePhraseWord> getSourcePhraseWords(String phrase)
    {
        if (phrase == null || phrase.length() == 0)
            return new ArrayList<SourcePhraseWord>();
        
        List<String> words = WordSplitter.splitWithoutStopWords(phrase);
        //List<String> words = WordSplitter.splitWithStopWords(StringUtility.normalizeToKey(phrase));
        
        Map<Integer, SourcePhraseWord> wordIds = new HashMap<Integer, SourcePhraseWord>(words.size());
        List<SourcePhraseWord> sourcePhraseWords = new ArrayList<SourcePhraseWord>(wordIds.size());
        
        // Find word id of all unique words
        for (String word : words)
        {
            if (!StringUtility.isNumeric(word))
            {
                String wordNormalized = VariantsTable.getBaseWordInflected(word);
            
                //System.out.println("word='" + word + "', norm='" + wordNormalized + "'");
            
                if (WordToWordIdTable.wordExists(wordNormalized))
                {
                    Integer wordId = WordToWordIdTable.getWordId(wordNormalized);
            
                    if (wordId >= 0 && !wordIds.containsKey(wordId))
                    {
                        wordIds.put(wordId, null);
                        
                        List<Integer> variantWordsIds = VariantsTable.getBaseWordFullVariants(wordId);
                        
//                        System.out.println(wordNormalized);
//                        for (Integer variantWordsId : variantWordsIds)
//                            System.out.println("\t" + WordToWordIdTable.getWordIdText(variantWordsId));
                        
                        SourcePhraseWord sourcePhraseWordItem = new SourcePhraseWord(wordNormalized, wordId, variantWordsIds);
                        sourcePhraseWords.add(sourcePhraseWordItem);
                    }
                }
            }
        }
        
        return sourcePhraseWords;
   }
    
    public static List<CandidatePhrase> generateSourcePhraseCandidates(List<SourcePhraseWord> sourcePhraseWords)
    {
        Map<Integer, Integer> uniqueCandidatePhraseIds = new HashMap<Integer, Integer>();

        // Build a list of candidate phrases containing at least one of the source phrase words
        for (SourcePhraseWord sourcePhraseWord : sourcePhraseWords)
        {
            //System.out.println("Source word: " + WordToWordIdTable.getWordIdText(sourcePhraseWordId));
            
            //if (!m_stopWordIds.containsKey(sourcePhraseWordId))
            {
                // Base word
                List<Integer> candidatePhrasesForWordId = WordIdToPhraseIdsTable.getPhraseIdsForWordId(sourcePhraseWord.getId());
                for (Integer candidatePhraseId : candidatePhrasesForWordId)
                {
                    //  System.out.println("Base Source word '" + WordToWordIdTable.getWordIdText(sourcePhraseWordId) + "' in candidate phrase " + candidatePhraseId + ":'" + PhraseIdToWordIdsTable.getPhraseText(candidatePhraseId) + "'");
                    
                        if (!uniqueCandidatePhraseIds.containsKey(candidatePhraseId))
                            uniqueCandidatePhraseIds.put(candidatePhraseId, null);
                }
                
                // Variant Words
                List<Integer> variantWordsIds = sourcePhraseWord.getVariantIds();
                for (Integer variantWordId : variantWordsIds)
                {
                    candidatePhrasesForWordId = WordIdToPhraseIdsTable.getPhraseIdsForWordId(variantWordId);
                    for (Integer candidatePhraseId : candidatePhrasesForWordId)
                    {
                        //  System.out.println("Base Source word '" + WordToWordIdTable.getWordIdText(sourcePhraseWordId) + "' in candidate phrase " + candidatePhraseId + ":'" + PhraseIdToWordIdsTable.getPhraseText(candidatePhraseId) + "'");
                        
                            if (!uniqueCandidatePhraseIds.containsKey(candidatePhraseId))
                                uniqueCandidatePhraseIds.put(candidatePhraseId, null);
                    }
                }
            }
        }

        // Build the list of unique phrases
        //System.out.println("Candidate phrase list generator:");        
        List<CandidatePhrase> candidateItemList = new ArrayList<CandidatePhrase>();
        for (Integer candidatePhraseId : uniqueCandidatePhraseIds.keySet())
        {
            List<Integer> candidatePhraseWordIds = PhraseIdToWordIdsTable.getWordIds(candidatePhraseId);
            
            if (candidatePhraseWordIds.size() <= sourcePhraseWords.size())
            {
                //System.out.println("candidate phrase: " + candidatePhraseId + ": " + PhraseIdToWordIdsTable.getPhraseText(candidatePhraseId));
            
                CandidatePhrase candidate = new CandidatePhrase(candidatePhraseId);
        
                candidate.addWordIds(candidatePhraseWordIds);
        
                candidateItemList.add(candidate);
            }
        }
        
        //System.out.println("Candidate list size is " + candidateItemList.size());
        
        return candidateItemList;
    }
}
