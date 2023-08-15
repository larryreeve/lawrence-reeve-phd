/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.output;

import java.io.*;
import java.util.*;

import biocommon.document.*;
import biosumm.chain.*;


public class OutputLemurParam
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		// Get parameters
		//	Compression Rate
		double paramCompressionRate = Double.parseDouble(parameters.getProperty("compressionrate", "20"));
		if (paramCompressionRate > 0) 
			paramCompressionRate /= 100;
		if (paramCompressionRate <= 0)
			paramCompressionRate = 0.20;
		
		//	Number of Sentences
		int paramNumSentences = Integer.parseInt(parameters.getProperty("numsentences", "0"));
		
		// Index path
		String indexPath = parameters.getProperty("indexpath", "data/lemur/index/LemurIndex.ifp");
		

		// Find maximum # of sentences to generate
		int maxNumberOfSentencesToGenerate = 0;
		int totalNumberOfSentences = 0;
		

		// Make a list of sentences to sort in ascending order by score
		for (DocumentSection section : annotatedDocument.getSections())
		{
			totalNumberOfSentences += section.getSentences().size();
		}
		
		if (paramNumSentences > 0)
			maxNumberOfSentencesToGenerate = paramNumSentences;
		else
			maxNumberOfSentencesToGenerate = (int) Math.ceil(totalNumberOfSentences * paramCompressionRate);
		
		writer.println("<parameters>");
		writer.println("  <index>" + indexPath + "</index>");
		writer.println("  <docID>" + annotatedDocument.getDocID() + "</docID>");
		writer.println("  <summLength>" + maxNumberOfSentencesToGenerate + "</summLength>");
		writer.println("</parameters>");
	}
}
