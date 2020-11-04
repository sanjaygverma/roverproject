package com.mars.rover.command;

import com.mars.rover.command.process.CommandProcessor;
import com.mars.rover.location.Location;

import java.util.concurrent.Callable;

public class CommandTask implements Callable<String> {

    private Location location;
    private String commandParams[];


    public CommandTask(final Location location, final String params[])
    {
        this.location = location;
        this.commandParams = params;
    }

    @Override
    public String call() throws Exception {
        return CommandProcessor.process(location, commandParams);
    }
}
