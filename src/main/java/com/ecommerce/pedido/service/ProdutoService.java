package com.ecommerce.pedido.service;

import com.ecommerce.pedido.model.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProdutoService {

    private String produtoApiURL = "http://localhost:8081/";

    public Produto obterProdutoPorId(long produtoId) {
        return WebClient.create(produtoApiURL + produtoId)
                .get()
                .retrieve()
                .bodyToMono(Produto.class)
                .block();
    }
}
