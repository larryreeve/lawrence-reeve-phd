/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator;

import java.io.PrintStream;
import java.util.Properties;

import biocommon.document.Document;
import biocommon.document.DocumentPhrase;

/**
 * Interface for annotating source text files
 * 
 *
 */
public interface IConceptAnnotator
{
    AnnotationTimer getAnnotationTimer();
    
    String getName();
    
    String getStats();

    void initialize(Properties parameters) throws Exception;

    void annotateFile(String inputFilename, String outputFilename) throws Exception;
    
    void annotateFile(String filename, Document annotatedDocument) throws Exception;
    
    void annotatePhrase(DocumentPhrase phrase) throws Exception;
    
    void annotatePhraseFile(String phraseFilename, PrintStream ps) throws Exception;

    void annotateText(String text, Document annotatedDocument) throws Exception;

    void terminate() throws Exception;
}
