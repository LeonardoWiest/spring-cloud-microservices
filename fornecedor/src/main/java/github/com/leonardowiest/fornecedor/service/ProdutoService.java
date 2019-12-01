package github.com.leonardowiest.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.leonardowiest.fornecedor.domain.Produto;
import github.com.leonardowiest.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutosPorUf(String uf) {
        return produtoRepository.findByUf(uf);
    }

}