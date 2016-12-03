package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 10/10/2016.
 */
public class Aluno {

    private String nome;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return nome;
    }

}
