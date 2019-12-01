package github.com.leonardowiest.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.leonardowiest.loja.client.FornecedorClient;
import github.com.leonardowiest.loja.dto.CompraDTO;
import github.com.leonardowiest.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void processarCompra(CompraDTO compraDTO) {

        InfoFornecedorDTO fornecedorDTO = fornecedorClient.getInfoPorUF(compraDTO.getEndereco().getUf());

        System.out.println(fornecedorDTO.getEndereco());
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
