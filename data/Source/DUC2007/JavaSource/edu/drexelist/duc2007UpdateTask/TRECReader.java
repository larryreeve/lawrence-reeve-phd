package edu.drexelist.duc2007UpdateTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TRECReader
{
    public static List<Sentence> getSentences(File trecFile)
    {
        if (trecFile.exists())
        {
            BufferedReader textFileReader = null;
    
            try
            {
            	boolean inParagraph = false;
            	StringBuilder sbText = new StringBuilder();
                textFileReader = new BufferedReader(new FileReader(trecFile));
    
                String line = null;
                while ((line = textFileReader.readLine()) != null)
                {       
                	line = line.trim();
                	
                	if (line.length() > 0)
                	{
	                	if (line.startsWith("<p>") || line.startsWith("<P>"))
	                	{
	                		inParagraph = true;
	                	}
	                	else if (line.startsWith("</p>") || line.startsWith("</P>"))
	                	{
	                		inParagraph = false;
	                	}
	                	else if (inParagraph)
	                	{
	                		if (sbText.length() > 0)
	                			sbText.append(" ");	
                			sbText.append(line);
	                	}
                	}
                }
                
                //System.out.println(sbText.toString());
                
                textFileReader.close();
                textFileReader = null;
                
                return SentenceSplitter.splitTextIntoSentences(sbText.toString());
            }
            catch(Exception e)
            {
                System.err.println("Error loading trec file: " + e.getMessage());
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
        
        return null;
    }
    
    public static List<Sentence> getSentencesForDocSet(String updatePath, String docSetId, String part)
    {
    	List<Sentence> sentencesForDocSet = new ArrayList<Sentence>();
    	
    	String path = updatePath;
    	if (!path.endsWith(File.separator))
    		path += File.separator;
    	
    	path += docSetId + File.separator + docSetId + "-" + part + File.separator;
    	//System.out.println("path=" + path);
    	
    	File dir = new File(path);
        
        String[] filenames = dir.list();
        
        for (String filename : filenames)
        {
        	//System.out.println("filename=" + path + filename);
        	
        	File fileToProcess = new File(path + filename);
        	
        	if (fileToProcess.isFile())
        	{
        		//System.out.println("Processing " + fileToProcess.getAbsolutePath());
        		List<Sentence> sentences = TRECReader.getSentences(fileToProcess);
        		sentencesForDocSet.addAll(sentences);
        	}
        }
    	
    	return sentencesForDocSet;
    }
    
    public static List<String> getTopicStatementWords(File topicStatementFile)
    {
        if (topicStatementFile.exists())
        {
            BufferedReader textFileReader = null;
    
            try
            {
            	StringBuilder sbText = new StringBuilder();
                textFileReader = new BufferedReader(new FileReader(topicStatementFile));
    
                String line = null;
                while ((line = textFileReader.readLine()) != null)
                {       
                	line = line.trim();
                	
                	if (line.length() > 0)
                	{
                		if (sbText.length() > 0)
                			sbText.append(" ");	
                		sbText.append(line);
                	}
                }
                
                //System.out.println(sbText.toString());
                
                textFileReader.close();
                textFileReader = null;
                
        		String normalizedText = sbText.toString();
        		
        		normalizedText = normalizedText.toLowerCase();
        		normalizedText = normalizedText.replace("(", " ");
        		normalizedText = normalizedText.replace(")", " ");
        		normalizedText = normalizedText.replace(",", " ");
        		normalizedText = normalizedText.replace(".", " ");
        		normalizedText = normalizedText.replace(";", " ");
        		normalizedText = normalizedText.replace(":", " ");
        		normalizedText = normalizedText.replace("_", " ");
        		normalizedText = normalizedText.replace("-", " ");
        		normalizedText = normalizedText.replace("'", " ");
        		normalizedText = normalizedText.replace(",", " ");
        		normalizedText = normalizedText.replace(".", " ");
        		normalizedText = normalizedText.replace("?", " ");
        		normalizedText = normalizedText.replace("!", " ");
        		
        		//System.out.println(normalizedText);
        		
        		List<String> splitWords = WordSplitter.splitWithStopWords(normalizedText);
        		
        		List<String> normalizedSplitWords = new ArrayList<String>();
        		for (String word : splitWords)
        		{
        			if (word.length() > 1)
        				normalizedSplitWords.add(word);
        		}
                
                return normalizedSplitWords;
            }
            catch(Exception e)
            {
                System.err.println("Error loading trec file: " + e.getMessage());
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
        
        return new ArrayList<String>();
    }
}
