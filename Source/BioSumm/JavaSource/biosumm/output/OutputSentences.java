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


public class OutputSentences 
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				writer.println(sentence.getSentenceText());
				writer.println();
			}
		}
	}
}
