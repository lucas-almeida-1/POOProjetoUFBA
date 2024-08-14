package Entidade.Produtos.Compra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Pedido {
    private UUID idPedido;
    private LocalDateTime dataPedido;
    private boolean status;
    private float valorTotal;
    //gatewaydepagamento
    private boolean pagamento;

    public Pedido(UUID idPedido, LocalDateTime dataPedido, boolean status, float valorTotal, boolean pagamento) {
        this.idPedido = UUID.randomUUID();
        this.dataPedido = LocalDateTime.now();
        this.status = status;
        this.valorTotal = valorTotal;
        this.pagamento = pagamento;
    }

    public UUID getIdPedido() {
        return idPedido;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }
    // Finalizar compra chamando gatway de pagamento mercado pago
    public void finalizarCompra(){

    }
}
