/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.tables;

public class VariantWord
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    private Integer             wordId    = Integer.MIN_VALUE;
    private Integer             distance  = 1;
    

    public VariantWord(Integer wordId, Integer distance)
    {
        this.wordId = wordId;
        this.distance = distance;
    }
    
    public Integer getDistance()
    {
        return this.distance;
    }
    
    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }
    
    public Integer getWordId()
    {
        return this.wordId;
    }
    
    public void setWordId(Integer wordId)
    {
        this.wordId = wordId;
    }
}
