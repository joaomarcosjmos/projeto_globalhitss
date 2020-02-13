CREATE TABLE TB_PRODUTO(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (50) NOT NULL,
    preco DECIMAL (10,2) NOT NULL,
    quantidade NUMERIC (10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_PRODUTO (nome, preco, quantidade) VALUES ('Sabonete', 10.00, 2);
INSERT INTO TB_PRODUTO (nome, preco, quantidade) VALUES ('Pasta de dente', 15.00, 5);
INSERT INTO TB_PRODUTO (nome, preco, quantidade) VALUES ('Desodorante', 17.50, 1);