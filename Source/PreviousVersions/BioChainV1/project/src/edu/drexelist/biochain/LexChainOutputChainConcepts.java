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
public class LexChainOutputChainConcepts 
	implements ILexChainOutputGenerator 
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    
    //  ------------------------------------------------------- Properties

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

        System.out.println("Chains:");
        System.out.println("------");
        for (int idx=0; idx < lexChainList.length; idx++) 
        {
            if (lexChainList[idx] != null) 
            {
                List lexList = lexChainList[idx].getTermList();
        		
                if (lexList.size() > 0) 
                {
                    System.out.println(lexChainList[idx].getTUI() + " - " + lexChainList[idx].getDescription() + ": " + lexChainList[idx].getScore());
        			
                    for (int termIdx=0; termIdx < lexList.size(); termIdx++) 
                    {
                        LexChainTerm term = (LexChainTerm) lexList.get(termIdx);
                        System.out.println("\tphrase: " + term.getPhrase());
                        System.out.println("\t\tconcept: " + term.getTerm());
                        System.out.println("\t\tsentence#" + term.getSentenceNumber());
                        System.out.println("\t\tsection#" + term.getSectionNumber());
                        System.out.println();
                    }
        	
                    System.out.println();
                }
            }
        }
    }
    

    //  ------------------------------------------------------- Private Methods    
}
