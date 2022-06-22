package BO.Tp.eu.unareil.DAL;

import BO.Tp.eu.unareil.bo.Produits.ProduitDAO;

import java.util.List;

public interface DAO<T> {
    public void insert(T data) throws DALexception;

    public void delete(T data) throws DALexception;

    public void update(T data) throws DALexception;

    public T selectById(long id) throws DALexception;

    public List<T> selectAll() throws DALexception;
}
