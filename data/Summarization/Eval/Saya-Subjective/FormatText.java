
import java.io.*;
import java.util.*;

class FormatText
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
    
