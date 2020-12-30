package com.acme.statusmgr.executors;
import com.acme.statusmgr.commands.ExecutableWebCommands;

public class SimpleExecutor {

    private ExecutableWebCommands command;
    public SimpleExecutor(ExecutableWebCommands command) {
        this.command = command;
    }

    public void handleImmediately()
    {
        command.execute();
    }


}
