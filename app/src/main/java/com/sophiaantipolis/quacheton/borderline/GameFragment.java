package com.sophiaantipolis.quacheton.borderline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Blfab on 26/09/2016.
 */
public class GameFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                /*----INFLATER DU LAYOUT text_fragment----*/
        view = inflater.inflate(R.layout.game_fragment, container, false);

        return view;
    }

}

