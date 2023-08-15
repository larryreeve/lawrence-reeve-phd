/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.List;

public class CandidatePhrase
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    private Integer             phraseId  = Integer.MIN_VALUE;
    private double              score     = Double.MIN_VALUE;
    private List<Integer>       wordIds   = new ArrayList<Integer>();

    
    public CandidatePhrase(Integer phraseId)
    {
        this(phraseId, null);
    }

    public CandidatePhrase(Integer phraseId, List<Integer> wordIds)
    {
        this.phraseId = phraseId;
        
        if (wordIds != null)
            this.wordIds.addAll(wordIds);
    }
    
    public Integer getPhraseId()
    {
        return phraseId;
    }

    public void setPhraseId(Integer phraseId)
    {
        this.phraseId = phraseId;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    public List<Integer> getWordIds()
    {
        return this.wordIds;
    }

    public void addWordId(Integer wordId)
    {
        this.wordIds.add(wordId);
    }

    public void addWordIds(List<Integer> list)
    {
        this.wordIds.addAll(list);
    }
}
