/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.util.words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biocommon.ConfigurationSettings;



public class StopWordManager 
{
    @SuppressWarnings("unused")
    private static final String        COPYRIGHT   = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<String, String> m_stopwords = new HashMap<String, String>();
	

	static
	{
		BufferedReader textFileReader = null;
	
		try
		{
    		String filename = ConfigurationSettings.getConfigPath() + "PubMedStopWordsList.txt";
	    	
			textFileReader = new BufferedReader(new FileReader(new File(filename)));
	
			String line = null;
			while ((line = textFileReader.readLine()) != null)
			{		
				if (!line.startsWith("#"))
				{
					String normalizedWord =line.trim().toLowerCase(); 
					if (!m_stopwords.containsKey(normalizedWord))
						m_stopwords.put(normalizedWord, null);
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading stopwords: " + e.getMessage());
		}
		finally 
		{
			try 
			{
				if (textFileReader!= null) 
					textFileReader.close();
			}
			catch(Exception e) {} 
		}
	}
	
    public static List<String> getStopWordList()
    {
        List<String> stopWordList = new ArrayList<String>();
        
        for (String word : m_stopwords.keySet())
            stopWordList.add(word);
        
        return stopWordList;
    }
	
	public static boolean isStopWord(String word)
	{
		String normalizedWord = word.trim();
		
		return (m_stopwords.containsKey(normalizedWord));
	}
}
