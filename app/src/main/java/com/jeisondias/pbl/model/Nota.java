package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 11/3/2016.
 */
public class Nota {
    private int codNota;
    private float nFrequencia;
    private float nParticipacao;
    private float nSegmento;
    private Sessao sessao;

    public int getCodNota() {
        return codNota;
    }

    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }

    public float getnFrequencia() {
        return nFrequencia;
    }

    public void setnFrequencia(float nFrequencia) {
        this.nFrequencia = nFrequencia;
    }

    public float getnParticipacao() {
        return nParticipacao;
    }

    public void setnParticipacao(float nParticipacao) {
        this.nParticipacao = nParticipacao;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public float getnSegmento() {
        return nSegmento;
    }

    public void setnSegmento(float nSegmento) {
        this.nSegmento = nSegmento;
    }
}
