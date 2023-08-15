/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package bioannotator;

import java.io.File;

import biocommon.ConfigurationSettings;

public class Constants
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT                        = biocommon.copyright.Copyright.COPYRIGHT;

    public static final String  FILENAME_ALL_UNIQUE_CONCEPTS     = ConfigurationSettings.getDataAnnotationPath() + "input"
                                                                         + File.separator + "24PaperCorpus-AllUniquePhrases.txt";

    public static final String  FILENAME_ONE_UNIQUE_CONCEPTS     = ConfigurationSettings.getDataAnnotationPath() + "input"
                                                                         + File.separator
                                                                         + "24PaperCorpus-AllUniquePhrasesWithOneConcept.txt";

    public static final String  FILENAME_UMLS_CUI_CONCEPT        = ConfigurationSettings.getUMLSStrictPath() + "cui_concept.txt";

    public static final String  FILENAME_UMLS_SUI_NMSTR          = ConfigurationSettings.getUMLSStrictPath() + "sui_nmstr_str.txt";

    public static final String  FILENAME_UMLS_ALL_WORDS          = ConfigurationSettings.getUMLSStrictPath()
                                                                         + "all_words_counts.txt";

    public static final String  FILENAME_UMLS_SUI_CUI            = ConfigurationSettings.getUMLSStrictPath() + "sui_cui.txt";

    public static final String  FILENAME_UMLS_VARIANT_INFLECTION = ConfigurationSettings.getUMLSLexiconPath() + "infl.txt";

    public static final String  FILENAME_UMLS_VARIANT_FULL       = ConfigurationSettings.getUMLSLexiconPath() + "fullVars.txt";

    public static final String  FILENAME_BIO_CID2CONCEPTNAME     = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "cid2conceptname.gzip";

    public static final String  FILENAME_BIO_CLM_UNIGRAM         = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "clmunigram.gzip";

    public static final String  FILENAME_BIO_CID2PIDS            = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "cid2pids.gzip";

    public static final String  FILENAME_BIO_PID2CIDS            = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "pid2cids.gzip";

    public static final String  FILENAME_BIO_PID2WIDS            = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "pid2wids.gzip";

    public static final String  FILENAME_BIO_VARIANTS            = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "variants.gzip";

    public static final String  FILENAME_BIO_WID2PIDS            = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "wid2pids.gzip";

    public static final String  FILENAME_BIO_WID2IPF             = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "wid2ipf.gzip";

    public static final String  FILENAME_BIO_WORD2WIDS           = ConfigurationSettings.getDataPath() + "annotation"
                                                                         + File.separator + "input" + File.separator
                                                                         + "word2wids.gzip";
}
