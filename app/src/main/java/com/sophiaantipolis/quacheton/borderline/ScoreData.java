package com.sophiaantipolis.quacheton.borderline;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Blfab on 28/11/2016.
 */

public class ScoreData extends RealmObject {

    private long id;
    private int score;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}