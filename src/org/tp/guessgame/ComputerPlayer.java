package org.tp.guessgame;

import org.tp.logger.Logger;
import org.tp.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        //TODO implement me
        return 0;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        //TODO implement me
    }
}
