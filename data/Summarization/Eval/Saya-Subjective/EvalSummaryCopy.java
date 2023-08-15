
import java.io.*;
import java.util.*;

class EvalSummaryCopy
{
    static FilenameFilter directoryOnlyFilter = new FilenameFilter() 
    {
      public boolean accept(File dir, String name) 
      {
        return dir.isDirectory();
      }
    };

    public static void main(String[] args) 
    {
      File dirOutput = new File("..\\Output");
    
      String[] outputFolderNames = dirOutput.list(directoryOnlyFilter);
      for (int outputFolderIdx=0; outputFolderIdx < outputFolderNames.length; outputFolderIdx++) 
      {
          // Get filename of file or directory
          String summaryFolderName = outputFolderNames[outputFolderIdx];
          
          System.out.println("\nProcessing folder " + summaryFolderName + "...");
          
          File outputFolder = new File("output\\" + summaryFolderName);
          if (!outputFolder.exists())
            outputFolder.mkdirs();
          
          File summaryFolder = new File("..\\Output\\" + summaryFolderName);

          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_15pct_BioChain_FilteredPosition.txt",
                   summaryFolderName + "\\Summary1.txt");

          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_15pct_BioChain_UnfilteredPosition.txt",
                   summaryFolderName + "\\Summary2.txt");

          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSentences_BioChain.txt",
                    summaryFolderName + "\\ArticleSentences.txt");
          
          
//          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_25pct_Filtered_BioChain.txt",
//                   summaryFolderName + "\\Summary1.txt");
//                   
//          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_25pct_Copernic.txt",
//                   summaryFolderName + "\\Summary2.txt");
//
//          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_25pct_SweSum.txt",
//                   summaryFolderName + "\\Summary3.txt");
//
//          copyFile("..\\Output\\" + summaryFolderName + "\\" + summaryFolderName + "-ArticleSummary_25pct_Word.txt",
//                   summaryFolderName + "\\Summary4.txt");
                   
      }
    }
    
    private static void copyFile(String inputFilename, String outputFilename)
    {
      final int LINE_LENGTH = 100;
      
      System.out.println("\t" + inputFilename + "\n\t" + outputFilename + "...");
      
      BufferedReader reader = null;
      BufferedWriter writer = null;
      
      try 
      {
        String line = null;
        reader = new BufferedReader(new FileReader(inputFilename));
        writer = new BufferedWriter(new FileWriter(outputFilename));
        
        while ((line = reader.readLine()) != null)
        {
          if (line.length() < LINE_LENGTH)
          {
            writer.write(line);
            writer.newLine();
          }
          else
          {
            int curPos = 0;
            int curLen = LINE_LENGTH;
            
            while (curPos < line.length())
            {
              curLen = LINE_LENGTH;
              if ((curLen + curPos) > line.length())
              {
                curLen = line.length() - curPos - 1;
              }
                
              while (((curPos + curLen) < line.length()) && !Character.isWhitespace(line.charAt(curPos + curLen)))
                curLen++;
                
              String newSummaryLine = line.substring(curPos, curPos + curLen);
            
              writer.write(newSummaryLine);
              writer.newLine();
              
              curPos += curLen+1;
            }
          }
        } 
      }
      catch(Exception e) 
      {
        System.out.println(e.getMessage());
      }
      finally
      {
        try
        {
          if (reader != null)
            reader.close();
            
          if (writer != null)
            writer.close();
        }
        catch(Exception e)
        {
        }
      }
    }
}

    
    
