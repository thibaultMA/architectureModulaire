package BO.Tp.eu.unareil.DAL;



import BO.Tp.eu.unareil.bo.Produits.Perissable.Glace;
import BO.Tp.eu.unareil.bo.Produits.Perissable.Pain;
import BO.Tp.eu.unareil.bo.Produits.Produit;
import BO.Tp.eu.unareil.bo.Produits.ProduitDAO;
import BO.Tp.eu.unareil.bo.Produits.ProduitPerissable;
import BO.Tp.eu.unareil.bo.Produits.TypeProduit;
import BO.Tp.eu.unareil.bo.Produits.nonPerissable.Auteur;
import BO.Tp.eu.unareil.bo.Produits.nonPerissable.CartePostale;
import BO.Tp.eu.unareil.bo.Produits.nonPerissable.Stylo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class produitsJdcb implements DAO<Produit> {

//1 ref /2 marque /3 libelle /4 qteStock /5 prix /6 DateLimite /7 Poid /8 parfum /9 temperature /10 couleur /11 typeMine/ 12 typeCartePostal ////13 idAuteur /14 typeProduit
    private static final String SQL_INSERT="insert into tpProduits (refProd,marque,libelle,qteStock,prix,DateLimite,Poid,parfum,temperature,couleur,typeMine,typeCartePostal,idAuteur,typeProduits) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,) ";

    private static final String SQL_UPDATE="update tpProduits set refProd=?,marque=?,libelle=?,qteStock=?,prix=?,DateLimite=?,Poid=?,parfum=?,temperature=?,couleur=?,typeMine=?,typeCartePostal=?,idAuteur=?,typeProduits=? where refProd=?";
    //finir ici =>
    private static final String SQL_DELETE="delete from tpProduits where refProd=?";
    private static final String SQL_SELECT_ALL="select * from tpProduits";
    private static final String SQL_SELECT_BY_ID="select * from tpProduits where refProd=?";
    private static final String SQL_SELECT_Auteur_BY_ID="select * from auteur where id=?";

    @Override
    public void insert(Produit data) throws DALexception {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        PreparedStatement pstmt=null;

        //Connection cnx=null;
        Connection cnx=JdbcTools.getConnection();
        try {
            pstmt=cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, data.getRefProd());
            pstmt.setString(2, data.getMarque());
            pstmt.setString(3, data.getLibelle());
            pstmt.setFloat(4, data.getQteStock());
            pstmt.setFloat(5, data.getPrixUnitaire());

            if (data instanceof ProduitPerissable){
                pstmt.setDate(6, Date.valueOf(((Pain) data).getDateLimiteConso()));
            }
            if (data instanceof Pain){
                pstmt.setInt(7, ((Pain) data).getPoid());
            pstmt.setString(14, "Pain");

            }
            if (data instanceof Glace) {
                pstmt.setString(8, ((Glace) data).getParfum());
                pstmt.setFloat(9, ((Glace)data).getTemperatureConservation());
            pstmt.setString(14, "Glace");
            }
            if (data instanceof Stylo) {
            pstmt.setString(10, ((Stylo) data).getCouleur());
            pstmt.setString(11, ((Stylo) data).getTypeMine());
            pstmt.setString(14, "Stylo");
            }
            if (data instanceof CartePostale) {
                pstmt.setString(12, ((CartePostale) data).getType());
                StringBuilder auteurList = new StringBuilder();
                for (Auteur auteur : ((CartePostale) data).getLesAuteurs()) {
                    auteurList.append(auteur.getId()).append(',');
                }
            pstmt.setString(13, auteurList.toString());
            pstmt.setString(14,"CartePostale");

            }



            int nbRow=pstmt.executeUpdate();
            if (nbRow==1)
            {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    data.setRefProd(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DALexception("erreur du insert - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DALexception("erreur du insert au niveau du close- data="+data,e.getCause());
            }
        }

    }

    @Override
    public void delete(Produit data) throws DALexception {
        // TODO Auto-generated method stub
        PreparedStatement pstmt=null;
        //Connection cnx=null;
        long id=data.getRefProd();
        Connection cnx=JdbcTools.getConnection();
        try {
            pstmt=cnx.prepareStatement(SQL_DELETE);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DALexception("erreur du delete - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DALexception("erreur du delete au niveau du close- data="+data,e.getCause());
            }
        }
    }


    @Override
    public void update(Produit data) throws DALexception {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        PreparedStatement pstmt=null;
        //Connection cnx=null;
        long id=data.getRefProd();
        Connection cnx=JdbcTools.getConnection();
        try {
            //private static final String SQL_UPDATE="update elements_chimiques set elNom=?,elSymbole=?,elNumAtomique=?,elMasseAtomique=? where elId=?";
            pstmt=cnx.prepareStatement(SQL_UPDATE);
            pstmt.setLong(1, data.getRefProd());
            pstmt.setString(2, data.getMarque());
            pstmt.setString(3, data.getLibelle());
            pstmt.setLong(4, data.getQteStock());
            pstmt.setFloat(5, data.getPrixUnitaire());
            pstmt.setLong(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DALexception("erreur du update - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DALexception("erreur du update au niveau du close- data="+data,e.getCause());
            }
        }
    }

    @Override
    public Produit selectById(long id) throws DALexception {
        // TODO Auto-generated method stub
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        Produit el = null;
        //Connection cnx=null;
        Connection cnx=JdbcTools.getConnection();
        try {
            pstmt=cnx.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setLong(1, id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                String typeProd = rs.getString(14);
                if (typeProd.equals(TypeProduit.STYLO.toString())) {
                    el = new Stylo(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            rs.getString(6 ),
                            rs.getString(7)
                    );
                }
                if (typeProd.equals(TypeProduit.CARTEPOSTAl.toString())) {

                    Connection cnxAuteur = JdbcTools.getConnection();
                    PreparedStatement stmtAuteur=cnxAuteur.prepareStatement(SQL_SELECT_Auteur_BY_ID);
                    String idAuteurs = rs.getString(13 );
                    List<String> listIdAuteur = List.of(idAuteurs.split(","));
                    List<Auteur> Auteurs = new ArrayList<>();
                    for (String idAuteur : listIdAuteur) {
                        stmtAuteur.setString(1, idAuteur);
                        ResultSet rsAuteur = stmtAuteur.executeQuery();
                        Auteurs.add(new Auteur(rsAuteur.getString(2 ),rsAuteur.getString(3)));
                    }
                    el = new CartePostale(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            Auteurs,
                            rs.getString(12)
                    );
                }
                if (typeProd.equals(TypeProduit.GLACE.toString())) {
                    el = new Glace(
                            rs.getLong(1),
                            rs.getDate(6).toLocalDate(),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            rs.getString(8 ),
                            rs.getInt(9)
                    );
                }
                if (typeProd.equals(TypeProduit.PAIN.toString())) {
                    el = new Pain(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(7),
                            rs.getLong(4),
                            rs.getFloat(5 )

                    );
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DALexception("erreur du select by id - id="+id,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DALexception("erreur du select by id au niveau du close- id="+id,e.getCause());
            }
        }
        return el;
    }

    @Override
    public List<Produit> selectAll() throws DALexception {
        // TODO Auto-generated method stub
        Statement stmt=null;
        ResultSet rs=null;
        List<Produit> lesElements= new ArrayList<>();
        Produit el=null;
        //Connection cnx=null;
        Connection cnx=JdbcTools.getConnection();
        try {
            stmt=cnx.createStatement();
            rs=stmt.executeQuery(SQL_SELECT_ALL);
            while(rs.next())
            {
                String typeProd = rs.getString(14);
                if (typeProd.equals(TypeProduit.STYLO.toString())) {
                    el = new Stylo(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            rs.getString(6 ),
                            rs.getString(7)
                    );
                }
                if (typeProd.equals(TypeProduit.CARTEPOSTAl.toString())) {

                    Connection cnxAuteur = JdbcTools.getConnection();
                    PreparedStatement stmtAuteur=cnxAuteur.prepareStatement(SQL_SELECT_Auteur_BY_ID);
                    String idAuteurs = rs.getString(13 );
                    List<String> listIdAuteur = List.of(idAuteurs.split(","));
                    List<Auteur> Auteurs = new ArrayList<>();
                    for (String idAuteur : listIdAuteur) {
                        stmtAuteur.setString(1, idAuteur);
                        ResultSet rsAuteur = stmtAuteur.executeQuery();
                        Auteurs.add(new Auteur(rsAuteur.getString(2 ),rsAuteur.getString(3)));
                    }
                    el = new CartePostale(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            Auteurs,
                            rs.getString(12)
                    );
                }
                if (typeProd.equals(TypeProduit.GLACE.toString())) {
                    el = new Glace(
                            rs.getLong(1),
                            rs.getDate(6).toLocalDate(),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getLong(4),
                            rs.getFloat(5),
                            rs.getString(8 ),
                            rs.getInt(9)
                    );
                }
                if (typeProd.equals(TypeProduit.PAIN.toString())) {
                    el = new Pain(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(7),
                            rs.getLong(4),
                            rs.getFloat(5 )

                    );
                }
                lesElements.add(el);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DALexception("erreur du select all",e.getCause());
        }
        finally
        {
            try {
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DALexception("erreur du select all au niveau du close- ",e.getCause());
            }
        }
        return lesElements;
    }

}
