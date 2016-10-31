package com.sophiaantipolis.quacheton.borderline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Alaric on 06/10/2016.
 */

public class PointView extends View {

    private int taille = 80;
    private int vitesse;
    int nombreOccurence = 30;

    private Paint paint;
    private int i;

    private Point[] tableauPoint = new Point[nombreOccurence];


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

    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        paint = new Paint();
        removeCallbacks(animator);
        post(animator);

        for(i=0; i < nombreOccurence; i++) {
            tableauPoint[i] = new Point(random(taille + 1, 984 - taille), random(taille + 1, 1440 - taille));
        }
    }

    public int random(int min, int max){
       return min + (int)(Math.random() * max);
    }

    public boolean colisionBordX(int i){
        if(tableauPoint[i].getX() - taille <= 0 || tableauPoint[i].getX() + taille >= getWidth()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean colisionBordY(int i){
        if(tableauPoint[i].getY() - taille <= 0 || tableauPoint[i].getY() + taille >= getHeight()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //test.setColorFilter(Color.BLUE, PorterDuff.Mode.ADD);*/
        /*for(i = 0; i<4; i++) {
            canvas.drawCircle(tab[i].getX(), tab[i].getY(), taille, paint);
        }*/
        for(i=0; i < nombreOccurence; i++) {
            canvas.drawCircle(tableauPoint[i].getX(), tableauPoint[i].getY(), taille, paint);
        }
    }


    public void update() {
        for(i = 0; i<nombreOccurence; i++) {
            if (colisionBordX(i)) {
                tableauPoint[i].setDx(tableauPoint[i].getDx() * - 1);
            }
            if (colisionBordY(i)) {
                tableauPoint[i].setDy(tableauPoint[i].getDy() * - 1);
            }

            tableauPoint[i].setX(tableauPoint[i].getX() + vitesse * tableauPoint[i].getDx());
            tableauPoint[i].setY(tableauPoint[i].getY() + vitesse * tableauPoint[i].getDy());
        }
    }

    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            update();
            invalidate();
            postDelayed(this, 15);
        }};
}

