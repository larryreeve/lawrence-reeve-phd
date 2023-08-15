/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.output;

import java.io.*;
import java.text.*;
import java.util.*;

import biocommon.document.*;
import biosumm.chain.*;


public class OutputStrongChains
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		// Get parameters
		int numStdDeviations = Integer.parseInt(parameters.getProperty("stddev", "2"));
		
		// Make copy of chain list to sort in ascending order by score
		List<ConceptChain> tempChainList = new ArrayList<ConceptChain>();
		for (ConceptChain chain : conceptChainList)
			tempChainList.add(chain);
		Collections.sort(tempChainList, new ChainCompareByScore(false));
		
        // Calculate average score
        double 	totalScore = 0.0;
        double 	squareSum = 0.0;
        int 	numEntries = 0;
        
		for (ConceptChain chain : tempChainList)
		{
        	if (chain.getConceptList().size() > 0)
        	{
        		numEntries++;
        		totalScore += chain.getScore();
        		squareSum  += (chain.getScore() * chain.getScore());
        	}
        }

        double averageScore = totalScore / numEntries;
        double stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
        double strongChainMinScore = (averageScore + (numStdDeviations * stdDev));
		
        // Display strong chains
        DecimalFormat formatter = new DecimalFormat("#0.00");
        writer.println("Strong chains: (" + numStdDeviations + " StdDev)");
        writer.println("-------------");
        writer.println("\tAvg score:    " + formatter.format(averageScore));
        writer.println("\tStd Dev:      " + formatter.format(stdDev));
        writer.println("\tStrong Score: " + formatter.format(strongChainMinScore));
        writer.println();

		for (ConceptChain chain : tempChainList)
		{
            if (chain.getScore() >= strongChainMinScore) 
            {
            	writer.println("\t" + chain.getId() + "-" + chain.getDescription() + ": " + formatter.format(chain.getScore()));				
            }
        }
	}
}
