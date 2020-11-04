package com.mars.rover.command.process;

import com.mars.rover.location.Location;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.mars.rover.Constants.DELIM;

public class CommandProcessorMain {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     *  in the format <n> <location> <command> ...
     *  - n is the number of commands on the command line
     *  - latitude,longitude,N/E/W/S example: 3,4,N
     *  - array of commands example:  f - forward ,b - backward ,r - rotate 90 degree cockwise ,
     *    l - rotate 90 degree anticlock wise
     *    example: f,f,b,f,f
     *
     * @param args
     */

    /*private static final CommandProcessor cmdProcessor = CommandProcessor.of();*/

    public static void main(String[] args) {
        executeCommands();

    }

    private static void executeCommands() {
        ExecutorService execSvc = null;
        try {
            execSvc = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            int noOfCommands = Integer.parseInt(scanner.nextLine());

            Set<Callable<String>> lstCall = new LinkedHashSet<>();

            for (int i = 0; i < noOfCommands; i++) {
                String command = scanner.nextLine();
                Location loc = CommandProcessorUtils.interpretLocation(command);

                String commandStr = scanner.nextLine(); // commandStr
                lstCall.add(() -> CommandProcessor.process(loc, commandStr.split(DELIM)));

            }
            execSvc.invokeAll(lstCall);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            execSvc.shutdown();
        }
    }

}
