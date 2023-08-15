/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.tables;

public class LanguageModelItem
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT   = biocommon.copyright.Copyright.COPYRIGHT;

    private int                 wordId      = 0;
    private int                 frequency   = 0;
    private double              probability = 0.0;


    public LanguageModelItem(int wordId, int frequency)
    {
        this(wordId, frequency, 0.00);
    }

    public LanguageModelItem(int wordId, int frequency, double probability)
    {
        this.wordId = wordId;
        this.frequency = frequency;
        this.probability = probability;
    }
    
    public int getFrequency()
    {
        return this.frequency;
    }

    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    public double getProbability()
    {
        return this.probability;
    }

    public void setProbability(double probability)
    {
        this.probability = probability;
    }

    public int getWordId()
    {
        return this.wordId;
    }

    public void setWordId(int wordId)
    {
        this.wordId = wordId;
    }

    public void incrementFrequency()
    {
        this.incrementFrequency(1);
    }

    public void incrementFrequency(int value)
    {
        this.frequency += value;
    }
}
