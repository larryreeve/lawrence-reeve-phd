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


public class OutputUniquePhrases 
	implements IOutputGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    
	
    public void generate(PrintWriter 		writer,
            			 Document			annotatedDocument,
            			 List<ConceptChain> conceptChainList,
            			 Properties 		parameters)
	{
		Map<String, String> phraseMap = new HashMap<String, String>();
		
		// Get parameters
		String phrasesFilename = parameters.getProperty("phrasesfilename", null);
		if (phrasesFilename == null || phrasesFilename.length() == 0)
			return;

		// Read existing phrases
        File phrasesFile = new File(phrasesFilename);
        if (phrasesFile.exists())
        {
            BufferedReader phraseReader = null;
            
            try
            {
            	phraseReader = new BufferedReader(new FileReader(phrasesFilename));
            	
            	String phrase = null;
            	while ((phrase = phraseReader.readLine()) != null)
            	{
            		String phraseNormalized = phrase.trim().toLowerCase();
              
            		if (phraseNormalized.length() > 0) 
            		{
            			if (!phraseMap.containsKey(phraseNormalized))
            				phraseMap.put(phraseNormalized, null);
            		}
            	}
            	phraseReader.close();
            	phraseReader = null;
            }
            catch(Exception e)
            {
            	// empty
            	System.out.println("Error reading phrases file '" + phrasesFilename + ": " + e.getMessage());
            }
            finally
            {
            	if (phraseReader != null)
            	{
            		try
            		{
            			phraseReader.close();
            		}
            		catch (Exception e)
            		{
                    	// empty
            		}
            	}
            }
        }
        System.out.println("# existing phrases: " + phraseMap.size());


		// Find new phrases
		for (DocumentSection section : annotatedDocument.getSections())
		{
			for (DocumentSentence sentence : section.getSentences())
			{
				for (DocumentPhrase phrase : sentence.getPhrases())
				{
					String phraseNormalized = phrase.getPhraseText().trim().toLowerCase();
					
					if (!phraseMap.containsKey(phraseNormalized))
						phraseMap.put(phraseNormalized, null);
				}
			}
		}
		
		// Write phrase list
		BufferedWriter 	phraseWriter = null;
		if (!phraseMap.isEmpty())
		{
			try
			{
				phraseWriter = new BufferedWriter(new FileWriter(phrasesFilename));
        	
				for (String phrase : phraseMap.keySet())
				{
					phraseWriter.write(phrase);
					phraseWriter.newLine();
				}
        	
				phraseWriter.close();
				phraseWriter = null;
				
		        System.out.println("# phrases output: " + phraseMap.size());
			}
			catch(Exception e)
			{
				// 	empty
            	System.out.println("Error writing phrases file '" + phrasesFilename + ": " + e.getMessage());
			}
			finally
			{
				try
				{
					if (phraseWriter != null)
						phraseWriter.close();
				}
				catch(Exception e)
				{
					// empty
				}
			}
        }
	}
}
