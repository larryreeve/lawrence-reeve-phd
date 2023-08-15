package edu.drexelist.biochain;

import java.text.*;
import java.util.*;

public class LexChainEvaluatorStandardForAri2
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


        // Show strong chains in abstract
		System.out.println("\tStrong chains in abstract:"); 
		for (Object o : strongChainsFullText)
		{
			Integer idx = (Integer) o;
			
			LexChainTermList lexChain = lexChainAbstract[idx.intValue()];
			
			System.out.println("\t\t" + lexChain.getTUI() + ": " + lexChain.getDescription());
		}

        // Show strong chains in full-text
		System.out.println();
		System.out.println("\tStrong chains in full-text:"); 
		for (Object o : strongChainsFullText)
		{
			Integer idx = (Integer) o;
			
			LexChainTermList lexChain = lexChainFullText[idx.intValue()];
			
			System.out.println("\t\t" + lexChain.getTUI() + ": " + lexChain.getDescription());
		}
	}
}
