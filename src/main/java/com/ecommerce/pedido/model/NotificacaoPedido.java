package com.ecommerce.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoPedido {

    private Long pedidoId;
    private String customerEmail;
    private StatusPedido status;
}
