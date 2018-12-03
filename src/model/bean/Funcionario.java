package model.bean;

/**
 *
 * @author Bruno Rocha
 */
public class Funcionario {

    private int id;
    private String nome;
    private int cartao;
    private float limite;
    private Departamento departamento;
    private int idChefe;

    public Funcionario() {
    }

    //METODO CONSTRUTOR FUNCIONARIO COM CARTAO
    public Funcionario(String nome, int cartao, float limite, Departamento departamento, int idChefe) {

        this.nome = nome;
        this.cartao = cartao;
        this.limite = limite;
        this.departamento = departamento;
        this.idChefe = idChefe;
    }

    //METODO CONSTRUTOR FUNCIONARIO SEM CARTÃO
    public Funcionario(String nome, float limite, Departamento departamento, int idChefe) {

        this.nome = nome;
        this.limite = limite;
        this.departamento = departamento;
        this.idChefe = idChefe;
    }

    //METODO CONSTRUTROR CHEFE
    public Funcionario(String nome, int cartao, float limite, Departamento departamento) {

        this.nome = nome;
        this.cartao = cartao;
        this.limite = limite;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getIdChefe() {
        return idChefe;
    }

    public void setIdChefe(int idChefe) {
        this.idChefe = idChefe;
    }

}
