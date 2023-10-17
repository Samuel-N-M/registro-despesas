package br.com.infogest.model;


public class Usuarios {
    private static int id;
    private static String tipo;

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuarios.id = id;
    }

    public String getTipo() {
        return tipo;
    }
    
    public static void setTipo(String tipo) {
        Usuarios.tipo = tipo;
    }
    
    
    
    
}
