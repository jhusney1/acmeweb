package com.acme.statusmgr;

public class OperationsDetailDecorator extends DetailedStatusControllerDecorator {
    public OperationsDetailDecorator(AbstractStatus detailedStatusControllerToBeDecorated) {
        super(detailedStatusControllerToBeDecorated);
    }

    @Override
    public String getCurrentServerStatus() {
        return super.getCurrentServerStatus() + ", and is operating normally";
    }
}

