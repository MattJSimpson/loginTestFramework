package Managers;

import DataProviders.ConfigFileReader;

/* FileReaderManager is created as one globally accessible instance of a class in order to manage all the file reader objects in this framework */
public class FileReaderManager {

    /* Instantiating all objects required when defining the FileReaderManager class */
    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
