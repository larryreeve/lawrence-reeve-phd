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
public class LexChainOutputTopChains implements ILexChainOutputGenerator 
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
    	List lexChainListSorted = Arrays.asList(lexChainList);
    	Collections.sort(lexChainListSorted, Collections.reverseOrder());

        System.out.println("Top chains:");
        System.out.println("----------");

        Iterator it = lexChainListSorted.iterator();
        while (it.hasNext()) 
        {
        	LexChainTermList lexTermList = (LexChainTermList) it.next();

            if (lexTermList.getScore() > 0)
                System.out.println("\t" + lexTermList.getTUI() + "-" + lexTermList.getDescription() + ", score: " + lexTermList.getScore());
        }
    }
    

    //  ------------------------------------------------------- Private Methods    
}
