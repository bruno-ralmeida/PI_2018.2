/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import model.bean.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Bruno Rocha
 */
public class UserDAOTest {

    public UserDAOTest() {
    }

    @Test
   

    public void insert() {
        Funcionario func = new Funcionario();
        func.setId(1);

        User login = new User();
        login.setSenha("senha123");
        login.setFuncionario(func);

        UserDAO dao = new UserDAO();

        if (dao.insert(login)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void delete() {
        Funcionario func = new Funcionario();
        func.setId(1);
        User login = new User();
        login.setFuncionario(func);
        UserDAO dao = new UserDAO();
        if (dao.delete(login)) {
            System.out.println("Registro Excluido!");
        } else {
            System.out.println("Erro ao excluir!");
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Funcionario func = new Funcionario();
        func.setId(1);
        
        User login = new User();
        login.setSenha("novaSenha");
        login.setFuncionario(func);
        UserDAO dao = new UserDAO();
        
        if (dao.update(login)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }
}
