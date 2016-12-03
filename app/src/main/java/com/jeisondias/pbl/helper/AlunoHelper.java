package com.jeisondias.pbl.helper;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.jeisondias.pbl.R;
import com.jeisondias.pbl.dao.AlunoDAO;
import com.jeisondias.pbl.model.Aluno;
import com.jeisondias.pbl.view.AlunoActivity;

import java.util.ArrayList;


public class AlunoHelper {

    private AlunoActivity activityA;
    private Aluno aluno;
    private AlunoDAO bancoA;
    private ArrayList<Aluno> alunos;
    private ArrayAdapter<Aluno> adapter;
    private EditText nomeA;
    private Button botaoAddA;
    private ListView listViewAL;

    public AlunoHelper(AlunoActivity alunoActivity, Aluno aluno){
        this.activityA = alunoActivity;
        this.aluno = aluno;
        componentsStart();
    }

    public AlunoHelper(AlunoActivity alunoActivity){
        this.activityA = alunoActivity;
        componentsStart();
    }

    private void componentsStart() {
        bancoA = new AlunoDAO(activityA.getApplicationContext());
        nomeA = (EditText) activityA.findViewById(R.id.nomeA);
        botaoAddA = (Button) activityA.findViewById(R.id.botaoAddA);
        listViewAL = (ListView) activityA.findViewById(R.id.listViewAL);
        funcBotao(botaoAddA);
        exibirAlunos();
    }

    public void exibirAlunos(){
        alunos = bancoA.getAluno();
        adapter = new ArrayAdapter<Aluno>(activityA, android.R.layout.simple_list_item_1, alunos);
        listViewAL.setAdapter(adapter);
    }

    private void funcBotao(Button botaoAddA) {
        botaoAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno = new Aluno();
                aluno.setNome(nomeA.getText().toString());
                bancoA.insertA(aluno);
                exibirAlunos();
            }
        });
    }


}
