package Entidade;

public class Perfil extends Usuario{
    private String apelido;
    private Usuario[] amigos;
    private Conquistas[] conquistas;
    private Item[] ListaDeDesejos;

    public Perfil(String usernome, String senha, String email, String apelido, Usuario[] amigos, Conquistas[] conquistas, Item[] listaDeDesejos) {
        super(usernome, senha, email);
        this.apelido = apelido;
        this.amigos = amigos;
        this.conquistas = conquistas;
        ListaDeDesejos = listaDeDesejos;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Usuario[] getAmigos() {
        return amigos;
    }

    public void setAmigos(Usuario[] amigos) {
        this.amigos = amigos;
    }

    public Conquistas[] getConquistas() {
        return conquistas;
    }

    public void setConquistas(Conquistas[] conquistas) {
        this.conquistas = conquistas;
    }

    public Item[] getListaDeDesejos() {
        return ListaDeDesejos;
    }

    public void setListaDeDesejos(Item[] listaDeDesejos) {
        ListaDeDesejos = listaDeDesejos;
    }
}
