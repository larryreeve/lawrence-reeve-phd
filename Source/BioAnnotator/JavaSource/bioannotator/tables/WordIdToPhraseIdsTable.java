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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;
import biocommon.util.words.WordSplitter;

public class WordIdToPhraseIdsTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;

    private static final long                  serialVersionUID    = 1965082455622776147L;

    private static Map<Integer, List<Integer>> m_WordIdToPhraseIds = new HashMap<Integer, List<Integer>>(1000000);


    /**
     * 
     *
     */
    public static void clear()
    {
        m_WordIdToPhraseIds.clear();
    }

    public static List<Integer> getPhraseIdsForWordId(Integer wordId)
    {
        List<Integer> retList = m_WordIdToPhraseIds.get(wordId);

        if (retList == null)
            return new ArrayList<Integer>();

        return retList;
    }

    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        WordIdToPhraseIdsTable.clear();

        //        try 
        //        {
        //            File fileSerialized = new File(Constants.FILENAME_BIO_WID2PIDS);
        //            
        //            ObjectInputStream serializationReader = new ObjectInputStream(new FileInputStream(fileSerialized));
        //
        //            m_WordIdToPhraseIds = (Map<Integer, List<Integer>>) serializationReader.readObject();
        //            
        //            serializationReader.close();
        //        } 
        //        catch (ClassNotFoundException e) 
        //        {
        //        } 
        //        catch (IOException e) 
        //        {
        //        }

        DataInputStream fileReader = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_WID2PIDS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_WID2PIDS);

            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(
                    Constants.FILENAME_BIO_WID2PIDS))));

            int numRecordsExpected = fileReader.readInt();

            m_WordIdToPhraseIds = new HashMap<Integer, List<Integer>>(((int) (numRecordsExpected * 1.0 / 0.75)) + 1);

            for (int recordIndex = 0; recordIndex < numRecordsExpected; recordIndex++)
            {
                Integer wordId = new Integer(fileReader.readInt());

                int numPhraseIds = fileReader.readInt();

                List<Integer> phraseIds = new ArrayList<Integer>(numPhraseIds);

                for (int idx = 0; idx < numPhraseIds; idx++)
                    phraseIds.add(fileReader.readInt());

                m_WordIdToPhraseIds.put(wordId, phraseIds);
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
     * Format: S0005246|myeloma|Myeloma
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        BufferedReader fileReader = null;

        WordIdToPhraseIdsTable.clear();
        try
        {
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_SUI_NMSTR));

            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 3)
                    throw new Exception("Invalid sui_nmstr_str file format: " + line);

                String phraseId = fields[0];
                String normalizedPhrase = fields[1];

                try
                {
                    Integer phraseIdNumber = Integer.parseInt(phraseId.substring(1));

                    List<String> words = WordSplitter.splitWithoutStopWords(normalizedPhrase);

                    for (String word : words)
                    {
                        Integer wordId = WordToWordIdTable.getWordId(VariantsTable.getBaseWordInflected(word));

                        if (wordId >= 0)
                        {
                            if (m_WordIdToPhraseIds.containsKey(wordId))
                            {
                                List<Integer> phraseIdList = m_WordIdToPhraseIds.get(wordId);
                                phraseIdList.add(phraseIdNumber);
                            }
                            else
                            {
                                List<Integer> phraseIds = new ArrayList<Integer>();
                                phraseIds.add(phraseIdNumber);
                                m_WordIdToPhraseIds.put(wordId, phraseIds);
                            }
                        }
                    }
                }
                catch (NumberFormatException e)
                {
                    System.err.println("  Warning: Invalid phrase id '" + phraseId + "'");
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

        //        try
        //        {
        //            File fileSerialized = new File(Constants.FILENAME_BIO_WID2PIDS);
        //            
        //            if (fileSerialized.exists())
        //                fileSerialized.delete();
        //            
        //            ObjectOutput serializationWriter = new ObjectOutputStream(new FileOutputStream(fileSerialized));
        //            
        //            serializationWriter.writeObject(m_WordIdToPhraseIds);
        //            
        //            serializationWriter.close();
        //        }
        //        catch(Exception e)
        //        {
        //            throw e;
        //        }

        DataOutputStream fileWriter = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_WID2PIDS);
            if (f.exists())
                f.delete();

            if (m_WordIdToPhraseIds.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(
                        Constants.FILENAME_BIO_WID2PIDS))));

                fileWriter.writeInt(m_WordIdToPhraseIds.size());

                for (Integer wordId : m_WordIdToPhraseIds.keySet())
                {
                    List<Integer> phraseIdList = m_WordIdToPhraseIds.get(wordId);

                    fileWriter.writeInt(wordId.intValue());

                    int lastPhraseId = Integer.MIN_VALUE;

                    List<Integer> phraseIdsNormalized = new ArrayList<Integer>();

                    Collections.sort(phraseIdList);

                    for (Integer phraseId : phraseIdList)
                    {
                        if (phraseId > lastPhraseId)
                        {
                            phraseIdsNormalized.add(phraseId);
                            lastPhraseId = phraseId;
                        }
                    }

                    fileWriter.writeInt(phraseIdsNormalized.size());

                    for (Integer phraseId : phraseIdsNormalized)
                        fileWriter.writeInt(phraseId.intValue());

                    //System.out.println("NumIds:" + phraseIds.size() + ", NumWritten:" + numWritten);
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
