package com.ucodeacademy.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        String path = "config.properties";

        try {
            FileInputStream file = new FileInputStream(path);

            properties.load(file);
            file.close();

        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("The file Path was not found in ConfigReade");
        }


    }

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }
}
