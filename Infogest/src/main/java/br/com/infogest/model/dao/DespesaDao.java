package br.com.infogest.model.dao;

import br.com.infogest.model.dtm.Despesa;
import br.com.infogest.dao.DAO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class DespesaDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date dataAtual = new Date(System.currentTimeMillis());

    public void bucarIdUsuario(String email) throws SQLException {
        conexao = DAO.conectar();

        String sql = "SELECT id FROM usuarios WHERE email = ?";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, email);

        rs = pst.executeQuery();

        if (rs.next()) {
            Despesa.setUsuario_id(rs.getInt("id"));
        }

    }

    public void Adicionar(Despesa d) throws SQLException {

        try {
            String sql = "INSERT INTO movimentacoes(descricao, data, valor, tipo, usuario_id) VALUES (?, ?, ?, 'Despesa', ?)";

            conexao = DAO.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, d.getDescricao());
            pst.setDate(2, dataAtual);
            pst.setDouble(3, d.getValor());
            pst.setInt(4, d.getUsuario_id());

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
    public List<Despesa> listarDesp() throws SQLException {
        conexao = DAO.conectar();

        Despesa d = new Despesa();

        List<Despesa> despesas = new ArrayList<>();

        try {
            String sql = "Select id, descricao, data, valor from movimentacoes WHERE usuario_id = ? AND tipo = 'Despesa'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, d.getUsuario_id());
            rs = pst.executeQuery();

            while (rs.next()) {
                Despesa desp = new Despesa();
                // Buscando dados do BD
                desp.setId(rs.getInt("id"));
                desp.setDescricao(rs.getString("descricao"));
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
    public void ExcluirDespesa(Despesa d) throws SQLException {

        try {
            String sql = "DELETE FROM movimentacoes WHERE id = ?";

            conexao = DAO.conectar();
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
