package br.com.infogest.model.dao;

import br.com.infogest.dao.DAO;
import br.com.infogest.views.Principal;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginDao extends DAO {

    public boolean logar(String email, String senha) throws SQLException {
        boolean logado = false;

        Connection conexao = conectar();

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = md5(?)";

        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, senha);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Principal principal = new Principal();
            principal.setVisible(true);
            Principal.lblUser.setText(rs.getString(2));
            Principal.lblEmail.setText(rs.getString(3));

            DespesaDao despesa = new DespesaDao();
            despesa.bucarIdUsuario(email);
            ReceitaDao receita = new ReceitaDao();
            receita.bucarIdUsuario(email);
            MovimentacaoDao mov = new MovimentacaoDao();
            mov.bucarIdUsuario(email);

            logado = true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido!");
        }

        return logado;
    }
}
