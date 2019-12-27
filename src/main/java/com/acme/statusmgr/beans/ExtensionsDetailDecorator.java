package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public class ExtensionsDetailDecorator extends DetailedStatusControllerDecorator {

    ServerManager serverManager;
    public ExtensionsDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");

    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", " + serverManager.getExtensionsStatus();
    }
}
