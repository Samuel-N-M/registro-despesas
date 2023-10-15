package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class DespDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date dataAtual = new Date(System.currentTimeMillis());

    public void Adicionar(Despesas d) throws SQLException {

        try {
            String sql = "INSERT INTO listaPess(descricao, qtd, data, valor, usuario_id) VALUES (?, ?, ?, ?, ?)";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, d.getDescricao());
            pst.setInt(2, d.getQtd());
            pst.setDate(3, dataAtual);
            pst.setDouble(4, d.getValor());
            pst.setInt(5, d.getUsuario_id());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Não foi possivel realizar esta operação!" + "Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    // Adicionar item na lista de despesas
    public List<Despesas> listarDesp() throws SQLException {
        conexao = ConexaoDao.conectar();

        List<Despesas> despesas = new ArrayList<>();

        try {
            String sql = "Select id, descricao, qtd, data, valor from listaPess";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Despesas desp = new Despesas();
                // Buscando dados do BD
                desp.setId(rs.getInt("id"));
                desp.setDescricao(rs.getString("descricao"));
                desp.setQtd(rs.getInt("qtd"));
                desp.setData(rs.getDate("data"));
                desp.setValor(rs.getDouble("valor"));
                // Adicioanr todos os valores obtidos na lista
                despesas.add(desp);
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
        return despesas;
    }

    // Deletar itens da lista de despesa
    public void ExcluirDespItem(Despesas d) throws SQLException {

        try {
            String sql = "DELETE FROM listaPess WHERE id = ?";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, d.getId());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar esta operação!" + "Error: " + e);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}
