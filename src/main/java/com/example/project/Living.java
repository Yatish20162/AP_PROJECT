package com.example.project;

import javafx.scene.image.ImageView;

public class Living extends GameObject {

    private double jumpHeight;
    private boolean isAlive;

    Living(ImageView i, double x, double y, double width, double height, double jumpHeight, boolean isAlive) {
        super(i, x, y, width, height );
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
