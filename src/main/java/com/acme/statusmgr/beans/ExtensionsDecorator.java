package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public class ExtensionsDecorator extends AbstractStatusControllerDecorator {

    ServerManager serverManager;

    public ExtensionsDecorator(ServerStatus serverStatusToBeDecorated) {
        super(serverStatusToBeDecorated);
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

    }

    @Override
    public String obtainStatusDesc() {

        return super.serverStatusToBeDecorated.obtainStatusDesc() + ", " + serverManager.getExtensionsStatus();
    }
}
