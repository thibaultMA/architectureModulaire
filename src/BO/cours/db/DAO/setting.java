package BO.cours.db.DAO;

import java.io.IOException;
import java.util.Properties;

public class setting {
    private static Properties properties;
    private static void chargement()throws DALexception {
        properties = new Properties();
        try {
            properties.load(setting.class.getResourceAsStream("setting.properties"));
        }catch (IOException e) {
            throw new DALexception("zadaz");
        }
    }
    public static String getProperties(String key )throws DALexception{
        chargement();
        return properties.getProperty(key);
    }

}
