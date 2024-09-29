package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.model.Pedido;
import com.ecommerce.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Optional<Pedido> optPedido = pedidoService.findById(id);
        if (optPedido.isPresent()) {
            return ResponseEntity.ok(optPedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido saved = pedidoService.create(pedido);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedidoService.update(id, pedido);
        return ResponseEntity.ok().build();
    }
}
