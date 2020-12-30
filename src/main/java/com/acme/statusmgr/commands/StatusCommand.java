package com.acme.statusmgr.commands;

abstract class StatusCommand implements ExecutableWebCommands {

    CmdState cmdState;
    Long cmdId;
    String template;
    String requestorName;

    StatusCommand(Long cmdId, String template, String name) {
        this.cmdId = cmdId;
        this.template = template;
        this.requestorName = name;
        this.cmdState = CmdState.NOTSTARTED;
    }
}
