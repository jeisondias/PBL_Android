package com.jeisondias.pbl.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.helper.DisciplinaHelper;
import com.jeisondias.pbl.model.Disciplina;


/**
 * Created by jeiso on 10/2/2016.
 */
public class DisciplinaActivity extends AppCompatActivity {

    private DisciplinaHelper helperD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disciplina);
        Intent intent = this.getIntent();

        Disciplina disciplina =  (Disciplina) intent.getSerializableExtra("disciplina");
        helperD = new DisciplinaHelper(this, disciplina);

    }

}