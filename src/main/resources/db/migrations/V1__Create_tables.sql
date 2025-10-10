CREATE TABLE tb_missao (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    dificuldade VARCHAR(255)
);

CREATE TABLE tb_cadastro (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    img_url VARCHAR(255),
    idade INT,
    missoes_id BIGINT,
    FOREIGN KEY (missoes_id) REFERENCES tb_missao(id)
);