/*
 * CIMSDataSource.java
 *
 * Copyright (c) 2005 CIMS Lab, Inc.
 * 3013 Douglas Boulevard, Suite 120, Roseville, California, 95661-3842, U.S.A.
 * All rights reserved.
 *
 */

package com.cims.types;

import java.util.*;

/**
 * Class documentation
 *
 */
public class CIMSDataSource
{
    public enum DBType {
        UNKNOWN,
        DB2,
        MSSQLSERVER,
        ORACLE
    }
    
    public enum DBPlatformType {
    	UNKNOWN,
		WINDOWS,
		UNIX,
		ZOS
	}    

	public String dataSourceNameOS = null;      // OS data source mapping (e.g., ODBC)
    public String dataSourcePassword = null;
    public String dataSourceUserId = null;
    public DBType databaseType  = DBType.UNKNOWN;
    public DBPlatformType databasePlatform  = DBPlatformType.UNKNOWN;
}
