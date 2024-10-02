package com.ecommerce.pedido.service;

import com.ecommerce.pedido.model.NotificacaoPedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final WebClient.Builder webClientBuilder;

    public void enviarNotificacao(NotificacaoPedido NotificacaoPedido) {
        WebClient webClient = webClientBuilder.build();

        webClient.post()
                .uri("http://notificacao-service/")
                .bodyValue(NotificacaoPedido)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
