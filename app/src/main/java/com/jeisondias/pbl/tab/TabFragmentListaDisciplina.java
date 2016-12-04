package com.jeisondias.pbl.tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.dao.DisciplinaDAO;
import com.jeisondias.pbl.model.Disciplina;

import java.util.ArrayList;

/**
 * Created by jeiso on 11/7/2016.
 */
public class TabFragmentListaDisciplina extends Fragment {

    private Disciplina disciplina;
    private DisciplinaDAO bancoD;
    private ArrayList<Disciplina> disciplinas;
    private ArrayAdapter<Disciplina> adapter;
    private ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }
        //Infla o Layout mas ainda não o manda para a Activity com  layout inflado é possível pegar os
        // elementos da tela
        View view = inflater.inflate(R.layout.lista_disciplinas, container, false);
        //Capturando os componentes da tela a partir da view criada.
        lista = (ListView) view.findViewById(R.id.lstDisciplinas);
        componentesStart();
        //Retorna a view para a activity (Container)
        return view;
    }


    private void componentesStart() {
        //disciplinas = new ArrayList<>();
        bancoD = new DisciplinaDAO(getActivity().getApplicationContext());
        disciplinas = bancoD.getDisciplina();
        System.out.println(disciplinas.size());
        adapter = new ArrayAdapter<Disciplina>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, disciplinas);
        lista.setAdapter(adapter);
    }

}