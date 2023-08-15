import java.io.*;
import java.util.*;

class GenerateFreqDistBatFile
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
                                  
            
        	  String filename = "EvalGenBioFreqDistSummariesSPL.bat";
        	  
        	  
        	  
        	  // Open output config file
        	  System.out.println("Generating freq dist bat file " + filename + "...");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            writer.println("@echo off");
            writer.println("if \"%1%\" == \"\" goto ERROR");
            
            
            // Write an entry for each paper
            for (String paperId : paperIds)
            {
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Term_Cosine.spl                -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=false;similarityfunction=Cosine");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Term_Dice.spl                  -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=false;similarityfunction=Dice");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Term_Euclidean.spl             -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=false;similarityfunction=Euclidean");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Term_UnitFrequency.spl         -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=false;similarityfunction=UnitFrequency");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Term_VectorSubtraction.spl     -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=false;similarityfunction=VectorSubtraction");
                
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Concept_Cosine.spl             -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=true;similarityfunction=Cosine");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Concept_Dice.spl               -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=true;similarityfunction=Dice");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Concept_Euclidean.spl          -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=true;similarityfunction=Euclidean");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Concept_UnitFrequency.spl      -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=true;similarityfunction=UnitFrequency");
                writer.println("call biochain.bat -inputfilefull data\\input\\" + paperId + "\\" + paperId + "-Article-A.txt -outputtype summary -outputfile data\\eval\\rouge\\duist\\systems\\" + paperId + "-ArticleSummary_%1pct_BioSumm_FreqDist-Concept_VectorSubtraction.spl  -outputoptions compressionrate=%1;format=spl -scorer freqdist -scoringoptions useconcepts=true;similarityfunction=VectorSubtraction");
            }
            
            // Close output config file
          writer.println("goto END");
          writer.println();
          writer.println(":ERROR");
          writer.println("echo.");
          writer.println("echo.");
          writer.println("echo Parameter error. The compression rate must be specified.");
          writer.println("echo Example: EvalGenBioFreqDistSummariesSPL 15 to use 15 percent compression");
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
