package github.com.leonardowiest.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import github.com.leonardowiest.loja.client.FornecedorClient;
import github.com.leonardowiest.loja.domain.Compra;
import github.com.leonardowiest.loja.dto.CompraDTO;
import github.com.leonardowiest.loja.dto.InfoFornecedorDTO;
import github.com.leonardowiest.loja.dto.InfoPedidoDTO;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    @HystrixCommand
    public Compra processarCompra(CompraDTO compraDTO) {

        InfoFornecedorDTO fornecedorDTO = fornecedorClient.getInfoPorUF(compraDTO.getEndereco().getUf());

        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compraDTO.getItens());

        Compra compra = new Compra();
        compra.setPedidoID(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());

        return compra;
    }

    /*@Autowired
    private RestTemplate client;
    
    @Autowired
    private DiscoveryClient euDiscoveryClient;
    
    public void processarCompra(CompraDTO compraDTO) {
    
        ResponseEntity<InfoFornecedorDTO> fornecedorDTO = client.exchange("http://fornecedor/info/" + compraDTO.getEndereco().getUf(), HttpMethod.GET,
                null, InfoFornecedorDTO.class);
    
        euDiscoveryClient.getInstances("fornecedor").stream().forEach(instanciaFornecedor -> {
            System.out.println("localhost:" + instanciaFornecedor.getPort());
        });
    
        System.out.println(fornecedorDTO.getBody().getEndereco());
    }*/

}
