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


-- inserindo despesas na tablea movimentacoes

INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    ('Aluguel', 1000.00, '2023-08-15', 'Despesa', 1),
    ('Supermercado', 250.00, '2023-08-10', 'Despesa', 3),
    ('Conta de Luz', 150.00, '2023-08-05', 'Despesa', 5),
    ('Gás', 50.00, '2023-09-20', 'Despesa', 4),
    ('Almoço fora', 30.00, '2023-09-12', 'Despesa', 3),
    ('Transporte', 100.00, '2023-09-08', 'Despesa', 1),
    ('Internet', 70.00, '2023-07-25', 'Despesa', 2),
    ('Telefone', 40.00, '2023-08-14', 'Despesa', 4),
    ('Assinatura de Streaming', 15.00, '2023-09-09', 'Despesa', 3),
    ('Manutenção do Carro', 200.00, '2023-10-17', 'Despesa', 3),
    ('Mensalidade da Academia', 80.00, '2023-11-02', 'Despesa', 4),
    ('Seguro de Saúde', 120.00, '2023-12-23', 'Despesa', 3),
    ('Material Escolar', 50.00, '2023-01-20', 'Despesa', 1),
    ('Impostos', 300.00, '2023-02-10', 'Despesa', 4),
    ('Roupas', 75.00, '2023-03-08', 'Despesa', 3),
    ('Conserto em Casa', 200.00, '2023-04-15', 'Despesa', 2),
    ('Manutenção do Computador', 60.00, '2023-05-07', 'Despesa', 1),
    ('Presentes', 50.00, '2023-07-03', 'Despesa', 3);


INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    ('Supermercado', 250.00, '2023-09-01', 'Despesa', 3),
    ('Supermercado', 250.00, '2023-10-18', 'Despesa', 3),
    ('Conta de Luz', 150.00, '2023-09-05', 'Despesa', 5),
    ('Conta de Luz', 150.00, '2023-10-07', 'Despesa', 5),
    ('Gás', 50.00, '2023-10-20', 'Despesa', 4),
    ('Gás', 50.00, '2023-08-04', 'Despesa', 4),
    ('Transporte', 80.00, '2023-10-23', 'Despesa', 1),
    ('Internet', 70.00, '2023-07-25', 'Despesa', 3),
    ('Internet', 70.00, '2023-08-25', 'Despesa', 2),
    ('Internet', 70.00, '2023-09-25', 'Despesa', 2),
    ('Mensalidade da Academia', 80.00, '2023-10-02', 'Despesa', 4),
    ('Mensalidade da Academia', 80.00, '2023-09-02', 'Despesa', 4),
    ('Mensalidade da Academia', 80.00, '2023-08-02', 'Despesa', 4);
    

-- inserindo receitas na tablea movimentações

INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    ('Salário', 2000.00, '2023-09-05', 'Receita', 1),
    ('Salário', 2000.00, '2023-09-05', 'Receita', 3),
    ('Rendimento de Investimentos', 300.00, '2023-08-10', 'Receita', 4),
    ('Freelance', 500.00, '2023-08-15', 'Receita', 3),
    ('Reembolso de Despesas', 150.00, '2023-08-20', 'Receita', 3),
    ('Reembolso de Despesas', 125.00, '2023-09-18', 'Receita', 3),
    ('Venda de Produtos', 200.00, '2023-07-25', 'Receita', 3),
    ('Venda de Produtos', 150.00, '2023-08-25', 'Receita', 4),
    ('Venda de Produtos', 225.00, '2023-09-25', 'Receita', 3),
    ('Bônus no Trabalho', 276.00, '2023-08-03', 'Receita', 1),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 3),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 1),
    ('Consultoria', 300.00, '2023-08-18', 'Receita', 3),
    ('Aluguel de Propriedade', 800.00, '2023-09-25', 'Receita', 1),
    ('Venda de Arte', 150.00, '2023-10-10', 'Receita', 4),
    ('Prêmio em Dinheiro', 100.00, '2023-09-20', 'Receita', 4),
    ('Bolsa de Estudos', 350.00, '2023-09-10', 'Receita', 1),
    ('Venda de Eletrônicos', 200.00, '2023-08-20', 'Receita', 4),
    ('Consultoria de TI', 150.00, '2023-10-25', 'Receita', 1),
    ('Recebimento de Empréstimo', 100.00, '2023-09-30', 'Receita', 3),
    ('Venda de Veículo', 800.00, '2023-07-05', 'Receita', 3),
    ('Rendimento de Poupança', 75.00, '2023-07-10', 'Receita', 4),
    ('Prêmio em Loteria', 500.00, '2023-08-15', 'Receita', 3),
    ('Prêmio em Loteria', 500.00, '2023-06-04', 'Receita', 1);
