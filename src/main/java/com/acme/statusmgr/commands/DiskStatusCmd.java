package com.acme.statusmgr.commands;

import com.acme.statusmgr.beans.*;

/**
 * Stores information about the command as per the command pattern design
 * Contains method that will actually execute the command and complete it before spring gets the chance
 */
public class DiskStatusCmd extends StatusCommand implements ExecutableWebCommands{
    private DiskStatus result = null;

    public DiskStatusCmd(Long cmdId, String template, String name){
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
        result = new DiskStatus(cmdId, String.format(template, name));
        result.checkDisk();
        this.cmdState = CmdState.COMPLETED;
    }

    /**
     * Returns the Disk results that it created
     * @return
     */
    public DiskStatus getResult() {
        return result;
    }
}
