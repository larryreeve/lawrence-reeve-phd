package edu.drexelist.biochain;

//import java.io.File;
import java.io.IOException;
import java.util.*;

import gov.nih.nlm.nls.mmtx.MMTxAPI;

public class LexChainMain
{
    public static void main (String[] arguments) throws Exception, IOException 
    {

        if ((arguments.length > 0 ) && (arguments[0].equals("-h"))) 
        {
            System.out.println("LexChainMMTx chains a abstract and full-text file");
            System.out.println();
            System.out.println("Usage: ");
            System.out.println();
            System.out.println("   java edu.drexelist.biochain.LexChainMMTx [-h] <abstract filename> [<full-text filename>]" );
            System.out.println("                      -h prints out the help");
            System.out.println();
        }
        else 
        {
            try 
            {
                // Initialize MetaMap Transfer
                StopWatch mmtxInitTime = new StopWatch();
                //System.out.println("Initializing MetaMap Transfer...");
                mmtxInitTime.start();
                //MMTxAPI mmtx = null;
                MMTxAPI mmtx = new MMTxAPI();
                mmtxInitTime.stop();
                //if (mmtx == null) 
                //	throw new Exception("Unable to acquire MMTx instance");
                //System.out.println("MetaMap Transfer initialization completed..." + mmtxInitTime.getElapsedTime() + " ms");
                //System.out.println();
                
                if (arguments.length == 1)
                {
                    LexChainMMTx lexChainer = new LexChainMMTx(mmtx);

                    System.out.println("Chaining file " + arguments[0] + "...");
                    LexChainStats lexStats = lexChainer.chainFile(arguments[0]);
                    LexChainTermList lexChains[] = lexChainer.getLexChains();
                    List sentences = lexChainer.getSentences();
                    System.out.println("Chaining completed...");
                    System.out.println("\tMMTx processing time:  " + lexStats.MMTxProcessTime().getElapsedTime() + " ms");
                    System.out.println("\tChain processing time: " + lexStats.ChainingProcessTime().getElapsedTime() + " ms");

                    //
                    // Display output
                    //
                    Properties outputParameters = new Properties();
                    ILexChainOutputGenerator output = null;

                    // Display strong chains - 2 StdDevs
                    output = new LexChainOutputStrongChains();
                    outputParameters.clear();
                    outputParameters.setProperty("StdDev", "2");
                    System.out.println();
                    System.out.println();
                    output.generateOutput(lexChains, sentences, outputParameters);

                    // Display strong chains - 1 StdDevs
                    output = new LexChainOutputStrongChains();
                    outputParameters.clear();
                    outputParameters.setProperty("StdDev", "1");
                    System.out.println();
                    System.out.println();
                    output.generateOutput(lexChains, sentences, outputParameters);

                    // Display summary
                    output = new LexChainOutputSummary();
                    outputParameters.clear();
                    outputParameters.setProperty("StdDev", "2");
                    outputParameters.setProperty("compression", "25");
                    System.out.println();
                    System.out.println();
                    System.out.println("Summary:");
                    output.generateOutput(lexChains, sentences, outputParameters);
                }
                else if (arguments.length == 2)
                {
                    LexChainMMTx lexChainer = new LexChainMMTx(mmtx);

                    // Chain the summary
                    //System.out.println("Chaining abstract file " + arguments[0] + "...");
                    LexChainStats lexStats = lexChainer.chainFile(arguments[0]);
                    LexChainTermList lexChainsSummary[] = lexChainer.getLexChains();
                    List sentencesSummary = lexChainer.getSentences();
                    //System.out.println("Summary chaining completed...");
                    //System.out.println("\tMMTx processing time:  " + lexStats.MMTxProcessTime().getElapsedTime() + " ms");
                    //System.out.println("\tChain processing time: " + lexStats.ChainingProcessTime().getElapsedTime() + " ms");

                    //System.out.println();

                    // Chain the full-text
                    //System.out.println("Chaining full-text file " + arguments[1] + "...");
                    lexStats = lexChainer.chainFile(arguments[1]);
                    LexChainTermList lexChainsFullText[] = lexChainer.getLexChains();
                    List sentencesFullText = lexChainer.getSentences();
                    System.out.println();
                    System.out.println();
                    //System.out.println("Full-text chaining completed...");
                    //System.out.println("\tMMTx processing time:  " + lexStats.MMTxProcessTime().getElapsedTime() + " ms");
                    //System.out.println("\tChain processing time: " + lexStats.ChainingProcessTime().getElapsedTime() + " ms");
                    //System.out.println();
                    
                    //
                    // Display output
                    //
                    Properties outputParameters = new Properties();
                    ILexChainOutputGenerator output = null;

                    // Display strong chains - 2 StdDevs
                    //	Abstract
                    //output = new LexChainOutputStrongChains();
                    //outputParameters.clear();
                    //outputParameters.setProperty("StdDev", "2");
                    //System.out.println();
                    //System.out.println();
                    //System.out.println("Abstract:");
                    //output.generateOutput(lexChainsSummary, sentencesSummary, outputParameters);

                    //	Full-text
                    //output = new LexChainOutputStrongChains();
                    //outputParameters.clear();
                    //outputParameters.setProperty("StdDev", "2");
                    //System.out.println();
                    //System.out.println();
                    //System.out.println("Full-text:");
                    //output.generateOutput(lexChainsFullText, sentencesFullText, outputParameters);

                    // Evaluate chains
                    ILexChainEvaluator evaluator = new LexChainEvaluatorStandardForAri2();
                    outputParameters.clear();
                    outputParameters.setProperty("StdDev", "2");
                    evaluator.evaluate(lexChainsSummary, lexChainsFullText, sentencesSummary, sentencesFullText, outputParameters);
                    
                    // Display summary - abstract
//                    output = new LexChainOutputSummary();
//                    outputParameters.clear();
//                    outputParameters.setProperty("StdDev", "2");
//                    outputParameters.setProperty("compression", "25");
//                    System.out.println();
//                    System.out.println();
//                    System.out.println("Summary-Abstract:");
//                    output.generateOutput(lexChainsSummary, sentencesSummary, outputParameters);

                    // Display summary - full-text
//                    output = new LexChainOutputSummary();
//                    outputParameters.clear();
//                    outputParameters.setProperty("StdDev", "2");
//                    outputParameters.setProperty("compression", "25");
//                    System.out.println();
//                    System.out.println();
//                    System.out.println("Summary-Full-Text:");
//                    output.generateOutput(lexChainsFullText, sentencesFullText, outputParameters);
                }


                // Get list of files to process
//                ArrayList filesToBeProcessed = new ArrayList();
//                File fileArgument = new File(arguments[0]);
//                if (fileArgument.isDirectory()) 
//                {
//                    TxtFilenameFilter filter = new TxtFilenameFilter();
//                    File filesInDir[] = fileArgument.listFiles(filter);
//                	
//                    for (int idx=0; idx < filesInDir.length; idx++)
//                        filesToBeProcessed.add(filesInDir[idx].getAbsolutePath());
//                }
//                else 
//                {
//                    filesToBeProcessed.add(arguments[0]);
//                }
                
                
//                // Process each file
//                for (int idx=0; idx < filesToBeProcessed.size(); idx++) 
//                {
//                    String filename = (String) filesToBeProcessed.get(idx);
//                	
//                    LexChainMMTx lexChainer = new LexChainMMTx(mmtx);
//
//                    System.out.println("Chaining file " + filename + "...");
//                    LexChainStats lexStats = lexChainer.chainFile(filename);
//                    System.out.println();
//                    System.out.println();
//                    System.out.println("Chaining completed...");
//                    System.out.println("\tMMTx processing time:  " + lexStats.MMTxProcessTime().getElapsedTime() + " ms");
//                    System.out.println("\tChain processing time: " + lexStats.ChainingProcessTime().getElapsedTime() + " ms");
//                }
                
            }
            catch (Exception e) 
            {
                e.printStackTrace();
                System.err.println("Error: " + e.toString());
            }
        }
    }
}
