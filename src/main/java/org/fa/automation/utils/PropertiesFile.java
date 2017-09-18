package org.fa.automation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Forgeahead-Shital on 9/14/2017.
 */
public class PropertiesFile {
    Properties properties;
    InputStream inputStream;

    public Properties readPropertyFile(String filename) {
        try {

            inputStream = new FileInputStream(filename);
            properties.load(inputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
