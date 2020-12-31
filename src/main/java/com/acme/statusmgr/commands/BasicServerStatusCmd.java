package com.acme.statusmgr.commands;

import com.acme.statusmgr.StatusController;
import com.acme.statusmgr.beans.*;

/**
 * Stores information about the command as per the command pattern design
 * Contains method that will actually execute the command and complete it before spring gets the chance
 */
public class BasicServerStatusCmd extends StatusCommand implements ExecutableWebCommands{
    private ServerStatus result = null;

    public BasicServerStatusCmd(Long cmdId, String template, String name){
        super(cmdId, template, name);
    }

    /**
     * Executes command
     * Stores progress of command state
     * Can be modified in the future to store more important information about command
     */
    @Override
    public void execute() {
        this.cmdState = CmdState.INPROGRESS;
        result = new ServerStatus(cmdId, String.format(template, name));
        result.setStatusDesc(result.obtainStatusDesc());
        this.cmdState = CmdState.COMPLETED;
    }

    /**
     * Returns the ServerStatus that it created
     * @return
     */
    public ServerStatus getResult() {
        return result;
    }
}
