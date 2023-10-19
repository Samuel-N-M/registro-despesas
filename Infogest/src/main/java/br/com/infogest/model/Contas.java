package br.com.infogest.model;

public class Contas {
    private int id;
    private double saldo;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public static void setUsuario_id(int usuario_id) {
        Contas.usuario_id = usuario_id;
    }
    
    
}
