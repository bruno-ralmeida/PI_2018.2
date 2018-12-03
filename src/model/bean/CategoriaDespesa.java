package model.bean;

/**
 *
 * @author Bruno Rocha
 */
public class CategoriaDespesa {

    private int id;
    private String nome;

    public CategoriaDespesa() {
    }

    public CategoriaDespesa(String nome) {
        this.nome = nome;
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

}
