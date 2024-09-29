package com.ecommerce.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private int quantidade;
}
