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

    public void AdicionarDespEmpress(DespesasEmpress dp) throws SQLException {
        try {
            String sql = "INSERT INTO listaEmpress(nome, descricao, qtd, data, endereco, tipo, valor, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, dp.getNome());
            pst.setString(2, dp.getDescricao());
            pst.setInt(3, dp.getQtd());
            pst.setDate(4, dataAtual);
            pst.setString(5, dp.getEndereco());
            pst.setString(6, dp.getTipo());
            pst.setDouble(7, dp.getValor());
            pst.setInt(8, dp.getUsuario_id());

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
    public List<DespesasEmpress> listarDespEmpress() throws SQLException {
        conexao = ConexaoDao.conectar();
        
        DespesasEmpress dp = new DespesasEmpress();

        List<DespesasEmpress> despesas = new ArrayList<>();

        try {
            String sql = "Select id, nome, descricao, qtd, data, endereco, valor from listaEmpress WHERE usuario_id = ? AND tipo = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dp.getUsuario_id());
            pst.setString(2, dp.getTipo());
            rs = pst.executeQuery();

            while (rs.next()) {
                // Buscando dados do BD
                dp.setId(rs.getInt("id"));
                dp.setNome(rs.getString("nome"));
                dp.setDescricao(rs.getString("descricao"));
                dp.setQtd(rs.getInt("qtd"));
                dp.setData(rs.getDate("data"));
                dp.setEndereco(rs.getString("endereco"));
                dp.setValor(rs.getDouble("valor"));

                // Adicioanr todos os valores obtidos na lista
                despesas.add(dp);
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

    // Deletar itens da lista de receita
    public void ExcluirDespEmpressItem(DespesasEmpress dp) throws SQLException {

        try {
            String sql = "DELETE FROM listaEmpress WHERE id = ?";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dp.getId());

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
