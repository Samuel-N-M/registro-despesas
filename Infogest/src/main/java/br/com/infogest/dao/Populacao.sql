-- inserindo despesas na tablea movimentacoes

-- Inserindo usuários
INSERT INTO usuarios (nome, email, senha) VALUES 
    ("samuel", "samuel@gmail.com", md5(123456)),
    ("daniel", "daniel@gmail.com", md5(123456)),
    ("joão", "joao@gmail.com" , md5(123456)),
    ("ian", "ian@gmail.com", md5(123456));

-- inserindo despesas na tablea movimentacoes

-- Despesas do Mes 10/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1
    ('Manutenção do Carro', 200.00, '2023-10-17', 'Despesa', 1),
    ('Supermercado', 250.00, '2023-10-18', 'Despesa', 1),
    ('Conta de Luz', 150.00, '2023-10-07', 'Despesa', 1),
    ('Conta de energia', 250.00, '2023-10-07', 'Despesa', 1),
    ('mercado livre', 550.00, '2023-10-05', 'Despesa', 1),
    ('resturante', 250.00, '2023-10-10', 'Despesa', 1),
    ('Gás', 50.00, '2023-10-20', 'Despesa', 1),
    ('Transporte', 80.00, '2023-10-23', 'Despesa', 1),
    ('Mensalidade da Academia', 80.00, '2023-10-02', 'Despesa', 1),
    -- usuario 2
    ('Manutenção do Carro', 200.00, '2023-10-17', 'Despesa', 1),
    ('Supermercado', 250.00, '2023-10-18', 'Despesa', 1),
    ('Conta de Luz', 150.00, '2023-10-07', 'Despesa', 1),
    ('Conta de energia', 250.00, '2023-10-07', 'Despesa', 1),
    ('mercado livre', 550.00, '2023-10-05', 'Despesa', 1),
    ('resturante', 250.00, '2023-10-10', 'Despesa', 1),
    ('Gás', 50.00, '2023-10-20', 'Despesa', 1),
    ('Transporte', 80.00, '2023-10-23', 'Despesa', 1),
    ('Mensalidade da Academia', 80.00, '2023-10-02', 'Despesa', 1);

-- Despesas do Mes 09/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1
    ('Gás', 50.00, '2023-09-20', 'Despesa', 1),
    ('Almoço fora', 30.00, '2023-09-12', 'Despesa', 1),
    ('Transporte', 100.00, '2023-09-08', 'Despesa', 1),
    ('Assinatura de Streaming', 15.00, '2023-09-09', 'Despesa', 1),
    ('Supermercado', 250.00, '2023-09-01', 'Despesa', 1),
    ('Conta de Luz', 150.00, '2023-09-05', 'Despesa', 1),
    ('Conta de Luz', 150.00, '2023-09-05', 'Despesa', 1),
    ('Internet', 70.00, '2023-09-25', 'Despesa', 1),
    ('Mensalidade da Academia', 80.00, '2023-09-02', 'Despesa', 1),
    -- usuario 2
    ('Gás', 50.00, '2023-09-20', 'Despesa', 2),
    ('Almoço fora', 30.00, '2023-09-12', 'Despesa', 2),
    ('Transporte', 100.00, '2023-09-08', 'Despesa', 2),
    ('Assinatura de Streaming', 15.00, '2023-09-09', 'Despesa', 2),
    ('Supermercado', 250.00, '2023-09-01', 'Despesa', 2),
    ('Conta de Luz', 150.00, '2023-09-05', 'Despesa', 2),
    ('Conta de Luz', 150.00, '2023-09-05', 'Despesa', 2),
    ('Internet', 70.00, '2023-09-25', 'Despesa', 2),
    ('Mensalidade da Academia', 80.00, '2023-09-02', 'Despesa', 2);
    
-- Despesas do Mes 08/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1
    ('Aluguel', 1000.00, '2023-08-15', 'Despesa', 1),
    ('Supermercado', 250.00, '2023-08-10', 'Despesa', 1),
    ('Conta de Luz', 150.00, '2023-08-05', 'Despesa', 1),
    ('Gás', 50.00, '2023-08-04', 'Despesa', 1),
    ('Internet', 70.00, '2023-08-25', 'Despesa', 1),
    ('Mensalidade da Academia', 80.00, '2023-08-02', 'Despesa', 1),
    ('Telefone', 40.00, '2023-08-14', 'Despesa', 1),
    -- usuario 2
    ('Aluguel', 1000.00, '2023-08-15', 'Despesa', 2),
    ('Supermercado', 250.00, '2023-08-10', 'Despesa', 2),
    ('Conta de Luz', 150.00, '2023-08-05', 'Despesa', 2),
    ('Gás', 50.00, '2023-08-04', 'Despesa', 2),
    ('Internet', 70.00, '2023-08-25', 'Despesa', 2),
    ('Mensalidade da Academia', 80.00, '2023-08-02', 'Despesa', 2),
    ('Telefone', 40.00, '2023-08-14', 'Despesa', 2);
    
-- Despesas do Mes 07/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1    
    ('Internet', 70.00, '2023-07-25', 'Despesa', 1),
    ('Presentes', 50.00, '2023-07-03', 'Despesa', 1),
    ('Internet', 70.00, '2023-07-25', 'Despesa', 1),
    ('Mensalidade da Academia', 80.00, '2023-11-02', 'Despesa', 1),
    ('Seguro de Saúde', 120.00, '2023-12-23', 'Despesa', 1),
    ('Material Escolar', 50.00, '2023-01-20', 'Despesa', 1),
    ('Impostos', 300.00, '2023-02-10', 'Despesa', 1),
    ('Roupas', 75.00, '2023-03-08', 'Despesa', 1),
    ('Conserto em Casa', 200.00, '2023-04-15', 'Despesa', 1),
    ('Manutenção do Computador', 60.00, '2023-05-07', 'Despesa', 1),
    -- usuario 2
    ('Internet', 70.00, '2023-07-25', 'Despesa', 2),
    ('Presentes', 50.00, '2023-07-03', 'Despesa', 2),
    ('Internet', 70.00, '2023-07-25', 'Despesa', 2),
    ('Mensalidade da Academia', 80.00, '2023-11-02', 'Despesa', 2),
    ('Seguro de Saúde', 120.00, '2023-12-23', 'Despesa', 2),
    ('Material Escolar', 50.00, '2023-01-20', 'Despesa', 2),
    ('Impostos', 300.00, '2023-02-10', 'Despesa', 2),
    ('Roupas', 75.00, '2023-03-08', 'Despesa', 2),
    ('Conserto em Casa', 200.00, '2023-04-15', 'Despesa', 2),
    ('Manutenção do Computador', 60.00, '2023-05-07', 'Despesa', 2);

-- inserindo receitas na tablea movimentações

-- Receitas do Mes 10/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    ('Venda de Arte', 150.00, '2023-10-10', 'Receita', 1),
    ('Consultoria de TI', 150.00, '2023-10-25', 'Receita', 1);
    
-- Receitas do Mes 09/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1
    ('Salário', 2000.00, '2023-09-05', 'Receita', 1),
    ('Salário', 2000.00, '2023-09-05', 'Receita', 1),
    ('Reembolso de Despesas', 125.00, '2023-09-18', 'Receita', 1),
    ('Venda de Produtos', 225.00, '2023-09-25', 'Receita', 1),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 1),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 1),
    ('Aluguel de Propriedade', 800.00, '2023-09-25', 'Receita', 1),
    ('Prêmio em Dinheiro', 100.00, '2023-09-20', 'Receita', 1),
    ('Bolsa de Estudos', 350.00, '2023-09-10', 'Receita', 1),
    ('Recebimento de Empréstimo', 100.00, '2023-09-30', 'Receita', 1),
    -- usuario 2
    ('Salário', 2000.00, '2023-09-05', 'Receita', 1),
    ('Salário', 2000.00, '2023-09-05', 'Receita', 1),
    ('Reembolso de Despesas', 125.00, '2023-09-18', 'Receita', 1),
    ('Venda de Produtos', 225.00, '2023-09-25', 'Receita', 1),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 1),
    ('Dividendos de Ações', 50.00, '2023-09-10', 'Receita', 1),
    ('Aluguel de Propriedade', 800.00, '2023-09-25', 'Receita', 1),
    ('Prêmio em Dinheiro', 100.00, '2023-09-20', 'Receita', 1),
    ('Bolsa de Estudos', 350.00, '2023-09-10', 'Receita', 1),
    ('Recebimento de Empréstimo', 100.00, '2023-09-30', 'Receita', 1);

-- Receitas do Mes 09/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    -- usuario 1
    ('Rendimento de Investimentos', 300.00, '2023-08-10', 'Receita', 1),
    ('Freelance', 500.00, '2023-08-15', 'Receita', 1),
    ('Reembolso de Despesas', 150.00, '2023-08-20', 'Receita', 1),
    ('Venda de Produtos', 150.00, '2023-08-25', 'Receita', 1),
    ('Bônus no Trabalho', 276.00, '2023-08-03', 'Receita', 1),
    ('Consultoria', 300.00, '2023-08-18', 'Receita', 1),
    ('Venda de Eletrônicos', 200.00, '2023-08-20', 'Receita', 1),
    ('Prêmio em Loteria', 500.00, '2023-08-15', 'Receita', 1),
    ('Prêmio em Loteria', 500.00, '2023-06-04', 'Receita', 1),
    -- usuario 2
    ('Rendimento de Investimentos', 300.00, '2023-08-10', 'Receita', 1),
    ('Freelance', 500.00, '2023-08-15', 'Receita', 1),
    ('Reembolso de Despesas', 150.00, '2023-08-20', 'Receita', 1),
    ('Venda de Produtos', 150.00, '2023-08-25', 'Receita', 1),
    ('Bônus no Trabalho', 276.00, '2023-08-03', 'Receita', 1),
    ('Consultoria', 300.00, '2023-08-18', 'Receita', 1),
    ('Venda de Eletrônicos', 200.00, '2023-08-20', 'Receita', 1),
    ('Prêmio em Loteria', 500.00, '2023-08-15', 'Receita', 1),
    ('Prêmio em Loteria', 500.00, '2023-06-04', 'Receita', 1);

-- Receitas do Mes 09/2023
INSERT INTO movimentacoes (descricao, valor, data, tipo, usuario_id) VALUES
    ('Venda de Produtos', 200.00, '2023-07-25', 'Receita', 1),
    ('Venda de Veículo', 800.00, '2023-07-05', 'Receita', 1),
    ('Rendimento de Poupança', 75.00, '2023-07-10', 'Receita', 1);
