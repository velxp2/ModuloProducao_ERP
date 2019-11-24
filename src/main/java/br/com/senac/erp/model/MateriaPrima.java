/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.model;

/**
 *
 * @author VictorGuilhermeSeraf
 */
public class MateriaPrima {
    
    private int id;
    private String nome;
    private int quantidade;
    private String fabricante;
    private boolean selecionado = false;
    private int quantidadeUtilizada;
    
    public MateriaPrima() {
    }

    public MateriaPrima(int id, String nome, int quantidade, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
    }

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidadeUtilizada() {
        return quantidadeUtilizada;
    }

    public void setQuantidadeUtilizada(int quantidadeUtilizada) {
        this.quantidadeUtilizada = quantidadeUtilizada;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean campoDesativado) {
        this.selecionado = campoDesativado;
    }
}
