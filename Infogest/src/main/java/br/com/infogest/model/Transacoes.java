package br.com.infogest.model;

import java.sql.Date;


public class Transacoes {
    private int id;
    private String nome;
    private String descricao;
    private int qtd;
    private Date data;
    private String endereco;
    private double valor;
    private static String tipo;
    private static int usuario_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public static void setTipo(String tipo) {
        Transacoes.tipo = tipo;
    }

    public int getUsuarioID() {
        return usuario_id;
    }

    public static void setUsuarioID(int userID) {
        Transacoes.usuario_id = userID;
    }
    
    
    private static String listar;

    public String getListar() {
        return listar;
    }

    public static void setListar(String listar) {
        Transacoes.listar = listar;
    }
    
    
    
}
