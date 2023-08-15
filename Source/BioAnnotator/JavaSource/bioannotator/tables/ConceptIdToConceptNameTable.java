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
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;

public class ConceptIdToConceptNameTable
{
    @SuppressWarnings("unused")
    private static final String         COPYRIGHT                 = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, String> m_ConceptIdToConceptNames = new TreeMap<Integer, String>();


    public static void addEntry(Integer conceptId, String conceptName)
    {
        m_ConceptIdToConceptNames.put(conceptId, conceptName);
    }

    public static void clear()
    {
        m_ConceptIdToConceptNames.clear();
    }
    
    public static String getConceptName(Integer conceptId)
    {
        return m_ConceptIdToConceptNames.get(conceptId);
    }
    
    public static int size()
    {
        return m_ConceptIdToConceptNames.size();
    }

    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        ConceptIdToConceptNameTable.clear();

        DataInputStream fileReader = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_CID2CONCEPTNAME);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_CID2CONCEPTNAME);

            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_CID2CONCEPTNAME))));

            int numRecordsExpected = fileReader.readInt();
            m_ConceptIdToConceptNames = new HashMap<Integer, String>(((int) (numRecordsExpected / 0.75)) + 1);

            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                Integer conceptId = new Integer(fileReader.readInt());
                String conceptName = fileReader.readUTF();

                m_ConceptIdToConceptNames.put(conceptId, conceptName);
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
                catch (Exception e)
                {
                    // ignore errors on close
                }
            }
        }
    }

    /**
     * 
     * Format: C0000939|Accounts Payable
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        BufferedReader fileReader = null;

        ConceptIdToConceptNameTable.clear();
        try
        {
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_CUI_CONCEPT));

            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 2)
                    throw new Exception("Invalid cui_concept file format: " + line);

                String conceptId = fields[0];
                String conceptName = fields[1];

                try
                {
                    Integer conceptNumber = Integer.parseInt(conceptId.substring(1));

                    ConceptIdToConceptNameTable.addEntry(conceptNumber, conceptName);
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Invalid concept number '" + conceptId + "'");
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

    public static void save() throws Exception
    {
        DataOutputStream fileWriter = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_CID2CONCEPTNAME);
            if (f.exists())
                f.delete();

            if (m_ConceptIdToConceptNames.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_CID2CONCEPTNAME))));

                fileWriter.writeInt(m_ConceptIdToConceptNames.size());

                for (Integer cid : m_ConceptIdToConceptNames.keySet())
                {
                    String conceptName = m_ConceptIdToConceptNames.get(cid);

                    fileWriter.writeInt(cid.intValue());
                    fileWriter.writeUTF(conceptName);
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
