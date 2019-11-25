package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class OperationsDetailDecorator extends DetailedStatusControllerDecorator {
    public OperationsDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", " + ServerManager.getOperationsStatus();
    }
}

