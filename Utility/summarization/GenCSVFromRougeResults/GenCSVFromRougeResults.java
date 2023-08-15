import java.io.*;
import java.util.*;

class GenCSVFromRougeResults
{
    public static void main(String[] args) 
    {
        try 
        {
            BufferedReader readerInput = null;
            String line = null;
            
        	  String filenameInput  = args[0];
        	  String filenameOutput = args[1];
        	  
        	  // Open output file
        	  System.out.println("Generating output file " + filenameOutput + "...");
            PrintWriter writerOutput = new PrintWriter(new BufferedWriter(new FileWriter(filenameOutput)));

            // Process summary file
            System.out.println("Reading rouge results file " + filenameInput + "...");
            readerInput = new BufferedReader(new FileReader(filenameInput));
            while ((line = readerInput.readLine()) != null)
            {
                //System.out.println(line);
                String [] results = line.split(" ");
                
                //System.out.println(line);
                //System.out.println(results.length);
                
                if (results.length >= 4)
                {
                    String summarizerName = results[0];
                    String metricName = results[1];
                    String metricAverageName = results[2];
                    String metricValue = results[3];
                    
                    //System.out.println("[" + metricName + "]");
                    //System.out.println("[" + metricAverageName + "]");
                    
                    if ((metricName.equalsIgnoreCase("ROUGE-2") || (metricName.equalsIgnoreCase("ROUGE-SU4"))) && 
                        metricAverageName.equalsIgnoreCase("Average_R:"))
                    {
                        //writerOutput.println(summarizerName + "\t" + metricName + "\t" + metricAverageName + "\t" + metricValue);
                        writerOutput.println(summarizerName + "," + metricName + "," + metricAverageName + "," + metricValue);
                    }
                }
            }
            readerInput.close();
            writerOutput.close();
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
