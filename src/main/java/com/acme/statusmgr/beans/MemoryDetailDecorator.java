package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class MemoryDetailDecorator extends DetailedStatusControllerDecorator {
    public MemoryDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", " + ServerManager.getMemoryStatus();
    }
}