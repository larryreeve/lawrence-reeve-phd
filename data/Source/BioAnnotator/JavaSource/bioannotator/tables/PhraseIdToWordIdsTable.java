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
import biocommon.util.words.WordSplitter;

public class PhraseIdToWordIdsTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT           = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, List<Integer>> m_PhraseIdToWordIds = new TreeMap<Integer, List<Integer>>();


    /**
     * 
     *
     */
    public static void clear()
    {
        m_PhraseIdToWordIds.clear();
    }
    
    /**
     * 
     * @param phraseId
     * @return
     */
    public static List<Integer> getWordIds(Integer phraseId)
    {
       return m_PhraseIdToWordIds.get(phraseId);
    }
    
    /**
     * 
     * @param phraseId
     * @return
     */
    public static String getPhraseText(Integer phraseId)
    {
        StringBuilder sb = new StringBuilder();
        
        List<Integer> wordIds = m_PhraseIdToWordIds.get(phraseId);
        
        for (Integer wordId : wordIds)
        {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(WordToWordIdTable.getWordIdText(wordId));
        }
        
        return sb.toString();
    }
    
    /**
     * 
     * @param sourcePhraseWordIds
     * @param candidatePhraseWordIds
     * @return
     */
    public static boolean isExactMatch(List<Integer> sourcePhraseWordIds, List<Integer> candidatePhraseWordIds)
    {
        if (sourcePhraseWordIds.size() == candidatePhraseWordIds.size())
        {
            for (int idx=0; idx < sourcePhraseWordIds.size(); idx++)
            {
                Integer sourcePhraseWordId = sourcePhraseWordIds.get(idx);
                Integer candidatePhraseWordId = candidatePhraseWordIds.get(idx);
                if (sourcePhraseWordId.compareTo(candidatePhraseWordId) != 0)
                    return false;
            }
            
            return true;
        }
        
        return false;
    }
    

    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        PhraseIdToWordIdsTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_PID2WIDS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_PID2WIDS);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_PID2WIDS))));
            
            int numRecordsExpected = fileReader.readInt();
            m_PhraseIdToWordIds = new TreeMap<Integer, List<Integer>>();
            
            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                Integer phraseId = new Integer(fileReader.readInt());
                
                int numWordIds = fileReader.readInt();
                
                List<Integer> wordIds = new ArrayList<Integer>(numWordIds);
                
                for (int idx=0; idx < numWordIds; idx++)
                    wordIds.add(fileReader.readInt());
                
                m_PhraseIdToWordIds.put(phraseId, wordIds);
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
     * Format: S0005246|myeloma|Myeloma
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        BufferedReader fileReader = null;

        PhraseIdToWordIdsTable.clear();
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
                
                List<String> words = WordSplitter.splitWithoutStopWords(normalizedPhrase);
                
                List<Integer> wordIdList = new ArrayList<Integer>();
                for (String word : words)
                {
                    Integer wordId = WordToWordIdTable.getWordId(VariantsTable.getBaseWordInflected(word));
                    if (wordId >= 0)
                        wordIdList.add(wordId);
                }
                //System.out.println(normalizedPhrase + "::" + wordIdList.size() + "words");

                try
                {
                    Integer phraseIdNumber = Integer.parseInt(phraseId.substring(1));

                    m_PhraseIdToWordIds.put(phraseIdNumber, wordIdList);
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Invalid phrase id '" + phraseId + "'");
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
            File f = new File(Constants.FILENAME_BIO_PID2WIDS);
            if (f.exists())
                f.delete();

            if (m_PhraseIdToWordIds.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_PID2WIDS))));

                fileWriter.writeInt(m_PhraseIdToWordIds.size());
                
                for (Integer phraseId : m_PhraseIdToWordIds.keySet())
                {
                    List<Integer> wordIdList = m_PhraseIdToWordIds.get(phraseId);
                    
                    fileWriter.writeInt(phraseId.intValue());
                    
                    fileWriter.writeInt(wordIdList.size());
                    
                    for (Integer wordId : wordIdList)
                        fileWriter.writeInt(wordId);
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
    
    /**
     * 
     * @return
     */
    public static int size()
    {
        return m_PhraseIdToWordIds.size();
    }
}
