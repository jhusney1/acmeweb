package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class ExtentionsDetailDecorator extends DetailedStatusControllerDecorator {
    public ExtentionsDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", " + ServerManager.getExtensionsStatus();
    }
}
