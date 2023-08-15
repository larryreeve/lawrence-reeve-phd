package edu.drexelist.biochain;

import java.text.*;
import java.util.*;

public class LexChainEvaluatorStandardForAri
	implements ILexChainEvaluator
{
    //  ------------------------------------------------------- Public Methods
	public void evaluate(
			LexChainTermList[] lexChainAbstract,
            LexChainTermList[] lexChainFullText,
            List sentencesAbstract,
            List sentencesFullText,
            Properties parameters)
	{
		double 		averageScore = 0.0;
		ArrayList	strongChainsFullText = new ArrayList();
		ArrayList	strongChainsAbstract = new ArrayList();
		int			numEntries = 0;
		int 		numStdDeviations = Integer.parseInt(parameters.getProperty("StdDev", "2"));
		double 		squareSum = 0.0;
		double 		stdDev = 0.0;
		double 		strongChainMinScore = 0.0;
		double		totalScore = 0.0;
		ArrayList	chainsWithNoConceptsInAbstract = new ArrayList();


		//
		// Get list of Abstract strong chains
        //
		// 	Calculate average score
		totalScore = 0.0;
		squareSum = 0.0;
		numEntries = 0;
		for (int idx=0; idx < lexChainAbstract.length; idx++)
		{
			if (lexChainAbstract[idx].getTermList().size() > 0)
			{
				numEntries++;
				totalScore += lexChainAbstract[idx].getScore();
				squareSum += (lexChainAbstract[idx].getScore() * lexChainAbstract[idx].getScore());
			}
		}

		averageScore = totalScore / numEntries;
		stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
		strongChainMinScore = (averageScore + (numStdDeviations * stdDev));

		for (int idx=0; idx < lexChainAbstract.length; idx++)
		{
			if (lexChainAbstract[idx].getScore() >= strongChainMinScore)
			{
				strongChainsAbstract.add(new Integer(idx));
			}
		}

		//
		// Get list of full-text strong chains
        //
		// Calculate average score
		totalScore = 0.0;
		squareSum = 0.0;
		numEntries = 0;
		for (int idx=0; idx < lexChainFullText.length; idx++)
		{
			if (lexChainFullText[idx].getTermList().size() > 0)
			{
				numEntries++;
				totalScore += lexChainFullText[idx].getScore();
				squareSum += (lexChainFullText[idx].getScore() * lexChainFullText[idx].getScore());
			}
		}

		averageScore = totalScore / numEntries;
		stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
		strongChainMinScore = (averageScore + (numStdDeviations * stdDev));

		for (int idx=0; idx < lexChainFullText.length; idx++)
		{
			if (lexChainFullText[idx].getScore() >= strongChainMinScore)
			{
				strongChainsFullText.add(new Integer(idx));
			}
		}


		//
		// Build list of strong concepts from Abstract
		//
		Hashtable AbstractConceptsStrong = new Hashtable();
        for (int idx=0; idx < strongChainsAbstract.size(); idx++)
		//for (int idx=0; idx < lexChainAbstract.length; idx++)
		
        {
        	int chainIndex = ((Integer) strongChainsAbstract.get(idx)).intValue();
			//int chainIndex = idx;
        	
        	// See if chain has this Abstract concept
			if (lexChainAbstract[chainIndex] != null)
			{
				List lexList = lexChainAbstract[chainIndex].getTermList();
				for (int termIdx=0; termIdx < lexList.size(); termIdx++) 
				{
					LexChainTerm term = (LexChainTerm) lexList.get(termIdx);
                
					String concept = term.getTerm().toLowerCase() + ":" + lexChainAbstract[chainIndex].getTUI();
					//String concept = term.getTerm().toLowerCase();
					//System.out.println("AbstractConcept=" + concept);
                
					AbstractConceptsStrong.put(concept, "");
				}
			}
        }
        

		//
		// Build list of all concepts from Abstract
		//
		Hashtable AbstractConceptsAll = new Hashtable();
		for (int idx=0; idx < lexChainAbstract.length; idx++)
        {
        	// See if chain has this Abstract concept
			if (lexChainAbstract[idx] != null)
			{
				if (lexChainAbstract[idx].getScore() > 0.0)
				{
					List lexList = lexChainAbstract[idx].getTermList();
					for (int termIdx=0; termIdx < lexList.size(); termIdx++) 
					{
						LexChainTerm term = (LexChainTerm) lexList.get(termIdx);
                
						String concept = term.getTerm().toLowerCase() + ":" + lexChainAbstract[idx].getTUI();
						//String concept = term.getTerm().toLowerCase();
						//System.out.println("AbstractConcept=" + concept);
                
						AbstractConceptsAll.put(concept, "");
					}
				}
			}
        }

        
        //
        // Recall: Number of strong chains in Full-text with concepts from Abstract
        //
		Hashtable chainsWithNoConceptsFromAbstract = new Hashtable();
        int strongChainsWithAbstractConceptsCount = 0;
        double lexchainRecall = 0.0;
        for (int idx=0; idx < strongChainsFullText.size(); idx++)
        {
        	int chainIndex = ((Integer) strongChainsFullText.get(idx)).intValue();
        	
        	// See if chain has any Abstract concepts
        	boolean conceptFound = false;
    		List lexList = lexChainFullText[chainIndex].getTermList();
            for (int termIdx=0; termIdx < lexList.size() && !conceptFound; termIdx++) 
            {
                LexChainTerm term = (LexChainTerm) lexList.get(termIdx);

                String concept = term.getTerm().toLowerCase() + ":" + lexChainFullText[chainIndex].getTUI();
                //String concept = term.getTerm().toLowerCase();
                //System.out.println("FullTextConcept1=" + concept);
                
                if (AbstractConceptsAll.containsKey(concept))
                {
                	conceptFound = true;
                	break;
                }
            }
            
            if (conceptFound)
            {
            	strongChainsWithAbstractConceptsCount++;
            }
            else
            {
            	if (!chainsWithNoConceptsFromAbstract.containsKey(new Integer(chainIndex)))
            		chainsWithNoConceptsFromAbstract.put(new Integer(chainIndex), new Integer(chainIndex));
            	
            	System.out.println("\tRecall: Chain with no concepts from Abstract: " + lexChainFullText[chainIndex].getTUI() + "-" + lexChainFullText[chainIndex].getDescription() + "(idx=" + chainIndex + ")");
            }
        }
        lexchainRecall = (strongChainsWithAbstractConceptsCount * 1.0) / strongChainsFullText.size(); 
        
        
        //
        // Precision: Number of Abstract concepts having strong chains in full-text
        //
        List abstractConceptsWithNoStrongChains = new ArrayList();
        int AbstractConceptsWithStrongChains = 0;
        double lexchainPrecision = 0.0;
        for (Enumeration e = AbstractConceptsStrong.keys(); e.hasMoreElements();)
        {
        	String AbstractConcept = (String) e.nextElement();
        	//System.out.println();
        	//System.out.println("AbstractConcept2=" + AbstractConcept);
        	
        	boolean conceptFound = false;
            for (int idx=0; idx < strongChainsFullText.size() && !conceptFound; idx++)
            {
            	
            	int chainIndex = ((Integer) strongChainsFullText.get(idx)).intValue();
            	
            	// See if chain has this Abstract concept
        		List lexList = lexChainFullText[chainIndex].getTermList();
                for (int termIdx=0; termIdx < lexList.size() && !conceptFound; termIdx++) 
                {
                    LexChainTerm term = (LexChainTerm) lexList.get(termIdx);

                    String chainConcept = term.getTerm().toLowerCase() + ":" + lexChainFullText[chainIndex].getTUI();
                    //String chainConcept = term.getTerm().toLowerCase();
                    //System.out.println("FullTextConcept2=" + chainConcept);
                    
                    if (AbstractConcept.equalsIgnoreCase(chainConcept))
                    {
                    	//System.out.println("Match: " + idx + ": suM:" + AbstractConcept + ", chain:" + chainConcept);
                    	conceptFound = true;
                    }
                }
            }
            
            if (conceptFound)
            {
            	AbstractConceptsWithStrongChains++;
            }
            else
            {
            	abstractConceptsWithNoStrongChains.add(AbstractConcept);
            	//System.out.println("\tAbstract concept " + AbstractConcept + " has no match with any strong chain");            	
            }
        }
        lexchainPrecision = (AbstractConceptsWithStrongChains * 1.0) / AbstractConceptsStrong.size();

        
        System.out.println();
        System.out.println("Concepts in abstract:");
        System.out.println("--------------------");
        for (Object key : AbstractConceptsStrong.keySet())
        {
        	String conceptName = (String) key;
        	
        	System.out.println("\t" + conceptName);
        }

        System.out.println();
        System.out.println("Concepts in abstract with no match in full-text strong chains:");
        System.out.println("-------------------------------------------------------------");
        if (abstractConceptsWithNoStrongChains.size() == 0)
        {
        	System.out.println("\tNone");
        }
        else
        {
	        for (Object concept : abstractConceptsWithNoStrongChains)
	        {
	        	System.out.println("\t" + concept.toString());	
	        }
        }
        
        //
        // Display evaluation
        //
        DecimalFormat formatter = new DecimalFormat("#0.00");

        System.out.println();
        System.out.println();
        System.out.println("Evaluation:");
        System.out.println("-----------");
        System.out.println("\tNumber of strong chains in Full-text: " + strongChainsFullText.size());
        System.out.println("\tNumber of concepts in Abstract: " + AbstractConceptsStrong.size());
        System.out.println();
        System.out.println("\tNumber of strong chains in Full-text with concepts from Abstract: " + strongChainsWithAbstractConceptsCount);
        System.out.println("\t  Recall: " + formatter.format(lexchainRecall));
        System.out.println();
        System.out.println("\tNumber of Abstract concepts having strong chains in full-text: " + AbstractConceptsWithStrongChains);
        System.out.println("\t  Precision: " + formatter.format(lexchainPrecision));
        System.out.println();
        System.out.println();
	}
}
