/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Departamento;
import model.bean.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Bruno Rocha
 */
public class FuncionarioDAOTest {

    public FuncionarioDAOTest() {
    }

    @Test
    @Ignore
    public void insert() {
        Departamento departamento = new Departamento();
        departamento.setId(3);

        Funcionario func = new Funcionario();
        func.setIdChefe(1);
        func.setDepartamento(departamento);
        func.setNome("Bruno Rocha");
        func.setLimite(2500);
        func.setCartao(9666);

        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.insert(func)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void insertNoCard() {
        Departamento departamento = new Departamento();
        departamento.setId(3);

        Funcionario func = new Funcionario();
        func.setIdChefe(1);
        func.setDepartamento(departamento);
        func.setNome("Teste Chefe");
        func.setLimite(2500);
        func.setCartao(6666);

        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.insert(func)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void insertBoss() {
        Departamento departamento = new Departamento();
        departamento.setId(3);

        Funcionario func = new Funcionario();

        func.setDepartamento(departamento);
        func.setNome("Teste sem Cartao");
        func.setLimite(2500);

        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.insert(func)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void update() {

        Funcionario func = new Funcionario();
        func.setId(61);
        func.setNome("Bruno Almeida");
        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.update(func)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void delete() {
        Funcionario func = new Funcionario();
        func.setId(59);
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.delete(func)) {
            System.out.println("Registro Excluido!");
        } else {
            System.out.println("Erro ao excluir!");
        }
    }


    @Test   
    public void select() {
        FuncionarioDAO dao = new FuncionarioDAO();
        DepartamentoDAO depDAO = new DepartamentoDAO();
        for (Funcionario d : dao.select()) {
            
                System.out.println(" ID: " + d.getId() + "\n Id Chefe " + d.getIdChefe()+
                        "\n Departamento: " + d.getDepartamento().getNome()
                        + "\n Nome: " + d.getNome() + "\n Cartão: "
                        + d.getCartao() +"\n \n");

            
        }
    }
    
}
