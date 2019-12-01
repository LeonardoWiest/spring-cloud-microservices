package github.com.leonardowiest.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import github.com.leonardowiest.loja.domain.Compra;
import github.com.leonardowiest.loja.dto.CompraDTO;
import github.com.leonardowiest.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(method = RequestMethod.POST)
    public Compra realizaCompra(@RequestBody CompraDTO compraDTO) {

        return compraService.processarCompra(compraDTO);
    }

}
