DROP DATABASE IF EXISTS dbbitshow;
CREATE DATABASE dbbitshow;
USE dbbitshow;

SET SQL_SAFE_UPDATES = 0;

CREATE TABLE categoria (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45)
);

CREATE TABLE usuario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    e_mail VARCHAR(100) UNIQUE NOT NULL, 
    telefone VARCHAR(15) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    endereco VARCHAR(255)
);

CREATE TABLE produto_anunciado (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    data_anuncio DATE,
    encerramento_anuncio DATE,
    data_venda DATE,
    id_usuario INT,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);

CREATE TABLE carrinho (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_produto INT,
    id_usuario INT,
    id_produto_anunciado INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_produto_anunciado) REFERENCES produto_anunciado(id)
);

CREATE TABLE pergunta (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    texto VARCHAR(255),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE resposta (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255),
    id_usuario INT,
    id_pergunta INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_pergunta) REFERENCES pergunta(id)
);
