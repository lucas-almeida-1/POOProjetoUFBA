package Entidade.Produtos;

public class Soundtrack extends Jogos {
    //Atributos
    protected boolean tocando;

    //Construtor
    public Soundtrack(String nome, String id, float preco, float tempoUso, boolean temConquista, boolean tocando) {
        super(nome, id, preco, tempoUso, temConquista);
        this.tocando = tocando;
    }

    //Métodos Gerais
    public void tocar(){
        setTocando(true);
    }

    public void pausar(){
        setTocando(false);
    }

    //Método Get e Set
    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
}
