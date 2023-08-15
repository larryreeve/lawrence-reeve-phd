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


public class OutputConceptCount
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		
		// Count all concepts
		Map<String, Integer> conceptCounts = new HashMap<String, Integer>();
		for (ConceptChain chainEntry : conceptChainList)
		{
			for (Concept conceptEntry : chainEntry.getConceptList())
			{
				String conceptKey = chainEntry.getId() + "-" + chainEntry.getDescription() + "::" + conceptEntry.getName();
				
				if (conceptCounts.containsKey(conceptKey))
				{
					Integer count = conceptCounts.get(conceptKey);
					conceptCounts.put(conceptKey, new Integer(count.intValue() + 1));
				}
				else
				{
					conceptCounts.put(conceptKey, new Integer(1));
				}
			}
		}
		
		// Write out concept counts
		for (String conceptKey : conceptCounts.keySet())
		{
			String [] conceptKeyParts = conceptKey.split("::");
			
			//System.out.println(conceptKeyParts[0] + "-->" + conceptKeyParts[1]);
			
			String semanticType = conceptKeyParts[0];
			String conceptName = conceptKeyParts[1];
			Integer count = conceptCounts.get(conceptKey);
			
			writer.println(conceptName + "\t" + count + "\t" + semanticType);
		}
	}
}
