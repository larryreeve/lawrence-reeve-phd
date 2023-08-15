/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biosumm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import bioannotator.IConceptAnnotator;
import bioannotator.duist.DUISTAnnotator;
import bioannotator.mmtx.MMTxAnnotator;
import biocommon.document.Document;
import biocommon.perfmon.StopWatch;
import biocommon.util.string.StringUtility;
import biosumm.chain.ConceptChain;
import biosumm.chain.ConceptChainer;
import biosumm.evaluate.EvaluatorPrecisionRecall;
import biosumm.evaluate.IEvaluator;
import biosumm.output.IOutputGenerator;
import biosumm.output.OutputConceptCount;
import biosumm.output.OutputLemur;
import biosumm.output.OutputLemurParam;
import biosumm.output.OutputPhrases;
import biosumm.output.OutputSentences;
import biosumm.output.OutputStatistics;
import biosumm.output.OutputStrongChains;
import biosumm.output.OutputSummary;
import biosumm.output.OutputUniquePhrases;
import biosumm.score.IScorer;
import biosumm.score.ScoreBaseLead;
import biosumm.score.ScoreBaseRandom;
import biosumm.score.ScoreChainConceptFreq;
import biosumm.score.ScoreChainConceptFreqDist;
import biosumm.score.ScoreChainConceptFreqSentencePosition;
import biosumm.score.ScoreChainFilterDUCOM;
import biosumm.score.ScoreFreqDist;
import biosumm.score.ScoreFreqSumBasic;
import biosumm.score.ScoreFreqSummBasicConcept;
import biosumm.score.ScoreLM;

public class BioSummMain
{
    @SuppressWarnings("unused")
    private static final String      COPYRIGHT      = biocommon.copyright.Copyright.COPYRIGHT;
    private static final String      PROG_NAME      = "BioSumm";
    private static final String      PROG_VERSION   = "1.2";

    private static ArrayList<String> m_filenameList = new ArrayList<String>();

    public static void main(String[] arguments)
    {
        // Setup command line parser and parse command line
        Options cliOptions = new Options();

        // cliOptions.addOption("a", true, "annotator to use; valid options are
        // mmtx; default is mmtx");
        // cliOptions.addOption("d", true, "define output options, in format
        // name=value;name=value");
        // cliOptions.addOption("f", true, "apply semantic filtering");
        // cliOptions.addOption("h", false, "print this message");
        // cliOptions.addOption("i", true, "filename of source text");
        // cliOptions.addOption("b", true, "filename of source text");
        // cliOptions.addOption("o", true, "output file");
        // cliOptions.addOption("s", true, "scoring options");
        // cliOptions.addOption("t", true, "output type; valid options are
        // allchains, evaluation, phrases, uphrase, sentences, strongchains,
        // summary; default is summary");

        cliOptions.addOption(OptionBuilder.withArgName("annotatorname").hasArg().withDescription(
                "annotator to use; valid options are duist, mmtx; default is mmtx").create("annotator"));
        // cliOptions.addOption(OptionBuilder.withArgName("property=value").hasArg().withValueSeparator().withDescription("define
        // output options, in format
        // name=value;name=value").create("outputoptions"));
        cliOptions.addOption(OptionBuilder.withArgName("property=value").hasArg().withDescription(
                "define output options, in format name=value;name=value").create("outputoptions"));
        cliOptions.addOption(OptionBuilder.withArgName("filtername").hasArg().withDescription(
                "use semantic filtering; valid options are DUCOM; default is none").create("filter"));
        cliOptions.addOption(OptionBuilder.withDescription("print this message").create("help"));
        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("filename of source abstract").create(
                "inputfileabstract"));
        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("filename of source text").create(
                "inputfilefull"));
        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("filename of output file").create(
                "outputfile"));
        cliOptions.addOption(OptionBuilder.withArgName("property=value").hasArg().withDescription(
                "define scoring options, in format name=value;name=value").create("scoringoptions"));
        cliOptions
                .addOption(OptionBuilder
                        .withArgName("scorer")
                        .hasArg()
                        .withDescription(
                                "score function to use; valid options are chainfreqdist, chainfreqpos, freqdist, lead, lm, random, sumbasic-term, sumbasic-concept; default is chainfreqpos")
                        .create("scorer"));
        cliOptions
                .addOption(OptionBuilder
                        .withArgName("typename")
                        .hasArg()
                        .withDescription(
                                "output type; valid options are allchains, conceptcount, evaluation, phrases, uphrases, sentences, statistics, strongchains, summary; trec; default is summary")
                        .create("outputtype"));
        cliOptions.addOption(OptionBuilder.withArgName("docid").hasArg().withDescription("document id (optional)").create("docid"));
        cliOptions.addOption(OptionBuilder.withDescription("generates verbose output").create("verbose"));
        // for (String s : arguments)
        // System.out.println(s);

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
        String paramDocId = "";
        String paramSourceFilenameFull = null;
        String paramSourceFilenameAbstract = null;
        String paramOutputFilename = null;
        String paramAnnotatorName = "mmtx";
        String paramOutputOptions = "compressionrate=15";
        String paramScorer = "chainfreqpos";
        String paramScoringOptions = "stddev=2";
        String paramSemanticFilteringType = null;
        String paramOutputType = "summary";
        boolean paramVerbose = false;

        // Required
        //
        if (cliLine.hasOption("inputfilefull"))
        {
            paramSourceFilenameFull = cliLine.getOptionValue("inputfilefull");
        }
        else
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);

            System.out.println("Source filename not specified");
            return;
        }

        // Optional parameters
        //
        if (cliLine.hasOption("annotator"))
            paramAnnotatorName = cliLine.getOptionValue("annotator").toLowerCase();

        if (cliLine.hasOption("inputfileabstract"))
            paramSourceFilenameAbstract = cliLine.getOptionValue("inputfileabstract");

        if (cliLine.hasOption("outputoptions"))
            paramOutputOptions = cliLine.getOptionValue("outputoptions");

        if (cliLine.hasOption("docid"))
            paramDocId = cliLine.getOptionValue("docid");

        if (cliLine.hasOption("filter"))
            paramSemanticFilteringType = cliLine.getOptionValue("filter");

        if (cliLine.hasOption("outputfile"))
            paramOutputFilename = cliLine.getOptionValue("outputfile");

        if (cliLine.hasOption("scorer"))
            paramScorer = cliLine.getOptionValue("scorer");

        if (cliLine.hasOption("scoringoptions"))
            paramScoringOptions = cliLine.getOptionValue("scoringoptions");

        if (cliLine.hasOption("outputtype"))
            paramOutputType = cliLine.getOptionValue("outputtype").toLowerCase();

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
            System.out.println("\t\tSource file: " + paramSourceFilenameFull);
            if (paramSourceFilenameAbstract != null)
                System.out.println("\t\tSource file abstract: " + paramSourceFilenameAbstract);
            System.out.print("\t\tOutput file: ");
            if (paramOutputFilename == null)
                System.out.println("stdout");
            else
                System.out.println(paramOutputFilename);
            System.out.println("\t\tConcept annotator: " + paramAnnotatorName);
            System.out.println("\t\tOutput format: " + paramOutputType);
            System.out.println("\t\tOutput options: " + paramOutputOptions);
            System.out.println("\t\tScorer: " + paramScorer);
            if (paramSemanticFilteringType != null && paramSemanticFilteringType.length() != 0)
                System.out.println("\t\tSemantic Filtering method: " + paramSemanticFilteringType);
            else
                System.out.println("\t\tSemantic Filtering method: none");
            System.out.println("\t\tScoring options: " + paramScoringOptions);
            System.out.println("\t\tVerbose: " + paramVerbose);
            // System.out.println("\tScoring method: " + paramOutputOptions);
            System.out.println();
        }

        IConceptAnnotator annotator = null;
        try
        {
            // Get list of files to process
            buildFileList(paramSourceFilenameFull);

            // ----------
            // Initialize
            // ----------

            // Initialize annotator
            if (paramVerbose)
            {
                System.out.println();
                System.out.println("Initializing annotator '" + paramAnnotatorName + "'...");
            }
            if (paramAnnotatorName.equalsIgnoreCase("mmtx"))
                annotator = new MMTxAnnotator();
            else if (paramAnnotatorName.equalsIgnoreCase("duist"))
                annotator = new DUISTAnnotator(); 
            else
            {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(PROG_NAME, cliOptions);

                throw new Exception("Unknown annotator type '" + paramAnnotatorName + "'");
            }

            StopWatch annotatorInitTime = new StopWatch();
            annotatorInitTime.start();
            annotator.initialize(null);
            annotatorInitTime.stop();
            if (paramVerbose)
            {
                System.out.println("Annotator initialization completed..." + annotatorInitTime.getElapsedTime() + " ms");
                System.out.println();
            }

            // Initialize output generator
            IOutputGenerator outputGenerator = null;
            if (!paramOutputType.equals("evaluation"))
            {
                if (paramOutputType.equalsIgnoreCase("conceptcount"))
                    outputGenerator = new OutputConceptCount();
                else if (paramOutputType.equalsIgnoreCase("phrases"))
                    outputGenerator = new OutputPhrases();
                else if (paramOutputType.equalsIgnoreCase("uphrases"))
                    outputGenerator = new OutputUniquePhrases();
                else if (paramOutputType.equalsIgnoreCase("sentences"))
                    outputGenerator = new OutputSentences();
                else if (paramOutputType.equalsIgnoreCase("statistics"))
                    outputGenerator = new OutputStatistics();
                else if (paramOutputType.equalsIgnoreCase("summary"))
                    outputGenerator = new OutputSummary();
                else if (paramOutputType.equalsIgnoreCase("strongchains"))
                    outputGenerator = new OutputStrongChains();
                else if (paramOutputType.equalsIgnoreCase("lemur"))
                    outputGenerator = new OutputLemur();
                else if (paramOutputType.equalsIgnoreCase("lemurparam"))
                    outputGenerator = new OutputLemurParam();
                else
                {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp(PROG_NAME, cliOptions);

                    throw new Exception("Unknown output type '" + paramOutputType + "'");
                }
            }

            // Output options
            Properties outputOptions = StringUtility.parseNameValueOptions(paramOutputOptions);

            // Scoring options
            Properties scoringOptions = StringUtility.parseNameValueOptions(paramScoringOptions);

            // Initialize scorers
            IScorer sentenceScorer = null;
            if (paramScorer == null || paramScorer.toLowerCase().equalsIgnoreCase("chainfreqpos"))
                sentenceScorer = new ScoreChainConceptFreqSentencePosition();
            else if (paramScorer == null || paramScorer.toLowerCase().equalsIgnoreCase("chainfreq"))
                sentenceScorer = new ScoreChainConceptFreq();
            else if (paramScorer == null || paramScorer.toLowerCase().equalsIgnoreCase("chainfreqdist"))
                sentenceScorer = new ScoreChainConceptFreqDist();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("freqdist"))
                sentenceScorer = new ScoreFreqDist();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("lead"))
                sentenceScorer = new ScoreBaseLead();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("lm"))
                sentenceScorer = new ScoreLM();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("random"))
                sentenceScorer = new ScoreBaseRandom();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("sumbasic-concept"))
                sentenceScorer = new ScoreFreqSummBasicConcept();
            else if (paramScorer.toLowerCase().equalsIgnoreCase("sumbasic-term"))
                sentenceScorer = new ScoreFreqSumBasic();
            else
            {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(PROG_NAME, cliOptions);

                throw new Exception("Unknown scorer '" + paramScorer + "'");
            }

            IScorer chainListFilter = null;
            if (paramSemanticFilteringType != null && paramSemanticFilteringType.length() != 0)
            {
                if (paramSemanticFilteringType.equalsIgnoreCase("DUCOM"))
                    chainListFilter = new ScoreChainFilterDUCOM();
            }

            // --------------------------
            // Process source document(s)
            // --------------------------
            if (!paramOutputType.equals("evaluation"))
            {
                for (String filename : m_filenameList)
                {
                    Document annotatedDocument = new Document(filename);
                    annotatedDocument.setDocID(paramDocId);

                    // Annotate document
                    StopWatch annotatorAnnotateTime = new StopWatch();
                    try
                    {
                        if (paramVerbose)
                            System.out.println("\tAnnotating document '" + filename + "'...");
                        
                        annotatorAnnotateTime.start();
                        
                        annotator.annotateFile(filename, annotatedDocument);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error in annotation: " + e.getMessage() + "\n" + "Filename='" + filename + "'");
                    }
                    finally
                    {
                        annotatorAnnotateTime.stop();
                        
                        if (paramVerbose)
                            System.out.println("\tAnnotation completed..." + annotatorAnnotateTime.getElapsedTime() + " ms");
                    }

                    // Chain the document concepts
                    List<ConceptChain> conceptChainList = new ArrayList<ConceptChain>();                    
                    if ((sentenceScorer instanceof ScoreChainConceptFreqSentencePosition)  ||
                        (sentenceScorer instanceof ScoreChainConceptFreq)                  || 
                        (sentenceScorer instanceof ScoreChainConceptFreqDist))
                    {
                        ConceptChainer.chainDocument(conceptChainList, annotatedDocument);

                        // Filter the chains
                        if (chainListFilter != null)
                        {
                            StopWatch filterTime = new StopWatch();
                            filterTime.start();
                            chainListFilter.score(conceptChainList, annotatedDocument, scoringOptions);
                            filterTime.stop();
                            if (paramVerbose)
                                System.out.println("\tSemantic filtering completed..." + filterTime.getElapsedTime() + " ms");
                        }
                    }
                    
                    // Score the chains
                    StopWatch scorerTime = new StopWatch();
                    scorerTime.start();
                    sentenceScorer.score(conceptChainList, annotatedDocument, scoringOptions);
                    scorerTime.stop();
                    if (paramVerbose)
                        System.out.println("\tDocument scoring completed..." + scorerTime.getElapsedTime() + " ms");

                    // Generate output
                    PrintWriter writer = null;
                    // String outputFilename = null;
                    if (paramOutputFilename == null || paramOutputFilename.length() == 0)
                    {
                        writer = new PrintWriter(System.out);
                        // outputFilename = filename;
                        // if (outputFilename.toLowerCase().endsWith(".txt"))
                        // outputFilename =
                        // outputFilename.substring(outputFilename.length() - 4,
                        // 3);
                        //        			
                        // outputFilename = outputFilename + paramOutputType +
                        // ".txt";
                    }
                    else
                    {
                        // System.out.println("Overwrite: f1=" +
                        // !outputOptions.containsKey("overwrite") + ", f2=" +
                        // ((String)
                        // outputOptions.get("overwrite")).equalsIgnoreCase("true"));
                        boolean overwrite = !outputOptions.containsKey("overwrite")
                                || ((String) outputOptions.get("overwrite")).equalsIgnoreCase("true");
                        writer = new PrintWriter(new BufferedWriter(new FileWriter(paramOutputFilename, !overwrite)));

                        // outputFilename = paramOutputFilename;
                    }

                    StopWatch outputTime = new StopWatch();
                    outputTime.start();
                    outputGenerator.generate(writer, annotatedDocument, conceptChainList, outputOptions);
                    writer.flush();
                    outputTime.stop();
                    if (paramVerbose)
                        System.out.println("\tOutput generation completed..." + outputTime.getElapsedTime() + " ms");
                }
            }
            else
            // Evaluation
            {
                Document annotatedDocumentFullText = new Document(paramSourceFilenameFull);
                Document annotatedDocumentAbstract = new Document(paramSourceFilenameAbstract);

                // Open output file
                PrintWriter writer = null;
                if (paramOutputFilename == null || paramOutputFilename.length() == 0)
                {
                    writer = new PrintWriter(System.out);
                }
                else
                {
                    writer = new PrintWriter(new BufferedWriter(new FileWriter(paramOutputFilename, false)));
                }

                // Annotate documents
                StopWatch annotatorAnnotateTime = new StopWatch();
                annotatorAnnotateTime.start();
                if (paramVerbose)
                    writer.println("\tAnnotating full-text document '" + paramSourceFilenameFull + "'...");
                annotator.annotateFile(paramSourceFilenameFull, annotatedDocumentFullText);
                annotatorAnnotateTime.stop();
                if (paramVerbose)
                    writer.println("\tAnnotation completed..." + annotatorAnnotateTime.getElapsedTime() + " ms");

                annotatorAnnotateTime.start();
                writer.println("\tAnnotating abstract document '" + paramSourceFilenameAbstract + "'...");
                if (paramVerbose)
                    annotator.annotateFile(paramSourceFilenameAbstract, annotatedDocumentAbstract);
                annotatorAnnotateTime.stop();
                if (paramVerbose)
                {
                    writer.println("\tAnnotation completed..." + annotatorAnnotateTime.getElapsedTime() + " ms");
                    writer.println();
                    writer.println();
                }

                // Chain the document concepts
                List<ConceptChain> conceptChainListFullText = new ArrayList<ConceptChain>();
                List<ConceptChain> conceptChainListAbstract = new ArrayList<ConceptChain>();
                ConceptChainer.chainDocument(conceptChainListFullText, annotatedDocumentFullText);
                ConceptChainer.chainDocument(conceptChainListAbstract, annotatedDocumentAbstract);

                // Filter the chains
                if (chainListFilter != null)
                {
                    StopWatch filterTime = new StopWatch();
                    filterTime.start();
                    chainListFilter.score(conceptChainListFullText, annotatedDocumentFullText, scoringOptions);
                    chainListFilter.score(conceptChainListAbstract, annotatedDocumentAbstract, scoringOptions);
                    filterTime.stop();
                    if (paramVerbose)
                        writer.println("\tSemantic filtering completed..." + filterTime.getElapsedTime() + " ms");
                }

                // Score the chains
                StopWatch scorerTime = new StopWatch();
                scorerTime.start();
                sentenceScorer.score(conceptChainListFullText, annotatedDocumentFullText, scoringOptions);
                sentenceScorer.score(conceptChainListAbstract, annotatedDocumentAbstract, scoringOptions);
                scorerTime.stop();
                if (paramVerbose)
                    writer.println("\tDocument scoring completed..." + scorerTime.getElapsedTime() + " ms");

                // Generate evaluation
                IEvaluator evaluator = new EvaluatorPrecisionRecall();
                StopWatch outputTime = new StopWatch();
                outputTime.start();
                evaluator.evaluate(writer, annotatedDocumentFullText, conceptChainListFullText, annotatedDocumentAbstract,
                        conceptChainListAbstract, outputOptions);
                writer.flush();
                outputTime.stop();
                if (paramVerbose)
                    System.out.println("\tEvaluation generation completed..." + outputTime.getElapsedTime() + " ms");
            }

            // -----------
            // Termination
            // -----------

            //
            // Terminate the annotator
            // StopWatch annotatorTerminateTime = new StopWatch();
            // annotatorTerminateTime.start();
            // System.err.println("Terminating annotator...");
            annotator.terminate();
            // annotatorTerminateTime.stop();
            // System.err.println("Annotator termination completed..." +
            // annotatorTerminateTime.getElapsedTime() + " ms");
            // System.err.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Error: " + e.toString());
        }
    }

    private static void buildFileList(String filespec)
    {
        m_filenameList.clear();

        File startingFile = new File(filespec);

        processAllDirsAndFiles(startingFile);
    }

    private static void processAllDirsAndFiles(File fileToProcess)
    {
        if (fileToProcess.isDirectory())
        {
            String filesInDir[] = fileToProcess.list();

            for (String nextfile : filesInDir)
                processAllDirsAndFiles(new File(fileToProcess, nextfile));
        }
        else
        {
            String filename = fileToProcess.getAbsolutePath().toLowerCase();

            if (filename.endsWith("-a.txt"))
                m_filenameList.add(filename);
            else if (filename.endsWith(".spl"))
                m_filenameList.add(filename);
            else if (filename.endsWith(".lst"))
            {
                // File contains a list of filenames to read
            }

        }
    }
}
