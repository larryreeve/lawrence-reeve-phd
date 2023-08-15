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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;
import biocommon.util.string.StringUtility;
import biocommon.util.words.WordSplitter;

public class WordToWordIdTable
{
    @SuppressWarnings("unused")
    private static final String         COPYRIGHT   = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<String, Integer> m_WordToWID = new TreeMap<String, Integer>();
    private static Map<Integer, String> m_WIDToWord = new TreeMap<Integer, String>();
    private static int                  m_NextWID   = 1;


    /**
     * 
     * @param word
     */
    public static void addEntry(String word)
    {    
        if (word == null || word.length() == 0)
            return;
        
        String wordNormalized = word.trim().toLowerCase();
        
        if (!m_WordToWID.containsKey(wordNormalized))
        {
            m_WordToWID.put(wordNormalized, m_NextWID);
            m_NextWID++;
        }
    }

    /**
     * 
     *
     */
    public static void clear()
    {
        m_WordToWID.clear();
    }
    
    /**
     * 
     * @param word
     * @return
     */
    public static boolean wordExists(String word)
    {
        return m_WordToWID.containsKey(word);
    }
    
    public static Integer getWordId(String word)
    {
        if (m_WordToWID.containsKey(word))
            return m_WordToWID.get(word);
        
        return Integer.MIN_VALUE;
    }
    
    public static String getWordIdText(Integer wordId)
    {
        // Initialize table on first entry
        if (m_WIDToWord.size() == 0 && m_WordToWID.size() > 0)
        {
            for (String word : m_WordToWID.keySet())
                m_WIDToWord.put(m_WordToWID.get(word), word);
        }
        
        if (m_WIDToWord.containsKey(wordId))
            return m_WIDToWord.get(wordId);
        
        return "unknown";
    }
    
    /**
     * 
     * @param wordIds
     * @return
     */
    public static String getWordIdsText(List<Integer> wordIds)
    {
        StringBuilder sb = new StringBuilder();
        
        for (Integer wordId : wordIds)
        {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(WordToWordIdTable.getWordIdText(wordId));
        }
        
        return sb.toString();
    }
    
    
    public static List<Integer> getAllWordIds()
    {
        List<Integer> wordIdList = new ArrayList<Integer>(m_WordToWID.size());
        
        if (m_WordToWID.size() == 0)
            return wordIdList;
        
        for (Integer wordId : m_WordToWID.values())
            wordIdList.add(wordId);
        
        return wordIdList;
    }
    
    public static Set<String> getAllWords()
    {
        return m_WordToWID.keySet();
    }
    
    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        WordToWordIdTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_WORD2WIDS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_WORD2WIDS);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_WORD2WIDS))));
            
            int numRecordsExpected = fileReader.readInt();
            m_WordToWID = new HashMap<String, Integer>(((int) (numRecordsExpected / 0.75) + 1));
            
            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                Integer wordId = new Integer(fileReader.readInt());
                String  word = fileReader.readUTF();
                
                m_WordToWID.put(word, wordId);
                
                if (wordId.intValue() > m_NextWID)
                    m_NextWID = wordId.intValue() + 1;
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
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        BufferedReader fileReader = null;

        WordToWordIdTable.clear();
        try
        {
//            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_ALL_WORDS));
//
//            String line = null;
//            while ((line = fileReader.readLine()) != null)
//            {
//                String[] fields = line.split("[|]");
//
//                if (fields.length != 2)
//                    throw new Exception("Invalid all_words file format: " + line);
//
//                String word = StringUtility.normalizeToKey(fields[0]);
//                String wordNormalized = VariantsTable.getBaseWordFromInflectedVariants(word);
//
//                if (wordNormalized != null)
//                    WordToWordIdTable.addEntry(wordNormalized);
//            }
//            fileReader.close();
//            fileReader = null;
            
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_SUI_NMSTR));

            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 3)
                    throw new Exception("Invalid sui_nmstr_str file format: " + line);

                String normalizedPhrase = StringUtility.normalizeToKey(fields[1]);
                
                List<String> words = WordSplitter.splitWithoutStopWords(normalizedPhrase);
                
                for (String word : words)
                {
                    if (word != null)
                        WordToWordIdTable.addEntry(word);
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
            File f = new File(Constants.FILENAME_BIO_WORD2WIDS);
            if (f.exists())
                f.delete();

            if (m_WordToWID.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_WORD2WIDS))));

                fileWriter.writeInt(m_WordToWID.size());
                
                for (String word : m_WordToWID.keySet())
                {
                    Integer wid = m_WordToWID.get(word);
                
                    fileWriter.writeInt(wid.intValue());
                    fileWriter.writeUTF(word);
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
        return m_WordToWID.size();
    }
}
