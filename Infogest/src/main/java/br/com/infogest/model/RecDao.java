package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.sql.*;
import javax.swing.JOptionPane;

public class RecDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date dataAtual = new Date(System.currentTimeMillis());

    public void AdicionarRec(Receitas r) throws SQLException {
        try {
            String sql = "INSERT INTO listaDesp(nome, descricao, qtd, data, endereco, valor) VALUES (?, ?, ?, ?, ?, ?)";

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
}
