package org.tp.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(new SecureRandom().nextInt(100));
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }


        else if(args.length > 0 && args[0].equals("-auto") && Integer.parseInt(args[1]) > 0) {
            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(new SecureRandom().nextInt(Integer.parseInt(args[1])));
            simulation.loopUntilPlayerSucceed(10000);
        }

        else {
            System.out.println("Wrong arguments passed.");
            System.out.println("Usage: java Launcher [args]");
            System.out.println("You can specify as args : -interactive / -auto [number]");
        }
    }
}
