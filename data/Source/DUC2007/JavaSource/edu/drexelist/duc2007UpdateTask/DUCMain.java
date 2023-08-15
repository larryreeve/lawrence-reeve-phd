package edu.drexelist.duc2007UpdateTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class DUCMain
{
    @SuppressWarnings("unused")
    private static final String      COPYRIGHT      = biocommon.copyright.Copyright.COPYRIGHT;
    private static final String      PROG_NAME      = "DUC 2007";
    private static final String      PROG_VERSION   = "1.0";

    public static void main(String[] arguments)
    {
        // Setup command line parser and parse command line
        Options cliOptions = new Options();

        cliOptions.addOption(OptionBuilder.withArgName("path").hasArg().withDescription(
                "path to update folder").create("updatepath"));
        cliOptions.addOption(OptionBuilder.withArgName("docsetid").hasArg().withDescription(
                "document set id").create("docsetid"));

        CommandLineParser cliParser = new BasicParser();
        CommandLine cliLine = null;
        try
        {
            // parse the command line arguments
            cliLine = cliParser.parse(cliOptions, arguments);
        }
        catch (ParseException e)
        {
            System.err.println("Command line parsing failed: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);

            return;
        }

        // Display help
        if (cliLine.hasOption("help"))
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);
            return;
        }

        // Retrieve argument options
        String paramDocSetId = "";
        String paramUpdatePath = null;
        boolean paramVerbose = true;

        // Required
        //
        if (cliLine.hasOption("updatepath"))
        {
        	paramUpdatePath = cliLine.getOptionValue("updatepath");
        }
        else
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);

            System.out.println("Update path not specified");
            return;
        }
        if (cliLine.hasOption("docsetid"))
        {
        	paramDocSetId = cliLine.getOptionValue("docsetid");
        }
        else
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);

            System.out.println("Doc set id not specified");
            return;
        }

        if (cliLine.hasOption("verbose"))
            paramVerbose = true;

        // Summarize parameters
        if (paramVerbose)
        {
            System.out.println();
            System.out.println();
            System.out.println(PROG_NAME + " " + PROG_VERSION);
            System.out.println();

            System.out.println("\tParameters:");
            System.out.println("\t\tUpdate path: " + paramUpdatePath);
            System.out.println("\t\tDoc Set Id: " + paramDocSetId);
            System.out.println("\t\tVerbose: " + paramVerbose);
            System.out.println();
        }

        
        try
        {
        	FreqDistSummarizer summarizer = new FreqDistSummarizer();
        	
        	// Get important words
        	List<String> importantWords = TRECReader.getTopicStatementWords(new File(paramUpdatePath + File.separator + paramDocSetId + File.separator + "TopicStatement.txt"));
        	Map<String, Double> importantWordsMap = new HashMap<String, Double>();
        	for (String word : importantWords)
        		importantWordsMap.put(word, new Double(1.0));

        	System.out.println("Important words:");
        	for (String word : importantWordsMap.keySet())
        		System.out.println("\tword: '" + word + "'");	
        	
        	// Process document set - part A
        	List<Sentence> sourceSentencesA = TRECReader.getSentencesForDocSet(paramUpdatePath, paramDocSetId, "A");
        	List<Sentence> summarySentencesA = new ArrayList<Sentence>();
        	summarizer.summarizeText(sourceSentencesA, null, summarySentencesA, importantWordsMap);
//        	if (summarySentencesA.size() < 75)
//        	{
//        		System.out.println("NOT using important words");
//        		summarySentencesA.clear();
//        		summarizer.summarizeText(sourceSentencesA, null, summarySentencesA, null);
//        	}
        	System.out.println(summarySentencesA.size() + " sentences from pool size " + sourceSentencesA.size());
        	printSentences("Summary-A", summarySentencesA);
        	
        	// Process document set - part B
        	List<Sentence> sourceSentencesB = TRECReader.getSentencesForDocSet(paramUpdatePath, paramDocSetId, "B");
        	List<Sentence> summarySentencesB = new ArrayList<Sentence>();
        	summarizer.summarizeText(sourceSentencesB, summarySentencesA, summarySentencesB, importantWordsMap);
//        	if (summarySentencesB.size() < 75)
//        	{
//        		System.out.println("NOT using important words");
//        		summarySentencesB.clear();
//        		summarizer.summarizeText(sourceSentencesB, summarySentencesA, summarySentencesB, null);
//        	}
        	System.out.println(summarySentencesB.size() + " sentences from pool size " + sourceSentencesB.size());
        	printSentences("Summary-B", summarySentencesB);

        	// Process document set - part C
        	List<Sentence> summarySentencesC = new ArrayList<Sentence>();
        	List<Sentence> sourceSentencesC = TRECReader.getSentencesForDocSet(paramUpdatePath, paramDocSetId, "C");
        	summarizer.summarizeText(sourceSentencesC, summarySentencesA, summarySentencesC, importantWordsMap);
//        	if (summarySentencesC.size() < 75)
//        	{
//        		System.out.println("NOT using important words");
//        		summarySentencesC.clear();
//        		summarizer.summarizeText(sourceSentencesC, summarySentencesA, summarySentencesC, null);
//        	}
        	System.out.println(summarySentencesC.size() + " sentences from pool size " + sourceSentencesC.size());
        	printSentences("Summary-C", summarySentencesC);
        	
        	// Generate submission file
        	generateSubmission(paramUpdatePath, paramDocSetId, summarySentencesA, summarySentencesB, summarySentencesC);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Error: " + e.toString());
        }
    }
    
    private static void printSentences(String title, List<Sentence> sentences)
    {
    	int totalWordCount = 0;
    	
    	System.out.println();
    	System.out.println(title);
    	for (Sentence sentence : sentences)
    	{
    		System.out.print("[" + sentence.getWordCount() + "]");
    		System.out.print("[" + sentence.getSentenceNumber() + "]");
    		System.out.println(":" + sentence.getSentenceText());
    		totalWordCount += sentence.getWordCount();
    	}
    	
    	System.out.println("Total word count=" + totalWordCount);
    }
    
    private static void generateSubmission(String updatePath, 
    		                               String docSetId, 
    		                               List<Sentence> summarySentencesA,
    		                               List<Sentence> summarySentencesB,
    		                               List<Sentence> summarySentencesC)
    {
    	try
    	{
    		PrintWriter xmlWriter = new PrintWriter(new BufferedWriter(new FileWriter(updatePath + File.separator + docSetId + ".xml", false)));

//    		xmlWriter.println("<?xml version=\"1.0\" standalone=\"no\"?>");
//    		xmlWriter.println("<!DOCTYPE DUC2007UPDATETASKSUBMISSION SYSTEM \"duc2007updatetasksubmission.dtd\">");
//    		xmlWriter.println("<DUC2007UPDATETASKSUBMISSION SYSID=\"NISTupdate\" TASK=\"UPDATE\">");
    		
    		xmlWriter.println("  <UPDATE DOCSUBSET=\"" + docSetId + "-A\">");
    		for (Sentence sentence : summarySentencesA)
    		{
    			String normalizedSentence = sentence.getSentenceText();
    			normalizedSentence.replace("<", "&lt;");
    			normalizedSentence.replace("&", "&amp;");
    			normalizedSentence.replace("&UR;", " ");
    			normalizedSentence.replace("&LR;", " ");
    			normalizedSentence.replace("_", " ");
    			xmlWriter.println("    " + normalizedSentence);
    		}
    		xmlWriter.println("  </UPDATE>");
    		
    		xmlWriter.println("  <UPDATE DOCSUBSET=\"" + docSetId + "-B\">");
    		for (Sentence sentence : summarySentencesB)
    		{
    			String normalizedSentence = sentence.getSentenceText();
    			normalizedSentence.replace("<", "&lt;");
    			normalizedSentence.replace("&", "&amp;");
    			normalizedSentence.replace("&UR;", " ");
    			normalizedSentence.replace("&LR;", " ");
    			normalizedSentence.replace("_", " ");
    			xmlWriter.println("    " + normalizedSentence);
    		}
    		xmlWriter.println("  </UPDATE>");
    		
    		xmlWriter.println("  <UPDATE DOCSUBSET=\"" + docSetId + "-C\">");
    		for (Sentence sentence : summarySentencesC)
    		{
    			String normalizedSentence = sentence.getSentenceText();
    			normalizedSentence.replace("<", "&lt;");
    			normalizedSentence.replace("&", "&amp;");
    			normalizedSentence.replace("&UR;", " ");
    			normalizedSentence.replace("&LR;", " ");
    			normalizedSentence.replace("_", " ");
    			xmlWriter.println("    " + normalizedSentence);
    		}
    		xmlWriter.println("  </UPDATE>");
    		
    		
    		xmlWriter.close();
    	}
    	catch(Exception e)
    	{
            e.printStackTrace();
            System.err.println("Error writing submission file: " + e.toString());
    	}
    }
}
