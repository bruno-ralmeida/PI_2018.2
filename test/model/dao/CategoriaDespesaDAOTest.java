/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.CategoriaDespesa;
import model.dao.CategoriaDespesaDAO;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Bruno Rocha
 */
public class CategoriaDespesaDAOTest {
    
    public CategoriaDespesaDAOTest() {
    }
    
      /**
     *
     */
    @Test
    @Ignore
   
    public void insert() {
        
        CategoriaDespesa catDesp = new CategoriaDespesa("Teste 2");
        
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        
        if (dao.insert(catDesp)) {
            System.out.println("Salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }
    @Test
    @Ignore
    public void update() {
        
        CategoriaDespesa catDesp = new CategoriaDespesa("Teste 3");
        catDesp.setId(9);
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        
        if (dao.update(catDesp)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            System.out.println("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        CategoriaDespesa catDesp = new CategoriaDespesa();
        catDesp.setId(9);
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        
        if (dao.delete(catDesp)) {
            System.out.println("Registro Excluido!");
        } else {
            System.out.println("Erro ao excluir!");
        }
    }
    @Test
    @Ignore
    public void select() {
        CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
        
        for (CategoriaDespesa d: dao.select()){
            System.out.println("ID: "+d.getId()+" Nome: "  + d.getNome());
        }
    }
    
}