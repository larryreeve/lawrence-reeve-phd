package edu.drexelist.biochain;

import java.io.*;
import java.util.*;

public class SentenceMatch
{
    public static void main (String[] arguments) throws Exception, IOException 
    {

        if ((arguments.length > 0 ) && (arguments[0].equals("-h")) || arguments.length != 2) 
        {
            System.out.println("Compares two sentence files");
            System.out.println();
            System.out.println("Usage: ");
            System.out.println();
            System.out.println("   java edu.drexelist.biochain.SentenceMatch [-h] <BioChain Summary File> <Other summary file>" );
            System.out.println("                      -h prints out the help");
            System.out.println();
        }
        else 
        {
        	BufferedReader rdrSummary = null;
        	File fileSummary = null;
        	String line = null;
        	ArrayList listBioChainSummary = new ArrayList();
        	ArrayList listOtherSummary = new ArrayList();

            try 
            {
        		// Load BioChain summary
            	fileSummary = new File(arguments[0]);
            	rdrSummary = new BufferedReader(new FileReader(fileSummary));
        		while ((line = rdrSummary.readLine()) != null)
        		{
        			//System.out.println("AAA:" + line);
        			// Normalize line
        			line = line.trim();
        			if (line.length() > 0)
        			{
        				line = line.toLowerCase();
        				if (line.indexOf(' ') >= 0)
        				{
        				  line = line.replace("."," ");
        					line = line.trim();
        				}
        				if (line.length() > 0)
        				{
        					listBioChainSummary.add(line);
        					//System.out.println("AA:'" + line + "'");
        				}
        			}
        		}
        		rdrSummary.close();
        		rdrSummary = null;

            	// Load third-party summary file 
            	fileSummary = new File(arguments[1]);
            	rdrSummary = new BufferedReader(new FileReader(fileSummary));
        		while (( line = rdrSummary.readLine()) != null)
        		{
        			// Normalize line
        			line = line.trim();
        			if (line.length() > 0)
        			{
        				line = line.toLowerCase();
                if (line.indexOf(' ') >= 0)
                {
                  line = line.replace("."," ");
                  line = line.trim();
                }
                line = line.trim();
        				if (line.length() > 0)
        				{
        					listOtherSummary.add(line);
        					//System.out.println("BB:" + line);
        				}
        			}
        		}
        		rdrSummary.close();
        		rdrSummary = null;
        		
        		// Find number of matching sentence
        		int sentenceMatchCount = 0;
        		
        		for (int biochainIdx=0; biochainIdx < listBioChainSummary.size(); biochainIdx++)
        		{
        			String biochainSentence =  (String) listBioChainSummary.get(biochainIdx);
        		
        			for (int otherSummaryIdx=0; otherSummaryIdx < listOtherSummary.size(); otherSummaryIdx++)
        			{
        				String otherSummarySentence =  (String) listOtherSummary.get(otherSummaryIdx);
        				
        				if (biochainSentence.indexOf(otherSummarySentence) >= 0)
        				{
        					//System.out.println("A-" + biochainIdx + ":" + otherSummaryIdx);
        					//System.out.println("\t" + biochainSentence);
        					//System.out.println("\t" + otherSummarySentence);
        					//System.out.println();
        					sentenceMatchCount++;
        					break;
        				}
        				else if (otherSummarySentence.indexOf(biochainSentence) >= 0)
        				{
        					//System.out.println("B-" + biochainIdx + ":" + otherSummaryIdx);
        					//System.out.println("\t" + biochainSentence);
        					//System.out.println("\t" + otherSummarySentence);
        					//System.out.println();
        					sentenceMatchCount++;
        					break;
        				}
        			}
        		}
        		
        		
        		// Show stats
        		System.out.println("BioChain Summary File: " + arguments[0]);
        		System.out.println("\t" + listBioChainSummary.size() + " sentences");
        		System.out.println("External Summary File: " + arguments[1]);
        		System.out.println("\t" + listOtherSummary.size() + " sentences");
        		System.out.println("Total sentences matching BioChain: " + sentenceMatchCount);
        		
        		
        		
            }
            catch (Exception e) 
            {
                e.printStackTrace();
                System.err.println("Error: " + e.toString());
            }
    		finally 
    		{
        		try 
        		{
        			if (rdrSummary!= null) 
        			{
        				//	flush and close both "input" and its underlying FileReader
        				rdrSummary.close();
        			}
        		}
        		catch (IOException ex) 
        		{
        			ex.printStackTrace();
        		}
    		}
        }
    }
}
