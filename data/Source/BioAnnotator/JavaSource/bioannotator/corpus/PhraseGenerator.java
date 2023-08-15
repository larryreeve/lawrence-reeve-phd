/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.corpus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bioannotator.Constants;
import biocommon.ConfigurationSettings;
import biocommon.util.string.StringUtility;


public class PhraseGenerator
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

    private List<File> getFiles(File directoryEntry)
    {
        List<File> fileList = new ArrayList<File>();

        File[] directoryFiles = directoryEntry.listFiles();
        for (File fileEntry : directoryFiles)
        {
             
            if (!fileEntry.isDirectory())
            {
                if (fileEntry.getName().endsWith("-ArticlePhrases_mmtx.txt"))
                    fileList.add(fileEntry);
            }
            else
            {
                if (StringUtility.isNumeric(fileEntry.getName()))
                {
                    List<File> subfileList = getFiles(fileEntry);
                    fileList.addAll(subfileList);
                }
            }
          }
        
        Collections.sort(fileList);
          
        return fileList;
    }

    public void generate()
    {
        // Find all *-ArticlePhrases_mmtx.txt files
        File summaryOutputDirectory = new File(ConfigurationSettings.getDataSummarizationPath() + "output");
        List<File> fileList = this.getFiles(summaryOutputDirectory);
        
//        for (File fileEntry : fileList)
//            System.out.println(fileEntry.getAbsolutePath());
        
        Map<String, List<String>> phraseMap = new HashMap<String, List<String>>();
        
        BufferedReader phraseReader = null;
        BufferedWriter phraseWriter = null;
        
        int numInputFiles = 0;
        
        try
        {
            for (File fileEntry : fileList)
            {
                phraseReader = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));
            
                String inputLine = null;
                while ((inputLine = phraseReader.readLine()) != null)
                {
                    // Phrase
                    String phraseNormalized = inputLine.trim().toLowerCase();
                    
                    // Number of mapped concepts
                    inputLine = phraseReader.readLine();
                    int numConcepts = Integer.parseInt(inputLine.trim());
                    if (numConcepts > 0)
                    {
                        List<String> conceptNames = new ArrayList<String>();
                    
                        for (int idx=0; idx < numConcepts; idx++)
                        {
                            inputLine = phraseReader.readLine();
                            conceptNames.add(inputLine.toLowerCase());
                        }
          
                        if (phraseNormalized.length() > 0) 
                        {
                            if (!phraseMap.containsKey(phraseNormalized))
                                    phraseMap.put(phraseNormalized, conceptNames);
                        }
                    }
                }
                
                numInputFiles++;
            }
            phraseReader.close();
            phraseReader = null;
            
            // All unique phrases
            phraseWriter = new BufferedWriter(new FileWriter(Constants.FILENAME_ALL_UNIQUE_CONCEPTS));
            for (String phrase : phraseMap.keySet())
            {
                List<String> mappedConcepts = phraseMap.get(phrase);

                phraseWriter.write(phrase);
                phraseWriter.newLine();
                
                phraseWriter.write("  " + Integer.toString(mappedConcepts.size()));
                phraseWriter.newLine();
                
                for (String conceptName : mappedConcepts)
                {
                    phraseWriter.write(conceptName);
                    phraseWriter.newLine();
                }
            }
            phraseWriter.close();
            phraseWriter = null;

            
            // All unique phrases mapped to one concept
            int numPhrasesWithOneConceptMapped = 0;
            phraseWriter = new BufferedWriter(new FileWriter(Constants.FILENAME_ONE_UNIQUE_CONCEPTS));
            for (String phrase : phraseMap.keySet())
            {
                List<String> mappedConcepts = phraseMap.get(phrase);
                
                if (mappedConcepts.size() == 1)
                {
                    numPhrasesWithOneConceptMapped++;
                    
                    phraseWriter.write(phrase);
                    phraseWriter.newLine();
                
                    phraseWriter.write("  " + Integer.toString(mappedConcepts.size()));
                    phraseWriter.newLine();
                
                    for (String conceptName : mappedConcepts)
                    {
                        phraseWriter.write(conceptName);
                        phraseWriter.newLine();
                    }
                }
            }
            phraseWriter.close();
            phraseWriter = null;
            
            System.out.println("Number of input files: " + numInputFiles);
            System.out.println("Number of unique phrases: " + phraseMap.size());
            System.out.println("Number of unique phrases with one concept mapped: " + numPhrasesWithOneConceptMapped);
            System.out.println();
            System.out.println("Filename of unique phrases: " + Constants.FILENAME_ALL_UNIQUE_CONCEPTS);
            System.out.println("Filename of unique phrases with one concept mapped: " + Constants.FILENAME_ONE_UNIQUE_CONCEPTS);
        }
        catch(Exception e)
        {
            // empty
            System.out.println("Error reading/writing: " + e.getMessage());
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

            if (phraseWriter != null)
            {
                try
                {
                    phraseWriter.close();
                }
                catch (Exception e)
                {
                    // empty
                }
            }
        }
    }
}
