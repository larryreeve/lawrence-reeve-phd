/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.perfmon;

/**
 * Implements timer functionality for basic performance monitoring
 * 
 */
public final class StopWatch
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    private long                startTime = 0;
    private long                stopTime  = 0;


    /**
     * @return The elapsed time in ms
     * 
     */
    public long getElapsedTime()
    {
        if (this.startTime > this.stopTime)
            return 0;

        long elapsedTime = (this.stopTime - this.startTime);
        if (elapsedTime < 0)
            elapsedTime = 0;
        
        return elapsedTime; 
    }

    /**
     * @return The elapsed time in seconds
     * 
     */
    public double getElapsedTimeSeconds()
    {
        return this.getElapsedTime() / 1000L;
    }

    public static double convertTimeToSeconds(long timeValue)
    {
        return timeValue / 1000L;
    }

    /**
     * Start the stopwatch.
     * 
     */
    public void start()
    {
        this.startTime = System.currentTimeMillis();
        this.stopTime = 0;
    }

    /**
     * Stop the stopwatch.
     * 
     */
    public void stop()
    {
        this.stopTime = System.currentTimeMillis();
    }
}
