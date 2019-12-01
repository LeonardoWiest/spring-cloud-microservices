package github.com.leonardowiest.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import github.com.leonardowiest.fornecedor.domain.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}