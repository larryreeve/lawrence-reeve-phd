/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon;

import java.io.File;

public class ConfigurationSettings
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT               = biocommon.copyright.Copyright.COPYRIGHT;

    private static String       m_dataPath              = null;
    private static String       m_configPath            = null;
    private static String       m_dataSummarizationPath = null;
    private static String       m_dataAnnotationPath    = null;
    private static String       m_umlsPath              = null;
    private static String       m_umlsLexiconPath       = null;
    private static String       m_umlsStrictPath        = null;


    public static String getConfigPath()
    {
        if (m_configPath == null)
        {
            m_configPath = ConfigurationSettings.getDataPath() + File.separator + "config" + File.separator;
        }

        return m_configPath;
    }

    public static String getDataPath()
    {
        if (m_dataPath == null)
        {
            m_dataPath = System.getenv("DATA_HOME");
            if (m_dataPath == null)
                m_dataPath = File.separator + "data";

            // Add the trailing separator
            // Path should be in form /data/
            if (!m_dataPath.endsWith(File.separator))
                m_dataPath = m_dataPath + File.separator;
        }

        return m_dataPath;
    }

    public static String getDataAnnotationPath()
    {
        if (m_dataAnnotationPath == null)
        {
            m_dataAnnotationPath = ConfigurationSettings.getDataPath() + "annotation" + File.separator;
        }

        return m_dataAnnotationPath;
    }

    public static String getDataSummarizationPath()
    {
        if (m_dataSummarizationPath == null)
        {
            m_dataSummarizationPath = ConfigurationSettings.getDataPath() + "summarization" + File.separator;
        }

        return m_dataSummarizationPath;
    }

    public static String getUMLSPath()
    {
        if (m_umlsPath == null)
        {
            m_umlsPath = System.getenv("UMLS_HOME");
            if (m_umlsPath == null)
                m_umlsPath = File.separator + "umls";

            // Add the trailing separator
            // Path should be in form /data/
            if (!m_umlsPath.endsWith(File.separator))
                m_umlsPath = m_umlsPath + File.separator;
        }

        return m_umlsPath;
    }

    /**
     * 
     * @return
     */
    public static String getUMLSLexiconPath()
    {
        if (m_umlsLexiconPath == null)
        {
            StringBuilder sb = new StringBuilder();

            // /umls/mmtx/nls/mmtx/data/2004/lexicon
            sb.append(ConfigurationSettings.getUMLSPath());
            sb.append("mmtx");
            sb.append(File.separator);
            sb.append("nls");
            sb.append(File.separator);
            sb.append("mmtx");
            sb.append(File.separator);
            sb.append("data");
            sb.append(File.separator);
            sb.append("2004");
            sb.append(File.separator);
            sb.append("lexicon");
            sb.append(File.separator);

            m_umlsLexiconPath = sb.toString();
        }

        return m_umlsLexiconPath;
    }

    /**
     * 
     * @return
     */
    public static String getUMLSStrictPath()
    {
        if (m_umlsStrictPath == null)
        {
            StringBuilder sb = new StringBuilder();

            // /umls/mmtx/nls/mmtx/data/2004/strict
            sb.append(ConfigurationSettings.getUMLSPath());
            sb.append("mmtx");
            sb.append(File.separator);
            sb.append("nls");
            sb.append(File.separator);
            sb.append("mmtx");
            sb.append(File.separator);
            sb.append("data");
            sb.append(File.separator);
            sb.append("2004");
            sb.append(File.separator);
            sb.append("strict");
            sb.append(File.separator);

            m_umlsStrictPath = sb.toString();
        }

        return m_umlsStrictPath;
    }
}
