package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RecDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date dataAtual = new Date(System.currentTimeMillis());

    public void AdicionarRec(Receitas r) throws SQLException {
        try {
            String sql = "INSERT INTO listaEmpress(nome, descricao, qtd, data, endereco, tipo, valor, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            conexao = ConexaoDao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, r.getNome());
            pst.setString(2, r.getDescricao());
            pst.setInt(3, r.getQtd());
            pst.setDate(4, dataAtual);
            pst.setString(5, r.getEndereco());
            pst.setString(6, r.getTipo());
            pst.setDouble(7, r.getValor());
            pst.setInt(8, r.getUsuario_id());

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
    public List<Receitas> listarRec() throws SQLException {
        conexao = ConexaoDao.conectar();
        
        Receitas r = new Receitas();

        List<Receitas> receitas = new ArrayList<>();

        try {
            String sql = "Select id, nome, descricao, qtd, data, endereco, valor from listaEmpress WHERE usuario_id = ? AND tipo = ?";

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, r.getUsuario_id());
            pst.setString(2, r.getTipo());
            
            rs = pst.executeQuery();

            while (rs.next()) {
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
    public void ExcluirRecItem(Receitas r) throws SQLException {

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
