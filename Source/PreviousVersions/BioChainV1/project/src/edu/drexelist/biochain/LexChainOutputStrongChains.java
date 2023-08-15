/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.text.*;
import java.util.*;

/**
 * Container for lexical term information
 * Term may consist of more than one word
 *
 */
public class LexChainOutputStrongChains implements ILexChainOutputGenerator 
{
    //  ------------------------------------------------------- Public Methods
    /**
     * Display TUIs sorted in ascending order by score
     *
     */
    public void generateOutput(
        LexChainTermList[] lexChainList,
        List sentenceList,
        Properties parameters)
    {
        int numStdDeviations = Integer.parseInt(parameters.getProperty("StdDev", "2"));
        
    	List lexChainListSorted = Arrays.asList(lexChainList);
    	Collections.sort(lexChainListSorted, Collections.reverseOrder());

       
        // Calculate average score
        double totalScore = 0.0;
        double squareSum = 0.0;
        int numEntries = 0;
        Iterator it = lexChainListSorted.iterator( );
        while (it.hasNext()) 
        {
        	LexChainTermList lexTermList = (LexChainTermList) it.next();
			
        	if (lexTermList.getTermList().size() > 0)
        	{
        		numEntries++;
        		totalScore += lexTermList.getScore();
        		squareSum += (lexTermList.getScore() * lexTermList.getScore());
        	}
        }

        double averageScore = totalScore / numEntries;
        double stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
        double strongChainMinScore = (averageScore + (numStdDeviations * stdDev));

        // Display strong chains
        DecimalFormat formatter = new DecimalFormat("#0.00");
        System.out.println("Strong chains: (" + numStdDeviations + " StdDev)");
        System.out.println("-------------");
        System.out.println("\tAvg score:    " + formatter.format(averageScore));
        System.out.println("\tStd Dev:      " + formatter.format(stdDev));
        System.out.println("\tStrong Score: " + formatter.format(strongChainMinScore));
        System.out.println();

        it = lexChainListSorted.iterator( );
        while (it.hasNext()) 
        {
        	LexChainTermList lexTermList = (LexChainTermList) it.next();
			
            if (lexTermList.getScore() >= strongChainMinScore) 
            {
            	System.out.println();
                System.out.println("\tChain " + lexTermList.getTUI() + "-" + lexTermList.getDescription() + ": score=" + formatter.format(lexTermList.getScore()));
                
                List conceptList = lexTermList.getTermList();
                
                if (conceptList != null)
                {
                	// Build list of concept frequencies
                	Map conceptFrequencies = new HashMap();
                	for (int idx=1; idx < conceptList.size(); idx++) 
    				{
    					LexChainTerm term = (LexChainTerm) conceptList.get(idx);
    					if (!conceptFrequencies.containsKey(term.getTerm()))
						{
    						conceptFrequencies.put(term.getTerm(), new Integer(1));
						}
    					else
    					{
    						int count = ((Integer) conceptFrequencies.get(term.getTerm())).intValue();
    						conceptFrequencies.put(term.getTerm(), new Integer(count+1));
    					}
    				}
                	
                	// Display all concepts and their frequencies
                	for (Object key : conceptFrequencies.keySet())
                	{
                		String conceptName = (String) key;
                		
                		Integer count = (Integer) conceptFrequencies.get(conceptName);
                		
                		System.out.println("\t\tConcept " + conceptName + ", count=" + count);
                	}
                }
            }
        }
    }
}
