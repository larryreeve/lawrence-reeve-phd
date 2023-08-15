/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator;

import biocommon.perfmon.StopWatch;

public class AnnotationTimer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;

    private long      phraseTimeMin       = Long.MAX_VALUE;
    private long      phraseTimeMax       = Long.MIN_VALUE;
    private long      phraseTimeTotal     = 0;
    private int       numPhrases          = 0;
    private StopWatch phraseWatch         = new StopWatch();
    private StopWatch initializationWatch = new StopWatch();
    

    public void initializationStartClock()
    {
        this.initializationWatch.start();
    }

    public void initializationEndClock()
    {
        this.initializationWatch.stop();
    }
    
    public void phraseStartClock()
    {
        this.phraseWatch.start();
    }

    public void phraseEndClock()
    {
        this.phraseWatch.stop();
        
        long elapsedTime = this.phraseWatch.getElapsedTime();
        
        this.phraseTimeTotal += elapsedTime;
        this.numPhrases++;
        
        if (elapsedTime > this.phraseTimeMax)
            this.phraseTimeMax = elapsedTime;
        
        if (elapsedTime < this.phraseTimeMin)
            this.phraseTimeMin = elapsedTime;
    }
    
    public long getInitializationTime()
    {
        return this.initializationWatch.getElapsedTime();
    }

    public int getPhraseCount()
    {
        return this.numPhrases;
    }

    public long getPhraseTimeTotal()
    {
        return this.phraseTimeTotal;
    }

    public double getPhraseTimeAvg()
    {
        if (this.numPhrases <= 0)
            return 0;
        
        return (double) ((double) this.phraseTimeTotal)  / ((double) (this.numPhrases * 1.0));
    }
    
    public long getPhraseTimeMin()
    {
        if (this.phraseTimeMin == Long.MAX_VALUE)
            return 0;
        
        return this.phraseTimeMin;
    }

    public long getPhraseTimeMax()
    {
        if (this.phraseTimeMax == Long.MIN_VALUE)
            return 0;
        
        return this.phraseTimeMax;
    }
    
    public long getTotalTime()
    {
        return this.initializationWatch.getElapsedTime() + this.phraseTimeTotal;
    }
}
