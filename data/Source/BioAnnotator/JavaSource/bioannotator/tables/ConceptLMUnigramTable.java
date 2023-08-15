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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import bioannotator.Constants;

public class ConceptLMUnigramTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT                 = biocommon.copyright.Copyright.COPYRIGHT;

    private static Map<Integer, LanguageModel> m_ConceptLanguageModels   = new TreeMap<Integer, LanguageModel>();
    private static LanguageModel               m_CollectionLanguageModel = new LanguageModel();

    
    /**
     * 
     *
     */
    public static void clear()
    {
        m_ConceptLanguageModels.clear();
        m_CollectionLanguageModel.clear();
    }
    
    public static LanguageModel getConceptLM(Integer conceptId)
    {
        return m_ConceptLanguageModels.get(conceptId);
    }

    public static LanguageModel getCollectionLM()
    {
        return m_CollectionLanguageModel;
    }
    
    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        ConceptLMUnigramTable.clear();
        
        DataInputStream fileReader = null;
        
        try
        {
            File f =  new File(Constants.FILENAME_BIO_CLM_UNIGRAM);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_CLM_UNIGRAM);
            
            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(Constants.FILENAME_BIO_CLM_UNIGRAM))));
                
            // Concept Language Models
            int numRecordsExpected = fileReader.readInt();
            
            //System.out.println("numRecordsExpected:" + numRecordsExpected);                        
            
            m_ConceptLanguageModels = new TreeMap<Integer, LanguageModel>();
            
            for (int idxRecord=0; idxRecord < numRecordsExpected; idxRecord++)
            {
                //System.out.println("ri: " + idxRecord);
                
                Integer conceptId = new Integer(fileReader.readInt());
                
                LanguageModel conceptLM = new LanguageModel();              
                
                int numLMItems = fileReader.readInt();
                //System.out.println("\tnumLMItems: " + numLMItems);
                
                for (int idxLMItems=0; idxLMItems < numLMItems; idxLMItems++)
                {
                    //System.out.println("\t\tidxLMItems: " + idxLMItems);
                    
                    int wordId = fileReader.readInt();
                    int frequency = fileReader.readInt();
                    double probability = fileReader.readDouble();
                    
                    conceptLM.addEntry(new Integer(wordId), new LanguageModelItem(wordId, frequency, probability));
                }
                
                m_ConceptLanguageModels.put(conceptId, conceptLM);
            }
            
            // Phrase Language Model
            //System.out.println("reading 2nd num items...");
            int numLMItems = fileReader.readInt();
            //System.out.println("#lmItems:" + numLMItems);
            
            for (int idx=0; idx < numLMItems; idx++)
            {
                //System.out.println(idx);
                
                int wordId = fileReader.readInt();
                int frequency = fileReader.readInt();
                double probability = fileReader.readDouble();
                
                m_CollectionLanguageModel.addEntry(new Integer(wordId), new LanguageModelItem(wordId, frequency, probability));
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
     */
    public static void preprocess()
    {
        ConceptLMUnigramTable.clear();
        
        List<Integer> conceptIds = ConceptIdToPhraseIdsTable.getConceptIds();
        
        //System.out.println("#concept ids: " + conceptIds.size());
        
        for (Integer conceptId : conceptIds)
        {
            List<Integer> phraseIdList = ConceptIdToPhraseIdsTable.getPhraseIdsForConcept(conceptId);
            
            //System.out.println("conceptId: " + conceptId + ", #phrases: " + phraseIdList.size());            
            
            LanguageModel conceptLM = new LanguageModel();
            
            for (Integer phraseId : phraseIdList)
            {
                List<Integer> wordIds = PhraseIdToWordIdsTable.getWordIds(phraseId);
            
                for (Integer wordId : wordIds)
                {
                    conceptLM.addEntry(wordId);
                    m_CollectionLanguageModel.addEntry(wordId);
                }
            }
            
            conceptLM.updateItemProbabilities();
            m_ConceptLanguageModels.put(conceptId, conceptLM);
            
//            System.out.println("conceptId: " + conceptId + ", #phrases: " + phraseIdList.size());
//            LanguageModel conceptLM2 = m_ConceptLanguageModels.get(conceptId);
//            List<LanguageModelItem> lmItems = conceptLM2.getItems();
//            for (LanguageModelItem lmItem : lmItems)
//                System.out.println("\twid:" + lmItem.getWordId() + ", freq:" + lmItem.getFrequency());
        }
        
        m_CollectionLanguageModel.updateItemProbabilities();
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
            File f = new File(Constants.FILENAME_BIO_CLM_UNIGRAM);
            if (f.exists())
                f.delete();

            // Concept Language Models
            if (m_ConceptLanguageModels.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.FILENAME_BIO_CLM_UNIGRAM))));

                fileWriter.writeInt(m_ConceptLanguageModels.size());
                
                for (Integer conceptId : m_ConceptLanguageModels.keySet())
                {
                    LanguageModel conceptLM = m_ConceptLanguageModels.get(conceptId);
                    
                    List<LanguageModelItem> lmItems = conceptLM.getItems();
                    
                    fileWriter.writeInt(conceptId);
                    
                    fileWriter.writeInt(lmItems.size());
                    
                    //System.out.println("\tcid:" + conceptId + ", lmItems: " + lmItems.size());                   
                    
                    for (LanguageModelItem lmItem : lmItems)
                    {
                        //System.out.println("\t\twid:" + lmItem.getWordId() + ", freq:" + lmItem.getFrequency() + ", prob:" + lmItem.getProbability());
                        
                        fileWriter.writeInt(lmItem.getWordId());
                        fileWriter.writeInt(lmItem.getFrequency());
                        fileWriter.writeDouble(lmItem.getProbability());
                    }
                }
                
                // Collection Language Model
                List<LanguageModelItem> lmItems = m_CollectionLanguageModel.getItems();
                
                //System.out.println("Collection Language Model");
                fileWriter.writeInt(lmItems.size());
                
                for (LanguageModelItem lmItem : lmItems)
                {
                    //System.out.println("\twid:" + lmItem.getWordId() + ", freq:" + lmItem.getFrequency());
                    fileWriter.writeInt(lmItem.getWordId());
                    fileWriter.writeInt(lmItem.getFrequency());
                    fileWriter.writeDouble(lmItem.getProbability());
                }
            }
            else
            {
                System.out.println("There are no models to write");
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
