create database mybd;

use mybd;
-- Tabela de Usuários 
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) not null,
    email VARCHAR(55) NOT NULL UNIQUE,
    senha VARCHAR(32) NOT NULL,
    tipo ENUM('Pessoal', 'Empresarial') NOT NULL
);

-- Tabela de Contas Bancárias
CREATE TABLE contas_bancarias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de Despesas pessoais
CREATE TABLE listaPess (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    qtd int not null,
    valor DECIMAL(10, 2) NOT NULL,
    data DATE NOT NULL,
    conta_id INT ,
    usuario_id INT NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES contas_bancarias(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de despessas empresariais
CREATE TABLE listaEmpress (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    qtd INT NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    valor DECIMAL(10 ,2) NOT NULL,
    data DATE NOT NULL,
    tipo ENUM('Despesa', 'Receita') NOT NULL,
    usuario_id INT,
    conta_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (conta_id) REFERENCES contas_bancarias(id)
);

-- Consultar tabelas
select * from usuarios;
select * from categorias;
select * from contas_bancarias;
select * from listaPess;
select * from listaEmpress;

-- Detalhes da tabela
describe usuarios;
describe listaPess;
describe listaEmpress;


