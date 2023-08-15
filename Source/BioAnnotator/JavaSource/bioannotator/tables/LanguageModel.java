/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageModel
{
    @SuppressWarnings("unused")
    private static final String             COPYRIGHT     = biocommon.copyright.Copyright.COPYRIGHT;

    private Map<Integer, LanguageModelItem> languageModel = new HashMap<Integer, LanguageModelItem>();
    

    public void addEntry(Integer itemId)
    {
        this.addEntry(itemId, 1);
    }
    
    public void addEntry(Integer itemId, Integer frequency)
    {
        if (this.languageModel.containsKey(itemId))
        {
            LanguageModelItem item = this.languageModel.get(itemId);
            item.incrementFrequency(frequency.intValue());
        }
        else
        {
            LanguageModelItem item = new LanguageModelItem(itemId.intValue(), frequency.intValue());
            this.languageModel.put(itemId, item);
        }
    }
    
    public void addEntry(Integer itemId, LanguageModelItem item)
    {
        this.languageModel.put(itemId, item);
    }
    
    public void clear()
    {
        this.languageModel.clear();
    }
    
    public int getTotalItemCount()
    {
        return this.languageModel.size();
    }
    
    public List<LanguageModelItem> getItems()
    {
        List<LanguageModelItem> itemList = new ArrayList<LanguageModelItem>(this.languageModel.size());
        
        if (this.languageModel.size() == 0)
            return itemList;
        
        for (LanguageModelItem lmItem : this.languageModel.values())
            itemList.add(lmItem);
        
        return itemList;
    }
    
    public int getItemFrequency(Integer itemId)
    {
        if (!this.languageModel.containsKey(itemId))
            return 0;
            
        LanguageModelItem item = this.languageModel.get(itemId);
        
        return item.getFrequency();
    }

    public double getItemProbability(Integer itemId)
    {
        if (!this.languageModel.containsKey(itemId))
            return 0.0;
            
        LanguageModelItem item = this.languageModel.get(itemId);
        
        return item.getProbability();
    }
    
    public void updateItemProbabilities()
    {
        // Get total frequency
        int totalFrequency = 0;
        for (LanguageModelItem item : this.languageModel.values())
            totalFrequency += item.getFrequency();

        // Update probability
        for (LanguageModelItem item : this.languageModel.values())
            item.setProbability(item.getFrequency() * 1.0 / totalFrequency * 1.0);
    }
}
