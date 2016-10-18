package com.sophiaantipolis.quacheton.borderline;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

/**
 * Created by Blfab on 26/09/2016.
 */
public class OptionFragment extends Fragment {

    SeekBar speedBar;
    OnActionListener mListener;

    public interface OnActionListener  {
        public void OnAction(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*----Inflater du layout number_picker_fragment----*/
        View view = inflater.inflate(R.layout.option_fragment, container, false);

        speedBar = (SeekBar) view.findViewById(R.id.speedBar);

        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                mListener.OnAction(speedBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
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
