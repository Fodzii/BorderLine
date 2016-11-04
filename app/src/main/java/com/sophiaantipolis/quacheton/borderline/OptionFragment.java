package com.sophiaantipolis.quacheton.borderline;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;

/**
 * Created by Blfab on 26/09/2016.
 */
public class OptionFragment extends Fragment {

    public static final String MesPrefs = "MesPreferences";
    SeekBar speedBar;
    NumberPicker nbDePoints;
    EditText tailleDuPoint;
    Button buttonValider;
    OnActionListener mListener;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    String stringTailleDuPoint;

    public interface OnActionListener  {
        public void OnAction(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*----Inflater du layout number_picker_fragment----*/
        View view = inflater.inflate(R.layout.option_fragment, container, false);

        sharedpreferences = getActivity().getSharedPreferences(MesPrefs, Context.MODE_PRIVATE);

        speedBar = (SeekBar) view.findViewById(R.id.speedBar);

        tailleDuPoint = (EditText) view.findViewById(R.id.SizeNumberText);

        nbDePoints = (NumberPicker) view.findViewById(R.id.nbOccurNumberPicker);
        nbDePoints.setMaxValue(5);
        nbDePoints.setMinValue(1);

        buttonValider = (Button) view.findViewById(R.id.buttonValider);

        editor = sharedpreferences.edit();

        tailleDuPoint.setHint(Integer.toString(sharedpreferences.getInt("taille", 20)));
        nbDePoints.setValue(sharedpreferences.getInt("nbPoint", 20));
        speedBar.setProgress(sharedpreferences.getInt("vitesse", 0));


        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.putInt("vitesse", speedBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            }
        });

        buttonValider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stringTailleDuPoint = tailleDuPoint.getText().toString();
                if (stringTailleDuPoint.length() > 0) {
                    editor.putInt("taille", Integer.parseInt(stringTailleDuPoint));
                }
                editor.putInt("nbPoint", nbDePoints.getValue());
                editor.putString("couleur", "#0000FF");
                editor.commit();
            }
        });

        return view;
    }

    @Override
     public void onAttach (Activity activity){
        super.onAttach(activity);
        try {
            mListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnActionListener");
        }
    }

}
