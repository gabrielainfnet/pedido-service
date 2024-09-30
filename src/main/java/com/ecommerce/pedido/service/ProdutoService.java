package com.ecommerce.pedido.service;

import com.ecommerce.pedido.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final WebClient.Builder webClientBuilder;

    public Produto obterProdutoPorId(long produtoId) {
        WebClient webClient = webClientBuilder.build();

        return webClient.get()
                .uri("http://produto-service/" + produtoId)
                .retrieve()
                .bodyToMono(Produto.class)
                .block();
    }
}
