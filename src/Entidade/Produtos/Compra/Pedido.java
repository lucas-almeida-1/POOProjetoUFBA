package Entidade.Produtos.Compra;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Entidade.Item;
import Entidade.Usuario;

public class Pedido extends Carrinho {
    private UUID idPedido;
    private LocalDateTime dataPedido;
    private boolean status;
    private BigDecimal valorTotal;
    private boolean pagamento;

    // Construtor correto
    public Pedido(Usuario usuario, UUID idcart, Item[] itens, int qtdItens, float total) {
        super(usuario, idcart, itens.length); // Chama o construtor da superclasse com a capacidade do carrinho
        this.idPedido = UUID.randomUUID();
        this.dataPedido = LocalDateTime.now();
        this.status = false;
        this.valorTotal = BigDecimal.valueOf(total);
        this.pagamento = false;

        // Adiciona todos os itens ao carrinho
        for (Item item : itens) {
            addCarrinho(item); // Adiciona cada item ao carrinho
        }
    }

    public void finalizarCompra(String paymentMethodId, String token, String email) {
        // Recupera o token de acesso da variável de ambiente
        String accessToken = System.getenv("MERCADO_PAGO_ACCESS_TOKEN");
        if (accessToken == null || accessToken.isEmpty()) {
            System.out.println("Token de acesso não encontrado nas variáveis de ambiente.");
            return;
        }

        try {
            // URL da API de pagamentos do Mercado Pago
            URL url = new URL("https://api.mercadopago.com/v1/payments");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Criação do JSON para a requisição
            String jsonInputString = String.format(
                    "{\"transaction_amount\": %.2f, \"description\": \"Compra do pedido %s\", \"payment_method_id\": \"%s\", \"token\": \"%s\", \"payer\": {\"email\": \"%s\"}}",
                    this.valorTotal, this.idPedido, paymentMethodId, token, email
            );

            // Envio da requisição
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Verificação da resposta
            int responseCode = conn.getResponseCode();
            StringBuilder response = new StringBuilder();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta do InputStream
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }

                // Verifica o status do pagamento na resposta
                if (response.toString().contains("\"status\":\"approved\"")) {
                    this.pagamento = true;
                    this.status = true;
                    System.out.println("Pagamento aprovado!");
                } else {
                    this.pagamento = false;
                    this.status = false;
                    System.out.println("Pagamento não aprovado. Resposta: " + response);
                }
            } else {
                this.pagamento = false;
                this.status = false;
                System.out.println("Erro no pagamento. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.pagamento = false;
            this.status = false;
            System.out.println("Erro ao processar o pagamento: " + e.getMessage());
        }
    }


    // Getters e Setters
    public UUID getIdPedido() {
        return idPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public boolean isStatus() {
        return status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public boolean isPagamento() {
        return pagamento;
    }
}