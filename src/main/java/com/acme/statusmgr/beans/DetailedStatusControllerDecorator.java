package com.acme.statusmgr.beans;

public abstract class DetailedStatusControllerDecorator implements AbstractStatus {

    private final AbstractStatus detailedStatusControllerToBeDecorated;

    public DetailedStatusControllerDecorator(AbstractStatus detailedStatusControllerToBeDecorated){
        this.detailedStatusControllerToBeDecorated = detailedStatusControllerToBeDecorated;
    }

    @Override
    public String getCurrentServerStatus() {
        return detailedStatusControllerToBeDecorated.getCurrentServerStatus();
    }
}
