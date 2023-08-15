import java.io.*;
import java.util.*;

class ConceptChainCharacteristics
{
    public static void main(String[] args) 
    {
        try 
        {
            int totalConceptChainsWithConcepts   = 0;
            int minConceptChainsWithConcepts     = Integer.MAX_VALUE;
            int maxConceptChainsWithConcepts     = Integer.MIN_VALUE;

            int totalConceptChainsWithNoConcepts = 0;
            int minConceptChainsWithNoConcepts   = Integer.MAX_VALUE;
            int maxConceptChainsWithNoConcepts   = Integer.MIN_VALUE;
            
            int totalChainConcepts               = 0;
            int minChainConcepts                 = Integer.MAX_VALUE;
            int maxChainConcepts                 = Integer.MIN_VALUE;
            
            int totalChainDistinctConcepts       = 0;  
            int minChainDistinctConcepts         = Integer.MAX_VALUE;  
            int maxChainDistinctConcepts         = Integer.MIN_VALUE;  
            
        	String inputFilename   = args[0];
        	String outputFilename  = args[1];
        	  
            System.out.println("Reading input file list from " + inputFilename + "...");
            BufferedReader readerFileList = new BufferedReader(new FileReader(inputFilename));
            String filenameConceptCount = null;
            while ((filenameConceptCount = readerFileList.readLine()) != null)
            {
                System.out.println("Processing file: " + filenameConceptCount + "...");
                
                // Count concepts in the file
                BufferedReader readerConceptCount = new BufferedReader(new FileReader(filenameConceptCount));
                
                Map<Integer, Map<String, Integer>> conceptChains = new HashMap<Integer, Map<String, Integer>>();
                
                String line = null;
                while ((line = readerConceptCount.readLine()) != null)
                {
                    String [] conceptInfo = line.split("\\t");
                    
                    String  conceptName  = conceptInfo[0];
                    Integer conceptCount = Integer.valueOf(conceptInfo[1]);
                    Integer semanticType = Integer.valueOf(conceptInfo[2].substring(1, 4));
                    
                    if (conceptChains.containsKey(semanticType))
                    {
                        Map<String, Integer> conceptChain = conceptChains.get(semanticType);
                        
                        if (conceptChain.containsKey(conceptName))
                        {
                            Integer count = conceptChain.get(conceptName);
                            conceptChain.put(conceptName, new Integer(count.intValue() + conceptCount));
                        }
                        else
                        {
                            conceptChain.put(conceptName, new Integer(conceptCount));
                        }
                    }
                    else
                    {
                        HashMap<String, Integer> conceptChain = new HashMap<String, Integer>();
                        conceptChain.put(conceptName, new Integer(conceptCount));
                        
                        conceptChains.put(semanticType, conceptChain);
                    }
                }
                readerConceptCount.close();

                // Calculate stats                
                //
                                
                // Chains - with concepts                
                int conceptChainsWithConcepts = conceptChains.size();
                totalConceptChainsWithConcepts += conceptChainsWithConcepts;
                if (conceptChainsWithConcepts < minConceptChainsWithConcepts)
                    minConceptChainsWithConcepts = conceptChainsWithConcepts;
                if (conceptChainsWithConcepts > maxConceptChainsWithConcepts)
                    maxConceptChainsWithConcepts = conceptChainsWithConcepts;

                // Chains - without concepts
                int conceptChainsWithNoConcepts = 135 - conceptChains.size();
                totalConceptChainsWithNoConcepts += conceptChainsWithNoConcepts;
                if (conceptChainsWithNoConcepts < minConceptChainsWithNoConcepts)
                    minConceptChainsWithNoConcepts = conceptChainsWithNoConcepts;
                if (conceptChainsWithNoConcepts > maxConceptChainsWithNoConcepts)
                    maxConceptChainsWithNoConcepts = conceptChainsWithNoConcepts;
                    
                // Concepts within chains                   
                for (Integer semanticType : conceptChains.keySet())
                {
                    Map<String, Integer> conceptChain = conceptChains.get(semanticType);
                    //int chainConceptsCount = 0;

                    totalChainDistinctConcepts += conceptChain.size();
                    
                    if (conceptChain.size() < minChainDistinctConcepts)
                        minChainDistinctConcepts = conceptChain.size();
                    if (conceptChain.size() > maxChainDistinctConcepts)
                        maxChainDistinctConcepts = conceptChain.size();
                    
                    for (String conceptName : conceptChain.keySet())
                    {
                        Integer count = conceptChain.get(conceptName);
                        
                        //System.out.println("conceptName: " + conceptName + ", " + count);
                        
                        totalChainConcepts += count;
                        
                        //chainConceptsCount += count;
                        
                        if (count < minChainConcepts)
                            minChainConcepts = count;
                        if (count > maxChainConcepts)
                            maxChainConcepts = count;
                    }
                    
                    //System.out.println("totalChainDistinctConcepts: " + conceptChain.size());
                    //System.out.println("totalChainConcepts: " + chainConceptsCount);
                }
                
            }
            
            readerFileList.close();
            
            System.out.println("Chains with at least one concept:");
            System.out.println("\tAvg: " + (totalConceptChainsWithConcepts / 24));
            System.out.println("\tMin: " + minConceptChainsWithConcepts);
            System.out.println("\tMax: " + maxConceptChainsWithConcepts);

            System.out.println("Chains with no concepts:");
            System.out.println("\tAvg: " + (totalConceptChainsWithNoConcepts / 24));
            System.out.println("\tMin: " + minConceptChainsWithNoConcepts);
            System.out.println("\tMax: " + maxConceptChainsWithNoConcepts);

            System.out.println("Concepts within chains, All:");
            System.out.println("\tAvg: " + (totalChainConcepts / totalConceptChainsWithConcepts));
            System.out.println("\tMin: " + minChainConcepts);
            System.out.println("\tMax: " + maxChainConcepts);

            System.out.println("Concepts within chains, Distinct:");
            System.out.println("\tAvg: " + (totalChainDistinctConcepts / totalConceptChainsWithConcepts));
            System.out.println("\tMin: " + minChainDistinctConcepts);
            System.out.println("\tMax: " + maxChainDistinctConcepts);
            
            
            // Write out concept counts
//            if (outputFilename.endsWith(".csv"))
//            {
//                PrintWriter writerConceptCounts = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
//                for (String conceptKey : conceptCounts.keySet())
//                {
//                    String [] conceptKeyParts = conceptKey.split("::");
//			
//                    //System.out.println(conceptKeyParts[0] + "-->" + conceptKeyParts[1]);
//			
//                    String semanticType = conceptKeyParts[0];
//                    String conceptName = conceptKeyParts[1];
//                    Integer count = conceptCounts.get(conceptKey);
//                
//                    writerConceptCounts.println("\"" + conceptName + "\"," + count);
//                }
//                writerConceptCounts.close();
//            }
//            else
//            {
//                PrintWriter writerConceptCounts = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
//                for (String conceptKey : conceptCounts.keySet())
//                {
//                    String [] conceptKeyParts = conceptKey.split("::");
//			
//                    //System.out.println(conceptKeyParts[0] + "-->" + conceptKeyParts[1]);
//			
//                    String semanticType = conceptKeyParts[0];
//                    String conceptName = conceptKeyParts[1];
//                    Integer count = conceptCounts.get(conceptKey);
//                
//                    writerConceptCounts.println(conceptName + "\t" + count + "\t" + semanticType);
//                }
//                writerConceptCounts.close();
//            }
        } 
        catch(Exception e) 
        {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}
