/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

import java.util.*;

public class ChainCompareByScore
	implements Comparator<ConceptChain>
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT     = biocommon.copyright.Copyright.COPYRIGHT;

    private boolean             ascendingFlag = true;
	

    public ChainCompareByScore()
	{
		this(true);
	}
	
	public ChainCompareByScore(boolean ascendingFlag)
	{
		this.ascendingFlag = ascendingFlag;
	}
	
    public int compare(ConceptChain chain1,
    				   ConceptChain chain2) 
    {
    	int result = 0;
    	
    	if (chain1.getScore() > chain2.getScore())
    		result = 1;
    	else if (chain1.getScore() < chain2.getScore())
    		result = (-1);
    	else
    		result = 0;
    	
    	if (!this.ascendingFlag)
    		result *= (-1);
    	
    	return result;
    }
}
