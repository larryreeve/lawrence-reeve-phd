/*
 * 
 *
 *
 */
package edu.drexelist.biochain;


/**
 * Implements lexical chaining using MetaMap Transfer
 *
 */
public final class StopWatch 
{

	//  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Varibles
	private long startTime = 0;
	private long stopTime = 0;
    
    //  ------------------------------------------------------- Properties
	/**
	  * @return The elapsed time in ms
	  *
	  */
	public long getElapsedTime() 
	{
		if (this.startTime > this.stopTime)
			return 0;
		
		return (this.stopTime - this.startTime);
	}

	/**
	  * @return The elapsed time in seconds
	  *
	  */
	public double getElapsedTimeSeconds() 
	{
		return this.getElapsedTime() / 1000L;
	}

	
    //  ------------------------------------------------------- Public Methods
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

	//  ------------------------------------------------------- Private Methods    
}
