package br.com.infogest.model;

import br.com.infogest.dao.ConexaoDao;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContasDao {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void addSaldo() throws SQLException {
        Contas c = new Contas();

        try {
            conexao = ConexaoDao.conectar();

            // Consultar se tem saldo para o usuário no banco;
            String sqlVerif = "SELECT * FROM contas_bancarias WHERE usuario_id = ?";

            pst = conexao.prepareStatement(sqlVerif);
            pst.setInt(1, c.getUsuario_id());
            rs = pst.executeQuery();

            if (rs.next()) {
                // Atualiza o saldo no banco
                String sqlAtualizar = "UPDATE contas_bancarias SET saldo = ? WHERE usuario_id = ?";

                pst = conexao.prepareStatement(sqlAtualizar);
                pst.setDouble(1, c.getSaldo());
                pst.setInt(2, c.getUsuario_id());

                int atualizado = pst.executeUpdate();

                if (atualizado > 0) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel salvar o saldo!");
                }
            } else {
                // Adiciona um saldo no banco
                String sqlAdd = "INSERT INTO contas_bancarias(saldo, usuario_id) VALUES (?, ?)";

                pst = conexao.prepareStatement(sqlAdd);
                pst.setDouble(1, c.getSaldo());
                pst.setInt(2, c.getUsuario_id());

                int inserido = pst.executeUpdate();

                if (inserido > 0) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel salvar o saldo!");
                }
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
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

    public double buscarSaldo() {
        Contas c = new Contas();
        
        double saldo = 0.0;
        
        try {
            conexao = ConexaoDao.conectar();

            // Consultar se tem saldo para o usuário no banco;
            String sqlVerif = "SELECT saldo FROM contas_bancarias WHERE usuario_id = ?";

            pst = conexao.prepareStatement(sqlVerif);
            pst.setInt(1, c.getUsuario_id());
            rs = pst.executeQuery();

            if (rs.next()) {
                saldo = rs.getDouble("saldo");
                Contas.setSaldo(saldo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return saldo;
    }
}
