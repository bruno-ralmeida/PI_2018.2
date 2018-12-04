package login;

import model.bean.Funcionario;

/**
 *
 * @author Bruno Rocha
 */
public class User {

    private String senha;
    private Funcionario funcionario;
  

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}