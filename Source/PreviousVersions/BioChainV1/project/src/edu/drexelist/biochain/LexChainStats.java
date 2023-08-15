/*
 * 
 *
 *
 */
package edu.drexelist.biochain;


/**
 * Stores stats about lexical chaining performance
 *
 */
public final class LexChainStats {

	//  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Varibles
	private StopWatch chainingStopWatch = new StopWatch();
	private StopWatch mmtxStopWatch = new StopWatch();
    
    //  ------------------------------------------------------- Properties
	/**
	  * @return The chaining processing time
	  *
	  */
	public StopWatch ChainingProcessTime() {
		return this.chainingStopWatch;
	}
	
	/**
	  * @return The MMTx processing time
	  *
	  */
	public StopWatch MMTxProcessTime() {
		return this.mmtxStopWatch;
	}


	
    //  ------------------------------------------------------- Public Methods

	//  ------------------------------------------------------- Private Methods    
}
