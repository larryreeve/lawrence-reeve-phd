/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import bioannotator.corpus.PhraseGenerator;
import bioannotator.duist.DUISTAnnotator;
import bioannotator.mmtx.MMTxAnnotator;
import bioannotator.preprocess.DataFileBuilder;

public class BioAnnotatorMain
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT    = biocommon.copyright.Copyright.COPYRIGHT;

    private final static String PROG_NAME    = "BioAnnotator";
    private final static String PROG_VERSION = "1.0";

    public static void main(String[] arguments) throws Exception
    {
        //
        // Program title
        //
        System.out.println();
        System.out.println();
        System.out.println(PROG_NAME + " " + PROG_VERSION);
        //System.out.println(COPYRIGHT);
        System.out.println();

        //
        // Setup command line parser and parse command line
        //
        Options cliOptions = new Options();

        cliOptions.addOption(OptionBuilder.withArgName("annotatorname").hasArg().withDescription(
                "annotator to use; valid options are mmtx,duist; default is duist").create("annotator"));

        cliOptions.addOption(OptionBuilder.withDescription("generate phrase corpus").create("genphrasecorpus"));

        cliOptions.addOption(OptionBuilder.withArgName("options").hasArg().withDescription(
            "define ordered list of options to be used, each separated by a semicolon\n" +
            "Available DUIST annotator options are:\n" +
            "phrasefilters: define ordered list of filters to be used, each separated by a comma\n" +
            "  Available filters are: size, coherence-skipbigram, coverage-binary, coverage-ipf, coverage-ipf-involvement\n\n" +
            "finalmapper: define the final concept mapper to be used\n" +
            "  Available mappers are: phrasecount and unigram-lm\n\n" +
            "Example: phrasefilters=coherence-skipbigram,coverage-ipf;finalmapper=phrasecount").create("options"));

        cliOptions.addOption(OptionBuilder.withDescription("print this message").create("help"));

        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("filename of source text").create(
                "inputfile"));

        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription("filename of output file").create(
                "outputfile"));

        cliOptions.addOption(OptionBuilder.withArgName("file").hasArg().withDescription(
                "filename of phrase file (contains corpus of phrases").create("phrasefile"));

        cliOptions.addOption(OptionBuilder.withDescription("preprocess the UMLS files").create("preprocess"));

        cliOptions.addOption(OptionBuilder.withDescription("show information about the knowledge resources").create("stats"));

        cliOptions.addOption(OptionBuilder.withDescription("generates verbose output").create("verbose"));

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
        String paramInputFilename = null;
        String paramOutputFilename = null;
        String paramPhraseFilename = null;
        String paramAnnotatorName = "duist";
        String paramAnnotatorOptions = "phrasefilters=coherence-skipbigram,coverage-ipf;finalmapper=phrasecount";
        boolean paramPreprocess = false;
        boolean paramGeneratePhraseCorpus = false;
        boolean paramStats = false;
        boolean paramVerbose = false;
        
        //
        // Get parameter values
        //
        try
        {
            if (cliLine.hasOption("annotator"))
            {
                paramAnnotatorName = cliLine.getOptionValue("annotator");
                if (!paramAnnotatorName.equalsIgnoreCase("duist") &&
                    !paramAnnotatorName.equalsIgnoreCase("mmtx"))
                {
                    throw new Exception("Invalid annotator name");
                }
            }

            if (cliLine.hasOption("genphrasecorpus"))
                paramGeneratePhraseCorpus = true;

            if (cliLine.hasOption("inputfile"))
                paramInputFilename = cliLine.getOptionValue("inputfile");

            if (cliLine.hasOption("options"))
                paramAnnotatorOptions = cliLine.getOptionValue("options");

            if (cliLine.hasOption("outputfile"))
                paramOutputFilename = cliLine.getOptionValue("outputfile");

            if (cliLine.hasOption("phrasefile"))
                paramPhraseFilename = cliLine.getOptionValue("phrasefile");
        
            if (cliLine.hasOption("verbose"))
                paramVerbose = true;

            if (cliLine.hasOption("preprocess"))
                paramPreprocess = true;

            if (cliLine.hasOption("stats"))
                paramStats = true;
        }
        catch(Exception e)
        {
            System.err.println("Error parsing parameters: " + e.getMessage());
            System.err.println();
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(PROG_NAME, cliOptions);
            return;
        }

        //
        // Summarize parameters
        //
        if (paramVerbose)
        {
            System.out.println("\tParameters:");
            System.out.println("\t\tInput Filename:  " + paramInputFilename);
            System.out.println("\t\tOutput Filename: " + paramOutputFilename);
            System.out.println("\t\tPhrase Filename: " + paramPhraseFilename);
            System.out.println("\t\tAnnotator:       " + paramAnnotatorName);
            System.out.println("\t\tOptions:         " + paramAnnotatorOptions);
            System.out.println("\t\tInput Filename:  " + paramInputFilename);
        }

        if (paramGeneratePhraseCorpus)
        {
            try
            {
                PhraseGenerator pg = new PhraseGenerator();
                pg.generate();
                System.out.println("Phrase generation complete");
            }
            catch (Exception e)
            {
                System.out.println("Error during phrase generation: " + e.getMessage());
            }
        }

        else if (paramPreprocess)
        {
            try
            {
                DataFileBuilder.preprocess();
                System.out.println("Pre-processing complete");
            }
            catch (Exception e)
            {
                System.out.println("Error during pre-processing: " + e.getMessage());
            }
        }
        
        else if (paramStats)
        {
            IConceptAnnotator annotator = BioAnnotatorMain.getAnnotatorFromName(paramAnnotatorName);
            
            System.out.println("Stats:" + annotator.getStats());
        }
        
        // Process a phrase file (corpus of phrases)
        else if (paramPhraseFilename != null)
        {
            try
            {
                // Validate parameters
                if (paramPhraseFilename.length() == 0)
                    throw new Exception("Phrase filename not specified");
                
                IConceptAnnotator annotator = BioAnnotatorMain.getAnnotatorFromName(paramAnnotatorName);

                PrintStream ps = null;
                if (paramOutputFilename != null && paramOutputFilename.length() > 0)
                    ps = new PrintStream(new FileOutputStream(paramOutputFilename));

                annotator.annotatePhraseFile(paramPhraseFilename, ps);
                
                AnnotationTimer perfTimer = annotator.getAnnotationTimer();
                System.out.println("Metrics:");
                System.out.println("\tInitialization Time: " + perfTimer.getInitializationTime() + " ms");
                System.out.println("\tAnnotation Time:     " + perfTimer.getPhraseTimeTotal() + " ms");
                System.out.println("\tTotal Time:          " + perfTimer.getTotalTime() + " ms");
                System.out.println("\tPhrase Count:        " + perfTimer.getPhraseCount());
                System.out.println("\tAvg Annotation Time: " + perfTimer.getPhraseTimeAvg() + " ms");
                System.out.println("\tMin Annotation Time: " + perfTimer.getPhraseTimeMin() + " ms");
                System.out.println("\tMax Annotation Time: " + perfTimer.getPhraseTimeMax() + " ms");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(PROG_NAME, cliOptions);
            }
        }
        
        else 
        {
            try
            {
                // Validate parameters
                if (paramInputFilename == null || paramInputFilename.length() == 0)
                    throw new Exception("Input filename not specified");
                
                if (paramOutputFilename == null || paramOutputFilename.length() == 0)
                    throw new Exception("Output filename not specified");
                
                IConceptAnnotator annotator = BioAnnotatorMain.getAnnotatorFromName(paramAnnotatorName);
                
                Properties optionList = new Properties();
                String[] options = paramAnnotatorOptions.split(";");
                if (options != null)
                {
                    for (String option : options)
                    {
                        String[] optionDetail = option.split("=");
                        if (optionDetail == null || optionDetail.length != 2)
                        {
                            System.out.println("Warning: Option ignored, in wrong format: " + option);
                        }
                        else
                        {
                            optionList.put(optionDetail[0].toLowerCase(), optionDetail[1]);
                        }
                    }
                }
                
                annotator.initialize(optionList);
                
                annotator.annotateFile(paramInputFilename, paramOutputFilename);
                
                AnnotationTimer perfTimer = annotator.getAnnotationTimer();
                System.out.println("Metrics:");
                System.out.println("\tInitialization Time: " + perfTimer.getInitializationTime() + " ms");
                System.out.println("\tAnnotation Time:     " + perfTimer.getPhraseTimeTotal() + " ms");
                System.out.println("\tTotal Time:          " + perfTimer.getTotalTime() + " ms");
                System.out.println("\tPhrase Count:        " + perfTimer.getPhraseCount());
                System.out.println("\tAvg Annotation Time: " + perfTimer.getPhraseTimeAvg() + " ms");
                System.out.println("\tMin Annotation Time: " + perfTimer.getPhraseTimeMin() + " ms");
                System.out.println("\tMax Annotation Time: " + perfTimer.getPhraseTimeMax() + " ms");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(PROG_NAME, cliOptions);
                
            }

            
            //
            //  Testing
            //
//            try
//            {
//                System.out.println("Loading word variants...");
//                VariantsTable.load();
//                
//                System.out.println("Loading words...");
//                WordToWordIdTable.load();
//                
//                System.out.println("Loading concept names...");
//                ConceptIdToConceptNameTable.load();
//                
//                System.out.println("Loading pid2cids...");
//                PhraseIdToConceptIdTable.load();
//
////                System.out.println("Loading cid2pids...");
////                ConceptIdToPhraseIdsTable.load();
//
//                System.out.println("Loading pid2wids...");
//                PhraseIdToWordIdsTable.load();
//                
//                System.out.println("Loading wid2pids...");
//                WordIdToPhraseIdsTable.load();
//
//                System.out.println("Loading LM-Unigram...");
//                ConceptLMUnigramTable.load();
//
//                System.out.println("Loading wid2ipf...");
//                WordIdToWordIPFTable.load();
//                
//                List<String> phrases = new ArrayList<String>();
//                phrases.add("cancers of the lung");
//                phrases.add("pulmonary carcinoma");
//                phrases.add("multiple myeloma");
//                phrases.add("pelvic lymphadenectomy");
//                phrases.add("only eligible patients");
//                phrases.add("staging"); 
//                phrases.add("poor prognosis");
//                phrases.add("radiosensitivity");
//                phrases.add("pilot data");
//                phrases.add("treatment group");
//                phrases.add("underlies");
//                phrases.add("Ductal carcinoma in situ");
//                phrases.add("Invasive ductal carcinoma");
//                phrases.add("Lobular carcinoma");
//                phrases.add("Lobular carcinoma in situ");
//                phrases.add("kaplan-meier estimates");
//                
//                List<ICandidatePhraseFilter> filters = new ArrayList<ICandidatePhraseFilter>();
//                
//                ICandidatePhraseFilter coverageFilter = new CandidatePhraseFilterCoverageIPF();
//                coverageFilter.initialize();
//                filters.add(coverageFilter);
//                
//                IConceptMapper unigramLMMapper = new ConceptMapperUnigramLM();
//                unigramLMMapper.initialize();
//
//              System.out.print("Press Enter...");
//              System.in.read();
//              System.out.println();
//                
//                
//                for (String phrase : phrases)
//                {
//                    System.out.println("phrase: " + phrase);
//                    List<Integer> sourcePhraseWordIds = CandidatePhraseListGenerator.getSourcePhraseWordIds(phrase);
//                    List<CandidatePhrase> candidateList = CandidatePhraseListGenerator.generateSourcePhraseCandidates(sourcePhraseWordIds);
//                
//                    System.out.println("\t#candidates generated: " + candidateList.size());
////                  for (CandidateItem candidate : candidateList)
////                        System.out.println("\t" + candidate.getPhraseId());
//                    
//                    for (ICandidatePhraseFilter filter : filters)
//                    {
//                        System.out.println("\tApplying filter " + filter.getName());
//                        candidateList = filter.filter(sourcePhraseWordIds, candidateList); 
//                    }
//                    
//                    System.out.println("\t#candidates after filter : " + candidateList.size());
//                    
//                    //System.out.println("Applying mapper " + unigramLMMapper.getName());
//                    List<Integer> conceptIds = unigramLMMapper.map(sourcePhraseWordIds, candidateList);
//                    
//                    System.out.println("\tMapped Concepts:");
//                    for (Integer conceptId : conceptIds)
//                        System.out.println("\t Concept Id:" + conceptId + ": " + ConceptIdToConceptNameTable.getConceptName(conceptId));
//                    
//                    System.out.println();                    
//                    
////                    System.out.println("#candidates remaining: " + candidateList.size());
////                    for (CandidatePhrase candidate : candidateList)
////                        System.out.println("\t" + candidate.getPhraseId() + PhraseIdToWordIdsTable.getPhraseText(candidate.getPhraseId()));
//                }
//                
////                System.out.print("Press Enter...");
////                System.in.read();
////                System.out.println();
//            }
//            catch (Exception e)
//            {
//                System.out.println("Error: " + e.getMessage());
//            }
        }
    }
    
    private static IConceptAnnotator getAnnotatorFromName(String annotatorName) throws Exception
    {
        IConceptAnnotator annotator = null;
        if (annotatorName.equalsIgnoreCase("mmtx"))
        {
            annotator = new MMTxAnnotator();
            annotator.initialize(new Properties());
        }
        else
        {
            annotator = new DUISTAnnotator();
            annotator.initialize(new Properties());
        }
        
        
        
        return  annotator;
    }
}
