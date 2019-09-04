package org.tp.guessgame;

import org.tp.logger.Logger;
import org.tp.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scan = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        this.logger.log("Choose a number: ");
        return scan.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) this.logger.log("It's lower or greater !");
        else this.logger.log("You find the good number !");
    }
}
