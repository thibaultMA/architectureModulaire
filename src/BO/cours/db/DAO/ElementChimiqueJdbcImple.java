package BO.cours.db.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElementChimiqueJdbcImple implements DAO<ElementChimique>{
    private static final String sql_INSERT="insert into elements_chimiques (elNom,elSymbole,elNumAtomique,elMasseAtomique) values(?,?,?,?)";
    private static final String sql_Update="update elements_chimiques set elNom = ?,elSymbole=?,elNumAtomique=?,elMasseAtomique=? where elId=?";
    private static final String sql_DELETE="delete elements_chimiques where elId=?";
    private static final String sql_SELECT_ALL="select * from elements_chimiques ";
    private static final String sql_SELECT_BY_ID="select * from elements_chimiques where elId=?";
    @Override
    public void insert(ElementChimique data) throws DALexception {

    }

    @Override
    public void delete(ElementChimique data) throws DALexception {
        PreparedStatement pstmt = null;
        Connection cnx=JdbcTools.getConnection();
        long id = data.getId();
        try {
            pstmt = cnx.prepareStatement(sql_DELETE);
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DALexception("erreur du delete_id"+id,e.getCause());
        }
        finally {
            try {
                if (pstmt!=null) pstmt.close();
                cnx.close();
            } catch (SQLException e) {
                throw new DALexception("erreur du delete_id"+id,e.getCause());
            }
        }
    }

    @Override
    public void upddate(ElementChimique data) throws DALexception {
        PreparedStatement pstmt = null;
        Connection cnx=JdbcTools.getConnection();
        long id = data.getId();
        try {
            pstmt = cnx.prepareStatement(sql_Update);
            pstmt.setString(1,data.getNom());
            pstmt.setString(2,data.getSymbole());
            pstmt.setInt(3,data.getNumAtomique());
            pstmt.setFloat(4,data.getMasseAtomique());
            pstmt.setLong(5,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DALexception("erreur du update_id"+data,e.getCause());
        }
        finally {
            try {
                if (pstmt!=null) pstmt.close();
                cnx.close();
            } catch (SQLException e) {
                throw new DALexception("erreur du close update_id"+data,e.getCause());
            }
        }
    }

    @Override
    public ElementChimique selectById(Long id) throws DALexception {
        PreparedStatement pstmt = null;
        Connection cnx=JdbcTools.getConnection();
        ResultSet rs = null;
        ElementChimique el = null;
        try {
            pstmt = cnx.prepareStatement(sql_SELECT_BY_ID);
            pstmt.setLong(1,id);
           rs= pstmt.executeQuery();
           if (rs.next())el = new ElementChimique(rs.getLong(1),rs.getString(1),rs.getString(1),rs.getInt(1),rs.getLong(1));
        } catch (SQLException e) {
            throw new DALexception("erreur du update_id"+id,e.getCause());
        }
        finally {
            try {
                if (pstmt!=null) pstmt.close();
                cnx.close();
            } catch (SQLException e) {
                throw new DALexception("erreur du select by id "+id,e.getCause());
            }
        }
        return el;
    }

    @Override
    public List<ElementChimique> selectAll() throws DALexception {
        Statement stmt = null;
        ResultSet rs = null ;
        List<ElementChimique> lesElements = new ArrayList<>();
        ElementChimique el = null;
        Connection cnx = JdbcTools.getConnection();
        try {
            stmt = cnx.createStatement();
            rs = stmt.executeQuery(sql_SELECT_ALL);
            while (rs.next()) {
                el = new ElementChimique(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getFloat(5)
                );
                lesElements.add(el);
            }
        } catch (SQLException e) {
            throw new DALexception("erreur du select all" + e.getCause());
        }
        finally {
            try {
                if(stmt!=null) {
                    stmt.close();
                }
                if(cnx!=null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                throw new DALexception("erreur du select all au niveau du close" + e.getCause());
            }
        }
        return lesElements;
    }
}
