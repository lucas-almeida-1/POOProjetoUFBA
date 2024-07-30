package Start;

import Entidade.Perfil;
import Entidade.Usuario;
import Entidade.Conquistas;
import Entidade.Item;

public class Start {
    public static void main(String[] args) {
        Perfil perfil = new Perfil("user", "senha", "email", "apelido", new Usuario[0], new Conquistas[0], new Item[0]);
        Usuario usuario = new Usuario("user", "senha", "email");
        System.out.println("Perfil: " + perfil.getUsername() + " " + perfil.getSenha() + " " + perfil.getEmail() + " " + perfil.getApelido());
        System.out.println("Usuario: " + usuario.getUsername() + " " + usuario.getSenha() + " " + usuario.getEmail());

    }
}
