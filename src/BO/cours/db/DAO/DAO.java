package BO.cours.db.DAO;

import java.util.List;

public interface DAO<T> {
    public void insert(T data) throws DALexception;
    public void delete(T data) throws DALexception;
    public void upddate(T data) throws DALexception;
    public T selectById(Long id) throws DALexception;



    public List<T> selectAll()throws DALexception;
}
