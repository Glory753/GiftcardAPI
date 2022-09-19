package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class MyUtil {

    //Utility method to support load log4j2.xml file
    public static void loadLog4j2Config(String logConfigurationFile) {
        try {
            InputStream inputStream = new FileInputStream(logConfigurationFile);
            ConfigurationSource source = new ConfigurationSource(inputStream);
            Configurator.initialize(null, source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}