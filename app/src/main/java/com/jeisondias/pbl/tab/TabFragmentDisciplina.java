package com.jeisondias.pbl.tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.dao.Banco;
import com.jeisondias.pbl.dao.DisciplinaDAO;
import com.jeisondias.pbl.model.Disciplina;

import java.util.ArrayList;

/**
 * Created by jeiso on 11/7/2016.
 */
public class TabFragmentDisciplina extends Fragment {

    private Disciplina disciplina;
    private DisciplinaDAO bancoD;

    private EditText nome;
    private Button botao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }
        //Infla o Layout mas ainda não o manda para a Activity com  layout inflado é possível pegar os
        // elementos da tela
        View view = inflater.inflate(R.layout.disciplina, container, false);
        //Capturando os componentes da tela a partir da view criada.
        nome = (EditText) view.findViewById(R.id.nomeD);
        botao = (Button) view.findViewById(R.id.botaoD);
        funcBotao(botao);
        componentesStart();
        //Retorna a view para a activity (Container)
        return (RelativeLayout) view;
    }

    private void funcBotao(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (disciplina == null){
                    disciplina = new Disciplina();
                }
                disciplina.setNome(nome.getText().toString());
                bancoD.insertD(disciplina);
                //getActivity().finish();
            }
        });

    }

    private void componentesStart() {
        //disciplinas = new ArrayList<>();
        bancoD = new DisciplinaDAO(getActivity().getApplicationContext());
    }

}