package login;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bruno Rocha
 */
public class UserDAO {

    private Connection con = null;

    public UserDAO() {
        con = ConnectionFactory.getConnection();
    }

    //TABELA LOGIN
    //INSERIR DADOS 
    public boolean insert(User login) {
        String sql = "INSERT INTO login (senha, fk_idFuncionarios) VALUES (?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login.getSenha());
            stmt.setInt(2, login.getFuncionario().getId());
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
    public boolean checkLogin(int idFuncionario, String senha) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM login WHERE fk_idFuncionarios = ? and senha = ?");
            stmt.setInt(1, idFuncionario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;

            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }
    //Atualizar

    public boolean update(User user) {
        String sql = "UPDATE login SET senha = ? WHERE fk_idFuncionarios = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getSenha());
            stmt.setInt(2, user.getFuncionario().getId());
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
    public boolean delete(User user) {
        String sql = "DELETE FROM login WHERE fk_idFuncionarios = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user.getFuncionario().getId());
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
