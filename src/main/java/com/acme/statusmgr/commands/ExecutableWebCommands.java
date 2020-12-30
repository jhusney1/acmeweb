package com.acme.statusmgr.commands;

public interface ExecutableWebCommands {

    enum CmdState {NOTSTARTED, INPROGRESS, COMPLETED, ERROR}
    void execute();
}
