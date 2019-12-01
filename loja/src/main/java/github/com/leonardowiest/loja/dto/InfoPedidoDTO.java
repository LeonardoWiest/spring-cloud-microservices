package github.com.leonardowiest.loja.dto;

public class InfoPedidoDTO {

    private Long id;

    private Long tempoDePreparo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Long tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

}
