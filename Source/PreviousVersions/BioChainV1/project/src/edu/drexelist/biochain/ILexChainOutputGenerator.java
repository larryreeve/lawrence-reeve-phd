/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.util.*;

/**
 * Interface for generating summaries
 * 
 *
 */
public interface ILexChainOutputGenerator 
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    
    //  ------------------------------------------------------- Properties

    //  ------------------------------------------------------- Public Methods
	public void generateOutput(LexChainTermList[] lexChainList,
                               List sentenceList,
                               Properties parameters);
	    
    //  ------------------------------------------------------- Private Methods    
}
