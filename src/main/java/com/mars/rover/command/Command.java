package com.mars.rover.command;

import com.mars.rover.location.Location;

public interface Command {
    public Location forward(Location location);
    public Location backward(Location location);
    public Location rotateQuarterClockWise(Location location);
    public Location rotateQuarterAntiClockWise(Location location);
}
