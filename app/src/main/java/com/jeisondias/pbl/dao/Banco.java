package com.jeisondias.pbl.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco  extends SQLiteOpenHelper {
    private static final String DATABASE = "bancoPBL";
    private static final int VERSAO = 2;

    public Banco(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(addTabelaDisciplina());
        db.execSQL(addTabelaAluno());
        db.execSQL(addTabelaTurma());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ver como adicionar o nome da abela aqui
        db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);
    }

    private String addTabelaDisciplina(){
        return "CREATE TABLE disciplina (" +
                "  idDisciplina INTEGER PRIMARY KEY," +
                "  nome TEXT);";
    }

    private String addTabelaAluno(){
        return "CREATE TABLE aluno (" +
                "   idAluno INTEGER PRIMARY KEY," +
                "   nome TEXT);";
    }

    private String addTabelaTurma(){
        return "CREATE TABLE turma ("+
                "   idAluno INTERGER NOT NULL,"+
                "   idDisciplina INTEGER NOT NULL,"+
                "   PRIMARY KEY (idAluno, idDisciplina),"+
                "       FOREIGN KEY (idAluno)" +
                "       REFERENCES aluno (idAluno)" +
                "       ON DELETE NO ACTION" +
                "       ON UPDATE NO ACTION," +
                "       FOREIGN KEY (idDisciplina)" +
                "       REFERENCES disciplina (idDisciplina)" +
                "       ON DELETE NO ACTION" +
                "       ON UPDATE NO ACTION);";
    }
}