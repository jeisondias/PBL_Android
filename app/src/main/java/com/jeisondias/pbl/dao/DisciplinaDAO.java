package com.jeisondias.pbl.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.jeisondias.pbl.model.Disciplina;
import java.util.ArrayList;


public class DisciplinaDAO{

    private Banco banco;

    public DisciplinaDAO(Context context){
        banco = new Banco(context);
    }

    public void insertD(Disciplina disciplina){
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        if (disciplina.getCodigo() == 0){
            banco.getWritableDatabase().insert("disciplina", null, values);
        } else{
            updateD(disciplina);
        }
    }

    public void updateD(Disciplina disciplina) {
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        String args[] = {"" + disciplina.getCodigo()};
        banco.getWritableDatabase().update("disciplina", values, "idDisciplina=?", args);
    }

    public void deletD(Disciplina disciplina){
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        String args[] = {"" + disciplina.getCodigo() };
        banco.getWritableDatabase().delete("disciplina", "idDisciplina=?", args);
    }

    public ArrayList<Disciplina> getDisciplina(){
        Disciplina disciplina;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        String sql = "select * from disciplina;";
        Cursor cursor = banco.getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            disciplina= new Disciplina();
            disciplina.setCodigo(cursor.getInt(cursor.getColumnIndex("idDisciplina")));
            disciplina.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }
}
