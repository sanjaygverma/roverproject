package com.mars.rover;

import com.mars.rover.command.Command;
import com.mars.rover.command.RoverCommand;
import com.mars.rover.location.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverCommandTest {

    @Test
    void forward() {
        Location loc = new Location(3,4,"NORTH");
        Command command = new RoverCommand();
        Location aloc = command.forward(loc);
        Location eloc = new Location(3,5,"NORTH");
        assertNotNull(eloc);
        assertEquals(eloc,aloc);

        aloc = command.forward(eloc);
        eloc = new Location(3,6,"NORTH");
        assertEquals(eloc,aloc);

        aloc = command.rotateQuarterClockWise(eloc);
        eloc = new Location(3,6,"EAST");
        assertEquals(eloc,aloc);

        aloc = command.forward(eloc);
        eloc = new Location(4,6,"EAST");
        assertEquals(eloc,aloc);

        aloc = command.forward(eloc);
        eloc = new Location(5,6,"EAST");
        assertEquals(eloc,aloc);

    }

/*    @Test
    void backward() {
    }

    @Test
    void rotateQuarterClockWise() {
    }

    @Test
    void rotateQuarterAntiClockWise() {
    }*/
}