import java.io.*;
import java.util.*;

class GenerateBioChainBatFile
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
                                  
            
        	  String filename = "EvalGenBioChainSummariesSPL.bat";
        	  
        	  
        	  
        	  // Open output config file
        	  System.out.println("Generating bat file " + filename + "...");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            writer.println("@echo off");
            writer.println("if \"%1%\" == \"\" goto ERROR");
            writer.println("");
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_MostFrequentStrongChainConcept_Unfiltered.spl                      -outputoptions compressionrate=%1;format=spl -scorer chainfreq      -scoringoptions useAllStrongChainConcepts=false");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_MostFrequentStrongChainConcept_Filtered.spl                        -outputoptions compressionrate=%1;format=spl -scorer chainfreq      -scoringoptions useAllStrongChainConcepts=false -filter DUCOM");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_MostFrequentStrongChainConcept_UnfilteredPos.spl                   -outputoptions compressionrate=%1;format=spl -scorer chainfreqpos   -scoringoptions useAllStrongChainConcepts=false");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_MostFrequentStrongChainConcept_FilteredPos.spl                     -outputoptions compressionrate=%1;format=spl -scorer chainfreqpos   -scoringoptions useAllStrongChainConcepts=false -filter DUCOM");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Cosine.spl              -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=Cosine");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Dice.spl                -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=Dice");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_Euclidean.spl           -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=Euclidean");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_NewItems.spl            -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=NewItems");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_UnitFrequency.spl       -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=UnitFrequency");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_MostFrequentStrongChainConcept_VectorSubtraction.spl   -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=false;similarityfunction=VectorSubtraction");

                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_AllStrongChainConcepts_Unfiltered.spl                              -outputoptions compressionrate=%1;format=spl -scorer chainfreq      -scoringoptions useAllStrongChainConcepts=true");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_AllStrongChainConcepts_Filtered.spl                                -outputoptions compressionrate=%1;format=spl -scorer chainfreq      -scoringoptions useAllStrongChainConcepts=true -filter DUCOM");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_AllStrongChainConcepts_UnfilteredPos.spl                           -outputoptions compressionrate=%1;format=spl -scorer chainfreqpos   -scoringoptions useAllStrongChainConcepts=true");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChain_AllStrongChainConcepts_FilteredPos.spl                             -outputoptions compressionrate=%1;format=spl -scorer chainfreqpos   -scoringoptions useAllStrongChainConcepts=true -filter DUCOM");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_Cosine.spl                      -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=Cosine");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_Dice.spl                        -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=Dice");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_Euclidean.spl                   -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=Euclidean");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_NewItems.spl                    -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=NewItems");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_UnitFrequency.spl               -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=UnitFrequency");
                writer.println("call biosumm.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioChainPlusFreqDist_AllStrongChainConcepts_VectorSubtraction.spl           -outputoptions compressionrate=%1;format=spl -scorer chainfreqdist  -scoringoptions useAllStrongChainConcepts=true;similarityfunction=VectorSubtraction");
                
                writer.println("");
            }
            
            // Close output config file
          writer.println("");
          writer.println("goto END");
          writer.println();
          writer.println(":ERROR");
          writer.println("echo.");
          writer.println("echo.");
          writer.println("echo Parameter error. The compression rate must be specified.");
          writer.println("echo Example: EvalGenBioChainSummariesSPL 15 to use 15 percent compression");
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
