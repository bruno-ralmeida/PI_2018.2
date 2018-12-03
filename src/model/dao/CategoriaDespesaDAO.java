package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.CategoriaDespesa;

/**
 *
 * @author Bruno Rocha
 */
public class CategoriaDespesaDAO {

    private Connection con = null;

    public CategoriaDespesaDAO() {
        con = ConnectionFactory.getConnection();
    }

    //TABELA CATEGORIA DESPESA
    //INSERIR DADOS 
    public boolean insert(CategoriaDespesa catDesp) {
        String sql = "INSERT INTO catdespesa (nome) VALUES (?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, catDesp.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //BUSCAR DADOS 
    public List<CategoriaDespesa> select() {
        String sql = "SELECT * FROM catdespesa ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CategoriaDespesa> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CategoriaDespesa catDesp = new CategoriaDespesa();

                catDesp.setId(rs.getInt(1));
                catDesp.setNome(rs.getString("nome"));
                categorias.add(catDesp);

            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return categorias;
    }
    //Atualizar

    public boolean update(CategoriaDespesa catDesp) {
        String sql = "UPDATE catdespesa SET nome = ? WHERE idCatDespesa = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, catDesp.getNome());
            stmt.setInt(2, catDesp.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Apagar
    public boolean delete(CategoriaDespesa catDesp) {
        String sql = "DELETE FROM catdespesa WHERE idCatDespesa = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, catDesp.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
