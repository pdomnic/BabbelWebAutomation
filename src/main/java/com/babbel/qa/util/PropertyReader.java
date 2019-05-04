package com.babbel.qa.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * This file will help to read property from config file or set property to config file.
 */
public class PropertyReader {

    private static final Properties props = new Properties();
    HashMap<String, String> objectAndDataMap = new HashMap<String, String>();


    /*
     * Reading the properties file
     */
    public static Properties getProperties(String fileName) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);
            props.load(fis);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }


    /*
     * set the properties in file
     */
    public void setProperty(String propertyKey, String value) throws FileNotFoundException, IOException {

        props.setProperty(propertyKey, value);

    }

    /*
     * Load properties in file and return as map.
     */

    public Map<String, String> loadPropertiesFile(String fileName) {

        objectAndDataMap = new HashMap<String, String>();

        try {
            InputStream fstream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("=")) {
                    String[] splitLine = line.split("=");
                    String key = splitLine[0];
                    String value = splitLine[1];
                    objectAndDataMap.put(key, value);
                }
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectAndDataMap;
    }
}
