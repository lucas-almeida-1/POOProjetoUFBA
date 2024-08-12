package Entidade;

public abstract class Item {
    //Atributos
    protected String nome;
    protected String id;
    protected float preco;

    //Construtor
    public Item(String nome, String id, float preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    //Método Get e Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}