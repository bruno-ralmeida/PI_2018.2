package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Contas;

/**
 *
 * @author Bruno Rocha
 */
public class ContasDAO {

    private Connection con = null;

    public ContasDAO() {
        con = ConnectionFactory.getConnection();

    }
    //TABELA CONTAS

    //INSERIR DADOS 
    public boolean insert(Contas contas) {
        String sql = "INSERT INTO contas (data,valor,descricao,mes_ref,cartao_credito,adiantamento,fk_funcionario,fk_catDesp) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, contas.getData());
            stmt.setFloat(2, contas.getValor());
            stmt.setString(3, contas.getDescricao());
            stmt.setDate(4, contas.getMesRef());
            stmt.setInt(5, contas.getFuncionario().getCartao());
            stmt.setFloat(6, contas.getAdiantamento());
            stmt.setInt(7, contas.getFuncionario().getId());
            stmt.setString(8, contas.getCatDespesa().getNome());

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
    public List<Contas> select() {
        String sql = "SELECT * FROM contas ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Contas> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contas conta = new Contas();

                conta.setIdContas(rs.getInt(1));
                conta.setDescricao(rs.getString("Descrição"));
                contas.add(conta);

            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return contas;
    }
    //Atualizar

    public boolean update(Contas conta) {
        String sql = "UPDATE contas SET descricao = ? WHERE idContas = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, conta.getDescricao());
            stmt.setInt(2, conta.getIdContas());
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
    public boolean delete(Contas conta) {
        String sql = "DELETE FROM contas WHERE idContas = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, conta.getIdContas());
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
