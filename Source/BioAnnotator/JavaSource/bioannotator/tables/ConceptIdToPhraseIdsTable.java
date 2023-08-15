/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.tables;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;

public class ConceptIdToPhraseIdsTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT              = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, List<Integer>> m_ConceptIdToPhraseIds = new TreeMap<Integer, List<Integer>>();
    private static List<Integer>               m_ConceptIdList        = new ArrayList<Integer>();

    public static void clear()
    {
        m_ConceptIdToPhraseIds.clear();
        m_ConceptIdList.clear();
    }
    
    
    public static List<Integer> getConceptIds()
    {
        return m_ConceptIdList;
    }

    public static List<Integer> getPhraseIdsForConcept(Integer conceptId)
    {
        return m_ConceptIdToPhraseIds.get(conceptId);
    }

    public static void load() throws Exception
    {
        ConceptIdToPhraseIdsTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_CID2PIDS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_CID2PIDS);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_CID2PIDS))));
                
            int numRecordsExpected = fileReader.readInt();
            m_ConceptIdToPhraseIds = new TreeMap<Integer, List<Integer>>();
            
            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                // Concept Id
                Integer conceptId = new Integer(fileReader.readInt());
                m_ConceptIdList.add(conceptId);

                // Phrase Ids
                int numPhraseIds = fileReader.readInt();
                
                List<Integer> pidList = new ArrayList<Integer>(numPhraseIds);
                
                for (int idx=0; idx < numPhraseIds; idx++)
                    pidList.add(fileReader.readInt());

                m_ConceptIdToPhraseIds.put(conceptId, pidList);                
            }
        }
        finally
        {
            if (fileReader != null)
            {
                try
                {
                    fileReader.close();
                }
                catch(Exception e)
                {
                    // ignore errors on close
                }
            }
        }
    }

    /**
     * 
     * Format: S0000043|C0750901
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        BufferedReader fileReader = null;

        ConceptIdToPhraseIdsTable.clear();
        try
        {
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_SUI_CUI));

            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 2)
                    throw new Exception("Invalid sui_cui file format: " + line);

                String phraseId  = fields[0];
                String conceptId = fields[1];

                try
                {
                    Integer phraseIdValue = Integer.parseInt(phraseId.substring(1));
                    Integer conceptIdValue = Integer.parseInt(conceptId.substring(1));

                    if (m_ConceptIdToPhraseIds.containsKey(conceptIdValue))
                    {
                        List<Integer> pidList = m_ConceptIdToPhraseIds.get(conceptIdValue);
                        pidList.add(phraseIdValue);
                    }
                    else
                    {
                        List<Integer> pidList = new ArrayList<Integer>();
                        pidList.add(phraseIdValue);
                        m_ConceptIdList.add(conceptIdValue);
                        m_ConceptIdToPhraseIds.put(conceptIdValue, pidList);
                    }
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Invalid concept or phrase number: '" + phraseId + "', '" + conceptId + "'");
                    // ignore error
                }
            }
            fileReader.close();
            fileReader = null;
        }
        finally
        {
            try
            {
                if (fileReader != null)
                    fileReader.close();
            }
            catch (Exception e)
            {
            }
        }
    }

    /**
     * 
     * @throws Exception
     */
    public static void save() throws Exception
    {
        DataOutputStream fileWriter = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_CID2PIDS);
            if (f.exists())
                f.delete();

            if (m_ConceptIdToPhraseIds.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_CID2PIDS))));

                fileWriter.writeInt(m_ConceptIdToPhraseIds.size());
                
                for (Integer cid : m_ConceptIdToPhraseIds.keySet())
                {
                    List<Integer> pidList = m_ConceptIdToPhraseIds.get(cid);
                    
                    if (pidList != null && pidList.size() > 0)
                    {
                        fileWriter.writeInt(cid.intValue());
                        
                        fileWriter.writeInt(pidList.size());
                    
                        for (Integer pid : pidList)
                            fileWriter.writeInt(pid);
                    }
                }
            }
        }
        finally
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (Exception e)
                {
                    // ignore errors on close
                }
            }
        }
    }
}
