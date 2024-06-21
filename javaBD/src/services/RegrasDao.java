package services;

import model.Contato;

import java.sql.SQLException;
import java.util.List;

public interface RegrasDao<T> {

    void adiciona(T t) throws SQLException;
    List<T> getLista() throws SQLException;
    List<T> getListaById(int id) throws SQLException;
    List<T> getListaByInicial (char inicial) throws SQLException;
    void updateById(int id, T t) throws SQLException;
    void deleteById(int id, T t) throws SQLException;
}
