package com.jeisondias.pbl.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.jeisondias.pbl.model.Aluno;


import java.util.ArrayList;

/**
 * Created by jeiso on 10/10/2016.
 */
public class AlunoDAO {

    private Banco banco;

    public AlunoDAO(Context context) {
        banco = new Banco(context);
    }

    public void insertA(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        if (aluno.getId() == 0){
            banco.getWritableDatabase().insert("aluno", null, values);
        } else{
            updateA(aluno);
        }
    }

    private void updateA(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        String args[] = {"" + aluno.getId()};
        banco.getWritableDatabase().update("aluno", values, "idAluno=?", args);
    }

    private void deletA(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        String args[] = {"" + aluno.getId()};
        banco.getWritableDatabase().delete("aluno", "idAluno=?", args);
    }

    public ArrayList<Aluno> getAluno(){
        Aluno aluno;
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "select * from aluno;";
        Cursor cursor = banco.getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            aluno = new Aluno();
            aluno.setId(cursor.getInt(cursor.getColumnIndex("idAluno")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            alunos.add(aluno);
        }
        return alunos;
    }
}
