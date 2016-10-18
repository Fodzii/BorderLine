package com.sophiaantipolis.quacheton.borderline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

/**
 * Created by Alaric on 06/10/2016.
 */

public class PointView extends View {

    Paint paint;
    Drawable image;
    Bitmap bitmap;
    int taille = 50;
    int xRocket = 60;
    int yRocket = 60;

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

    }

    public boolean colisionBordX(){
        if(xRocket - taille <= 0 || xRocket + taille >= getWidth()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean colisionBordY(){
        if(yRocket - taille <= 0 || yRocket + taille >= getHeight()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //test.setColorFilter(Color.BLUE, PorterDuff.Mode.ADD);*/
        canvas.drawCircle(xRocket, yRocket, taille, paint);
    }

    public void update() {
        if (colisionBordX()==false && colisionBordY()==false) {

        }
        xRocket += 5;
        yRocket += 5;
    }

    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            long now = AnimationUtils.currentAnimationTimeMillis();
                update();
            invalidate();
            if (!false) {
                postDelayed(this, 15);
            }
        }};
}

