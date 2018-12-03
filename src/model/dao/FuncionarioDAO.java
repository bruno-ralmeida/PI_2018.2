package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Funcionario;

/**
 *
 * @author Bruno Rocha
 */
public class FuncionarioDAO {

    private Connection con = null;

    public FuncionarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    //TABELA FUNCIONARIO
    //INSERIR DADOS 
    public boolean insert(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (idChefe,idDepartamento,nome,limite,cartao) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdChefe());
            stmt.setInt(2, funcionario.getDepartamento().getId());
            stmt.setString(3, funcionario.getNome());
            stmt.setFloat(4, funcionario.getLimite());
            stmt.setInt(5, funcionario.getCartao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean insertNoCard(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (idChefe,idDepartamento,nome,limite) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdChefe());
            stmt.setInt(2, funcionario.getDepartamento().getId());
            stmt.setString(3, funcionario.getNome());
            stmt.setFloat(4, funcionario.getLimite());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean insertBoss(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (idDepartamento,nome,limite,cartao) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getDepartamento().getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setFloat(3, funcionario.getLimite());
            stmt.setInt(4, funcionario.getCartao());
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
    public List<Funcionario> select() {
        String sql = "SELECT * FROM funcionario ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt(1));
                funcionario.setNome(rs.getString("nome"));
                funcionarios.add(funcionario);

            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }
    //Atualizar

    public boolean update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ? WHERE idFuncionario = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getId());
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
    public boolean delete(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
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
