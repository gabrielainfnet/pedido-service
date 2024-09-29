package com.ecommerce.pedido.service;

import com.ecommerce.pedido.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    Pedido create(Pedido pedido);

    Optional<Pedido> findById(Long id);

    List<Pedido> findAll();

    void deleteById(Long id);

    Pedido update(Long id, Pedido pedido);

}
