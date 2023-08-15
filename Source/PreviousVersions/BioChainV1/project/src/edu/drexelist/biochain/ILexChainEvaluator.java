package edu.drexelist.biochain;

import java.util.List;
import java.util.Properties;

public interface ILexChainEvaluator 
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    
    //  ------------------------------------------------------- Properties

    //  ------------------------------------------------------- Public Methods
	public void evaluate(LexChainTermList[] lexChainSummary,
			             LexChainTermList[] lexChainFullText,
                         List sentencesSummary,
                         List sentencesFullText,
                         Properties parameters);
	    
    //  ------------------------------------------------------- Private Methods    

}
