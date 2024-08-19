package Start;

import Entidade.Perfil;
import Entidade.Produtos.Jogos;
import Entidade.Produtos.ProdutosFisicos;
import Entidade.Produtos.Skin;
import Entidade.Produtos.Software;
import Entidade.Usuario;
import Entidade.Conquistas;
import Entidade.Item;
import Screens.Screen;
import Entidade.Produtos.Compra.Pedido;
import Entidade.Produtos.Compra.Carrinho;

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

        // Criar carrinho
        Carrinho carrinho = new Carrinho(user1, UUID.randomUUID(), 10); // Capacidade do carrinho

        System.out.println("Steam Verde: Entretenimento Sustentável com Triciclo Eco\n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Você já está logado, vejamos as suas opções:");
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
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'g' para adicionar um item da lista de desejos ao carrinho");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Digite 'h' para fazer um pedido");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Caso queira sair digite qualquer outra coisa");

        Scanner leitor = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "a" ->
                        System.out.println("Seu apelido é " + perfil.getApelido());
                case "b" ->
                        System.out.println("Seu email é " + perfil.getEmail());
                case "c" ->
                        System.out.println("Seu username é " + perfil.getUsername());
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
                    boolean adicionarMais = true;

                    while (adicionarMais) {
                        System.out.println("A sua lista de desejos é a seguinte: ");
                        for (Item item : perfil.getListaDeDesejos()) {
                            System.out.println(item.getNome());
                        }
                        System.out.println("Digite o nome do item que deseja adicionar ao carrinho:");

                        String nomeItem = leitor.nextLine();
                        boolean itemAdicionado = false;

                        for (Item item : perfil.getListaDeDesejos()) {
                            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                                carrinho.addCarrinho(item);
                                System.out.println(item.getNome() + " foi adicionado ao carrinho.");
                                itemAdicionado = true;
                                break;
                            }
                        }

                        if (!itemAdicionado) {
                            System.out.println("Item não encontrado na lista de desejos.");
                        }

                        System.out.println("Deseja adicionar mais um item ao carrinho ou finalizar o pedido?");
                        System.out.println("Digite 'a' para adicionar mais um item, 'p' para finalizar o pedido, ou qualquer outra tecla para sair.");
                        String resposta = leitor.nextLine();

                        if (resposta.equalsIgnoreCase("a")) {
                            continue; // Volta para o início do laço para adicionar mais itens
                        } else if (resposta.equalsIgnoreCase("p")) {
                            if (carrinho.getQtdItens() > 0) {
                                Pedido pedido = carrinho.fazerPedido(); // Faz o pedido
                                System.out.println("Fazendo pedido...");
                                pedido.finalizarCompra("token", "paymentMethodId", "email"); // Substitua pelos valores reais
                                System.out.println("Pedido finalizado com sucesso.");
                            } else {
                                System.out.println("O carrinho está vazio. Adicione itens antes de fazer um pedido.");
                            }
                            adicionarMais = false; // Sai do laço e volta ao menu principal
                        } else {
                            adicionarMais = false; // Sai do laço e volta ao menu principal
                        }
                    }
                }


                case "h" -> {
                    if (carrinho.getQtdItens() > 0) {
                        // Enquanto houver itens no carrinho, continue fazendo pedidos
                        while (carrinho.getQtdItens() > 0) {
                            Pedido pedido = carrinho.fazerPedido(); // Faz o pedido
                            System.out.println("Fazendo pedido...");
                            pedido.finalizarCompra("token", "paymentMethodId", "email"); // Substitua pelos valores reais
                        }
                    } else {
                        // Se o carrinho estiver vazio, mostre uma mensagem e adicione itens
                        System.out.println("O carrinho está vazio. Adicione itens antes de fazer um pedido.");
                        mostrarJogosDisponiveis(leitor, carrinho);
                    }

                }
                default -> {
                    System.out.println("Saindo do programa");
                    loop = false;
                }
            }
            new Screen();
        }

    }

    private static void mostrarJogosDisponiveis(Scanner leitor, Carrinho carrinho) {
        // Lista de jogos disponíveis
        ArrayList<Jogos> jogosDisponiveis = new ArrayList<>();
        jogosDisponiveis.add(new Jogos("Elden Ring", "0000", 150, 48, true));
        jogosDisponiveis.add(new Jogos("The Last of Us I", "0001", 100, 60, true));
        // Adicione outros jogos disponíveis...

        System.out.println("Jogos disponíveis:");
        for (Jogos jogo : jogosDisponiveis) {
            System.out.println(jogo.getNome() + " - R$ " + jogo.getPreco());
        }

        System.out.println("Digite o nome do jogo que deseja adicionar ao carrinho ou 'n' para criar um novo jogo:");
        String escolha = leitor.nextLine();

        if (escolha.equalsIgnoreCase("n")) {
            // Lógica para criar um novo jogo
            System.out.println("Digite o nome do novo jogo:");
            String novoNome = leitor.nextLine();
            System.out.println("Digite o ID do novo jogo:");
            String novoId = leitor.nextLine();
            System.out.println("Digite o preço do novo jogo:");
            float novoPreco = Float.parseFloat(leitor.nextLine());
            System.out.println("Digite a duração do novo jogo:");
            int novaDuracao = Integer.parseInt(leitor.nextLine());
            System.out.println("O jogo é online? (true/false):");
            boolean novoOnline = Boolean.parseBoolean(leitor.nextLine());

            Jogos novoJogo = new Jogos(novoNome, novoId, novoPreco, novaDuracao, novoOnline);
            carrinho.addCarrinho(novoJogo);
            System.out.println(novoJogo.getNome() + " foi adicionado ao carrinho.");
        } else {
            // Adiciona o jogo selecionado ao carrinho
            boolean jogoAdicionado = false;
            for (Jogos jogo : jogosDisponiveis) {
                if (jogo.getNome().equalsIgnoreCase(escolha)) {
                    carrinho.addCarrinho(jogo);
                    System.out.println(jogo.getNome() + " foi adicionado ao carrinho.");
                    jogoAdicionado = true;
                    break;
                }
            }
            if (!jogoAdicionado) {
                System.out.println("Jogo não encontrado na lista de jogos disponíveis.");
            }
        }
    }
}