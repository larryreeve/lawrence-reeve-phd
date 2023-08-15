/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.util.*;
import java.io.*;

/**
 * Loads a SEMDEF file into a hash structure
 *
 */
public class SEMDEFLoader {

    
    //  ------------------------------------------------------- Constants
    
    //  ------------------------------------------------------- Instance Varibles
    
    //  ------------------------------------------------------- Properties

    //  ------------------------------------------------------- Public Methods
    /**
     * @param filename Full path to the semdef.txt MMTx semantic definitions file.
     *  Input line looks like:
     *  	aapp|T116|Amino Acid, Peptide, or Protein
     */
    public Map LoadFile(String filename) 
    	throws Exception {

    	BufferedReader semdefReader = null;
    	HashMap semdefMap = new HashMap();
    	
    	try {
        	File semdefFile = new File(filename);

        	semdefReader = new BufferedReader(new FileReader(semdefFile));
    		
    		String line = null;
    		
    		while (( line = semdefReader.readLine()) != null){
    			String[] fields = line.split("[|]");
    			
    			if (fields.length != 3)
    				throw new Exception("Invalid semdef format: " + line);
    			
    			//System.out.println(line);
    			//System.out.println("\tC:" + fields.length);
    			//System.out.println("\tF1:'" + fields[0] + "'");
    			//System.out.println("\tF2:'" + fields[1] + "'");
    			//System.out.println("\tF3:'" + fields[2] + "'");
    			semdefMap.put(fields[0], Integer.valueOf(fields[1].substring(1)));
    		}
    	}
    	finally {
    		try {
    			if (semdefReader!= null) {
    				//	flush and close both "input" and its underlying FileReader
    				semdefReader.close();
    			}
    		}
    		catch (IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    	
    	return semdefMap;
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
        else {
        	try {
        		System.out.println(arguments[0]);
            	
            	SEMDEFLoader loader = new SEMDEFLoader();
            	
            	Map semdefMap = loader.LoadFile(arguments[0]);
            	
            	System.out.println("Map contains " + semdefMap.size() + " entries:");
            	
        		Collection c=semdefMap.keySet();
        		Iterator i=c.iterator();
        		while(i.hasNext()) {
        			Object key=i.next();
        			Object value=semdefMap.get(key);
        			System.out.println("\tAbbrev:" + key + ", Id:" + value);
        		}
        	}
       		catch ( Exception e ) {
    			e.printStackTrace();
    		        System.err.println("Something went wrong " + e.toString() );
		      }
        }
	}



    
    //  ------------------------------------------------------- Private Methods    
}
