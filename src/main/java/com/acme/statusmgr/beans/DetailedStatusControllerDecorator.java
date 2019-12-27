package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

public abstract class DetailedStatusControllerDecorator implements AbstractStatus {

    private AbstractStatus detailedStatusControllerToBeDecorated;


    public DetailedStatusControllerDecorator(AbstractStatus detailedStatusControllerToBeDecorated){
        this.detailedStatusControllerToBeDecorated = detailedStatusControllerToBeDecorated;
        this.detailedStatusControllerToBeDecorated = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }

    @Override
    public String getCurrentServerStatus() {
        return detailedStatusControllerToBeDecorated.getCurrentServerStatus();
    }
}
