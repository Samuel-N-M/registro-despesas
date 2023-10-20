package br.com.infogest.model;

public class Contas {
    private int id;
    private static double saldo;
    private static int usuario_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Contas.saldo = saldo;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public static void setUsuario_id(int usuario_id) {
        Contas.usuario_id = usuario_id;
    }
    
    
}
