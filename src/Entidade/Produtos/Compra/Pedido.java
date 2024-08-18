
 package Entidade.Produtos.Compra;

 import java.math.BigDecimal;
 import java.time.LocalDateTime;
 import java.util.UUID;

 import Entidade.Item;
 import Entidade.Usuario;
 import com.mercadopago.MercadoPagoConfig;
 import com.mercadopago.client.payment.PaymentClient;
 import com.mercadopago.client.payment.PaymentCreateRequest;
 import com.mercadopago.client.payment.PaymentPayerRequest;
 import com.mercadopago.exceptions.MPApiException;
 import com.mercadopago.exceptions.MPException;
 import com.mercadopago.resources.payment.Payment;

 public class Pedido extends Carrinho {
     private UUID idPedido;
     private LocalDateTime dataPedido;
     private boolean status;
     private BigDecimal valorTotal;
     private boolean pagamento;

     public Pedido(Usuario usuario, UUID idcart, Item[] itens, int qtdItens, float total, UUID idPedido, LocalDateTime dataPedido, boolean status, BigDecimal valorTotal, boolean pagamento) {
         super(usuario, idcart, itens, qtdItens, total);
         this.idPedido = UUID.randomUUID();
         this.dataPedido = LocalDateTime.now();
         this.status = status;
         this.valorTotal = valorTotal;
         this.pagamento = pagamento;
     }

     public Pedido(Usuario usuario, UUID idcart, Item[] itens, int qtdItens, float total) {
         super();
     }

     public UUID getIdPedido() {
         return idPedido;
     }

     public void setIdPedido(UUID idPedido) {
         this.idPedido = idPedido;
     }

     public LocalDateTime getDataPedido() {
         return dataPedido;
     }

     public void setDataPedido(LocalDateTime dataPedido) {
         this.dataPedido = dataPedido;
     }

     public boolean isStatus() {
         return status;
     }

     public void setStatus(boolean status) {
         this.status = status;
     }

     public BigDecimal getValorTotal() {
         return valorTotal;
     }

     public void setValorTotal(BigDecimal valorTotal) {
         this.valorTotal = valorTotal;
     }

     public boolean isPagamento() {
         return pagamento;
     }

     public void setPagamento(boolean pagamento) {
         this.pagamento = pagamento;
     }

     public void finalizarCompra(String accessToken, String paymentMethodId, String token, String email) {
         // Configurar o token de acesso
         MercadoPagoConfig.setAccessToken(accessToken);

         // Inicializa o cliente de pagamento
         PaymentClient paymentClient = new PaymentClient();

         // Cria a requisição de pagamento
         PaymentCreateRequest paymentRequest = PaymentCreateRequest.builder()
                 .transactionAmount(this.valorTotal)
                 .description("Compra do pedido " + this.idPedido)
                 .paymentMethodId(paymentMethodId) // ID do método de pagamento
                 .token(token) // Token do cartão
                 .payer(PaymentPayerRequest.builder().email(email).build()) // Email do comprador
                 .build();

         try {
             // Realiza o pagamento
             Payment payment = paymentClient.create(paymentRequest);

             // Verifica o status do pagamento
             if ("approved".equals(payment.getStatus())) {
                 this.pagamento = true;
                 this.status = true; // O status do pedido é alterado para "finalizado"
                 System.out.println("Pagamento aprovado! ID do pagamento: " + payment.getId());
             } else {
                 this.pagamento = false;
                 this.status = false; // O status do pedido é alterado para "não finalizado"
                 System.out.println("Pagamento não aprovado. Status: " + payment.getStatus());
             }
         } catch (MPApiException e) {
             e.printStackTrace();
             this.pagamento = false;
             this.status = false; // O status do pedido é alterado para "não finalizado"
             System.out.println("Erro ao processar o pagamento: " + e.getMessage());
         } catch (MPException e) {
             throw new RuntimeException(e);
         }
     }
 }