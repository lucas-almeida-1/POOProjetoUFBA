package Start;

import Entidade.Perfil;
import Entidade.Produtos.Compra.Carrinho;
import Entidade.Produtos.Jogos;
import Entidade.Produtos.ProdutosFisicos;
import Entidade.Produtos.Skin;
import Entidade.Produtos.Software;
import Entidade.Usuario;
import Entidade.Conquistas;
import Entidade.Item;
import Screens.Screen;
import Entidade.Produtos.Compra.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Usuario user1 = new Usuario("user1", "user1", "user1@gmail.com");
        Usuario user2 = new Usuario("user2", "user2", "user2@gmail.com");
        Usuario user3 = new Usuario("user3", "user3", "user3@gmail.com");
        Usuario user4 = new Usuario("user4", "user4", "user4@gmail.com");

        Jogos EldenRing = new Jogos("Elden Ring", "0000",150, 48,true);
        Jogos TheLastOfUsI = new Jogos("TheLastOfUsI", "0001",100, 60,true);
        Jogos HollowKnight = new Jogos("HollowKnight", "0002",30, 120,true);
        Software AppEngine = new Software("AppEngine", "0003", 50,210);
        Skin FuzilAzul = new Skin("FuzilAzul", "0004", 200,TheLastOfUsI,"skin azulada de um tal fuzil no jogo");
        ProdutosFisicos estatuaJoel = new ProdutosFisicos("EstatuaJoel", "0005", 529, "estatua em 1:10 do personagem Joel");

        Conquistas conq1 = new Conquistas("PrimeiraMorte","Conquista ao morrer a primeira vez no jogo",
                EldenRing);
        Conquistas conq2 = new Conquistas("SalveElie","Conquista ao salvar a Elie da morte a primeira vez",
                TheLastOfUsI);
        Conquistas conq3 = new Conquistas("PrimeiroBoss","Conquista ao derrotar o seu primeiro boss no jogo",
                HollowKnight);

        ArrayList<Usuario> amigos = new ArrayList<>();
        amigos.add(user1);
        amigos.add(user2);
        amigos.add(user3);
        amigos.add(user4);

        ArrayList<Conquistas> conquistas = new ArrayList<>();
        conquistas.add(conq1);
        conquistas.add(conq2);
        conquistas.add(conq3);

        ArrayList<Item> listaDesejos = new ArrayList<>();
        listaDesejos.add(EldenRing);
        listaDesejos.add(TheLastOfUsI);
        listaDesejos.add(HollowKnight);
        listaDesejos.add(AppEngine);
        listaDesejos.add(FuzilAzul);
        listaDesejos.add(estatuaJoel);

        Perfil perfil = new Perfil("rafael", "rafael123", "rafael123@gmail.com", "Treezi"
        , amigos, conquistas, listaDesejos);

        System.out.println("Bem-vindo a nossa Steam Verde");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Você já esta logado, vejamos as suas opções:");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Digite 'a' para mostrar o seu apelido");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'b' para mostrar o seu email");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'c' para mostrar o seu username");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'd' para mostrar os seus amigos");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'e' para mostrar as suas conquistas");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'f' para mostrar a sua lista de desejos");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Caso queira sair digite qualquer outra coisa");

        Scanner leitor = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "a" ->
                        System.out.println("Seu apelido è " + perfil.getApelido());
                case "b" ->
                        System.out.println("Seu email è " + perfil.getEmail());
                case "c" ->
                        System.out.println("Seu username è " + perfil.getUsername());
                case "d" -> {
                    System.out.println("A sua lista de amigos é a seguinte: ");
                    for (Usuario amigo : perfil.getAmigos()) {
                        System.out.println(amigo.getUsername());
                    }
                }
                case "e" -> {
                    System.out.println("A sua lista de conquistas é a seguinte: ");
                    for (Conquistas conquista : perfil.getConquistas()) {
                        System.out.println(conquista.getNomeConquista());
                    }
                }
                case "f" -> {
                    System.out.println("A sua lista de desejos é a seguinte: ");
                    for (Item item : perfil.getListaDeDesejos()) {
                        System.out.println(item.getNome());
                    }
                }
                default -> {
                    System.out.println("Saindo do programa");
                    loop = false;
                }
            }
        }
        // criar carrinho
        Carrinho carrinho = new Carrinho();
        new Screen();

    }
}
