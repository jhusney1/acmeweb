package com.acme.statusmgr.commands;

import com.acme.statusmgr.StatusController;
import com.acme.statusmgr.beans.*;

public class BasicServerStatusCmd extends StatusCommand implements ExecutableWebCommands{
    private ServerStatus result = null;

    public BasicServerStatusCmd(Long cmdId, String template, String name){
        super(cmdId, template, name);
    }

    @Override
    public void execute() {
        this.cmdState = CmdState.INPROGRESS;
        result = new ServerStatus(cmdId, String.format(template, requestorName));
        this.cmdState = CmdState.COMPLETED;
    }

    public ServerStatus getResult() {
        return result;
    }
}
