package com.jeisondias.pbl.tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jeisondias.pbl.R;

/**
 * Created by jeiso on 11/7/2016.
 */
public class TabFragmentAluno extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        return (RelativeLayout) inflater.inflate(R.layout.aluno, container, false);
    }
}