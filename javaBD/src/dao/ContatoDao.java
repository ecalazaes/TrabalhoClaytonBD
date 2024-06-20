package dao;

import javabanco.ConnectionFactory;
import model.Contato;
import services.RegrasDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao implements RegrasDao<Contato> {
    private Connection con;

    public ContatoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    @Override
    public void adiciona(Contato contato) throws SQLException {
        String sql = "Insert into contatos (nome, email, endereco) values (?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        stmt.execute();

        stmt.close();
        con.close();
    }

    @Override
    public List<Contato> getLista() throws SQLException {
        String query = "select * from contatos";
        PreparedStatement stmt = con.prepareStatement(query);

        ResultSet rset = stmt.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        while (rset.next()) {
            Contato contato = new Contato();
            contato.setNome(rset.getString("nome"));
            contato.setEmail(rset.getString("email"));
            contato.setEndereco(rset.getString("endereco"));
            contatos.add(contato);
        }

        rset.close();
        stmt.close();
        con.close();

        return contatos;
    }

    @Override
    public List<Contato> getListaById(int id) throws SQLException {
        String query = "select * from contatos where id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);

        ResultSet rset = stmt.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        if (rset.next()) {
            Contato contato = new Contato();
            contato.setNome(rset.getString("nome"));
            contato.setEmail(rset.getString("email"));
            contato.setEndereco(rset.getString("endereco"));
            contatos.add(contato);
        }

        rset.close();
        stmt.close();
        con.close();

        return contatos;
    }

    @Override
    public List<Contato> getListaByInicial(String inicial) throws SQLException {
        String query = "select * from contatos where nome like ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, inicial + "%");

        ResultSet rset = stmt.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        while (rset.next()) {
            Contato contato = new Contato();
            contato.setNome(rset.getString("nome"));
            contato.setEmail(rset.getString("email"));
            contato.setEndereco(rset.getString("endereco"));
            contatos.add(contato);
        }

        rset.close();
        stmt.close();
        con.close();

        return contatos;
    }

    @Override
    public void updateById(int id, Contato contato) throws SQLException {
        String query = "select * from contatos where id = ?";
        PreparedStatement stmtSelect = con.prepareStatement(query);
        stmtSelect.setInt(1, id);

        ResultSet rset = stmtSelect.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ? WHERE id = ?";

        PreparedStatement stmtUpdate = con.prepareStatement(sql);
        stmtUpdate.setString(1, contato.getNome());
        stmtUpdate.setString(2, contato.getEmail());
        stmtUpdate.setString(3, contato.getEndereco());
        stmtUpdate.setInt(4, id);

        stmtUpdate.executeUpdate();


        stmtUpdate.close();
        rset.close();
        stmtSelect.close();
        con.close();
    }

    @Override
    public void deleteById(int id, Contato contato) throws SQLException {
        String query = "select * from contatos where id = ?";
        PreparedStatement stmtSelect = con.prepareStatement(query);
        stmtSelect.setInt(1, id);

        ResultSet rset = stmtSelect.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        String sql = "delete from contatos where id = ?";

        PreparedStatement stmtDelete = con.prepareStatement(sql);
        stmtDelete.setInt(1, id);

        stmtDelete.executeUpdate();


        stmtDelete.close();
        rset.close();
        stmtSelect.close();
        con.close();
    }
}
