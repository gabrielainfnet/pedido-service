package com.ecommerce.pedido.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long produtoId;

    @Transient
    private Produto produto;

    private int quantidade;

    private BigDecimal valorUnitario;

}
