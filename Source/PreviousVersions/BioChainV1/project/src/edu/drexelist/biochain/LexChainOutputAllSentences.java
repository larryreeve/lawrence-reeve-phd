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
public class LexChainOutputAllSentences implements ILexChainOutputGenerator 
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
        ArrayList semanticTypes = new ArrayList();
        for (int idx=0; idx < lexChainList.length; idx++) 
        {
            if (lexChainList[idx] != null) 
            {
                List lexList = lexChainList[idx].getTermList();
        		
                if (lexList.size() > 0) 
                {
                    semanticTypes.add(new SemanticType(lexChainList[idx].getTUI(), lexChainList[idx].getDescription(), lexChainList[idx].getScore()));
                }
            }
        }

        Collections.sort(semanticTypes);

//        System.out.println("All sentences:");
//        System.out.println("-------------");
//        Iterator it = semanticTypes.iterator( );
//        while (it.hasNext()) 
//        {
//            SemanticType sem = (SemanticType) it.next();
//			
//            if (sem.getScore() > 0)
//            {
//                System.out.println(sem.getTUI() + "-" + sem.getDescription() + ": " + sem.getScore());
//                
//				// Find the concept in the chain term list and get
//				// its sentence number
//				Iterator itTermList = sem. lexTermList.getTermList().iterator();
//        		while(itTermList.hasNext())
//        		{
//        			LexChainTerm term = (LexChainTerm) itTermList.next();
//        			
//        			if (term.getTerm().equalsIgnoreCase(hashkey))
//        			{
//        				System.out.println("Concept: " + term.getTerm() + ", sentence#" + term.getSentenceNumber());
//        				System.out.println("Sentence: " + (String) sentenceList.get(term.getSentenceNumber()));
//        				System.out.println();
//        			}
//        		}
//                
//            }
//        }
    }
    

    //  ------------------------------------------------------- Private Methods    
}
