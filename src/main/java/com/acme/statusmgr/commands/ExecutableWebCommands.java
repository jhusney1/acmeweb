package com.acme.statusmgr.commands;

/**
 * Interface that if implemented will create contract that requires the execute method and
 * the state of the command to be stored
 */
public interface ExecutableWebCommands {

    enum CmdState {NOTSTARTED, INPROGRESS, COMPLETED}
    void execute();
}
