package TestManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

public class Log {

    static {
        init() ;
    }


    private static final Logger LOGGER = LogManager.getLogger(Log.class) ;

    private static void init () {
        PropertyConfigurator.configure("src/test/java/Log.properties");
    }

    public static <T> void pass (T message) {
        LOGGER.info(message);
    }

    public static <T> void warning(T message) {
        LOGGER.warn(message);
    }

    public static <T> void fail(T message) {
        LOGGER.error(message);
        Assert.fail(message.toString());
    }
}
