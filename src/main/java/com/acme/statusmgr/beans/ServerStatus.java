package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.*;

import java.util.List;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    private ServerManager serverManager = new ServerManager();


    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = serverManager.getCurrentServerStatus();
    }
    public ServerStatus(long id, String contentHeader, List<String> details) throws BadRequestException {
        this.id = id;
        this.contentHeader = contentHeader;

        AbstractStatus detailedStatusControllerDecorator = new ServerManager();
        for(String s : details) {
            if(s.equals("operations"))
                detailedStatusControllerDecorator = new OperationsDetailDecorator(detailedStatusControllerDecorator);
            else if(s.equals("extensions"))
                detailedStatusControllerDecorator = new ExtentionsDetailDecorator(detailedStatusControllerDecorator);
            else if(s.equals("memory"))
                detailedStatusControllerDecorator = new MemoryDetailDecorator(detailedStatusControllerDecorator);
            else throw new BadRequestException("invalid details option:" + s);
        }
        this.statusDesc = detailedStatusControllerDecorator.getCurrentServerStatus();
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
