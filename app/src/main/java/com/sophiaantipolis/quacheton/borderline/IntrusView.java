package com.sophiaantipolis.quacheton.borderline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import io.realm.Realm;

/**
 * Created by Alaric on 06/10/2016.
 */

public class IntrusView extends View {

    private int taille;
    private int vitesse = 1;
    String couleur = "#000000";
    int hauteur;
    int largeur;
    int score = 0;

    private Paint paint;
    private Point point;


    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int uneVitesse) {
        this.vitesse = uneVitesse;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int uneTaille) {
        this.taille = uneTaille;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String uneCouleur) {
        this.couleur = uneCouleur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public IntrusView(Context context) {
        super(context);
        init();
    }

    public IntrusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor(couleur));
        removeCallbacks(animator);
        post(animator);
        point = new Point(random(taille + 1, largeur - taille), random(taille + 1, hauteur - taille));
        point.setDx(vitesse);
        point.setDy(vitesse);
    }

    public int random(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public boolean colisionBordX(){
        return point.getX() - taille <= 0 || point.getX() + taille >= getWidth();
    }

    public boolean colisionBordY(){
        return point.getY() - taille <= 0 || point.getY() + taille >= getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(point.getX(), point.getY(), taille, paint);
    }


    public void update() {
        if (colisionBordX()) {
            point.setDx(point.getDx() * - 1);
        }
        if (colisionBordY()) {
            point.setDy(point.getDy() * - 1);
        }
        point.setX(point.getX() + point.getDx());
        point.setY(point.getY() + point.getDy());
    }

    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            update();
            invalidate();
            postDelayed(this, 15);
        }};

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if((x>point.x - taille && x<point.x+taille) && (y>point.y - taille && y<point.y + taille)) {
                    score++;
                    Toast.makeText(getContext(), Integer.toString(score), Toast.LENGTH_SHORT).show();
                }
                else {
                    Realm realm = Realm.getDefaultInstance();

                    ScoreData monScores = new ScoreData();
                    monScores.setScore(score);

// Copy the object to Realm. Any further changes must happen on realmUser
                    realm.beginTransaction();
                    ScoreData realmScore = realm.copyToRealm(monScores);
                    realm.commitTransaction();
                    realm.close();
                }

                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
        }
        return true;
    }

}

