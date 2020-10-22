package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public class OperationsDecorator extends AbstractStatusControllerDecorator {

    ServerManager serverManager;

    public OperationsDecorator(ServerStatus serverStatusToBeDecorated) {

        super(serverStatusToBeDecorated);
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

    }

    @Override
    public String getStatusDesc() {
        return super.serverStatusToBeDecorated.getStatusDesc() + ", " + serverManager.getOperationsStatus();
    }
}

