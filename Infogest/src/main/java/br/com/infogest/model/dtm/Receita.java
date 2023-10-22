package br.com.infogest.model.dtm;

import java.sql.Date;

public class Receita {

    private int id;
    private String descricao;
    private Date data;
    private double valor;
    private String tipo;
    private static int usuario_id;

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
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public static void setUsuario_id(int usuario_id) {
        Receita.usuario_id = usuario_id;
    }
    
    

}
