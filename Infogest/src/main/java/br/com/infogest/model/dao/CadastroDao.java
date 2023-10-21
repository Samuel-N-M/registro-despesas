package br.com.infogest.model.dao;

import br.com.infogest.dao.ConexaoDao;
import br.com.infogest.views.Cadastro;
import br.com.infogest.views.Principal;
import java.sql.*;
import javax.swing.JOptionPane;

public class CadastroDao extends ConexaoDao {

    public boolean exist(String email) throws SQLException {
        Connection conexao = conectar();

        String sql = "SELECT * FROM usuarios WHERE email = ?";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();

        return rs.next();
    }

    public boolean cadastarUsuario(String nome, String email, String senha) throws SQLException {
        boolean cadastrou = false;
        Connection conexao = conectar();

        if (exist(email)) {
            JOptionPane.showMessageDialog(null, "Usuário existente.");
            return false;
        }

        String sql = "INSERT INTO usuarios(nome, email, senha) VALUES (?, ?, md5(?))";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, nome);
        pst.setString(2, email);
        pst.setString(3, senha);

        int inserido = pst.executeUpdate();

        if (inserido > 0) {
            JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido");
            // Abre tela principal
            Principal principal = new Principal();
            principal.setVisible(true);
            Principal.lblUser.setText(nome);
            Principal.lblEmail.setText(email);

            // Busca id o usuário e salva em usuario da tabela movimentação
            DespesaDao despesa = new DespesaDao();
            despesa.bucarIdUsuario(email);
            ReceitaDao receita = new ReceitaDao();
            receita.bucarIdUsuario(email);
            MovimentacaoDao mov = new MovimentacaoDao();
            mov.bucarIdUsuario(email);

            cadastrou = true;
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro mal-sucedido");
        }

        return cadastrou;
    }
}
