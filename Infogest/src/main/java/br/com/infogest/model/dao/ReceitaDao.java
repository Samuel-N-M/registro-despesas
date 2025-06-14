package br.com.infogest.model.dao;

import br.com.infogest.dao.DAO;
import br.com.infogest.model.dtm.Receita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReceitaDao {

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
            Receita.setUsuario_id(rs.getInt("id"));
        }

    }

    public void AdicionarRec(Receita r) throws SQLException {
        try {
            String sql = "INSERT INTO movimentacoes(descricao, data, valor, tipo, usuario_id) VALUES (?, ?, ?, 'Receita', ?)";

            conexao = DAO.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, r.getDescricao());
            pst.setDate(2, dataAtual);
            pst.setDouble(3, r.getValor());
            pst.setInt(4, r.getUsuario_id());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar esta operação!" + "Error: " + e);
        } finally {
            conexao.close();
            pst.close();
        }
    }

    // Adicionar item na lista de despesas
    public List<Receita> listarReceita() throws SQLException {
        conexao = DAO.conectar();

        Receita d = new Receita();

        List<Receita> receitas = new ArrayList<>();

        try {
            String sql = "Select id, descricao, data, valor from movimentacoes WHERE usuario_id = ? AND tipo = 'Receita'";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, d.getUsuario_id());
            rs = pst.executeQuery();

            while (rs.next()) {
                Receita rec = new Receita();
                // Buscando dados do BD
                rec.setId(rs.getInt("id"));
                rec.setDescricao(rs.getString("descricao"));
                rec.setData(rs.getDate("data"));
                rec.setValor(rs.getDouble("valor"));
                // Adicioanr todos os valores obtidos na lista
                receitas.add(rec);
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
        return receitas;
    }

    // Deletar itens da lista de receita
    public void ExcluirReceita(Receita r) throws SQLException {

        try {
            String sql = "DELETE FROM movimentacoes WHERE id = ?";

            conexao = DAO.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, r.getId());

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
