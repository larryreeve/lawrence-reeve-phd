/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.util.string;

import java.util.Properties;

public class StringUtility
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT = biocommon.copyright.Copyright.COPYRIGHT;

    
    public static boolean isNumeric(String stringToCheck)
    {
        if (!stringToCheck.endsWith("%"))
        {
            for (int idx = 0; idx < stringToCheck.length(); idx++)
            {
                char ch = stringToCheck.charAt(idx);
                if (!Character.isDigit(ch) && 
                        ch != '.' && 
                        ch != ',')
                    return false;
            }
        }

        return true;
    }
    
    /**
     * 
     * @param stringToCheck
     * @param charsToCheckFor
     * @return
     */
    public static boolean hasCharacter(String stringToCheck, char[] charsToCheckFor)
    {
        for (int idx = 0; idx < stringToCheck.length(); idx++)
        {
            char ch = stringToCheck.charAt(idx);
            
            for (int charIdx = 0; charIdx < charsToCheckFor.length; charIdx++)
            {
                if (ch == charsToCheckFor[charIdx])
                    return true;
            }
        }

        return false;
    }
    
    
    public static String normalizeToKey(String value)
    {
        if (value == null || value.length() == 0)
            return value;
        
        return value.trim().toLowerCase();
    }

    /**
     * Splits a string with name=value;name=value into individual parameters
     * 
     * @param parameters
     * @return a Properties object
     */
    public static Properties parseNameValueOptions(String parameters)
    {
        Properties options = new Properties();

        if (parameters == null || parameters.length() == 0)
            return options;

        String[] params = parameters.split(";");
        for (String param : params)
        {
            String nameValuePair[] = param.split("=");
            options.put(nameValuePair[0].toLowerCase(), nameValuePair[1]);
        }

        return options;
    }
}
