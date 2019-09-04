package org.tp.logger;

public class CompositeLogger implements Logger {
    private final Logger devLog;
    private final Logger fileLog;

    @Override
    public void log(String message) {
        this.devLog.log(message);
        this.fileLog.log(message);
    }

    public CompositeLogger(Logger devLog, Logger fileLog) {
        this.devLog = devLog;
        this.fileLog = fileLog;
    }
}
