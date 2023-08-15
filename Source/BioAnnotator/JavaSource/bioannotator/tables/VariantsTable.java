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
import biocommon.util.string.StringUtility;

public class VariantsTable
{
    @SuppressWarnings("unused")
    private static final String                COPYRIGHT               = biocommon.copyright.Copyright.COPYRIGHT;

    private static final char[]                MULTIWORD_DELIMITERS    = { ' ', '-' };
    private static final List<Integer>         EMPTY_INTEGER_LIST      = new ArrayList<Integer>();

    private static Map<Integer, List<Integer>> m_VariantWordsFull      = new TreeMap<Integer, List<Integer>>();
    private static Map<String, String>         m_VariantWordsInflected = new TreeMap<String, String>();

    
    /**
     * 
     * 
     */
    public static void clear()
    {
        m_VariantWordsFull.clear();
        m_VariantWordsInflected.clear();
    }
    
    public static int sizeInflected()
    {
        return m_VariantWordsInflected.size();
    }

    public static int sizeFullVariant()
    {
        return m_VariantWordsFull.size();
    }

    /**
     * 
     * @param word
     * @return
     */
    public static List<Integer> getBaseWordFullVariants(Integer wordId)
    {
        List<Integer> wordVariants = m_VariantWordsFull.get(wordId);

        if (wordVariants == null)
            return EMPTY_INTEGER_LIST;

        return wordVariants;
    }


    /**
     * 
     * @param word
     * @return
     */
    public static String getBaseWordInflected(String word)
    {
        String wordNormalized = StringUtility.normalizeToKey(word);

        String baseWord = m_VariantWordsInflected.get(wordNormalized);

        if (baseWord == null)
            baseWord = wordNormalized;

        return baseWord;
    }

    /**
     * 
     * @throws Exception
     */
    public static void load() throws Exception
    {
        VariantsTable.clear();

        DataInputStream fileReader = null;

        try
        {
            File f = new File(Constants.FILENAME_BIO_VARIANTS);
            if (!f.exists())
                throw new Exception("File does not exist: " + Constants.FILENAME_BIO_VARIANTS);

            fileReader = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(
                    Constants.FILENAME_BIO_VARIANTS))));

            m_VariantWordsInflected = new TreeMap<String, String>();
            m_VariantWordsFull = new TreeMap<Integer, List<Integer>>();

            // Inflected Words
            int numEntriesInflected = fileReader.readInt();
            for (int recordIndex = 0; recordIndex < numEntriesInflected; recordIndex++)
            {
                String baseWord = fileReader.readUTF();
                String variantWord = fileReader.readUTF();

                m_VariantWordsInflected.put(baseWord, variantWord);
            }

            // Full variant words
            int numEntriesFull = fileReader.readInt();
            // System.out.println("# full entries: " + numEntriesFull);
            for (int recordIndex = 0; recordIndex < numEntriesFull; recordIndex++)
            {
                Integer baseWordId = fileReader.readInt();

                int numWordVariants = fileReader.readInt();

                // System.out.println(baseWord + "(" + numWordVariants + ")");

                if (numWordVariants > 0)
                {
                    List<Integer> wordVariants = new ArrayList<Integer>(numWordVariants);

                    for (int wordVariantIndex = 0; wordVariantIndex < numWordVariants; wordVariantIndex++)
                    {
                        Integer wordVariant = fileReader.readInt();
                        // System.out.println("\t" + wordVariant);
                        wordVariants.add(wordVariant);
                    }

                    m_VariantWordsFull.put(baseWordId, wordVariants);
                }
            }

            fileReader.close();
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
     *  // ----+---+-------+------+--------+-------+-------+-----+------+----+ //
     * term|cat|variant|varCat|distance|history|FullVar|VarAN|VarANU|VarU| //
     * ----+---+-------+------+--------+-------+-------+-----+------+----+
     * 
     * FullVar - foundInFullTable VarAN - foundInNounAdjDerivationFilteredTable
     * VarANU - foundInNounAdjDerivationAndUniqAcronymFilteredTable VarU -
     * foundInUniqAcronymsFilteredTable
     * 
     * @throws Exception
     */
    public static void preprocess() throws Exception
    {
        VariantsTable.clear();

        BufferedReader fileReader = null;

        // Inflectional Variants
        //
        // bled|1024|32|E0218413|bleed|bleed
        // bled|1024|64|E0218413|bleed|bleed
        // bleed|1024|1|E0218413|bleed|bleed
        try
        {
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_VARIANT_INFLECTION));

            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 6)
                    throw new Exception("Invalid variant-inflection file format: " + line);

                String baseWord = StringUtility.normalizeToKey(fields[0]);
                String variantWord = StringUtility.normalizeToKey(fields[4]);
                String inflectionType = StringUtility.normalizeToKey(fields[2]);
                
//                if (inflectionType.equalsIgnoreCase("1")  ||    // COMPARATIVE
//                    inflectionType.equalsIgnoreCase("8")  ||    // Plural
//                    inflectionType.equalsIgnoreCase("16") ||    // PRESENT_PARTICIPLE
//                    inflectionType.equalsIgnoreCase("32") ||    // Past-tense
//                    inflectionType.equalsIgnoreCase("128"))     // PRESENT_3S
                if (    inflectionType.equalsIgnoreCase("8")  ||    // Plural
                        inflectionType.equalsIgnoreCase("16") ||    // PRESENT_PARTICIPLE
                        inflectionType.equalsIgnoreCase("32") ||    // Past-tense
                        inflectionType.equalsIgnoreCase("128"))     // PRESENT_3S
                {
                    if (!baseWord.equalsIgnoreCase(variantWord))
                    {
                        if (!StringUtility.hasCharacter(baseWord, MULTIWORD_DELIMITERS))
                        {
                            m_VariantWordsInflected.put(baseWord, variantWord);
                            
                            if (!WordToWordIdTable.wordExists(baseWord))
                                WordToWordIdTable.addEntry(baseWord);
                            if (!WordToWordIdTable.wordExists(variantWord))
                                WordToWordIdTable.addEntry(variantWord);
                        }
                    }
                }
            }
            fileReader.close();
            fileReader = null;

            //
            // Full variants
            //
            // bleeding|verb|bleeder|noun|4|di|1|0|0|1
            // bleeding|verb|bleeders|noun|5|idi|1|0|0|1
            // bleeding|noun|bleedings|noun|1|i|1|1|1|1
            // bleeding|noun|bleeding|noun|0|NULL|1|1|1|1
            // bleeding|verb|bled|verb|2|ii|1|1|1|1
            // bleeding|verb|bleeds|verb|2|ii|1|1|1|1
            // bleeding|verb|phlebotomized|verb|4|isi|1|1|1|1
            // bleeding|verb|phlebotomizes|verb|4|isi|1|1|1|1
            // bleeding|verb|bleed|verb|1|i|1|1|1|1
            // bleeding|verb|phlebotomize|verb|3|si|1|1|1|1
            // bleeding|verb|phlebotomise|verb|3|psi|1|1|1|1
            // bleeding|verb|bleeding|verb|0|NULL|1|1|1|1
            // bleeding|verb|phlebotomising|verb|4|ipsi|1|1|1|1
            // bleeding|verb|phlebotomises|verb|4|ipsi|1|1|1|1
            // bleeding|verb|phlebotomised|verb|4|ipsi|1|1|1|1
            // bleeding|verb|phlebotomizing|verb|4|isi|1|1|1|1
            //
            // premalignant|adj|precancerous|adj|2|sp|1|1|1|1
            // precancerous|adj|premalignant|adj|2|sp|1|1|1|1
            fileReader = new BufferedReader(new FileReader(Constants.FILENAME_UMLS_VARIANT_FULL));

            while ((line = fileReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");

                if (fields.length != 10)
                    throw new Exception("Invalid variant-full file format: " + line);

                String baseWord = StringUtility.normalizeToKey(fields[0]);
                // String baseWordCategory = fields[1];
                String variantWord = StringUtility.normalizeToKey(fields[2]);
                // String variantWordCategory = fields[3];
                //int distance = Integer.parseInt(fields[4].trim());

                if (!StringUtility.hasCharacter(baseWord, MULTIWORD_DELIMITERS) && 
                    !baseWord.equalsIgnoreCase(variantWord))
                {
//                    if (baseWord.equalsIgnoreCase("criterion"))
//                        System.out.println(baseWord + "-->" + variantWord);
                    
                    if (!WordToWordIdTable.wordExists(baseWord))
                        WordToWordIdTable.addEntry(baseWord);
                    if (!WordToWordIdTable.wordExists(variantWord))
                        WordToWordIdTable.addEntry(variantWord);
                    
                    Integer baseWordId = WordToWordIdTable.getWordId(baseWord);
                    Integer variantWordId = WordToWordIdTable.getWordId(variantWord);
                    
                    if (m_VariantWordsFull.containsKey(baseWordId))
                    {
                        List<Integer> wordVariants = m_VariantWordsFull.get(baseWordId);
                        wordVariants.add(variantWordId);
                    }
                    else
                    {
                        List<Integer> wordVariants = new ArrayList<Integer>();
                        wordVariants.add(variantWordId);
                        m_VariantWordsFull.put(baseWordId, wordVariants);
                    }
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
                // ignore errors
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
            File f = new File(Constants.FILENAME_BIO_VARIANTS);
            if (f.exists())
                f.delete();

            if (m_VariantWordsInflected.size() > 0 || m_VariantWordsFull.size() > 0)
            {
                fileWriter = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(
                        Constants.FILENAME_BIO_VARIANTS))));

                // Inflected Variants
                fileWriter.writeInt(m_VariantWordsInflected.size());
                for (String variantWord : m_VariantWordsInflected.keySet())
                {
                    String baseWord = m_VariantWordsInflected.get(variantWord);

                    fileWriter.writeUTF(variantWord);
                    fileWriter.writeUTF(baseWord);
                }

                // Full Variants
                fileWriter.writeInt(m_VariantWordsFull.size());
                for (Integer baseWordId : m_VariantWordsFull.keySet())
                {
                    fileWriter.writeInt(baseWordId);

                    List<Integer> variantWordIds = m_VariantWordsFull.get(baseWordId);

                    fileWriter.writeInt(variantWordIds.size());

                    for (Integer variantWordId : variantWordIds)
                        fileWriter.writeInt(variantWordId);
                }

                fileWriter.close();
                fileWriter = null;
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
