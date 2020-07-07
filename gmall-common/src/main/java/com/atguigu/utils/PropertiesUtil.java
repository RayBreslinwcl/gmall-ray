package com.atguigu.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties load(String path) {

        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
