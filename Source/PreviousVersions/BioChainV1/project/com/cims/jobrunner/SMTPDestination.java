/*
 * Copyright  2005-2006 CIMS Lab, Inc.
 *
 *
 */
package com.cims.jobrunner;

/**
 * Provides a container for information about a SMTP destination.
 *
 */
public class SMTPDestination {

    
    //  ------------------------------------------------------- Constants
    
    
    private static final int    DEFAULT_PORT = 25;
    private static final String DEFAULT_SERVERNAME = "mail.cimslab.com";
    private static final String DEFAULT_ADDRESS = "CIMSProcessResults@cimslab.com";
    
    
    //  ------------------------------------------------------- Instance Varibles

    
    /** Destination adress in format user@domain. */
    private String address = DEFAULT_ADDRESS;
    /** Port to use to communicate with SMTP server. */
    private int port = DEFAULT_PORT;
    /** Name of the SMTP server. */
    private String  serverName = DEFAULT_SERVERNAME;
    /** User id for plain-text authentication to SMTP server */
    private String  userId = null;
    /** User password for plain-text authentication to SMTP server */
    private String  userPassword = null;
    
    
    //  ------------------------------------------------------- Properties
    

    /**
     * @return Returns the destination address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address The destination address to set in the form <code>user@domain</code>.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The SMTP server port number.
     */
    public int getPort() {
        return this.port;
    }

    /**
     * @param value The SMTP server port number.
     */
    public void setPort(int port) {
        if (port > 0)
            this.port = port;
        else
            this.port = DEFAULT_PORT;
    }

    /**
     * @return The SMTP server name.
     */
    public String getServerName() {
        return this.serverName;
    }

    /**
     * @param value The SMTP server name to set. This cannot be <code>null</code>.
     */
    public void setServerName(String serverName) {
        if (serverName != null)
            this.serverName = serverName;
        else
            this.serverName = DEFAULT_SERVERNAME;
    }

    /**
     * @return The current user id. May be <code>null</code>, 
     *          indicating that no authentication will be done.
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * @param userId The userId to set.
     */
    public void setUserId(String userId) {
        if (userId != null)
            this.userId = userId;
        else
            this.userId = "";
    }

    /**
     * @return Returns the user password.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword The user password to set. 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    //  ------------------------------------------------------- Public Methods
    
    //  ------------------------------------------------------- Private Methods    
}
