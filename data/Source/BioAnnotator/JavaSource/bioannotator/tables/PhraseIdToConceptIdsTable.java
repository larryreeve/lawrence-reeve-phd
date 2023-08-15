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

public class PhraseIdToConceptIdsTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT              = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, List<Integer>> m_PhraseIdToConceptIds = new TreeMap<Integer, List<Integer>>();


    public static void addEntry(Integer phraseId, Integer conceptId)
    {
        List<Integer> cidList = null;
        
        if (m_PhraseIdToConceptIds.containsKey(phraseId))
        {
            cidList = m_PhraseIdToConceptIds.get(phraseId);
            cidList.add(conceptId);
        }
        else
        {
            cidList = new ArrayList<Integer>();
            cidList.add(conceptId);
            m_PhraseIdToConceptIds.put(phraseId, cidList);
        }
    }

    public static void clear()
    {
        m_PhraseIdToConceptIds.clear();
    }
    
    public static List<Integer> getConceptIds(Integer phraseId)
    {
        return m_PhraseIdToConceptIds.get(phraseId);
    }
    
    public static int size()
    {
        return m_PhraseIdToConceptIds.size();
    }

    public static void load() throws Exception
    {
        PhraseIdToConceptIdsTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_PID2CIDS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_PID2CIDS);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_PID2CIDS))));
                
            int numRecordsExpected = fileReader.readInt();
            m_PhraseIdToConceptIds = new TreeMap<Integer, List<Integer>>();
            
            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                // Phrase Id
                Integer phraseId = new Integer(fileReader.readInt());

                // Concept Ids
                int numConceptIds = fileReader.readInt();
                
                List<Integer> cidList = new ArrayList<Integer>(numConceptIds);
                                
                for (int idx=0; idx < numConceptIds; idx++)
                    cidList.add(fileReader.readInt());
                
                m_PhraseIdToConceptIds.put(phraseId, cidList);                
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

        PhraseIdToConceptIdsTable.clear();
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

                    PhraseIdToConceptIdsTable.addEntry(phraseIdValue, conceptIdValue);
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
            File f = new File(Constants.FILENAME_BIO_PID2CIDS);
            if (f.exists())
                f.delete();

            if (m_PhraseIdToConceptIds.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_PID2CIDS))));
                
                fileWriter.writeInt(m_PhraseIdToConceptIds.size());

                for (Integer pid : m_PhraseIdToConceptIds.keySet())
                {
                    List<Integer> cidList = m_PhraseIdToConceptIds.get(pid);
                    
                    if (cidList != null && cidList.size() > 0)
                    {
                        fileWriter.writeInt(pid.intValue());
                        
                        fileWriter.writeInt(cidList.size());
                    
                        for (Integer cid : cidList)
                            fileWriter.writeInt(cid);
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
