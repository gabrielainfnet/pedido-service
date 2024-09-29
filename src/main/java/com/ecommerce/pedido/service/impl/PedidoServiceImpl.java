package com.ecommerce.pedido.service.impl;

import com.ecommerce.pedido.model.ItemPedido;
import com.ecommerce.pedido.model.Pedido;
import com.ecommerce.pedido.model.Produto;
import com.ecommerce.pedido.repository.PedidoRepository;
import com.ecommerce.pedido.service.PedidoService;
import com.ecommerce.pedido.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        pedidos.forEach(pedido -> {
            List<ItemPedido> itensPedido = pedido.getItensPedido();
            itensPedido.forEach(itemPedido -> {
                Produto produto = produtoService.obterProdutoPorId(itemPedido.getProdutoId());
                itemPedido.setProduto(produto);
            });
        });

        return pedidos;
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Optional<Pedido> optPedido = pedidoRepository.findById(id);
        if (optPedido.isPresent()) {
            Pedido existingPedido = optPedido.get();
            existingPedido.setDataPedido(pedido.getDataPedido());
            existingPedido.setDataEntrega(pedido.getDataEntrega());
            existingPedido.setStatus(pedido.getStatus());
            existingPedido.setValorTotal(pedido.getValorTotal());
            existingPedido.setCliente(pedido.getCliente());
            existingPedido.setItensPedido(pedido.getItensPedido());
            existingPedido.setEnderecoEntrega(pedido.getEnderecoEntrega());
            return pedidoRepository.save(existingPedido);
        } else {
            throw new RuntimeException("Pedido com id " + id + " não encontrado");
        }
    }
}
