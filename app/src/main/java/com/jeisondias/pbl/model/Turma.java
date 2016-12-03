package com.jeisondias.pbl.model;

import java.util.ArrayList;

/**
 * Created by jeiso on 11/3/2016.
 */
public class Turma {

    private Disciplina disciplina;
    private int codTurma;
    private ArrayList<Aluno> alunos;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString(){
        return codTurma + " " + disciplina.getNome();
    }
}
