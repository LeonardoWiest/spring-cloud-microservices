package github.com.leonardowiest.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import github.com.leonardowiest.fornecedor.domain.InfoFornecedor;

public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {

    public InfoFornecedor findByUf(String uf);

}
