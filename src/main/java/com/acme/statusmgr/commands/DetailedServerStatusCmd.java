package com.acme.statusmgr.commands;

import com.acme.statusmgr.beans.ServerStatus;

import java.util.List;

public class DetailedServerStatusCmd extends StatusCommand implements ExecutableWebCommands {

//    DecoratorStyle decoratorstyle;
    List<String> detailTypes;

    private ServerStatus result = null;

    public DetailedServerStatusCmd(Long cmdId, String template, String name, List<String> detailTypes) {
        super(cmdId, template, name);
        this.detailTypes = detailTypes;
    }

    public void execute() {
        this.cmdState = CmdState.INPROGRESS;

        result = new ServerStatus(this.cmdId, String.format(this.template, this.requestorName));

        result.setStatusDesc(result.obtainStatusDesc());

        this.cmdState = CmdState.COMPLETED;
    }

    public ServerStatus getResult() {
        return result;
    }
}
