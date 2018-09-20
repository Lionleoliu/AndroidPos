package MethodTest;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Log4JDemo");
        PropertyConfigurator.configure("E:\\YJPWork\\Code\\YJPRetailAutoTestDemo\\log4j.properties");
        logger.debug("This is debug");
        logger.info("This is info");
        logger.warn("This is warn");
        logger.error("This is error");
        logger.fatal("This is fatal");
    }
}
