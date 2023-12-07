drop database if exists dbbitshow;
create database dbbitshow;

use dbbitshow;

-- Criação da tabela categoria
CREATE TABLE IF NOT EXISTS categoria (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

-- Criação da tabela usuario
CREATE TABLE IF NOT EXISTS usuario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    e_mail VARCHAR(100) UNIQUE NOT NULL, 
    telefone VARCHAR(15) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    endereco VARCHAR(255)
);

-- Criação da tabela produto_anunciado
CREATE TABLE IF NOT EXISTS produto_anunciado (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    data_anuncio DATE,
    encerramento_anuncio DATE,
    data_venda DATE,
    id_usuario INT,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Criação da tabela carrinho
CREATE TABLE IF NOT EXISTS carrinho (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_produto INT,
    id_usuario INT,
    id_produto_anunciado INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_produto_anunciado) REFERENCES produto_anunciado(id) ON DELETE CASCADE
);

-- Criação da tabela pergunta
CREATE TABLE IF NOT EXISTS pergunta (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    texto VARCHAR(255),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Criação da tabela resposta
CREATE TABLE IF NOT EXISTS resposta (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255),
    id_usuario INT,
    id_pergunta INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_pergunta) REFERENCES pergunta(id) ON DELETE CASCADE
);