package com.ecommerce.pedido.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private int quantidadeDisponivel;
}
