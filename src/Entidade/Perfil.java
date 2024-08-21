package Entidade;

import java.util.ArrayList;

public class Perfil extends Usuario{
    //Atributos
    private String apelido;
    private ArrayList<Usuario> amigos;
    private ArrayList<Conquistas> conquistas;
    private ArrayList<Item> listaDeDesejos;

    //Construtor
    public Perfil(String username, String senha, String email, String apelido, ArrayList<Usuario> amigos,
                  ArrayList<Conquistas> conquistas, ArrayList<Item> listaDeDesejos) {
        super(username, senha, email);
        this.apelido = apelido;
        this.amigos = amigos;
        this.conquistas = conquistas;
        this.listaDeDesejos = listaDeDesejos;
    }

    //Métodos Get e Set
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Conquistas> getConquistas() {
        return conquistas;
    }

    public void setConquistas(ArrayList<Conquistas> conquistas) {
        this.conquistas = conquistas;
    }

    public ArrayList<Item> getListaDeDesejos() {
        return listaDeDesejos;
    }

    public void setListaDeDesejos(ArrayList<Item> listaDeDesejos) {
        this.listaDeDesejos = listaDeDesejos;
    }
}