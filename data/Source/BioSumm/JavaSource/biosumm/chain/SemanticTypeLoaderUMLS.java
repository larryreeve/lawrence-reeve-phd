/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm.chain;

import java.util.*;
import java.io.*;

import biocommon.ConfigurationSettings;


/**
 * Loads a SRDEF file
 *
 */
public class SemanticTypeLoaderUMLS
	implements ISemanticTypeLoader
	
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;
    

    //  ------------------------------------------------------- Public Methods
    /**
     * @param filename Full path to the semdef.txt MMTx semantic definitions file.
     *  Input line looks like:
     *  	aapp|T116|Amino Acid, Peptide, or Protein
     */
    public List<SemanticType> loadFromFile(String filename) 
    	throws Exception
    {
    	BufferedReader readerSRDEF = null;
    	List<SemanticType> semanticTypes = new ArrayList<SemanticType>();
    	
    	String normalizedFilename = filename;
    	if (normalizedFilename == null || normalizedFilename.length() == 0)
    	{
    		normalizedFilename = ConfigurationSettings.getConfigPath() + "semdef.txt";
    	}
    	
    	try 
    	{
        	File fileSRDEF = new File(normalizedFilename);
        	readerSRDEF = new BufferedReader(new FileReader(fileSRDEF));
    		
    		String line = null;
    		
    		while (( line = readerSRDEF.readLine()) != null)
    		{
    			String[] fields = line.split("[|]");
    			
    			if (fields.length != 3)
    				throw new Exception("Invalid srdef format: " + line);
    			
//    			System.out.println(line);
//    			System.out.println("\tC:" + fields.length);
//    			System.out.println("\tF1:'" + fields[0] + "'");
//    			System.out.println("\tF2:'" + fields[1] + "'");
//    			System.out.println("\tF3:'" + fields[2] + "'");
    			
                int semanticTypeNum = Integer.valueOf(fields[1].substring(1)).intValue();
                
                semanticTypes.add(new SemanticType(semanticTypeNum, fields[1], fields[2]));
    		}
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    	finally 
    	{
    		try 
    		{
    			if (readerSRDEF != null) 
    			{
    				//	flush and close both "input" and its underlying FileReader
    				readerSRDEF.close();
    			}
    		}
    		catch (IOException e) 
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	return semanticTypes;
    }
    
    public static void main (String[] arguments) throws Exception, IOException {

    	if ((arguments.length > 0 ) && (arguments[0].equals("-h"))) {
    		System.out.println("SEMDEFLoader loads a semdef.txt MMTx semantic definitions file");
            System.out.println("into a map.");
            System.out.println();
            System.out.println("Usage: ");
            System.out.println();
            System.out.println("   java edu.drexelist.biochain.SEMDEFLoader [-h] <path and filename of semdef.txt>" );
            System.out.println("                      -h prints out the help");
            System.out.println();
        }
        else 
        {
        	try 
        	{
        		System.out.println(arguments[0]);
            	
            	ISemanticTypeLoader loader = new SemanticTypeLoaderUMLS();
            	
            	List<SemanticType> semanticTypes = loader.loadFromFile(arguments[0]);
            	
            	System.out.println("List contains " + semanticTypes.size() + " entries:");

            	for (SemanticType st : semanticTypes)
            	{
        			System.out.println("\tNum: " + st.getTypeNumber() + ", id:" + st.getId() + ", Desc:" + st.getDescription());
        		}
        	}
       		catch ( Exception e ) 
       		{
    			e.printStackTrace();
    		    System.err.println("Error: " + e.toString() );
		    }
        }
	}
}
