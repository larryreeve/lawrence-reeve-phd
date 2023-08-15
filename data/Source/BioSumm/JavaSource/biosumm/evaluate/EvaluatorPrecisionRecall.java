/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.evaluate;

import java.io.PrintWriter;
import java.text.*;
import java.util.*;

import biocommon.document.*;
import biosumm.chain.*;


public class EvaluatorPrecisionRecall
	implements IEvaluator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;


    public void evaluate(PrintWriter 		writer,
            			 Document			annotatedDocumentFullText,
            			 List<ConceptChain> conceptChainListFulltext,
            			 Document			annotatedDocumentAbstract,
            			 List<ConceptChain> conceptChainListAbstract,
            			 Properties 		parameters)
	{
		List<ConceptChain>	strongChainsFullText  = new ArrayList<ConceptChain>();
		List<ConceptChain>	strongChainsAbstract  = new ArrayList<ConceptChain>();
		Map<String, String> abstractConceptsAll	  = new HashMap<String, String>();
		Map<String, String> abstractConceptsStrong= new HashMap<String, String>();
        double 				precision 			  = 0.0;
        double 				recall 				  = 0.0;
        int 				countAbstractConceptsWithStrongChains = 0;
        int 				countStrongChainsWithAbstractConcepts = 0;

        
		// Get parameters
		int numStdDeviations = Integer.parseInt(parameters.getProperty("stddev", "2"));

		// Get list of strong chains in abstract
		writer.println("Abstract strong chains:");
		getStrongChainList(writer, conceptChainListAbstract, strongChainsAbstract, numStdDeviations);
		writer.println();
		writer.println();

		// Get list of strong chains in full-text
		writer.println("Full-text strong chains:");
		getStrongChainList(writer, conceptChainListFulltext, strongChainsFullText, numStdDeviations);
		writer.println();
		writer.println();

		// Build list of strong concepts from abstract
        for (ConceptChain chain : strongChainsAbstract)
        {
    		List<Concept> conceptList = chain.getConceptList();
		
    		for (Concept concept : conceptList)
    		{
    			if (!abstractConceptsStrong.containsKey(concept.getId()))
    				abstractConceptsStrong.put(concept.getId(), concept.getId() + ":" + concept.getName());
    		}
        }
        

		// Build list of all concepts from abstract
        for (ConceptChain chain : conceptChainListAbstract)
        {
        	if (chain.getScore() > 0.0)
        	{
        		List<Concept> conceptList = chain.getConceptList();
		
        		for (Concept concept : conceptList)
        		{
        			if (!abstractConceptsAll.containsKey(concept.getId()))
        				abstractConceptsAll.put(concept.getId(), concept.getId() + ":" + concept.getName());
        		}
        	}
        }

        
        //
        // Recall: Number of strong chains in full-text with concepts from abstract
        //
        writer.println();
        writer.println("Recall: Strong chain from full-text with with no concepts from abstract:");
        for (ConceptChain strongChain : strongChainsFullText)
        {
        	// See if chain has any abstract concepts
        	boolean conceptFound = false;
			List<Concept> strongChainConceptList = strongChain.getConceptList();
			
			for (Concept concept : strongChainConceptList)
			{
				if (abstractConceptsAll.containsKey(concept.getId()))
				{
					//writer.println("chain '" + strongChain.getId() + ":" + strongChain.getDescription() + "' has concept '" + concept.getId() + ":" + concept.getName() + "'");
					conceptFound = true;
					break;
				}
			}

            if (conceptFound)
            {
            	countStrongChainsWithAbstractConcepts++;
            }
            else
            {
            	writer.println("\t" + strongChain.getId() + ":" + strongChain.getDescription());
            }
        }
        if (countStrongChainsWithAbstractConcepts == strongChainsFullText.size())
        	writer.println("\tNone.");
        recall = (countStrongChainsWithAbstractConcepts * 1.0) / strongChainsFullText.size(); 
        
        
        //
        // Precision: Number of abstract concepts in strong chains of full-text
        //
        writer.println();
        writer.println("Precision: Abstract concepts with no match in any strong chains of full-text:");
        for (String abstractConcept : abstractConceptsStrong.keySet())
        {
        	boolean conceptFound = false;
            for (ConceptChain chain : strongChainsFullText)
            {
            	// See if chain has this abstract concept
    			List<Concept> conceptList = chain.getConceptList();
    			
    			for (Concept concept : conceptList)
    			{
    				if (concept.getId().equalsIgnoreCase(concept.getId()))
    				{
    					conceptFound = true;
    					break;
    				}
    			}
            }
            
            if (conceptFound)
            {
            	countAbstractConceptsWithStrongChains++;
            }
            else
            {
            	writer.println("\t" + abstractConceptsStrong.get(abstractConcept));            	
            }
        }
        if (countAbstractConceptsWithStrongChains == abstractConceptsStrong.size())
        	writer.println("\tNone.");
        precision = (countAbstractConceptsWithStrongChains * 1.0) / abstractConceptsStrong.size();
        
        //
        // Display evaluation
        //
        DecimalFormat formatter = new DecimalFormat("#0.00");

        writer.println();
        writer.println();
        writer.println("Evaluation:");
        writer.println("-----------");
        writer.println("\tNumber of strong chains in full-text: " + strongChainsFullText.size());
        writer.println("\tNumber of concepts in abstract: " + abstractConceptsStrong.size());
        writer.println();
        writer.println("\tNumber of strong chains in full-text with concepts from abstract: " + countStrongChainsWithAbstractConcepts);
        writer.println("\t  Recall: " + formatter.format(recall));
        writer.println();
        writer.println("\tNumber of strong concepts in abstract having strong chains in full-text: " + countAbstractConceptsWithStrongChains);
        writer.println("\t  Precision: " + formatter.format(precision));
	}
	

	private void getStrongChainList(PrintWriter 		writer,
									List<ConceptChain> allChainsList,
									List<ConceptChain> strongChainsList,
									int 			   numStdDeviations)
	{
		double 	averageScore		= 0.0;
		int		numEntries			= 0;
		double 	squareSum			= 0.0;
		double 	stdDev				= 0.0;
		double 	strongChainMinScore	= 0.0;
		double	totalScore			= 0.0;
		
		// Make copy of chain list to sort in ascending order by score
		List<ConceptChain> tempChainList = new ArrayList<ConceptChain>();
		for (ConceptChain chain : allChainsList)
			tempChainList.add(chain);
		Collections.sort(tempChainList, new ChainCompareByScore(false));
		
        // Calculate average score
		for (ConceptChain chain : tempChainList)
		{
        	if (chain.getConceptList().size() > 0)
        	{
        		numEntries++;
        		totalScore += chain.getScore();
        		squareSum  += (chain.getScore() * chain.getScore());
        	}
        }

        averageScore = totalScore / numEntries;
        stdDev = Math.sqrt(squareSum/numEntries - averageScore*averageScore);
        strongChainMinScore = (averageScore + (numStdDeviations * stdDev));
		
        // Get strong chains
		for (ConceptChain chain : tempChainList)
		{
            if (chain.getScore() >= strongChainMinScore)
            	strongChainsList.add(chain);
        }
		
		if (writer != null)
		{
			DecimalFormat formatter = new DecimalFormat("#0.00");
			writer.println("\tAvg score:    " 	+ formatter.format(averageScore));
			writer.println("\tStd Dev:      " 	+ formatter.format(stdDev));
			writer.println("\tStrong score: "   + formatter.format(strongChainMinScore));
			writer.println();
			for (ConceptChain chain : strongChainsList)
				writer.println("\t" + chain.getId()	+ ":" + 
									  chain.getDescription() + 
									  "(score=" + formatter.format(chain.getScore()) + ")");
		}
	}
}
