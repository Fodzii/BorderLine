package com.sophiaantipolis.quacheton.borderline;

/**
 * Created by Blfab on 18/10/2016.
 */

public class Point {
    int x;
    int y;
    int dx;
    int dy;

    public int getX() {
        return x;
    }

    public void setX(int unX) {
        this.x = unX;
    }

    public int getY() {
        return y;
    }

    public void setY(int unY) {
        this.y = unY;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int unDx) {
        this.dx = unDx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int unDy) {
        this.dy = unDy;
    }

    public Point(int unX, int unY){
        x = unX;
        y = unY;
        dx = 1;
        dy = 1;
    }
}
