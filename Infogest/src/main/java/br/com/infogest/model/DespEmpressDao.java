package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DespEmpressDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date dataAtual = new Date(System.currentTimeMillis());

    public void AdicionarDespEmpress(Receitas r) throws SQLException {
        try {
            String sql = "INSERT INTO listaEmpress(nome, descricao, qtd, data, endereco, tipo, valor) VALUES (?, ?, ?, ?, ?, 'Despesa', ?)";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, r.getNome());
            pst.setString(2, r.getDescricao());
            pst.setInt(3, r.getQtd());
            pst.setDate(4, dataAtual);
            pst.setString(5, r.getEndereco());
            pst.setDouble(6, r.getValor());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar esta operação!" + "Error: " + e);
        } finally {
            conexao.close();
            pst.close();
        }
    }

    // Adicionar item na lista de receitas
    public List<Receitas> listarDespEmpress() throws SQLException {
        conexao = ConexaoDao.conectar();

        List<Receitas> receitas = new ArrayList<>();

        try {
            String sql = "Select id, nome, descricao, qtd, data, endereco, valor from listaEmpress";

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Receitas r = new Receitas();
                // Buscando dados do BD
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setDescricao(rs.getString("descricao"));
                r.setQtd(rs.getInt("qtd"));
                r.setData(rs.getDate("data"));
                r.setEndereco(rs.getString("endereco"));
                r.setValor(rs.getDouble("valor"));

                // Adicioanr todos os valores obtidos na lista
                receitas.add(r);
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
    public void ExcluirDespEmpressItem(Receitas r) throws SQLException {

        try {
            String sql = "DELETE FROM listaEmpress WHERE id = ?";

            conexao = ConexaoDao.conectar();
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
