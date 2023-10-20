package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import static br.com.infogest.views.ListarRenda.listaDespRec;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TransacoesPessDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // listar na tabela todas as despesas do mês do usuário
    public void listarMensal(int mes, int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listaDespRec.getModel();
        model.setRowCount(0); // limpar a tabela

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT * FROM listaPess WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

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
    
    // listar na tabela todas as despesas do ano do usuário
    public void listarAnual(int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listaDespRec.getModel();
        model.setRowCount(0); // limpar a tabela

        Transacoes t = new Transacoes();

        try {
            conexao = ConexaoDao.conectar();

            String sql = "SELECT * FROM listaPess WHERE YEAR(data) = ? AND usuario_id = ?";

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
    
    // Somar todas as despesas do mês do usuário
    public double somarDespesas(int mes, int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaDespesas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaDespesas FROM listaPess WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

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
    
    // Somar todas as despesas do ano do usuário
    public double somarDespesasAnual(int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();
        double somaDespesas = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS somaDespesas FROM listaPess WHERE YEAR(data) = ? AND usuario_id = ?";

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
}
