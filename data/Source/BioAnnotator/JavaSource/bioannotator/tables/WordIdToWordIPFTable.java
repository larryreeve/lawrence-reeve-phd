/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.tables;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;

public class WordIdToWordIPFTable
{
    @SuppressWarnings("unused")
    private static final String         COPYRIGHT     = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, Double> m_WordIdToIPF = new HashMap<Integer, Double>(1000000);
    

    /**
     * 
     *
     */
    public static void clear()
    {
        m_WordIdToIPF.clear();
    }
    
    public static Double getWordIdIPFValue(Integer wordId)
    {
        if (m_WordIdToIPF.containsKey(wordId))
            return m_WordIdToIPF.get(wordId);
        
        return new Double(0.00);
    }
    
    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        WordIdToWordIPFTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_WID2IPF);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_WID2IPF);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_WID2IPF))));
                
            int numRecordsExpected = fileReader.readInt();
            
            m_WordIdToIPF = new HashMap<Integer, Double>(((int) (numRecordsExpected * 1.0 / 0.75)) + 1);
            
            for (int recordIndex=0; recordIndex < numRecordsExpected; recordIndex++)
            {
                Integer wordId = new Integer(fileReader.readInt());
                Double  ipf = new Double(fileReader.readDouble());
                
                m_WordIdToIPF.put(wordId, ipf);
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
        WordIdToWordIPFTable.clear();
        
        Double totalPhrases = new Double(PhraseIdToWordIdsTable.size());
        
        List<Integer> allWordIds = WordToWordIdTable.getAllWordIds();
        
        for (Integer wordId : allWordIds)
        {
            List<Integer> phraseIds = WordIdToPhraseIdsTable.getPhraseIdsForWordId(wordId);
            
            Double phraseCount = new Double(phraseIds.size());
            
            Double ipf = new Double(Math.log10(((double) totalPhrases) / ((double) phraseCount)));
            
            m_WordIdToIPF.put(wordId, ipf);
            
            //System.out.println("wid: " + wordId + ", word=" + word + ", ipf=" + ipf + ", N=" + totalPhrases + ", cnt=" + phraseIds.size());
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
            File f = new File(Constants.FILENAME_BIO_WID2IPF);
            if (f.exists())
                f.delete();

            if (m_WordIdToIPF.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_WID2IPF))));

                fileWriter.writeInt(m_WordIdToIPF.size());
                
                for (Integer wordId : m_WordIdToIPF.keySet())
                {
                    fileWriter.writeInt(wordId);
                    fileWriter.writeDouble(m_WordIdToIPF.get(wordId));
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
