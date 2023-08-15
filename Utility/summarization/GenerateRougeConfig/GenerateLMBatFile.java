import java.io.*;
import java.util.*;

class GenerateLMBatFile
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
                                  
            
        	  String filename = "EvalGenBioLMSummariesSPL.bat";
        	  
        	  
        	  
        	  // Open output config file
        	  System.out.println("Generating LM bat file " + filename + "...");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            writer.println("@echo off");
            writer.println("if \"%1%\" == \"\" goto ERROR");
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                // words
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-infocontentonly.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;infocontentonly=true");
                
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_sml-sent_sml-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.25;lamdaICLM=0.25;infocontent=idf;mixture=mixture");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_med-sent_sml-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.50;lamdaICLM=0.25;infocontent=idf;mixture=mixture");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_big-sent_sml-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.75;lamdaICLM=0.25;infocontent=idf;mixture=mixture");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_sml-sent_med-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.25;lamdaICLM=0.50;infocontent=idf;mixture=mixture");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_med-sent_med-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.50;lamdaICLM=0.50;infocontent=idf;mixture=mixture");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_big-sent_med-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.75;lamdaICLM=0.50;infocontent=idf;mixture=mixture");
                
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_sml-sent_big-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.25;lamdaICLM=0.75;infocontent=idf;mixture=mixture");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_med-sent_big-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.50;lamdaICLM=0.75;infocontent=idf;mixture=mixture");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lm_big-sent_big-idf-mix.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamdaLM=0.75;lamdaICLM=0.75;infocontent=idf;mixture=mixture");
                

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamsml-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.25;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lammed-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.50;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lambig-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.75;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamdyn-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=sentlen;infocontent=tfidf;mixture=multiplication");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamsml-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.25;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lammed-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.50;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lambig-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.75;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamdyn-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=sentlen;infocontent=idf;mixture=addition");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamsml-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.25;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lammed-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.50;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lambig-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=0.75;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-words-lamdyn-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=false;lamda=sentlen;infocontent=tfidf;mixture=addition");
                
                
                // concepts
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-infocontentonly.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;infocontentonly=true");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamsml-idf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.25;infocontent=idf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lammed-idf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.50;infocontent=idf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lambig-idf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.75;infocontent=idf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamdyn-idf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=sentlen;infocontent=idf;mixture=multiplication");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamsml-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.25;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lammed-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.50;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lambig-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.75;infocontent=tfidf;mixture=multiplication");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamdyn-tfidf-mult.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=sentlen;infocontent=tfidf;mixture=multiplication");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamsml-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.25;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lammed-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.50;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lambig-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.75;infocontent=idf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamdyn-idf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=sentlen;infocontent=idf;mixture=addition");

                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamsml-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.25;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lammed-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.50;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lambig-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=0.75;infocontent=tfidf;mixture=addition");
                //writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_LM-concepts-lamdyn-tfidf-add.spl -outputoptions compressionrate=%1;format=spl -scorer lm -scoringoptions useconcepts=true;lamda=sentlen;infocontent=tfidf;mixture=addition");
            }
            
            // Close output config file
          writer.println("goto END");
          writer.println();
          writer.println(":ERROR");
          writer.println("echo.");
          writer.println("echo.");
          writer.println("echo Parameter error. The compression rate must be specified.");
          writer.println("echo Example: EvalGenBioLMSummariesSPL 15 to use 15 percent compression");
          writer.println("echo.");
          writer.println("echo.");
          writer.println();
          writer.println(":END");
          writer.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
