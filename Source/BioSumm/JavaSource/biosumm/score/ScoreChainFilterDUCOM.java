/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.score;

import java.util.*;

import biocommon.document.Document;
import biosumm.chain.*;


public class ScoreChainFilterDUCOM
	implements IScorer
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;
    

    public void score(List<ConceptChain> 	conceptChainList,
					  Document 				annotatedDocument,
					  Properties 			parameters)
		throws Exception
	{
		for (ConceptChain chain : conceptChainList)
		{
			String chainId = chain.getId();
			
			if (!chainId.equalsIgnoreCase("T037") && // Injury or Poisoning
			    !chainId.equalsIgnoreCase("T051") && // Event
			    !chainId.equalsIgnoreCase("T052") && // Activity
			    !chainId.equalsIgnoreCase("T061") && // Therapeutic or Preventative Procedure
			    !chainId.equalsIgnoreCase("T062") && // Research Activity
			    !chainId.equalsIgnoreCase("T067") && // Phenomena or Process
			    !chainId.equalsIgnoreCase("T081") && // Quantitative Concept
			    !chainId.equalsIgnoreCase("T169") && // Functional Concept
			    !chainId.equalsIgnoreCase("T170") && // Intellectual Product
			    !chainId.equalsIgnoreCase("T191"))   // Neoplastic Process
				
				chain.setFiltered(true);
		}
	}
}
