package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 10/10/2016.
 */
public class Problema {
    private String descricao;
    private int idProblema;
    private String dataIni;
    private String dataEnt;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public String getDataEnt() {
        return dataEnt;
    }

    public void setDataEnt(String dataEnt) {
        this.dataEnt = dataEnt;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }
}