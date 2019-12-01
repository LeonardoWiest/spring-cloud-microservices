package github.com.leonardowiest.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import github.com.leonardowiest.loja.dto.InfoFornecedorDTO;
import github.com.leonardowiest.loja.dto.InfoPedidoDTO;
import github.com.leonardowiest.loja.dto.ItensCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{uf}")
    public InfoFornecedorDTO getInfoPorUF(@PathVariable String uf);

    @RequestMapping(method = RequestMethod.POST, value = "/pedido")
    public InfoPedidoDTO realizaPedido(List<ItensCompraDTO> itens);
}
