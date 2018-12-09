package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.CategoriaDespesa;
import model.bean.Contas;
import model.bean.Departamento;
import model.bean.Funcionario;

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
        String sql = "INSERT INTO contas (data,valor,descricao,mes_ref,cartao_credito,"
                + "adiantamento, condicao ,fk_funcionario,fk_catDesp) VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, converteData(contas.getData()));
            stmt.setFloat(2, contas.getValor());
            stmt.setString(3, contas.getDescricao());
            stmt.setString(4, contas.getMesRef());
            stmt.setInt(5, contas.getFuncionario().getCartao());
            stmt.setFloat(6, contas.getAdiantamento());
            stmt.setString(7, contas.getStatus());
            stmt.setInt(8, contas.getFuncionario().getId());
            stmt.setInt(9, contas.getCatDespesa().getId());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    private Date converteData(String data) {
        Date d = null;
        try {
            data = data.substring(6) + "-"
                    + data.substring(3, 5) + "-"
                    + data.substring(0, 2);
            d = Date.valueOf(data);
        } catch (Exception ex) {
        }
        return d;
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
    
    
    //Método para gerar relatório
    public List<Contas> selectContasFuncionario() {
        String sql = "SELECT * FROM contas conta \n"
                + "INNER JOIN funcionario func ON conta.fk_funcionario = func.idFuncionario\n"
                + "INNER JOIN departamento dep ON func.idDepartamento = dep.idDepartamento\n"
                + "INNER JOIN catdespesa cat ON conta.fk_catDesp = cat.idCatDespesa";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Contas> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contas conta = new Contas();
                Funcionario func = new Funcionario();
                Departamento dep = new Departamento();
                CategoriaDespesa catDesp = new CategoriaDespesa();

                catDesp.setId(rs.getInt("cat.idCatDespesa"));
                catDesp.setNome(rs.getString("cat.nome"));

                dep.setId(rs.getInt("dep.idDepartamento"));
                dep.setNome(rs.getString("dep.nome"));

                func.setId(rs.getInt("func.idFuncionario"));
                func.setIdChefe(rs.getInt("func.idChefe"));
                func.setDepartamento(dep);
                func.setNome(rs.getString("func.nome"));
                func.setLimite(rs.getFloat("func.limite"));
                func.setCartao(rs.getInt("func.cartao"));

                conta.setIdContas(rs.getInt("conta.idContas"));
                conta.setData(rs.getDate("conta.data").toString());
                conta.setValor(rs.getFloat("conta.valor"));
                conta.setDescricao(rs.getString("conta.descricao"));
                conta.setMesRef(rs.getString("conta.mes_ref"));
                conta.setAdiantamento(rs.getFloat("conta.adiantamento"));
                conta.setStatus(rs.getString("conta.condicao"));
                conta.setFuncionario(func);
                conta.setCatDespesa(catDesp);

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
