package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static br.com.infogest.views.ListarRenda.listaDespRec;

public class TransacoesDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // listar na tabela todas as receitas e despesas do mês do usuário
    public void listarMensal(int mes, int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listaDespRec.getModel();
        model.setRowCount(0); // limpar a tabela

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT * FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());

            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int qtd = rs.getInt("qtd");
                Date data = rs.getDate("data");
                String endereco = rs.getString("endereco");
                double valor = rs.getDouble("valor");

                model.addRow(new Object[]{id, nome, descricao, qtd, data, endereco, valor});
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    // listar na tabela todas as receitas e despesas do ano do usuário
    public void listarAnual(int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listaDespRec.getModel();
        model.setRowCount(0); // limpar a tabela

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT * FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());

            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int qtd = rs.getInt("qtd");
                Date data = rs.getDate("data");
                String endereco = rs.getString("endereco");
                double valor = rs.getDouble("valor");

                model.addRow(new Object[]{id, nome, descricao, qtd, data, endereco, valor});
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    // ABAIXO ESTÁ OS CALCULOS MENSSAIS
    // Somar todas as despesas do mês do usuário
    public double somarDespesas(int mes, int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaDespesas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaDespesas FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                somaDespesas = rs.getDouble("somaDespesas");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return somaDespesas;
    }

    // Somar todas as Receitas do mês do usuário
    public double somarReceitas(int mes, int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaReceitas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaReceitas FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                somaReceitas = rs.getDouble("somaReceitas");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return somaReceitas;
    }

    // Calcular qual foi a renda mensal do usuário
    public double calculoRenda(int mes, int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double renda = 0.0;

        try {

            String sql = "SELECT (SELECT SUM(valor) AS somaReceitas FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita') - (SELECT SUM(valor) AS somaDespesas FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa') AS renda";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());
            pst.setInt(4, mes);
            pst.setInt(5, ano);
            pst.setInt(6, t.getUsuarioID());
            rs = pst.executeQuery();

            if (rs.next()) {
                renda = rs.getDouble("renda");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return renda;
    }

    public List<String> Tipos(int mes, int ano) throws SQLException {
        List<String> tipos = new ArrayList<>();

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT tipo FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());

            rs = pst.executeQuery();

            while (rs.next()) {
                tipos.add(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return tipos;
    }

    // ABAIXO ESTÁ OS CALCULOS ANUAIS
    // Somar todas as despesas do ano do usuário
    public double somarDespesasAnual(int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaDespesas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaDespesas FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                somaDespesas = rs.getDouble("somaDespesas");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return somaDespesas;
    }

    // Somar todas as Receitas do ano do usuário
    public double somarReceitasAnuais(int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaReceitas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaReceitas FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                somaReceitas = rs.getDouble("somaReceitas");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return somaReceitas;
    }

    // Calcular qual foi a renda anual do usuário
    public double calculoRendaAnual(int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double renda = 0.0;

        try {
            String sql = "SELECT (SELECT SUM(valor) AS somaReceitas FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita') - (SELECT SUM(valor) AS somaDespesas FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa') AS renda";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());
            pst.setInt(3, ano);
            pst.setInt(4, t.getUsuarioID());
            rs = pst.executeQuery();

            if (rs.next()) {
                renda = rs.getDouble("renda");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return renda;
    }

    public List<String> Tipos(int ano) throws SQLException {
        List<String> tipos = new ArrayList<>();

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT tipo FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());

            rs = pst.executeQuery();

            while (rs.next()) {
                tipos.add(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return tipos;
    }
}
