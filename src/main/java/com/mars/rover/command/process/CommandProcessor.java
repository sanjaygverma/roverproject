package com.mars.rover.command.process;

import com.mars.rover.Rover;
import com.mars.rover.command.Command;
import com.mars.rover.command.RoverCommand;
import com.mars.rover.location.Location;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import static com.mars.rover.Constants.F;
import static com.mars.rover.Constants.B;
import static com.mars.rover.Constants.L;
import static com.mars.rover.Constants.R;

public class CommandProcessor {

    private static final ConcurrentMap<Location, Rover> location2Rover = new ConcurrentHashMap<>();


    public static String process(Location location, String[] commandParams) {
        String retStr = "Final Coordinate: %d, %d   \nFinal Direction:  %s";
        Location location1 = new Location(location.getLatitude(), location.getLongitude(), location.getDirection());

        Set<Location> hashSet = new LinkedHashSet<>(); // to get all and remove at the end (its thread safe as its in the stack)
        if(location2Rover.containsKey(location))
            return "";

        Command cmd = new RoverCommand();
        for (String command: commandParams) {
            switch (command){
                case F:
                    Location locationDervdF = cmd.forward(location);
                    if(location2Rover.putIfAbsent(locationDervdF, new Rover(Thread.currentThread().getName(),"Test")) != null)
                        return "";
                    else
                        hashSet.add(locationDervdF); //add the same value in the set
                    location = locationDervdF;
                    break;
                case B:
                    Location locationDervdB = cmd.backward(location);

                    if(location2Rover.putIfAbsent(locationDervdB, new Rover(Thread.currentThread().getName(),"Test")) != null)
                        return "";
                    else
                        hashSet.add(locationDervdB); //add the same value in the set
                    location = locationDervdB;
                    break;
                case R:
                    location = cmd.rotateQuarterClockWise(location);
                    break;
                case L:
                    location = cmd.rotateQuarterAntiClockWise(location);
                    break;
            }
        }

        //Remove all the locations except last one
        hashSet.stream().limit(hashSet.size()-1).map(loc -> location2Rover.remove(loc));
        hashSet.clear();

        if(location2Rover.putIfAbsent(location, new Rover(Thread.currentThread().getName(),"Test")) == null) {
            retStr = String.format(retStr, location.getLatitude(), location.getLongitude(), location.getDirection());
            System.out.println(retStr);
        }
        else {
            retStr = "";
            //System.out.println("***");
        }
        return retStr;
    }

}


