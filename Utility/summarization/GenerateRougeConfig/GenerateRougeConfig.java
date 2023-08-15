import java.io.*;
import java.util.*;

class GenerateRougeConfig
{
    public static void main(String[] args) 
    {
        try 
        {
            String [] paperIds  = { "0002", 
                                    "0013",
                                    "0162",
                                    "0234",
                                    "0782",
                                    "0786",
                                    "0787",
                                    "0811",
                                    "0814",
                                    "0821",
                                    "0954",
                                    "1001",
                                    "1108",
                                    "1110",
                                    "1111",
                                    "1115",
                                    "1117",
                                    "1118",
                                    "1122",
                                    "1132",
                                    "1197",
                                    "3563",
                                    "4016",
                                    "4017"
                                  };
                                  
            String [] models    = {"Jonathan", "Saya", "Tami"};
            //String [] models    = { "Saya", "Tami"};
            //String [] models    = {"Abstract"};
            //String [] models    = {"Saya"};
            //String [] models    = {"Abstract", "Jonathan", "Saya", "Tami"};
            //String [] models    = {"Jonathan", "Saya"};

            String pctValue = "20";
            
            
        	String filename = args[0];
        	  
        	// Open output config file
        	System.out.println("Generating rouge config file " + filename + "...");
            PrintWriter writerRougeConfig = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            writerRougeConfig.println("<ROUGE-EVAL version=\"1.0\">");
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                writerRougeConfig.println("\t<EVAL ID=\"1\">");
                    writerRougeConfig.println("\t\t<PEER-ROOT>systems</PEER-ROOT>");
                    writerRougeConfig.println("\t\t<MODEL-ROOT>models</MODEL-ROOT>");
                    writerRougeConfig.println("\t\t<INPUT-FORMAT TYPE=\"SPL\"/>");
                
                    writerRougeConfig.println("\t\t<PEERS>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Baseline-Lead\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BASE-LEAD.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Baseline-Random\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BASE-RANDOM.spl</P>");
                        
                        //writerRougeConfig.println("\t\t\t<P ID=\"Biochain-MostFrequentStrongChainConcept\">"                                + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_MostFrequentStrongChainConcept_Unfiltered.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"Biochain-MostFrequentStrongChainConcept-Filtered\">"                       + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_MostFrequentStrongChainConcept_Filtered.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Biochain-MostFrequentStrongChainConcept-Position\">"                       + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_MostFrequentStrongChainConcept_UnfilteredPos.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"Biochain-MostFrequentStrongChainConcept-Position-Filtered\">"              + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_MostFrequentStrongChainConcept_FilteredPos.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-Cosine\">"             + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Cosine.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-Dice\">"               + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Dice.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-Euclidean\">"          + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Euclidean.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-NewItems\">"           + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_NewItems.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-UnitFrequency\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_UnitFrequency.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-MostFrequentStrongChainConcept-VectorSubtraction\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_VectorSubtraction.spl</P>");

                        //writerRougeConfig.println("\t\t\t<P ID=\"Biochain-AllStrongChainConcepts\">"                                        + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_AllStrongChainConcepts_Unfiltered.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"Biochain-AllStrongChainConcepts-Filtered\">"                               + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_AllStrongChainConcepts_Filtered.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Biochain-AllStrongChainConcepts-Position\">"                               + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_AllStrongChainConcepts_UnfilteredPos.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"Biochain-AllStrongChainConcepts-Position-Filtered\">"                      + paperId + "-ArticleSummary_" + pctValue + "pct_BioChain_AllStrongChainConcepts_FilteredPos.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-Cosine\">"                     + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_Cosine.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-Dice\">"                       + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_Dice.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-Euclidean\">"                  + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_Euclidean.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-NewItems\">"                   + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_NewItems.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-UnitFrequency\">"              + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_UnitFrequency.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"BiochainPlusFreqDist-AllStrongChainConcepts-VectorSubtraction\">"          + paperId + "-ArticleSummary_" + pctValue + "pct_BioChainPlusFreqDist_AllStrongChainConcepts_VectorSubtraction.spl</P>");
                        
                        ////writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptMMTX-Cosine\">"            + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptMMTX_Cosine.spl</P>");
                        writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptMMTX-Dice\">"              + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptMMTX_Dice.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptMMTX-Euclidean\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptMMTX_Euclidean.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptMMTX-UnitFrequency\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptMMTX_UnitFrequency.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptMMTX-VectorSubtraction\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptMMTX_VectorSubtraction.spl</P>");

                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptDUIST-Cosine\">"            + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptDUIST_Cosine.spl</P>");
                        writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptDUIST-Dice\">"              + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptDUIST_Dice.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptDUIST-Euclidean\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptDUIST_Euclidean.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptDUIST-UnitFrequency\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptDUIST_UnitFrequency.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-ConceptDUIST-VectorSubtraction\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-ConceptDUIST_VectorSubtraction.spl</P>");
                        
                        ////writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-Term-Cosine\">"               + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-Term_Cosine.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-Term-Dice\">"                 + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-Term_Dice.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-Term-Euclidean\">"            + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-Term_Euclidean.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-Term-UnitFrequency\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-Term_UnitFrequency.spl</P>");
                        ////writerRougeConfig.println("\t\t\t<P ID=\"FreqDist-Term-VectorSubtraction\">"    + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_FreqDist-Term_VectorSubtraction.spl</P>");
                        
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_SML-SENT_SML-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_sml-sent_sml-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_MED-SENT_SML-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_med-sent_sml-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_BIG-SENT_SML-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_big-sent_sml-idf-mix.spl</P>");

                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_SML-SENT_MED-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_sml-sent_med-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_MED-SENT_MED-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_med-sent_med-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_BIG-SENT_MED-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_big-sent_med-idf-mix.spl</P>");

                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_SML-SENT_BIG-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_sml-sent_big-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_MED-SENT_BIG-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_med-sent_big-idf-mix.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LM_BIG-SENT_BIG-IDF-Mix\">"  + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lm_big-sent_big-idf-mix.spl</P>");
                        
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-InfoContentOnly\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-infocontentonly.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamSml-IDF-Mult\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamsml-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamMed-IDF-Mult\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lammed-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamBig-IDF-Mult\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lambig-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamDyn-IDF-Mult\">"        + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamdyn-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamSml-TFIDF-Mult\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamsml-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamMed-TFIDF-Mult\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lammed-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamBig-TFIDF-Mult\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lambig-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamDyn-TFIDF-Mult\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamdyn-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamSml-IDF-Add\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamsml-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamMed-IDF-Add\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lammed-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamBig-IDF-Add\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lambig-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamDyn-IDF-Add\">"         + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamdyn-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamSml-TFIDF-Add\">"       + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamsml-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamMed-TFIDF-Add\">"       + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lammed-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamBig-TFIDF-Add\">"       + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lambig-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Words-LamDyn-TFIDF-Add\">"       + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-words-lamdyn-tfidf-add.spl</P>");
                        

                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-InfoContentOnly\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-infocontentonly.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamSml-IDF-Mult\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamsml-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamMed-IDF-Mult\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lammed-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamBig-IDF-Mult\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lambig-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamDyn-IDF-Mult\">"     + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamdyn-idf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamSml-TFIDF-Mult\">"   + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamsml-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamMed-TFIDF-Mult\">"   + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lammed-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamBig-TFIDF-Mult\">"   + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lambig-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamDyn-TFIDF-Mult\">"   + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamdyn-tfidf-mult.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamSml-IDF-Add\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamsml-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamMed-IDF-Add\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lammed-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamBig-IDF-Add\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lambig-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamDyn-IDF-Add\">"      + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamdyn-idf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamSml-TFIDF-Add\">"    + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamsml-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamMed-TFIDF-Add\">"    + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lammed-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamBig-TFIDF-Add\">"    + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lambig-tfidf-add.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"BioLM-Concepts-LamDyn-TFIDF-Add\">"    + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_LM-concepts-lamdyn-tfidf-add.spl</P>");
                        
                        writerRougeConfig.println("\t\t\t<P ID=\"SumBasic-ConceptMMTX\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_SumBasic-ConceptMMTX.spl</P>");
                        writerRougeConfig.println("\t\t\t<P ID=\"SumBasic-ConceptDUIST\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_SumBasic-ConceptDUIST.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"SumBasic-Term\">" + paperId + "-ArticleSummary_" + pctValue + "pct_BioSumm_SumBasic-Term.spl</P>");
                        
                        ////writerRougeConfig.println("\t\t\t<P ID=\"Lemur-Basic\">" + paperId + "-ArticleSummary_" + pctValue + "pct_LemurBasic.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Lemur-MMR\">" + paperId + "-ArticleSummary_" + pctValue + "pct_LemurMMR.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Mead\">" + paperId + "-ArticleSummary_" + pctValue + "pct_MEAD.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"MSWord\">" + paperId + "-ArticleSummary_" + pctValue + "pct_MSWord.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"OTS\">" + paperId + "-ArticleSummary_" + pctValue + "pct_OTS.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"SweSum\">" + paperId + "-ArticleSummary_" + pctValue + "pct_SweSum.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Author-Abstract\">" + paperId + "-ArticleSummary_Abstract.spl</P>");
                        //writerRougeConfig.println("\t\t\t<P ID=\"Expert-Summary\">" + paperId + "-ArticleSummary_F1.spl</P>");
                    writerRougeConfig.println("\t\t</PEERS>");
                
                    writerRougeConfig.println("\t\t<MODELS>");
                    char postFix = 'A';
                    for (String model : models)
                    {
                        writerRougeConfig.println("\t\t\t<M ID=\"" + paperId + "-" + postFix + "\">" + paperId + "-Model_" + pctValue + "pct_" + model + ".spl</M>");
                        postFix++;
                    }
                    writerRougeConfig.println("\t\t</MODELS>");
                    
                writerRougeConfig.println("\t</EVAL>");
                writerRougeConfig.println();
            }
            
            // Close output config file
            writerRougeConfig.println("</ROUGE-EVAL>");
            writerRougeConfig.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
