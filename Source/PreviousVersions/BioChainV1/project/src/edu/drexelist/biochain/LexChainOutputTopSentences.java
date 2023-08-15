/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.util.*;

/**
 * Container for lexical term information
 * Term may consist of more than one word
 *
 */
public class LexChainOutputTopSentences implements ILexChainOutputGenerator 
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    
    //  ------------------------------------------------------- Properties

    //  ------------------------------------------------------- Public Methods
    /**
     * Display top sentences
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
        System.out.println("Top Sentences: (" + numStdDeviations + " StdDev)");
        System.out.println("-------------");
        System.out.println();

        it = lexChainListSorted.iterator( );
        while (it.hasNext()) 
        {
        	LexChainTermList lexTermList = (LexChainTermList) it.next();
			
            if (lexTermList.getScore() >= strongChainMinScore) 
            {
            	// Find most frequent concept
            	HashMap termMap = new HashMap();
            	
            	Iterator itMap = lexTermList.getTermList().iterator();
            	while (itMap.hasNext())
            	{
            		LexChainTerm term = (LexChainTerm) itMap.next();
            		
            		if (termMap.containsKey(term.getTerm()))
            		{
            			Integer termCount = (Integer) termMap.get(term.getTerm());
            			termMap.put(term.getTerm(), new Integer(termCount.intValue() + 1));
            		}
            		else
            		{
            			Integer termCount = new Integer(1);
            			termMap.put(term.getTerm(), termCount);
            		}
        		}

            	// Find concept with largest count
            	int maxCount = 0;
        		Iterator itMaxCount = termMap.keySet().iterator();
        		while(itMaxCount.hasNext())
        		{
        			String hashkey = (String) itMaxCount.next();
        			
        			Integer termCount = (Integer) termMap.get(hashkey);
        			
        			//System.out.println(hashkey + "=" + termCount);
        			
        			if (termCount.intValue() > maxCount)
        			{
        				maxCount = termCount.intValue();
        			}
        		}
        		
        		// Display all sentences where concept count is = maxCount
        		System.out.println();
        		System.out.println(lexTermList.getTUI() + "-" + lexTermList.getDescription()); 
        		System.out.println("--------------");
        		Iterator itSentence = termMap.keySet().iterator();
        		while(itSentence.hasNext())
        		{
        			String hashkey = (String) itSentence.next();
        			
        			Integer termCount = (Integer) termMap.get(hashkey);
        			
        			if (termCount.intValue() == maxCount)
        			{
        				// Find the concept in the chain term list and get
        				// its sentence number
        				Iterator itTermList = lexTermList.getTermList().iterator();
                		while(itTermList.hasNext())
                		{
                			LexChainTerm term = (LexChainTerm) itTermList.next();
                			
                			if (term.getTerm().equalsIgnoreCase(hashkey))
                			{
                				System.out.println("Concept: " + term.getTerm() + ", sentence#" + term.getSentenceNumber());
                				System.out.println("Sentence: " + (String) sentenceList.get(term.getSentenceNumber()));
                				System.out.println();
                			}
                		}
        			}
        		}
            }
        }
    }
    

    //  ------------------------------------------------------- Private Methods    
}
