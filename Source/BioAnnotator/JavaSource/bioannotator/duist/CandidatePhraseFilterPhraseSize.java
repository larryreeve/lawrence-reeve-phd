/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.List;

public class CandidatePhraseFilterPhraseSize implements ICandidatePhraseFilter
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
    public String getName()
    {
        return "CandidatePhraseFilterPhraseSize";
    }
    
    public void initialize()
    {
    }

    public List<CandidatePhrase> filter(List<SourcePhraseWord> sourcePhraseWords, List<CandidatePhrase> candidatePhraseItems)
    {
        List<CandidatePhrase> filteredCandidatePhrases = new ArrayList<CandidatePhrase>();
        
        int maxPhraseSize = sourcePhraseWords.size() * 1;
        
        // Score each candidate item
        for (CandidatePhrase candidatePhraseItem : candidatePhraseItems)
        {
            if (candidatePhraseItem.getWordIds().size() <= maxPhraseSize)
                filteredCandidatePhrases.add(candidatePhraseItem);
        }
        return filteredCandidatePhrases;
    }
}
