/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Departamento;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Bruno Rocha
 */
public class DepartamentoDAOTest {
    
    public DepartamentoDAOTest() {
    }

    /**
     *
     */
    @Test
    @Ignore
    public void insert() {
        
        Departamento dep = new Departamento("TesteDados");
        DepartamentoDAO dao = new DepartamentoDAO();
        
        if (dao.insert(dep)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }
    @Test
    @Ignore
    public void update() {
        
        Departamento dep = new Departamento("Diretoria");
        dep.setId(10);
        DepartamentoDAO dao = new DepartamentoDAO();
        
        if (dao.update(dep)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Departamento dep = new Departamento();
        dep.setId(12);
        DepartamentoDAO dao = new DepartamentoDAO();
        
        if (dao.delete(dep)) {
            System.out.println("Registro Excluido!");
        } else {
            System.out.println("Erro ao excluir!");
        }
    }
    @Test
    
    public void select() {
        DepartamentoDAO dao = new DepartamentoDAO();
        
        for (Departamento d: dao.select()){
            System.out.println("ID: "+d.getId()+" Nome: "  + d.getNome());
        }
    }
    
}
