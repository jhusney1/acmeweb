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

    //AbstractStatusControllerDecorator detailedStatusControllerDecorator;
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

    public String getStatusDesc() {
        return statusDesc;
    }
}
