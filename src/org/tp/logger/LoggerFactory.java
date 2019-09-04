package org.tp.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new ContextualLogger(name,
                                     new CompositeLogger(new ConsoleLogger(),
                                                         new FilteredLogger(
                                                                 new FileLogger("FileLogger.txt"),
                                                                 message -> message.contains("simulation")
                                                         )
                                     )
        );
    }
}
