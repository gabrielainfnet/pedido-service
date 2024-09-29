CREATE TABLE CLIENTE
(
    id   BIGINT PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE ENDERECO
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    rua        VARCHAR(255),
    numero     INT,
    cidade     VARCHAR(255),
    estado     VARCHAR(255),
    cep        VARCHAR(255),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES CLIENTE (id)
);

CREATE TABLE PEDIDO
(
    id                  BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    data_pedido         TIMESTAMP,
    data_entrega        TIMESTAMP,
    status              VARCHAR(255),
    valor_total         DECIMAL(19, 2),
    cliente_id          BIGINT,
    endereco_entrega_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES CLIENTE (id),
    FOREIGN KEY (endereco_entrega_id) REFERENCES ENDERECO(id)
);

CREATE TABLE ITEM_PEDIDO
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    produto_id     BIGINT,
    quantidade     INT,
    valor_unitario DECIMAL(19, 2),
    pedido_id      BIGINT,
    FOREIGN KEY (pedido_id) REFERENCES PEDIDO (id)
);

