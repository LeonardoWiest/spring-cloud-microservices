package github.com.leonardowiest.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import github.com.leonardowiest.loja.dto.InfoFornecedorDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{uf}")
    public InfoFornecedorDTO getInfoPorUF(@PathVariable String uf);
}
