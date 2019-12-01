package github.com.leonardowiest.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import github.com.leonardowiest.fornecedor.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findByUf(String uf);

    List<Produto> findByIdIn(List<Long> ids);
}