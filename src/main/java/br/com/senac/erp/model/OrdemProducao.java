/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.erp.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author VictorGuilhermeSeraf
 */
public class OrdemProducao {
    
    private int id;
    private OrdemVenda ordemVenda;
    private List<MateriaPrima> materias;
    private int QuantidadeRecurso;
    private String statu;
    private String dataInicio;
    private String dataTermino;
    private String dataPrevista;
    private String tempoEstimado;
    private int recursos;

    public OrdemProducao() {
    }

    public OrdemProducao(int id, OrdemVenda ordemVenda, List<MateriaPrima> materias, int QuantidadeRecurso, String statu, String dataInicio, String dataTermino, String dataPrevista, String tempoEstimado, int recursos) {
        this.id = id;
        this.ordemVenda = ordemVenda;
        this.materias = materias;
        this.QuantidadeRecurso = QuantidadeRecurso;
        this.statu = statu;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.dataPrevista = dataPrevista;
        this.tempoEstimado = tempoEstimado;
        this.recursos = recursos;
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

    public int getQuantidadeRecurso() {
        return QuantidadeRecurso;
    }

    public void setQuantidadeRecurso(int QuantidadeRecurso) {
        this.QuantidadeRecurso = QuantidadeRecurso;
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

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }
    
}
