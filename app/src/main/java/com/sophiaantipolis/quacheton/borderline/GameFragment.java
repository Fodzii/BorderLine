package com.sophiaantipolis.quacheton.borderline;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Blfab on 26/09/2016.
 */
public class GameFragment extends Fragment {

    public static final String MesPrefs = "MesPreferences";
    View view;
    PointView point;
    IntrusView intrus;
    SharedPreferences sharedpreferences;
    Canvas canvas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                /*----INFLATER DU LAYOUT text_fragment----*/
        view = inflater.inflate(R.layout.game_fragment, container, false);

        sharedpreferences = getActivity().getSharedPreferences(MesPrefs, Context.MODE_PRIVATE);

        point = (PointView) view.findViewById(R.id.pointView);
        intrus = (IntrusView) view.findViewById(R.id.intrusView);

        launch();

        return view;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (isVisibleToUser) {
                launch();
            }
        }
    }

    public void launch(){
        point.setTaille(sharedpreferences.getInt("taille", 20));
        point.setNombreOccurence(sharedpreferences.getInt("nbPoint", 1));
        point.setVitesse(sharedpreferences.getInt("vitesse", 1));
        point.setCouleur(sharedpreferences.getString("couleur", "#000000"));
        point.setLargeur(point.getWidth());
        point.setHauteur(point.getHeight());
        point.init();

        intrus.setTaille(sharedpreferences.getInt("taille", 20 + 10));
        intrus.setVitesse(sharedpreferences.getInt("vitesse", 1));
        //intrus.setCouleur(sharedpreferences.getString("couleur", "#000000"));
        intrus.setLargeur(point.getWidth());
        intrus.setHauteur(point.getHeight());
        intrus.init();
    }
}

