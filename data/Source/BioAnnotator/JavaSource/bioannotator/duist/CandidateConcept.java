/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

public class CandidateConcept
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    private Integer             conceptId = Integer.MIN_VALUE;
    private Double              score     = Double.MIN_VALUE;

    public CandidateConcept(Integer phraseId)
    {
        this.conceptId = phraseId;
    }

    public Integer getConceptId()
    {
        return conceptId;
    }

    public void setConceptId(Integer phraseId)
    {
        this.conceptId = phraseId;
    }

    public Double getScore()
    {
        return score;
    }

    public void setScore(Double score)
    {
        this.score = score;
    }
}
