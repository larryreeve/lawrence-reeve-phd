/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator.mmtx;

import gov.nih.nlm.nls.mmtx.MMTxAPI;
import gov.nih.nlm.nls.nlp.textfeatures.Candidate;
import gov.nih.nlm.nls.nlp.textfeatures.FinalMapping;
import gov.nih.nlm.nls.nlp.textfeatures.Phrase;
import gov.nih.nlm.nls.nlp.textfeatures.Section;
import gov.nih.nlm.nls.nlp.textfeatures.Sentence;
import gov.nih.nlm.nls.nlp.textfeatures.UMLS_SemanticTypePointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import bioannotator.AnnotationTimer;
import bioannotator.IConceptAnnotator;
import biocommon.document.DocumentConcept;
import biocommon.document.DocumentSection;
import biocommon.document.DocumentSentence;
import biocommon.document.DocumentPhrase;

/**
 * Implements annotation using MetaMap Transfer  
 *
 */
public class MMTxAnnotator implements IConceptAnnotator, Serializable
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT        = biocommon.copyright.Copyright.COPYRIGHT;

    private static final long   serialVersionUID = 1965082455622776147L;

    private static MMTxAPI      m_mmtxInstance   = null;
    private static boolean      m_initialized    = false;

    private AnnotationTimer     timer            = new AnnotationTimer();


    /**
     * 
     */
    public AnnotationTimer getAnnotationTimer()
    {
        return this.timer;
    }
    
    /**
     * 
     */
    public String getName()
    {
        return "MMTx";
    }
    
    public String getStats()
    {
        return "";
    }

    /**
     * 
     * 
     */
    public void initialize(Properties parameters) throws Exception
    {
    }

    /**
     * 
     */
    public void terminate() throws Exception
    {
        m_mmtxInstance = null;
        m_initialized  = false;
    }
    
    /**
     * 
     */
    public void annotateFile(String inputFilename, String outputFilename) throws Exception
    {
        if (outputFilename == null || outputFilename.length() == 0)
            throw new Exception("outputFilename not specified");
        
        biocommon.document.Document annotatedDocument = new biocommon.document.Document(inputFilename);
        
        this.annotateFile(inputFilename, annotatedDocument);
        
        annotatedDocument.writeToXMLFile(outputFilename);
    }    

    /**
     * 
     */
    public void annotateFile(String filename, biocommon.document.Document annotatedDocument) throws Exception
    {
        // Validate parameters
        if (annotatedDocument == null)
            throw new Exception("A valid Document instance was not specified.");

        if (filename == null || filename.length() == 0)
            throw new Exception("Filename not specified");

        // Initialize
        annotatedDocument.clear();

        File fileToAnnotate = new File(filename);
        if (fileToAnnotate == null)
            throw new Exception("The input file could not be accessed");
        if (!fileToAnnotate.exists())
            throw new Exception("The input file does not exist");
        if (fileToAnnotate.length() == 0)
            throw new Exception("The input file is empty");

        // If serialized version exists, load it
        //System.out.println("Serialized file: " + filename + ".mmtx");
        File fileSerialized = new File(filename + ".mmtx");
        if (fileSerialized.exists())
        {
            //System.out.println("\tUsing serialized file: " + fileSerialized.toString());
            
            boolean serializeValid = false;

            try
            {
                File file = new File(filename + ".mmtx");
                ObjectInputStream serializationReader = new ObjectInputStream(new FileInputStream(file));
                biocommon.document.Document serializedDocument = (biocommon.document.Document) serializationReader.readObject();
                serializationReader.close();

                if (serializedDocument != null)
                {
                    for (DocumentSection section : serializedDocument.getSections())
                        annotatedDocument.getSections().add(section);

                    serializeValid = true;
                }
            }
            catch (ClassNotFoundException e)
            {
            }
            catch (IOException e)
            {
            }

            if (serializeValid)
                return;
        }

        // Read full document text into memory
        FileInputStream fileStreamAnnotate = new FileInputStream(filename);
        int filesize = fileStreamAnnotate.available();
        byte filebuffer[] = new byte[filesize];
        fileStreamAnnotate.read(filebuffer);
        fileStreamAnnotate.close();
        String fileContent = new String(filebuffer);
        fileContent = fileContent.replaceAll(";", ",").replaceAll(":", ",");

        this.annotateText(fileContent, annotatedDocument);

        // Serialize document for future use
        try
        {
            if (fileSerialized.exists())
                fileSerialized.delete();
            ObjectOutput serializationWriter = new ObjectOutputStream(new FileOutputStream(fileSerialized));
            serializationWriter.writeObject(annotatedDocument);
            serializationWriter.close();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public void annotatePhrase(DocumentPhrase phrase) throws Exception
    {
        // Validate parameters
        if (phrase == null || phrase.getPhraseText() == null || phrase.getPhraseText().length() == 0)
            throw new Exception("A valid DocumentSentencePhrase instance was not specified.");
        
        //
        // Initialize
        //
        phrase.getConcepts().clear();

        if (!m_initialized)
            delayedInitialize();

        try
        {
            this.timer.phraseStartClock();

            // Read full document text into memory
            String phraseContent = phrase.getPhraseText().replaceAll(";", ",").replaceAll(":", ",");

            // Process document through MMTx
            gov.nih.nlm.nls.nlp.textfeatures.Phrase mmtxPhrase = m_mmtxInstance.processTerm(phraseContent);

            // Read through MMTx output, order hierarchically as:
            //		- Sections 
            //			- Sentences
            //				- Phrases
            //

            // Create new section instance and add it to document list of sections
//            DocumentSection docSection = new DocumentSection(0, "phrase");
//            annotatedDocument.getSections().add(docSection);
//
//            // Create new sentence instance and add it to section list of sentences
//            DocumentSentence docSentence = new DocumentSentence(phrase, 0, 0);
//            docSection.getSentences().add(docSentence);

            // Get list of all concept mappings for phrase
            ArrayList<FinalMapping> mmtxFinalMappings = mmtxPhrase.getFinalMappings();
            if (mmtxFinalMappings != null)
            {
                // Create new phrase instance and add it to sentence list of phrases
//                DocumentSentencePhrase docPhrase = new DocumentSentencePhrase(mmtxPhrase.getFullString(), 0, 0);
//                docSentence.getPhrases().add(docPhrase);

                // Add highest scoring mappings only
                int highScore = ((FinalMapping) mmtxFinalMappings.get(0)).getScore();
                for (FinalMapping mmtxFinalMapping : mmtxFinalMappings)
                {
                    if (mmtxFinalMapping.getScore() >= highScore)
                    {
                        //System.out.println("\tMapping: " +  mmtxFinalMapping.getScore() + "," + highScore);

                        ArrayList<Candidate> conceptMappingList = mmtxFinalMapping.getConcepts();

                        //  Iterate through the concepts of the mapping
                        for (Candidate conceptmapping : conceptMappingList)
                        {
                            //System.out.print("         [" + conceptmapping.getCUI() + "] ");
                            //System.out.println("\t" + conceptmapping.getCUI() + ", " + conceptmapping.getUMLSConceptName() + ", " + conceptmapping.getFinalScore());

                            // --------------------------------------- Iterate through the semantic types
                            UMLS_SemanticTypePointer semTypes[] = conceptmapping.getUMLS_SemanticTypes();
                            for (UMLS_SemanticTypePointer semType : semTypes)
                            {
                                // Add new concept
                                DocumentConcept phraseConcept = new DocumentConcept(conceptmapping.getCUI(), conceptmapping
                                        .getUMLSConceptName(), semType.getTUI());
                                if (!phrase.getConcepts().containsKey(conceptmapping.getCUI()))
                                    phrase.getConcepts().put(conceptmapping.getCUI(), phraseConcept);
                            }

                            //System.out.println();
                        }
                    }
                }
            }
        }
        finally
        {
            this.timer.phraseEndClock();
        }
    }
    
    
    /**
     * 
     */
    public void annotatePhraseFile(String phraseFilename, PrintStream ps) throws Exception
    {
        // Validate parameters
        if (phraseFilename == null || phraseFilename.length() == 0)
            throw new Exception("Filename not specified");

        // Verify file is specified, exists and is not empty
        File fileToAnnotate = new File(phraseFilename);
        if (fileToAnnotate == null)
            throw new Exception("The input file could not be accessed");
        if (!fileToAnnotate.exists())
            throw new Exception("The input file does not exist");
        if (fileToAnnotate.length() == 0)
            throw new Exception("The input file is empty");

        // Process file
        BufferedReader fileReader = null;
        
        try
        {
            fileReader = new BufferedReader(new FileReader(phraseFilename));
            
            String line = null;
            while ((line = fileReader.readLine()) != null)
            {
                String phrase = line.trim().toLowerCase();
                
                //System.out.println("phrase: " + phrase);
                
                Integer numMappings = Integer.parseInt(fileReader.readLine().trim());
                for (int idx=0; idx < numMappings; idx++)
                    fileReader.readLine();
                
                biocommon.document.DocumentPhrase annotatedPhrase = new biocommon.document.DocumentPhrase(phrase, 0, 0);
                
                this.annotatePhrase(annotatedPhrase);
                
//                for (DocumentSection docSection : annotatedDocument.getSections())
//                {
//                    for (DocumentSentence docSentence : docSection.getSentences())
//                    {
//                        for (DocumentSentencePhrase docPhrase : docSentence.getPhrases())
                        {
                            if (ps != null)
                            {
                                // The phrase source text
                                ps.println(annotatedPhrase.getPhraseText());
                            
                                // The number of concepts mapped
                                ps.println("  " + annotatedPhrase.getConcepts().values().size());
                            
                                // The mapped concepts
                                for (DocumentConcept docPhraseConcept : annotatedPhrase.getConcepts().values())
                                {
                                    ps.println("  " + docPhraseConcept.getId() + "|" + docPhraseConcept.getName() + "|" + docPhraseConcept.getSemanticTypeId());
                                }
                            }
                        }
//                    }
//                }
            }            
            
            fileReader.close();
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

    
    @SuppressWarnings("unchecked")
    public void annotateText(String text, biocommon.document.Document annotatedDocument) throws Exception
    {
        // Validate parameters
        if (annotatedDocument == null)
            throw new Exception("A valid Document instance was not specified.");

        // Initialize
        annotatedDocument.clear();

        if (m_mmtxInstance == null)
        {
            m_mmtxInstance = new MMTxAPI();
            if (m_mmtxInstance == null)
                throw new Exception("MMTx API instance not available");
        }

        // Read full document text into memory
        String documentContent = text.replaceAll(";", ",").replaceAll(":", ",");

        // Process document through MMTx
        gov.nih.nlm.nls.nlp.textfeatures.Document mmtxDocument = m_mmtxInstance.processDocument(documentContent);

        // Read through MMTx output, order hierarchically as:
        //		- Sections 
        //			- Sentences
        //				- Phrases
        //

        // Process all sections
        Vector<Section> mmtxSections = mmtxDocument.getSections();
        for (Section mmtxSection : mmtxSections)
        {
            DocumentSection docSection = new DocumentSection(mmtxSection.getId(), mmtxSection.getSectionName());
            annotatedDocument.getSections().add(docSection);

            // Process all sentences 
            Vector<Sentence> mmtxSentences = mmtxSection.getSentences();
            for (Sentence mmtxSentence : mmtxSentences)
            {
                // Process sentence text
                String sentenceText = mmtxSentence.getOriginalString();
                sentenceText = sentenceText.replaceAll("\r\n", "");
                sentenceText = sentenceText.replaceAll("\r", "");
                sentenceText = sentenceText.replaceAll("\n", "");

                // Create new sentence instance and add it to section list of sentences
                DocumentSentence docSentence = new DocumentSentence(sentenceText, mmtxSentence.getId(), mmtxSection.getId());
                docSection.getSentences().add(docSentence);

                // Process all sentence phrases
                Vector<Phrase> mmtxPhrases = mmtxSentence.getPhrases();
                for (Phrase mmtxPhrase : mmtxPhrases)
                {
                    if (mmtxPhrase.isNounPhrase())
                    {
                        // Get list of all concept mappings
                        ArrayList<FinalMapping> mmtxFinalMappings = mmtxPhrase.getFinalMappings();
                        if (mmtxFinalMappings != null)
                        {
                            // Create new phrase instance and add it to sentence list of phrases
                            DocumentPhrase docPhrase = new DocumentPhrase(mmtxPhrase.getNpString(), mmtxSection
                                    .getId(), mmtxSentence.getId());
                            docSentence.getPhrases().add(docPhrase);

                            //System.out.println(mmtxPhrase.getNpString());

                            int highScore = ((FinalMapping) mmtxFinalMappings.get(0)).getScore();

                            for (FinalMapping mmtxFinalMapping : mmtxFinalMappings)
                            {
                                if (mmtxFinalMapping.getScore() >= highScore)
                                {
                                    //System.out.println("\tMapping: " +  mmtxFinalMapping.getScore() + "," + highScore);

                                    ArrayList<Candidate> conceptMappingList = mmtxFinalMapping.getConcepts();

                                    //  Iterate through the concepts of the mapping
                                    for (Candidate conceptmapping : conceptMappingList)
                                    {
                                        //System.out.print("         [" + conceptmapping.getCUI() + "] ");
                                        //System.out.println("\t" + conceptmapping.getCUI() + ", " + conceptmapping.getUMLSConceptName() + ", " + conceptmapping.getFinalScore());

                                        // --------------------------------------- Iterate through the semantic types
                                        UMLS_SemanticTypePointer semTypes[] = conceptmapping.getUMLS_SemanticTypes();
                                        for (UMLS_SemanticTypePointer semType : semTypes)
                                        {
                                            // Add new concept
                                            DocumentConcept phraseConcept = new DocumentConcept(conceptmapping.getCUI(),
                                                    conceptmapping.getUMLSConceptName(), semType.getTUI());
                                            if (!docPhrase.getConcepts().containsKey(conceptmapping.getCUI()))
                                                docPhrase.getConcepts().put(conceptmapping.getCUI(), phraseConcept);
                                        }

                                        //System.out.println();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @throws Exception
     */
    private void delayedInitialize() throws Exception
    {
        if (!m_initialized)
        {
            try
            {
                this.timer.initializationStartClock();

                m_mmtxInstance = new MMTxAPI();

                if (m_mmtxInstance == null)
                    throw new Exception("MMTx API instance not available");

                m_initialized = true;
            }
            finally
            {
                this.timer.initializationEndClock();
            }
        }
    }
}
