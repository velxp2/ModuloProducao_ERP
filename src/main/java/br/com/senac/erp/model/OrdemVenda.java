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
public class OrdemVenda {
    
    private int id;
    private String produto;
    private int quantidadeProd;

    public OrdemVenda() {
    }

    public OrdemVenda(int id, String produto, int quantidadeProd) {
        this.id = id;
        this.produto = produto;
        this.quantidadeProd = quantidadeProd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidadeProd() {
        return quantidadeProd;
    }

    public void setQuantidadeProd(int quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }
    
}
