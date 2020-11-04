package com.mars.rover.command.process;

import com.mars.rover.location.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.mars.rover.Constants.F;
import static com.mars.rover.Constants.B;
import static com.mars.rover.Constants.L;
import static com.mars.rover.Constants.R;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
class CommandProcessorTest {

    /**
     *
     * Test cases
     *  1. No collision
     *  2. Inputs with Collision
     *  3. Inputs with no collision but outputs having collision but onbly set of one rover gets execution done rest
     *      - gets it command cancelled.
     *  4. Intermediate location collision
     *
     *
     *
     */
    @Test
    void process1() {
        System.out.println(Thread.currentThread().getName());
        Location loc = new Location(3,4,"NORTH");
        CommandProcessor.process(loc,new String[]{F,F,R,F,F});
    }


    @Test
    void process3() {
        System.out.println(Thread.currentThread().getName());
        Location loc = new Location(4,6,"EAST");
        CommandProcessor.process(loc,new String[]{F});
    }

    @Test
    void process4() {
        System.out.println(Thread.currentThread().getName());
        Location loc = new Location(4,6,"EAST");
        CommandProcessor.process(loc,new String[]{F,F,B});
    }

    @Test
    void process5() {
        System.out.println(Thread.currentThread().getName());
        Location loc = new Location(6,6,"EAST");
        CommandProcessor.process(loc,new String[]{F,F,B});
    }

    @Test
    void process6() {
        System.out.println(Thread.currentThread().getName());
        Location loc = new Location(8,6,"EAST");
        CommandProcessor.process(loc,new String[]{F,F,B,L});
    }

}