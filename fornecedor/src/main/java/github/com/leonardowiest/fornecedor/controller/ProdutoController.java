package github.com.leonardowiest.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.leonardowiest.fornecedor.domain.Produto;
import github.com.leonardowiest.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/{uf}")
    public List<Produto> getProdutosPorEstado(@PathVariable("uf") String uf) {
        return produtoService.getProdutosPorUf(uf);
    }
}