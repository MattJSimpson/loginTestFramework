package DataProviders;

import Enums.DriverType;
import Enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    /* Instantiating property class to enable configuration properties to be pulled from one persistent .properties file */
    private final Properties properties;

    /* Simple implementation to read configuration files */
    public ConfigFileReader() {
        /* A BufferedReader object is used to read files line-by-line as individual String objects */
        BufferedReader bufferedReader;
        /* FileReader object lets web applications asynchronously read the contents of files (or raw data buffers) stored on the user's computer, using File or Blob objects to specify the file or data to read. */
        FileReader fileReader;
        /* Defining path of configuration.properties file as a string */
        String propertyFilePath = "config/configuration.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    /* A string is used to extract and define the current url */
    public String getUrl() {
        String url = properties.getProperty("url");

        //Simply If...Else
        if (url != null) return url;
        else
            throw new RuntimeException("url not specified in the config file.");
    }

    /* Object used to determine the timeout to use for all tests from the .properties file and is defined as a string "timeout" */
    public long getTime() {
        String timeout = properties.getProperty("timeout");

        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }

    /* DriverType object used to determine the web browser to use for all tests from the .properties file e.g. chrome, firefox, edge, safari */
    public DriverType getBrowser()  {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "edge":
                return DriverType.EDGE;
            case "safari":
                return DriverType.SAFARI;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
        }
    }

    /* EnvironmentType object used to determine the type of environment to use for all tests from the .properties file e.g. Local or Remote*/
    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");

        switch (environmentName) {
            case "local":
                return EnvironmentType.LOCAL;
            case "remote":
                return EnvironmentType.REMOTE;
            default:
                throw new RuntimeException("Environment type key value in configuration file is not matched: " + environmentName);
        }
    }
}
