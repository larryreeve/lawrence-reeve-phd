/*
 * 
 *
 *
 */
package edu.drexelist.biochain;

import java.util.*;
import java.io.*;

//import gov.nih.nlm.nls.utils.U;              // - -------------------- 
import gov.nih.nlm.nls.nlp.textfeatures.*;     // - Included in mmtx.jar 
import gov.nih.nlm.nls.mmtx.MMTxAPI;           // - --------------------


/**
 * Implements lexical chaining using MetaMap Transfer
 *
 */
class TxtFilenameFilter implements FilenameFilter 
{
    public boolean accept(File dir, String name) 
    { 
        return (name.endsWith(".txt") ); 
    };
}


public class LexChainMMTx 
{


    //  ------------------------------------------------------- Constants
    private static final int MAX_SEMANTIC_TYPES = 256; 
    
    //  ------------------------------------------------------- Instance Varibles
    private MMTxAPI mmtx = null;
    private LexChainTermList lexChains[] = null;
    private List sentences = null;
    
    //  ------------------------------------------------------- Properties
    public LexChainTermList[] getLexChains()
    {
    	return this.lexChains;
    }

    public List getSentences()
    {
    	return this.sentences;
    }

    //  ------------------------------------------------------- Public Methods
    /**
     * @param filename Full path to the semdef.txt MMTx semantic definitions file.
     *  Input line looks like:
     *  	aapp|T116|Amino Acid, Peptide, or Protein
     */
    public LexChainMMTx(MMTxAPI mmtx) 
    {
        this.mmtx = mmtx;
    }

    /**
     * @param filename Full path to the semdef.txt MMTx semantic definitions file.
     *  Input line looks like:
     *  	aapp|T116|Amino Acid, Peptide, or Protein
     */
    public LexChainStats chainFile(String filename) 
        throws Exception 
    {
        // Create locals
        LexChainStats lexStats = new LexChainStats();
        lexChains = new LexChainTermList[MAX_SEMANTIC_TYPES];
        sentences = new ArrayList();

        // Validate parameters
        //if (this.mmtx == null)
        //    throw new Exception("MMTxAPI instance not specified");
        
        // Initialize chain term list
        Properties chainParameters = new Properties();
        chainParameters.setProperty("scoremethod", "duist");
        chainParameters.setProperty("filtered", "true");
        for (int idx=0; idx < lexChains.length; idx++)
        {
        	lexChains[idx] = new LexChainTermList();
            lexChains[idx].setParameters(chainParameters);
        }
        
        if (filename == null || filename.length() == 0)
            throw new Exception("Filename not specified");
        
        File fileToChain = new File(filename);
        if (fileToChain == null ) 
        {
            throw new Exception("The input file is null"); 
        }
        
        // Initialize lexical chain from UMLS SRDEF file
        BufferedReader srdefReader = null;
        try 
        {
            File srdefFile = new File("data/runtime/SRDEF");
            if (srdefFile == null)
                throw new Exception("Unable to get FILE instance for SRDEF");

            srdefReader = new BufferedReader(new FileReader(srdefFile));
    		
            String line = null;
    		
            while (( line = srdefReader.readLine()) != null)
            {
                String[] fields = line.split("[|]");
    			
                if (fields.length < 3)
                    throw new Exception("Invalid srdef format: " + line);
    			
                //System.out.println(line);
                //System.out.println("\tC:" + fields.length);
                //System.out.println("\tF1:'" + fields[0] + "'");
                //System.out.println("\tF2:'" + fields[1] + "'");
                //System.out.println("\tF3:'" + fields[2] + "'");
                if (fields[0].equalsIgnoreCase("sty")) 
                {
                    int semanticTypeNum = Integer.valueOf(fields[1].substring(1)).intValue();
                    lexChains[semanticTypeNum].setNumber(semanticTypeNum);
                    lexChains[semanticTypeNum].setTUI(fields[1]);
                    lexChains[semanticTypeNum].setDescription(fields[2]);
                }
            }
        }
        finally 
        {
            try 
            {
                if (srdefReader!= null) 
                {
                    srdefReader.close();
                    srdefReader = null;
                }
            }
            catch (IOException e) 
            {
            }
        }

        // Call MetaMap Transfer to convert text into concepts and semantic types
        lexStats.MMTxProcessTime().start();
        FileInputStream fileToChainStream = new FileInputStream(filename);
        int filesize = fileToChainStream.available();
        byte filebuffer[]= new byte[filesize];
        fileToChainStream.read(filebuffer);
        fileToChainStream.close();
        String fileToChainContent = new String(filebuffer);
        fileToChainContent = fileToChainContent.replaceAll(";", ",").replaceAll(":", ",");
        Document aDocument = this.mmtx.processDocument(fileToChainContent);
        lexStats.MMTxProcessTime().stop();

        // Read through MMTx output
        //	Sections
        //		Sentences
        //			Phrases
        lexStats.ChainingProcessTime().start();
        
        Vector sections = aDocument.getSections();
        for (Enumeration e = sections.elements(); e.hasMoreElements(); ) 
        {
            Section aSection = (Section) e.nextElement();
  	        
            //System.out.println( aSection.toPipedString() );
            //System.out.println("SectionId=" + aSection.getId()+1);
	

            // =====================================+ Loop through Sentences +==
            Vector mmtxSentences = aSection.getSentences();
            for (Enumeration f = mmtxSentences.elements(); f.hasMoreElements(); ) 
            {
                Sentence aSentence = (Sentence) f.nextElement();
	            
                //System.out.println( "  " + aSentence.toPipedString() );
                //System.out.println("Sentence=" + aSentence.getId()+1);

                String sentenceText = aSentence.getOriginalString();
                sentenceText = sentenceText.replaceAll("\r\n", "");
                sentenceText = sentenceText.replaceAll("\r", "");
                sentenceText = sentenceText.replaceAll("\n", "");
                sentences.add(sentenceText);
	
                // ==================================+ Loop through Phrases +==
                Vector mmtxPhrases = aSentence.getPhrases();
                for (Enumeration g = mmtxPhrases.elements(); g.hasMoreElements(); ) 
                {
                    Phrase aPhrase = (Phrase) g.nextElement();
        
                    if (aPhrase.isNounPhrase()) 
                    {
                        //System.out.println();
                        //System.out.println("     " + aPhrase.toPipedString() );
                        //System.out.println(aPhrase.getNpString());
	                
                        ArrayList finalMappings = aPhrase.getFinalMappings();
                        if (finalMappings != null) 
                        {
	                		
                            int highScore = ((FinalMapping) finalMappings.get(0)).getScore();
	                		
                            for (Iterator it=finalMappings.iterator(); it.hasNext(); ) 
                            {
                                FinalMapping aMapping = (FinalMapping) it.next();
	                			
                                if (aMapping.getScore() >= highScore) 
                                {
                                    //System.out.println("\tMapping: " +  aMapping.getScore() + "," + highScore);
	                			
                                    ArrayList cuis = aMapping.getConcepts();
    	                
                                    //  Iterate through the concepts of the mapping
                                    for (Iterator l = cuis.iterator(); l.hasNext(); ) 
                                    {
                                        Candidate cuiMapping = (Candidate) l.next();
	                			
                                        //System.out.print("         [" + cuiMapping.getCUI() + "] ");
                                        //System.out.print("\t\t" + cuiMapping.getUMLSConceptName() + "  ");

                                        // --------------------------------------- Iterate through the semantic types
                                        UMLS_SemanticTypePointer semTypes[] = cuiMapping.getUMLS_SemanticTypes();
                                        for (int idx=0; idx < semTypes.length; idx++) 
                                        {
                                            //System.out.print("idx=" + idx + ": " + semTypes[idx].getTUI() + "-" + semTypes[idx].getName() + ";" );

                                            // Create new term
                                            //aPhrase.getNpString()
                                            LexChainTerm term = new LexChainTerm(
                                                aPhrase.getNpString(),
                                                cuiMapping.getConcept(),
                                                aSection.getId(),
                                                aSentence.getId());
	                								
                                            // Add term to lexical chain
                                            int tui = Integer.valueOf(semTypes[idx].getTUI().substring(1)).intValue();
	                						
                                            //System.out.println(tui + "=>" + term.getTerm());	                						
	                						
                                            lexChains[tui].addTerm(term);
                                        }
                                        //System.out.println();
                                    }
                                }
                            }
                        }
                    } // End Mappings
                } // End Phrases
            } // End Sentences
        } // End Sections
        lexStats.ChainingProcessTime().stop();

        //
        // Display results
        //
//        Properties outputParameters = new Properties();
//        ILexChainOutputGenerator output = null;
        
        // Display chains of associated concepts
//        output = new LexChainOutputChainConcepts();
//        outputParameters.clear();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);
        
        // Display chains sorted in ascending order by score
//        output = new LexChainOutputTopChains();
//        outputParameters.clear();
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);
        
        // Display strong chains - 2 StdDevs
//        output = new LexChainOutputStrongChains();
//        outputParameters.clear();
//        outputParameters.setProperty("StdDev", "2");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChains, sentences, outputParameters);

        // Display strong chains - 1 StdDevs
//        output = new LexChainOutputStrongChains();
//        outputParameters.clear();
//        outputParameters.setProperty("StdDev", "1");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChains, sentences, outputParameters);

        // Display top sentences - 1 StdDevs
//        output = new LexChainOutputTopSentences();
//        outputParameters.clear();
//        outputParameters.setProperty("StdDev", "2");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);

        // Display top sentences - 2 StdDevs
//        output = new LexChainOutputTopSentences();
//        outputParameters.clear();
//        outputParameters.setProperty("StdDev", "1");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);

        // Display all sentences
//        output = new LexChainOutputAllSentences();
//        outputParameters.clear();
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);
		
        // Display summary - 2 StdDev
//        output = new LexChainOutputSummary();
//        outputParameters.clear();
//        outputParameters.setProperty("stddev", "2");
//        outputParameters.setProperty("compression", "25");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChains, sentences, outputParameters);

        // Display summary - 1 StdDev
//        output = new LexChainOutputSummary();
//        outputParameters.clear();
//        outputParameters.setProperty("stddev", "1");
//        outputParameters.setProperty("compression", "25");
//        System.out.println();
//        System.out.println();
//        output.generateOutput(lexChain, sentences, outputParameters);

        return lexStats;
    }
    
    
    //  ------------------------------------------------------- Private Methods    
}
