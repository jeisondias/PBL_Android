package com.jeisondias.pbl.helper;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.jeisondias.pbl.R;
import com.jeisondias.pbl.dao.Banco;
import com.jeisondias.pbl.dao.DisciplinaDAO;
import com.jeisondias.pbl.model.Disciplina;
import com.jeisondias.pbl.view.DisciplinaActivity;

public class DisciplinaHelper {

    private DisciplinaActivity activityD;
    private Disciplina disciplina;
    private DisciplinaDAO bancoD;
    private EditText nome;
    private Button botao;

    public DisciplinaHelper(DisciplinaActivity disciplinaActivity, Disciplina disciplina) {
        this.activityD = disciplinaActivity;
        this.disciplina = disciplina;
        componentsStart();
    }

    public DisciplinaHelper(DisciplinaActivity disciplinaActivity){
        this.activityD = disciplinaActivity;
        componentsStart();
    }

    private void componentsStart() {
        bancoD = new DisciplinaDAO(activityD.getApplicationContext());
        nome = (EditText) activityD.findViewById(R.id.nomeD);
        botao = (Button) activityD.findViewById(R.id.botaoD);
        funcBotao(botao);

    }

    private void funcBotao(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (disciplina == null){
                    disciplina = new Disciplina();
                }
                disciplina.setNome(nome.getText().toString());
                Banco banco = new Banco(activityD.getApplicationContext());
                bancoD.insertD(disciplina);
                activityD.finish();
            }
        });

    }
}