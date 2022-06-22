package BO.cours.db.testSLQ.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static final String SERVER=setting.getProperties("server");
    private static final String PORT=setting.getProperties("port");
    private static final String DB=setting.getProperties("db");
    private static final String USER=setting.getProperties("user");
    private static final String PASSWORD=setting.getProperties("pswd");
    public static Connection getConnection()throws SQLException {
        String db = String.format("jdbc:mariadb://%s:%s/%s?user=%s&password=%s", SERVER, PORT,  DB, USER, PASSWORD);
        return DriverManager.getConnection(db.toString());
    }
}
