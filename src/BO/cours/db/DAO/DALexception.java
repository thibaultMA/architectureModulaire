package BO.cours.db.DAO;

public class DALexception extends Exception{
    public DALexception() {
        super();
    }

    public DALexception(String message) {
        super("Erreur DAL" + message);
    }

    public DALexception(String message, Throwable cause) {
        super("Erreur DAL" + message, cause);
    }
}
