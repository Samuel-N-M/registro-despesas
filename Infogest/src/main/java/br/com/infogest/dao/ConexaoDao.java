package br.com.infogest.dao;

import java.sql.*;

public class ConexaoDao {
    // Info conexao BD
    private static final String url = "jdbc:mysql://localhost:3306/mybd";
    private static final String user = "root";
    private static final String senha = "123456789";
    // Driver conexao
    private static String driver = "com.mysql.cj.jdbc.Driver";
    // Conexao com banco
    private static Connection conexao = null;
    
    // Meto de conexao
    public static Connection conectar(){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
    
//    public static void fechar(){
//        try {
//            if(conexao != null){
//                conexao.close();
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
