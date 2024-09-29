package com.ecommerce.pedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String rua;

    private int numero;

    private String cidade;

    private String estado;

    private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
