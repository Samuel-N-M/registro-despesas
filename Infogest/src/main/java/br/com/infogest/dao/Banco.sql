create database infogest;

use infogest;

-- Tabela de Usuários 

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) not null,
    email VARCHAR(55) NOT NULL UNIQUE,
    senha VARCHAR(32) NOT NULL
);

-- Tabela de Despesas pessoais

CREATE TABLE movimentacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data DATE NOT NULL,
    tipo ENUM('Despesa', 'Receita') NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Consultar tabelas

select * from usuarios;
select * from movimentacoes;

-- Detalhes da tabela

describe usuarios;
describe movimentacoes;