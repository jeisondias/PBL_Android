package com.jeisondias.pbl.model;

import java.io.Serializable;


public class Disciplina implements Serializable {
    private String nome;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString(){
        return nome;
    }
}
