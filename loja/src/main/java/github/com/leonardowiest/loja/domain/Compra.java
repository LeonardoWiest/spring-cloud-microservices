package github.com.leonardowiest.loja.domain;

public class Compra {

    private Long pedidoID;

    private Long tempoDePreparo;

    private String enderecoDestino;

    public Long getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(Long pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Long getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Long tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

}
