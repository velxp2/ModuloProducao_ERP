/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.sendEmail;

/**
 *
 * @author Matheus
 */
public class Destinatarios {
    
    private String materiais = "@";
    private String estoque = "@";
    private String financeiro = "erp.tfinanceiro@gmail.com";
    private String TI = "@";
    private String RH = "@";

    public Destinatarios() {
    }

    public String getMateriais() {
        return materiais;
    }

    public String getEstoque() {
        return estoque;
    }

    public String getFinanceiro() {
        return financeiro;
    }

    public String getTI() {
        return TI;
    }

    public String getRH() {
        return RH;
    }
   
    
    
}
