package com.mars.rover.command.process;

import com.mars.rover.Constants;
import com.mars.rover.location.Location;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.mars.rover.Constants.DELIM;
import static com.mars.rover.Constants.EAST;
import static com.mars.rover.Constants.WEST;
import static com.mars.rover.Constants.NORTH;
import static com.mars.rover.Constants.SOUTH;

import static java.util.stream.Collectors.toList;

public class CommandProcessorUtils {

    public static Location interpretLocation(String cordString)
    {
        String [] coords = cordString.split(DELIM);
        if(coords.length != 3)
            throw new IllegalArgumentException("Need param in format 'Latitude,Longitude,Direction' ");
        return new Location(Integer.parseInt(coords[0]),
                Integer.parseInt(coords[1]),
                getDirection(coords[2]));
    }

    public static String getDirection(String directionShort)
    {
        String direction  = null;
        switch (directionShort)
        {
            case "N":
                direction = NORTH;
                break;
            case "S":
                direction = SOUTH;
                break;
            case "E":
                direction = EAST;
                break;
            case "W":
                direction = WEST;
                break;
        }
        return direction;
    }

    public static List<String> interpretCommandString(String commandString)
    {
        return Arrays.stream(commandString.split(DELIM)).collect(toList());
    }

}
