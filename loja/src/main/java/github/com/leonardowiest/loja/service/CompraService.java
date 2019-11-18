package github.com.leonardowiest.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import github.com.leonardowiest.loja.dto.CompraDTO;
import github.com.leonardowiest.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

    public void processarCompra(CompraDTO compraDTO) {

        ResponseEntity<InfoFornecedorDTO> fornecedorDTO = new RestTemplate().exchange("http://localhost:8081/info/" + compraDTO.getEndereco().getUf(),
                HttpMethod.GET, null, InfoFornecedorDTO.class);
        
        System.out.println(fornecedorDTO.getBody().getEndereco());
    }

}
