package BO.cours.db.testSLQ.test;

import java.sql.*;

public class testDB {
    private static final String SERVER="127.0.0.1";
    private static final String PORT="3306";
    private static final String DB="element_chimique";
    private static final String USER="root";
    private static final String PASSWORD="";

    public static void main(String[] args) {
//        String db = String.format("jdbc:mariadb://",SERVER,":",PORT,"/",DB,"?","user=",USER,"&password=",PASSWORD);
        String db = String.format("jdbc:mariadb://%s:%s/%s?user=%s", SERVER, PORT,  DB, USER);
//        StringBuffer sb = new StringBuffer("");
//        sb.append("jdbc:mariadb://");
//        sb.append(SERVER);
//        sb.append(":");
//        sb.append(PORT);
//        sb.append("/");
//        sb.append(DB);
//        sb.append("?");
//        sb.append("user=");
//        sb.append(USER);
//        sb.append("&");
//        sb.append("password=");
//        sb.append(PASSWORD);
        try {
            Connection cnx = JdbcTools.getConnection();
            cnx.setAutoCommit(false);
//            String sqlSelect = "select * from elements_chimiques";
            String sqlupdate = "update elements_chimiques set elSymbole=? where elId=?";
            PreparedStatement stmt = cnx.prepareStatement(sqlupdate);
            stmt.setString(1,"barbara");
            stmt.setInt(2,1);

            int nbRows = stmt.executeUpdate();
            System.out.println("nb enregistrement modifier :"+ nbRows);
            System.out.println("transaction non valide");
            stmt.setString(1,"ezit");
            stmt.setInt(2,1);
            nbRows = stmt.executeUpdate();
            System.out.println("nb enregistrement modifier :"+ nbRows);
            cnx.commit();
            System.out.println("transac ok");
//            ResultSet rs = stmt.executeQuery(sqlSelect);
//            StringBuilder sb = new StringBuilder();
//            while (rs.next()){
//                sb.append("id : ");
//                sb.append(rs.getInt("elId"));
//                sb.append(" nom : ");
//                sb.append(rs.getString("elNom"));
//                sb.append(" Symbole : ");
//                sb.append(rs.getString("elSymbole"));
//                sb.append(" NumAtomique : ");
//                sb.append(rs.getInt("elNumAtomique"));
//                sb.append(" MasseAtomique : ");
//                sb.append(rs.getInt("elMasseAtomique"));
//                sb.append('\n');
//            }
//            System.out.println(sb);
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
