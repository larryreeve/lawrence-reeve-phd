/*
 * CIMSDataSourceManager.java
 *
 * Copyright (c) 2005 CIMS Lab, Inc.
 * 3013 Douglas Boulevard, Suite 120, Roseville, California, 95661-3842, U.S.A.
 * All rights reserved worldwide.
 *
 */

package com.cims.dal;

import java.util.logging.*;

/**
 * Class documentation
 *
 */
public class CIMSDataSourceManager 
{
    /** instantiate class logger */
    public static final Logger LOG = Logger.getLogger("com.cims.data.dal.CIMSDataSourceManager");

    /** class variable documentation */
    private static String dataSourceName = null;


    /** 
     * method documentation
     * 
     * @param param1 documentation
     */
    public static String getDataSourceName() {
        return dataSourceName;
    }

    /** 
     * method documentation
     * 
     * @param param1 documentation
     */
    public static void setDataSourceName(String value) 
    {
        dataSourceName = value;
    }

}
