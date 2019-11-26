/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.model;

import java.util.List;

/**
 *
 * @author VictorGuilhermeSeraf
 */
public class OrdemProducao {
    
    private int id;
    private OrdemVenda ordemVenda;
    private List<MateriaPrima> materias;
    private int recurso;
    private String statu;
    private String dataInicio;
    private String dataTermino;
    private String dataPrevista;
    private String tempoEstimado;

    public OrdemProducao() {
    }

    public OrdemProducao(int id, OrdemVenda ordemVenda, List<MateriaPrima> materias, int recurso, String statu, 
            String dataInicio, String dataTermino, String dataPrevista, String tempoEstimado) {
        this.id = id;
        this.ordemVenda = ordemVenda;
        this.materias = materias;
        this.recurso = recurso;
        this.statu = statu;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.dataPrevista = dataPrevista;
        this.tempoEstimado = tempoEstimado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdemVenda getOrdemVenda() {
        return ordemVenda;
    }

    public void setOrdemVenda(OrdemVenda ordemVenda) {
        this.ordemVenda = ordemVenda;
    }

    public List<MateriaPrima> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaPrima> materias) {
        this.materias = materias;
    }

    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    @Override
    public String toString() {
        return "\nOrdemProducao " + "\nNúmero da ordem =   " + id + ",\nNúmero da ordem de Venda = " + ordemVenda.getId() 
                + ",\nProduto a ser produzido =   " + ordemVenda.getProduto()
                + ",\nQuantidade a ser produzida =   " + ordemVenda.getQuantidadeProd()
                + ",\n\nMateriais a serem utilizados:\n" + forString(materias)
                + "\nRecurso = " + recurso + ",\nStatus = " + statu + ",\nData Início  = " + dataInicio + ",\nData Término  = " 
                + dataTermino + ",\nData Prevista= " + dataPrevista + ",\nTempo Estimado = " + tempoEstimado;
    }
    
    public String forString(List<MateriaPrima> materia){
        String tudao = "";
        for(MateriaPrima m : materias){
                    String id = "Id:" + Integer.toString(m.getId());
                    String nome = "Nome: "+m.getNome();
                    String quantidade = "Quantidade: "+Integer.toString(m.getQuantidade());
                    String fabricante = "Fabricante: "+m.getFabricante();
                    String quantidadeU = "Quantidade utilizada: " + Integer.toString(m.getQuantidadeUtilizada()) + " utilizada";
                    tudao += id + "\n" + nome + "\n" + quantidade + "\n" + fabricante + "\n" + quantidadeU + "\n\n";
                }
        return tudao;
    }
}
