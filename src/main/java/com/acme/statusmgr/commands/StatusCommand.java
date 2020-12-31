package com.acme.statusmgr.commands;

/**
 * Contract that will require classes that extend it to have these fields about the command
 * Will be called upon to store some information with 'super'
 */
abstract class StatusCommand implements ExecutableWebCommands {

    CmdState cmdState;
    Long cmdId;
    String template;
    String name;

    StatusCommand(Long cmdId, String template, String name) {
        this.cmdId = cmdId;
        this.template = template;
        this.name = name;
        this.cmdState = CmdState.NOTSTARTED;
    }
}
