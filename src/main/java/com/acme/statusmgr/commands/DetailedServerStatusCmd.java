package com.acme.statusmgr.commands;

import com.acme.statusmgr.BadRequestException;
import com.acme.statusmgr.beans.ExtensionsDecorator;
import com.acme.statusmgr.beans.MemoryDecorator;
import com.acme.statusmgr.beans.OperationsDecorator;
import com.acme.statusmgr.beans.ServerStatus;

import java.util.List;

/**
 * Stores information about the command as per the command pattern design
 * Contains method that will actually execute the command and complete it before spring gets the chance
 */
public class DetailedServerStatusCmd extends StatusCommand implements ExecutableWebCommands {

    List<String> details;


    private ServerStatus decoratedServerStatus = null;

    public DetailedServerStatusCmd(Long cmdId, String template, String name, List<String> details) {
        super(cmdId, template, name);
        this.details = details;
    }

    /**
     * Saves progress of command
     * Creates layers of decorators which will get all detail parameter strings
     * Stores the ServerStatus by calling its set method
     */
    public void execute() {
        this.cmdState = CmdState.INPROGRESS;

        decoratedServerStatus = new ServerStatus(this.cmdId, String.format(this.template, this.name), details);
        for (String s : details) {
            if (s.equals("operations")) {
                decoratedServerStatus = new OperationsDecorator(decoratedServerStatus);
            } else if (s.equals("extensions")) {
                decoratedServerStatus = new ExtensionsDecorator(decoratedServerStatus);
            } else if (s.equals("memory")) {
                decoratedServerStatus = new MemoryDecorator(decoratedServerStatus);
            } else throw new BadRequestException("invalid details option:" + s);
        }
        decoratedServerStatus.setStatusDesc(decoratedServerStatus.obtainStatusDesc());

        this.cmdState = CmdState.COMPLETED;
    }

    public ServerStatus getResult() {
        return decoratedServerStatus;
    }
}
