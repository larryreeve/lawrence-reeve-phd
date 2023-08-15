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
public class LexChainOutputSummary implements ILexChainOutputGenerator 
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
    	ArrayList sentenceNumbers = new ArrayList();
		double compressionRate = (double) (Integer.parseInt(parameters.getProperty("compression", "100")) / 100.0);

		int numSentencesMax = (int) (sentenceList.size() * compressionRate);
		if ((sentenceList.size() * compressionRate) - Math.floor((sentenceList.size() * compressionRate)) > 0.0)
			numSentencesMax++;
		if (numSentencesMax < 1)
			numSentencesMax = 1;

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

        // Find strong sentences to display
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
        		
        		// Find all sentences where concept count is = maxCount
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
                				if (term.getSentenceNumber() >= 0 && term.getSentenceNumber() < sentenceList.size())
                				{
                					if (!sentenceNumbers.contains(Integer.valueOf(term.getSentenceNumber())))
                						sentenceNumbers.add((Object) new Integer(term.getSentenceNumber()));
                				}
                			}
                		}
        			}
        		}
            }
        }

        // Find sentences to display to fill out remainder of compression rate sentences 
        it = lexChainListSorted.iterator( );
        while (it.hasNext() && (sentenceNumbers.size() < numSentencesMax)) 
        {
        	LexChainTermList lexTermList = (LexChainTermList) it.next();
			
        	Iterator itMap = lexTermList.getTermList().iterator();
        	while (itMap.hasNext() && (sentenceNumbers.size() < numSentencesMax))
        	{
        		LexChainTerm term = (LexChainTerm) itMap.next();
            		
				if (!sentenceNumbers.contains(Integer.valueOf(term.getSentenceNumber())))
				{
					if (term.getSentenceNumber() >= 0 && term.getSentenceNumber() < sentenceList.size())
						sentenceNumbers.add((Object) new Integer(term.getSentenceNumber()));
				}
            }
        }

		// Sort the sentences in order of appearance
		if (numSentencesMax > sentenceNumbers.size())
			numSentencesMax = sentenceNumbers.size();
		Collections.sort(sentenceNumbers);

		// Display summary
        System.out.println("Summary (" + numStdDeviations + " StdDev, Compression=" + compressionRate + "," + numSentencesMax + " of " + sentenceList.size() + ")");
        System.out.println("-------------");
        System.out.println();
		
        for (int idx=0; idx < numSentencesMax; idx++)
        {
        	int sentenceNumber = ((Integer) sentenceNumbers.get(idx)).intValue();
        	
        	
        	if (sentenceNumber >= 0 && sentenceNumber < sentenceList.size())
        	{
        		//System.out.println("Sentence# " + sentenceNumber + ":" + (String) sentenceList.get(sentenceNumber));
        		System.out.println(idx + ") " + (String) sentenceList.get(sentenceNumber));
        	}
        	else
        	{
        		System.out.println(idx + ") Unexpected sentence #" + sentenceNumber);        		
        	}
        }
    }
    

    //  ------------------------------------------------------- Private Methods    
}
