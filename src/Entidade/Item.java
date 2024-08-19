package Entidade;

public abstract class Item {
    protected String nome;
    protected String id;
    protected float preco;
    protected int quantidade; // Adicionando um atributo para quantidade

    public Item(String nome, String id, float preco, int quantidade) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade; // Inicializa a quantidade
    }

    // Métodos Get e Set
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

    public int getQuantidade() {
        return quantidade; // Método para obter a quantidade
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade; // Método para definir a quantidade
    }
    @Override
    public String toString() {
        return nome + " - R$ " + preco; // Exibe o nome e o preço
    }
}