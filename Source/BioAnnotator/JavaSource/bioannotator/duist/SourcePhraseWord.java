/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.duist;

import java.util.ArrayList;
import java.util.List;

public class SourcePhraseWord
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT  = biocommon.copyright.Copyright.COPYRIGHT;

    private String              word       = "";
    private Integer             id         = Integer.MIN_VALUE;
    private List<Integer>       variantIds = new ArrayList<Integer>();
    

    public SourcePhraseWord(String word, Integer id, List<Integer> variantIds)
    {
        this.word = word;
        this.id = id;
        this.variantIds = variantIds;
    }
    
    public Integer getId()
    {
        return this.id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getWord()
    {
        return this.word;
    }
    
    public void setWord(String word)
    {
        this.word = word;
    }
    
    public void addVariantId(Integer id)
    {
        this.variantIds.add(id);
    }
    
    public List<Integer> getVariantIds()
    {
        return this.variantIds;
    }
}
