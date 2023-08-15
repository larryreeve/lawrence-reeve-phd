package edu.drexelist.biochain;

import java.text.*;
import java.util.*;

public class LexChainEvaluatorStandard
	implements ILexChainEvaluator
{
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Variables
    
    //  ------------------------------------------------------- Properties

    //  ------------------------------------------------------- Public Methods
	public void evaluate(
			LexChainTermList[] lexChainSummary,
            LexChainTermList[] lexChainFullText,
            List sentencesSummary,
            List sentencesFullText,
            Properties parameters)
	{
		double 		averageScore = 0.0;
		ArrayList	strongChainsFullText = new ArrayList();
		ArrayList	strongChainsSummary = new ArrayList();
		int			numEntries = 0;
		int 		numStdDeviations = Integer.parseInt(parameters.getProperty("StdDev", "2"));
		double 		squareSum = 0.0;
		double 		stdDev = 0.0;
		double 		strongChainMinScore = 0.0;
		double		totalScore = 0.0;


		//
		// Get list of summary strong chains
        //
		// 	Calculate average score
		totalScore = 0.0;
		squareSum = 0.0;
		numEntries = 0;
		for (int idx=0; idx < lexChainSummary.length; idx++)
		{
			if (lexChainSummary[idx].getTermList().size() > 0)
			{
				numEntries++;
				totalScore += lexChainSummary[idx].getScore();
				squareSum += (lexChainSummary[idx].getScore() * lexChainSummary[idx].getScore());
			}
		}

		averageScore = totalScore / numEntries;
		stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
		strongChainMinScore = (averageScore + (numStdDeviations * stdDev));

		for (int idx=0; idx < lexChainSummary.length; idx++)
		{
			if (lexChainSummary[idx].getScore() >= strongChainMinScore)
			{
				strongChainsSummary.add(new Integer(idx));
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
		// Build list of strong concepts from summary
		//
		Hashtable summaryConceptsStrong = new Hashtable();
        for (int idx=0; idx < strongChainsSummary.size(); idx++)
		//for (int idx=0; idx < lexChainSummary.length; idx++)
		
        {
        	int chainIndex = ((Integer) strongChainsSummary.get(idx)).intValue();
			//int chainIndex = idx;
        	
        	// See if chain has this summary concept
			if (lexChainSummary[chainIndex] != null)
			{
				List lexList = lexChainSummary[chainIndex].getTermList();
				for (int termIdx=0; termIdx < lexList.size(); termIdx++) 
				{
					LexChainTerm term = (LexChainTerm) lexList.get(termIdx);
                
					String concept = term.getTerm().toLowerCase() + ":" + lexChainSummary[chainIndex].getTUI();
					//String concept = term.getTerm().toLowerCase();
					//System.out.println("SummaryConcept=" + concept);
                
					summaryConceptsStrong.put(concept, "");
				}
			}
        }

		//
		// Build list of all concepts from summary
		//
		Hashtable summaryConceptsAll = new Hashtable();
		for (int idx=0; idx < lexChainSummary.length; idx++)
        {
        	// See if chain has this summary concept
			if (lexChainSummary[idx] != null)
			{
				if (lexChainSummary[idx].getScore() > 0.0)
				{
					List lexList = lexChainSummary[idx].getTermList();
					for (int termIdx=0; termIdx < lexList.size(); termIdx++) 
					{
						LexChainTerm term = (LexChainTerm) lexList.get(termIdx);
                
						String concept = term.getTerm().toLowerCase() + ":" + lexChainSummary[idx].getTUI();
						//String concept = term.getTerm().toLowerCase();
						//System.out.println("SummaryConcept=" + concept);
                
						summaryConceptsAll.put(concept, "");
					}
				}
			}
        }

        
        //
        // Recall: Number of strong chains in Full-text with concepts from Summary
        //
        int strongChainsWithSummaryConceptsCount = 0;
        double lexchainRecall = 0.0;
        for (int idx=0; idx < strongChainsFullText.size(); idx++)
        {
        	int chainIndex = ((Integer) strongChainsFullText.get(idx)).intValue();
        	
        	// See if chain has any summary concepts
        	boolean conceptFound = false;
    		List lexList = lexChainFullText[chainIndex].getTermList();
            for (int termIdx=0; termIdx < lexList.size() && !conceptFound; termIdx++) 
            {
                LexChainTerm term = (LexChainTerm) lexList.get(termIdx);

                String concept = term.getTerm().toLowerCase() + ":" + lexChainFullText[chainIndex].getTUI();
                //String concept = term.getTerm().toLowerCase();
                //System.out.println("FullTextConcept1=" + concept);
                
                if (summaryConceptsAll.containsKey(concept))
                {
                	conceptFound = true;
                	break;
                }
            }
            
            if (conceptFound)
            {
            	strongChainsWithSummaryConceptsCount++;
            }
            else
            {
            	System.out.println("\tRecall: Chain with no concepts from Summary: " + lexChainFullText[chainIndex].getTUI() + "-" + lexChainFullText[chainIndex].getDescription());
            }
        }
        lexchainRecall = (strongChainsWithSummaryConceptsCount * 1.0) / strongChainsFullText.size(); 
        
        
        //
        // Precision: Number of summary concepts having strong chains in full-text
        //
        int summaryConceptsWithStrongChains = 0;
        double lexchainPrecision = 0.0;
        for (Enumeration e = summaryConceptsStrong.keys(); e.hasMoreElements();)
        {
        	String summaryConcept = (String) e.nextElement();
        	//System.out.println();
        	//System.out.println("SummaryConcept2=" + summaryConcept);
        	
        	boolean conceptFound = false;
            for (int idx=0; idx < strongChainsFullText.size() && !conceptFound; idx++)
            {
            	
            	int chainIndex = ((Integer) strongChainsFullText.get(idx)).intValue();
            	
            	// See if chain has this summary concept
        		List lexList = lexChainFullText[chainIndex].getTermList();
                for (int termIdx=0; termIdx < lexList.size() && !conceptFound; termIdx++) 
                {
                    LexChainTerm term = (LexChainTerm) lexList.get(termIdx);

                    String chainConcept = term.getTerm().toLowerCase() + ":" + lexChainFullText[chainIndex].getTUI();
                    //String chainConcept = term.getTerm().toLowerCase();
                    //System.out.println("FullTextConcept2=" + chainConcept);
                    
                    if (summaryConcept.equalsIgnoreCase(chainConcept))
                    {
                    	//System.out.println("Match: " + idx + ": suM:" + summaryConcept + ", chain:" + chainConcept);
                    	conceptFound = true;
                    }
                }
            }
            
            if (conceptFound)
            {
            	summaryConceptsWithStrongChains++;
            }
            else
            {
            	System.out.println("Summary concept " + summaryConcept + " has no match");            	
            }
        }
        lexchainPrecision = (summaryConceptsWithStrongChains * 1.0) / summaryConceptsStrong.size();
        
        //
        // Display evaluation
        //
        DecimalFormat formatter = new DecimalFormat("#0.00");

        System.out.println();
        System.out.println();
        System.out.println("Evaluation:");
        System.out.println("-----------");
        System.out.println("\tNumber of strong chains in Full-text: " + strongChainsFullText.size());
        System.out.println("\tNumber of concepts in Summary: " + summaryConceptsStrong.size());
        System.out.println();
        System.out.println("\tNumber of strong chains in Full-text with concepts from Summary: " + strongChainsWithSummaryConceptsCount);
        System.out.println("\t  Recall: " + formatter.format(lexchainRecall));
        System.out.println();
        System.out.println("\tNumber of summary concepts having strong chains in full-text: " + summaryConceptsWithStrongChains);
        System.out.println("\t  Precision: " + formatter.format(lexchainPrecision));
	}
}
