package br.com.infogest.model;


public class Usuarios {
    private static int id;
    private static String nome;
    private static String email;
    private static String tipo;

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuarios.id = id;
    }

    public String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Usuarios.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Usuarios.email = email;
    }

    public String getTipo() {
        return tipo;
    }
    
    public static void setTipo(String tipo) {
        Usuarios.tipo = tipo;
    }
    
    
    
    
}
