package com.jeisondias.pbl.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.helper.AlunoHelper;
import com.jeisondias.pbl.model.Aluno;


/**
 * Created by jeiso on 10/9/2016.
 */
public class AlunoActivity extends AppCompatActivity {

    private AlunoHelper helperA;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluno);
        Intent intent = this.getIntent();

        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        helperA = new AlunoHelper(this, aluno);
        helperA.exibirAlunos();
    }

}
