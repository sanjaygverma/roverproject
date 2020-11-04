package com.mars.rover.command;

import com.mars.rover.Constants;
import com.mars.rover.location.Location;

public class RoverCommand implements Command {

    @Override
    public Location forward(Location location) {
        Location loc = null;
        String direction  = location.getDirection();
        switch (direction){
            case Constants.NORTH:
                loc = location.updateLongitude(location.getLongitude()+1);
                break;
            case Constants.SOUTH:
                loc = location.updateLongitude(location.getLongitude()+(-1));
                break;
            case Constants.EAST:
                loc = location.updateLatitude(location.getLatitude()+1);
                break;
            case Constants.WEST:
                loc = location.updateLatitude(location.getLatitude()+(-1));
                break;
        }
        return loc;
    }

    @Override
    public Location backward(Location location) {
        Location loc = null;
        switch (location.getDirection().toUpperCase()){
            case Constants.NORTH:
                loc = location.updateLongitude(location.getLongitude()-1);
                break;
            case Constants.SOUTH:
                loc = location.updateLongitude(location.getLongitude()-(-1));
                break;
            case Constants.EAST:
                loc = location.updateLatitude(location.getLatitude()-1);
                break;
            case Constants.WEST:
                loc = location.updateLatitude(location.getLatitude()-(-1));
                break;
        }
        return loc;
    }

    @Override
    public Location rotateQuarterClockWise(Location location) {
        Location loc = null;
        String direction = location.getDirection().toUpperCase();
        switch (direction){
            case Constants.NORTH:
                loc = location.updateDirection(Constants.EAST);
                break;
            case Constants.SOUTH:
                loc = location.updateDirection(Constants.WEST);
                break;
            case Constants.EAST:
                loc = location.updateDirection(Constants.SOUTH);
                break;
            case Constants.WEST:
                loc = location.updateDirection(Constants.NORTH);
                break;
        }
        return loc;
    }

    @Override
    public Location rotateQuarterAntiClockWise(Location location) {
        Location loc = null;
        String direction = location.getDirection().toUpperCase();
        switch (direction){
            case Constants.NORTH:
                loc = location.updateDirection(Constants.WEST);
                break;
            case Constants.SOUTH:
                loc = location.updateDirection(Constants.EAST);
                break;
            case Constants.EAST:
                loc = location.updateDirection(Constants.NORTH);
                break;
            case Constants.WEST:
                loc = location.updateDirection(Constants.SOUTH);
                break;
        }
        return loc;
    }
}
