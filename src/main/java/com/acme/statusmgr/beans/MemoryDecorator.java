package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public class MemoryDecorator extends AbstractStatusControllerDecorator {

    ServerManager serverManager;

    public MemoryDecorator(ServerStatus serverStatusToBeDecorated) {
        super(serverStatusToBeDecorated);
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

    }

    @Override
    public String obtainStatusDesc() {
        return super.serverStatusToBeDecorated.obtainStatusDesc() + ", " + serverManager.getMemoryStatus();
    }
}