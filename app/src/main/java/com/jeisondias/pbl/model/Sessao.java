package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 10/10/2016.
 */
public class Sessao {

    private Problema problema;
    private int codSessao;
    private String Data;
    private Turma turma;

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getCodSessao() {
        return codSessao;
    }

    public void setCodSessao(int codSessao) {
        this.codSessao = codSessao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
