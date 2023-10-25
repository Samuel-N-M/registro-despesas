package br.com.infogest.model.dao;

import br.com.infogest.dao.DAO;
import br.com.infogest.model.dtm.Movimentacao;
import static br.com.infogest.views.DetalharContas.listagem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MovimentacaoDao extends DAO {

    public void bucarIdUsuario(String email) throws SQLException {
        Connection conexao = conectar();

        String sql = "SELECT id FROM usuarios WHERE email = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Movimentacao.setUsuario_id(rs.getInt("id"));
        }
    }

    // listar na tabela todas as receitas e despesas do mês do usuário
    public void movimentacoesMensais(int mes, int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listagem.getModel();
        model.setRowCount(0); // limpar a tabela

        Movimentacao m = new Movimentacao();

        Connection conexao = conectar();

        String sql = "SELECT * FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, mes);
        pst.setInt(2, ano);
        pst.setInt(3, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String descricao = rs.getString("descricao");
            Date data = rs.getDate("data");
            double valor = rs.getDouble("valor");

            model.addRow(new Object[]{id, descricao, data, valor});
        }
    }

    public void movimentacoesAnuais(int ano) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) listagem.getModel();
        model.setRowCount(0); // limpar a tabela

        Movimentacao m = new Movimentacao();

        Connection conexao = conectar();

        String sql = "SELECT * FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, ano);
        pst.setInt(2, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String descricao = rs.getString("descricao");
            Date data = rs.getDate("data");
            double valor = rs.getDouble("valor");

            model.addRow(new Object[]{id, descricao, data, valor});
        }
    }

    // CALCULO MENSAIS
    // Somar depsesas mensais
    public double somarDespesas(int mes, int ano) throws SQLException {
        double somaDespesa = 0.00;

        Connection conexao = conectar();

        Movimentacao m = new Movimentacao();

        String sql = "SELECT SUM(valor) AS somaDespesas FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa'";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, mes);
        pst.setInt(2, ano);
        pst.setInt(3, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            somaDespesa = rs.getDouble("somaDespesas");
        }

        return somaDespesa;
    }

    // Somar receitas mensais
    public double somarReceitas(int mes, int ano) throws SQLException {
        double somaReceita = 0.00;

        Connection conexao = conectar();

        Movimentacao m = new Movimentacao();

        String sql = "SELECT SUM(valor) AS somaReceitas FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita'";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, mes);
        pst.setInt(2, ano);
        pst.setInt(3, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            somaReceita = rs.getDouble("somaReceitas");
        }

        return somaReceita;
    }

    public double rendaMensal(int mes, int ano) throws SQLException {
        double renda = 0.00;

//        Connection conexao = conectar();
//
//        Movimentacao m = new Movimentacao();
//
//        String sql = "SELECT (SELECT SUM(valor) AS somaReceitas FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita') - (SELECT SUM(valor) AS somaDespesas FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa') AS renda";
//
//        PreparedStatement pst = conexao.prepareStatement(sql);
//        pst.setInt(1, mes);
//        pst.setInt(2, ano);
//        pst.setInt(3, m.getUsuario_id());
//        pst.setInt(4, mes);
//        pst.setInt(5, ano);
//        pst.setInt(6, m.getUsuario_id());
//
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            renda = rs.getDouble("renda");
//        }
        double somaDespesaMensal = somarDespesas(mes, ano);
        double somaReceitaMensal = somarReceitas(mes, ano);
        
        renda = somaReceitaMensal - somaDespesaMensal;

        return renda;
    }

    public List<String> Tipos(int mes, int ano) throws SQLException {
        List<String> tipos = new ArrayList<>();

        Movimentacao m = new Movimentacao();

        Connection conexao = conectar();

        String sql = "SELECT tipo FROM movimentacoes WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, mes);
        pst.setInt(2, ano);
        pst.setInt(3, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            tipos.add(rs.getString("tipo"));
        }

        return tipos;
    }

    // CALCULOS ANUAIS
    // Somar depsesas anuais
    public double somarDespesasAnuais(int ano) throws SQLException {
        double somaDespesa = 0.00;

        Connection conexao = conectar();

        Movimentacao m = new Movimentacao();

        String sql = "SELECT SUM(valor) AS somaDespesas FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa'";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, ano);
        pst.setInt(2, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            somaDespesa = rs.getDouble("somaDespesas");
        }

        return somaDespesa;
    }

    // Somar receitas anuais
    public double somarReceitasAnuais(int ano) throws SQLException {
        double somaReceita = 0.00;

        Connection conexao = conectar();

        Movimentacao m = new Movimentacao();

        String sql = "SELECT SUM(valor) AS somaReceitas FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita'";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, ano);
        pst.setInt(2, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            somaReceita = rs.getDouble("somaReceitas");
        }

        return somaReceita;
    }

    // Calular a renda anual
    public double rendaAnual(int ano) throws SQLException {
        double renda = 0.00;

//        Connection conexao = conectar();
//
//        Movimentacao m = new Movimentacao();
//
//        String sql = "SELECT (SELECT SUM(valor) AS somaReceitas FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Receita') - (SELECT SUM(valor) AS somaDespesas FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ? AND tipo = 'Despesa') AS renda";
//        
//        PreparedStatement pst = conexao.prepareStatement(sql);
//        pst.setInt(1, ano);
//        pst.setInt(2, m.getUsuario_id());
//        pst.setInt(3, ano);
//        pst.setInt(4, m.getUsuario_id());
//
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            renda = rs.getDouble("renda");
//        }

        double somaDespesaAnual = somarDespesasAnuais(ano);
        double somaReceitaAnual = somarReceitasAnuais(ano);
        
        renda = somaReceitaAnual - somaDespesaAnual;

        return renda;
    }

    public List<String> Tipos(int ano) throws SQLException {
        List<String> tipos = new ArrayList<>();

        Movimentacao m = new Movimentacao();

        Connection conexao = conectar();

        String sql = "SELECT tipo FROM movimentacoes WHERE YEAR(data) = ? AND usuario_id = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setInt(1, ano);
        pst.setInt(2, m.getUsuario_id());

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            tipos.add(rs.getString("tipo"));
        }

        return tipos;
    }

}
