package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacoesDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Transacoes> listaMensal(int mes, int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();

        List<Transacoes> transacoes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM listaEmpress WHERE MONTH(data) = ? AND YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, mes);
            pst.setInt(2, ano);
            pst.setInt(3, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setDescricao(rs.getString("descricao"));
                t.setQtd(rs.getInt("qtd"));
                t.setData(rs.getDate("data"));
                t.setEndereco(rs.getString("endereco"));
                t.setValor(rs.getDouble("valor"));

                transacoes.add(t);
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

        return transacoes;
    }

    public List<Transacoes> listaAnual(int ano) throws SQLException {
        conexao = ConexaoDao.conectar();

        Transacoes t = new Transacoes();

        List<Transacoes> transacoes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM listaEmpress WHERE YEAR(data) = ? AND usuario_id = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ano);
            pst.setInt(2, t.getUsuarioID());

            rs = pst.executeQuery();

            if (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setDescricao(rs.getString("descricao"));
                t.setQtd(rs.getInt("qtd"));
                t.setData(rs.getDate("data"));
                t.setEndereco(rs.getString("endereco"));
                t.setValor(rs.getDouble("valor"));

                transacoes.add(t);
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
        
        return transacoes;
    }
    
}
