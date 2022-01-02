package com.example.project;

import javafx.scene.image.ImageView;

public class Living extends GameObject {

    private double jumpHeight;
    private boolean isAlive;

    Living(ImageView i, int x, int y, int widthx, double jumpHeight, boolean isAlive) {
        super(i, x, y, widthx);
        //TODO Auto-generated constructor stub

        this.jumpHeight = jumpHeight;
        this.isAlive = isAlive;
    }



    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }
    
}
