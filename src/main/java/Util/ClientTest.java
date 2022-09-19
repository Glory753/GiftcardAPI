package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientTest {
    //This static block has to be executed very first
    static {
        MyUtil.loadLog4j2Config("config/log4j2.xml");
    }

    private static final Logger logger = LogManager.getLogger(ClientTest.class);

    public static void main(String[] args)  {
        logger.info("Logging info message");
        logger.warn("Logging warn message");
        logger.error("Logging error message");
    }
}
