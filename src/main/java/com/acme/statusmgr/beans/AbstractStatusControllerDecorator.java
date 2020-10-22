package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public abstract class AbstractStatusControllerDecorator extends ServerStatus {

    ServerStatus serverStatusToBeDecorated;


    public AbstractStatusControllerDecorator(ServerStatus serverStatus) {
        this.id = serverStatus.id;
        this.contentHeader = serverStatus.contentHeader;
        this.statusDesc = serverStatus.statusDesc;
        this.serverStatusToBeDecorated = serverStatus;
    }


    abstract public String getStatusDesc();
}
