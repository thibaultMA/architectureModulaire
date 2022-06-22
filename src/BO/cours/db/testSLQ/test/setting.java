package BO.cours.db.testSLQ.test;

import java.io.IOException;
import java.util.Properties;

public class setting {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(setting.class.getResourceAsStream("settings.properties"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperties(String key ){
        return properties.getProperty(key);
    }

}
