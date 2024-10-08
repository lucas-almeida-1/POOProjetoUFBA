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
import Entidade.Produtos.Compra.Pedido;
import Screens.Screen;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Usuario user1 = new Usuario("user1", "user1", "user1@gmail.com");
        Usuario user2 = new Usuario("user2", "user2", "user2@gmail.com");
        Usuario user3 = new Usuario("user3", "user3", "user3@gmail.com");
        Usuario user4 = new Usuario("user4", "user4", "user4@gmail.com");
        //Criar Carrinho

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

        System.out.println("Steam Verde: Entretenimento Sustentável com Triciclo Eco\n" +
                "A Steam Verde é uma iniciativa inovadora que visa oferecer uma alternativa sustentável para os gamers, permitindo que eles troquem materiais recicláveis por créditos que podem ser usados para comprar jogos. Essa proposta não apenas promove a sustentabilidade, mas também democratiza o acesso aos jogos, que muitas vezes são caros para a população brasileira.\n" +
                "Como Funciona\n" +
                "Postos de Coleta: Os usuários podem levar materiais recicláveis a postos de coleta parceiros, como os do site triciclo.eco.br. Esses postos aceitam uma variedade de materiais, incentivando a reciclagem e a conscientização ambiental.\n" +
                "Créditos em Tricoins: A cada 100 Tricoins, os usuários ganham R$ 0,15. Esses créditos podem ser acumulados e utilizados para adquirir jogos na plataforma Steam Verde.\n" +
                "Troca Sustentável: A ideia é simples: ao reciclar, os usuários não apenas ajudam o meio ambiente, mas também ganham recompensas que podem ser usadas para entretenimento. Isso cria um ciclo positivo, onde a sustentabilidade e o acesso à cultura se entrelaçam.\n" +
                "Lista de Tricoins por Item\n" +
                "Abaixo está um exemplo de como os materiais recicláveis podem ser convertidos em Tricoins:\n" +
                "Material Reciclável\tTricoins por Unidade\n" +
                "Lata de Alumínio\t10 Tricoins\n" +
                "Garrafa PET\t5 Tricoins\n" +
                "Papel (kg)\t3 Tricoins\n" +
                "Papelão (kg)\t4 Tricoins\n" +
                "Plástico (kg)\t2 Tricoins\n");
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
                case "g" -> {
                    System.out.println("Add lista de desejos ao carrinho ");
                    Carrinho carrinho = new Carrinho(user1, UUID.randomUUID(), new Item[10]);
                    for (Item item : perfil.getListaDeDesejos()) {
                        carrinho.addCarrinho(item);
                        System.out.println(item.getNome() + " adicionado ao carrinho");
                    }

                }
                default -> {
                    System.out.println("Saindo do programa");
                    loop = false;
                }
            }
            new Screen();
        }
        // Criar Carrinho
        Carrinho carrinho = new Carrinho(user1, UUID.randomUUID(), new Item[1]);

        // Adiciona
        //r itens ao carrinho
        carrinho.addCarrinho(EldenRing);
        carrinho.addCarrinho(TheLastOfUsI);
        carrinho.addCarrinho(HollowKnight);
        carrinho.addCarrinho(AppEngine);
        carrinho.addCarrinho(FuzilAzul);
        carrinho.addCarrinho(estatuaJoel);

        // Mostrar detalhes do carrinho

        carrinho.fazerPedido();
        if(carrinho.fazerPedido() != null){
            System.out.println("Pedido feito, realize pagamento");
        }
        Pedido pedido = null;
        pedido.finalizarCompra("token", "paymentMethodId", "token", "email");


    }
}