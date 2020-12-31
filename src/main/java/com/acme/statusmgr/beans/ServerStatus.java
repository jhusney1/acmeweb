package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.*;

import java.util.List;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus {

    long id;
    String contentHeader;
    String statusDesc = "Unknown";
    private ServerManager serverManager;



    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id            a numeric identifier/counter of which request this
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {

        this.id = id;
        this.contentHeader = contentHeader;


        //Obtain and save reference to the ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
        this.statusDesc = serverManager.getCurrentServerStatus();

    }

    public ServerStatus(long id, String contentHeader, List<String> details) throws BadRequestException {

        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

        this.id = id;
        this.contentHeader = contentHeader;
        this.statusDesc = serverManager.getCurrentServerStatus();
    }

    public ServerStatus() {

    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }

    /**
     * Used to retrieve current status description and modify it with decorators etc
     * @return
     */
    public String obtainStatusDesc() {
        return statusDesc;
    }

    /**
     * Spring calls to retrieve string after already created and stored by setStatusDesc
     * @return
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Sets statusDesc before spring gets to it. This allows the executor to do the heavy lifting
     * @param statusDesc
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
