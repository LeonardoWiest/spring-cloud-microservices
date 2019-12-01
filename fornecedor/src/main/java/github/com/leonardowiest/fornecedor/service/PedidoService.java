package github.com.leonardowiest.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.leonardowiest.fornecedor.domain.Pedido;
import github.com.leonardowiest.fornecedor.domain.PedidoItem;
import github.com.leonardowiest.fornecedor.domain.Produto;
import github.com.leonardowiest.fornecedor.dto.ItemDoPedidoDTO;
import github.com.leonardowiest.fornecedor.repository.PedidoRepository;
import github.com.leonardowiest.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {

        if (itens == null) {
            return null;
        }

        List<PedidoItem> pedidoItens = toPedidoItem(itens);

        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());

        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

        List<Long> idsProdutos = itens.stream().map(ItemDoPedidoDTO::getId).collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        List<PedidoItem> pedidoItens = itens.stream().map(item -> {

            Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setProduto(produto);
            pedidoItem.setQuantidade(item.getQuantidade());

            return pedidoItem;

        }).collect(Collectors.toList());

        return pedidoItens;

    }
}