package com.sophiaantipolis.quacheton.borderline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Blfab on 05/12/2016.
 */

public class ScoreFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                /*----INFLATER DU LAYOUT text_fragment----*/
        view = inflater.inflate(R.layout.score_fragment, container, false);
        TextView textScore = (TextView) view.findViewById(R.id.editTextScore);

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<ScoreData> query = realm.where(ScoreData.class);
        RealmResults<ScoreData> result1 = query.findAll();

        for (ScoreData unScore:result1) {
            textScore.append("Score : " + Integer.toString(unScore.getScore()) + "\n");
        }
        return view;
    }
}
