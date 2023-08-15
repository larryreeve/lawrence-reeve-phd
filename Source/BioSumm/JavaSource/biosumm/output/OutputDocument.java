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
import biosumm.chain.ConceptChain;


public class OutputDocument 
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;


    /*
	 * Display document contents
	 */
	public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				writer.println(sentence.getSentenceNumber() + ": " + sentence.getSentenceText());
				for (DocumentPhrase phrase : sentence.getPhrases())
				{
					writer.println("\t" + phrase.getPhraseText());
					for (DocumentConcept phraseConcept : phrase.getConcepts().values())
					{
						writer.println("\t\t" + phraseConcept.getId() + "," + phraseConcept.getName() + ", " + phraseConcept.getSemanticTypeId());
					}
				}
			}
		}
	}
}
