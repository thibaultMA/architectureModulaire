package BO.Tp.eu.unareil.DAL;

import BO.cours.db.testSLQ.test.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static final String SERVER= setting.getProperties("server");
    private static final String PORT= setting.getProperties("port");
    private static final String DB= setting.getProperties("db");
    private static final String USER= setting.getProperties("user");
    private static final String PASSWORD= setting.getProperties("pswd");

    public static Connection getConnection() throws DALexception {
        String db = String.format("jdbc:mariadb://%s:%s/%s?user=%s&password=%s", SERVER, PORT,  DB, USER, PASSWORD);
        Connection cnx;
        try{
            cnx= DriverManager.getConnection(db.toString());
        } catch (SQLException e) {
            throw new DALexception("e",e.getCause());
        }
        return cnx;
    }
}
