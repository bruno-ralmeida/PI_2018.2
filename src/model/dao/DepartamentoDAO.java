package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Departamento;

/**
 * CRUD
 *
 * @author Bruno Rocha
 */
public class DepartamentoDAO {

    private Connection con = null;

    public DepartamentoDAO() {
        con = ConnectionFactory.getConnection();

    }
    //TABELA DEPARTAMENTO

    //INSERIR DADOS 
    public boolean insert(Departamento departamento) {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, departamento.getNome());
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
    public List<Departamento> select() {
        String sql = "SELECT * FROM departamento ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Departamento> departamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Departamento departamento = new Departamento();

                departamento.setId(rs.getInt(1));
                departamento.setNome(rs.getString("nome"));
                departamentos.add(departamento);

            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return departamentos;
    }
    //Atualizar

    public boolean update(Departamento departamento) {
        String sql = "UPDATE departamento SET nome = ? WHERE idDepartamento = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, departamento.getNome());
            stmt.setInt(2, departamento.getId());
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
    public boolean delete(Departamento departamento) {
        String sql = "DELETE FROM departamento WHERE idDepartamento = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, departamento.getId());
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
