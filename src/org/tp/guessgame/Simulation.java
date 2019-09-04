package org.tp.guessgame;

import org.tp.logger.Logger;
import org.tp.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long numberToGuess = player.askNextGuess();
        if(numberToGuess == this.numberToGuess) {
            player.respond(false);
            return true;
        }
        player.respond(true);
        if(numberToGuess > this.numberToGuess) this.logger.log("Lesser !");
        else this.logger.log("Greater !");
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIt) {
        long start = System.currentTimeMillis();
        while(maxIt > 0) {
            if(nextRound()) break;
            maxIt--;
        }
        long timelapseMillis = System.currentTimeMillis() - start;
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.MILLISECOND, (int) timelapseMillis);
        Date timelapseDate = calendar.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("mm:ss.SSS");
        this.logger.log("The game finished in " + dateFormatter.format(timelapseDate) + " (min:sec.milli)");

        if(maxIt != 0) this.logger.log("You Win !");
        else this.logger.log("You Loose !");
    }
}
