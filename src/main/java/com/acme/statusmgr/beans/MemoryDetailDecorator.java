package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;
import org.apache.catalina.Server;

public class MemoryDetailDecorator extends DetailedStatusControllerDecorator {

    ServerManager serverManager;
    public MemoryDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", " + serverManager.getMemoryStatus();
    }
}