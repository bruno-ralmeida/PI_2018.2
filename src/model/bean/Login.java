package model.bean;

/**
 *
 * @author Bruno Rocha
 */
public class Login {

    private String senha;
    private int idFuncionario;
    private boolean acesso;

    public Login(String senha, Funcionario funcionario) {
        this.senha = senha;
        this.idFuncionario = funcionario.getId();

    }

    public void cadastrar(String senha, int idFuncionario) {
        this.senha = senha;
        this.idFuncionario = idFuncionario;
    }

    public boolean validar(String senha, int idFuncionario) {
        if (this.senha.equals(senha) && this.idFuncionario == idFuncionario) {
            return this.acesso = true;
        } else {
            return this.acesso = false;
        }
    }

}
