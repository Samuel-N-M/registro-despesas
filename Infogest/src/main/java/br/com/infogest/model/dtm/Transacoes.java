package br.com.infogest.model.dtm;

import java.sql.Date;


public class Transacoes {
    private int id;
    private String descricao;
    private Date data;
    private double valor;
    private String tipo;
    static int usuario_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public int getUsuarioID() {
        return usuario_id;
    }

    public static void setUsuarioID(int userID) {
        Transacoes.usuario_id = userID;
    }
    
    
    static String listar;

    public String getListar() {
        return listar;
    }

    public static void setListar(String listar) {
        Transacoes.listar = listar;
    }
    
    
    // -----------------------------------------------------
    
    
    
    
    private static double somaDespesa;

    public double getSomaDespesa() {
        return somaDespesa;
    }

    public static void setSomaDespesa(double somaDespesa) {
        Transacoes.somaDespesa = somaDespesa;
    }
    
    
    
    
    
}
