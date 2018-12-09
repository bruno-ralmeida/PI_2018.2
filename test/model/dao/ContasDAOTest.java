/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.CategoriaDespesa;
import model.bean.Contas;
import model.bean.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Bruno Rocha
 */
public class ContasDAOTest {

    public ContasDAOTest() {
    }

    @Test
    public void testSomeMethod() {
    }

    @Test
    @Ignore
    public void insert() {
        Funcionario func = new Funcionario();
        func.setId(1);
        CategoriaDespesa catDesp = new CategoriaDespesa();
        catDesp.setId(1);
        Contas contas = new Contas();
        ContasDAO dao = new ContasDAO();
        contas.setData("06-12-2018");
        contas.setValor(100);
        contas.setDescricao("Teste");
        contas.setMesRef("DEZ");
        contas.setFuncionario(func);
        contas.setAdiantamento(0);
        contas.setFuncionario(func);
        contas.setCatDespesa(catDesp);
        
        if (dao.insert(contas)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void update() {

        Contas conta = new Contas();
        conta.setIdContas(1);
        ContasDAO dao = new ContasDAO();

        if (dao.update(conta)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void delete() {

        Contas dep = new Contas();
        dep.setIdContas(1);
        ContasDAO dao = new ContasDAO();

        if (dao.delete(dep)) {
            System.out.println("Registro Excluido!");
        } else {
            System.out.println("Erro ao excluir!");
        }
    }

    @Test
    @Ignore
    public void select() {
        ContasDAO dao = new ContasDAO();

        for (Contas d : dao.select()) {
            System.out.println("ID: " + d.getIdContas()+ " Nome: " + d.getDescricao());
        }
    }
    
    @Test
    public void selectFuncDep() {
        ContasDAO dao = new ContasDAO();

        for (Contas d : dao.selectContasFuncionario()) {
            System.out.println("ID: " + d.getIdContas()+ "\nNome: " + d.getFuncionario().getNome()
                    + "\nNome Departamento: " + d.getFuncionario().getDepartamento().getNome() + 
                    "\nValor: " + d.getValor());
        }
    }

}
