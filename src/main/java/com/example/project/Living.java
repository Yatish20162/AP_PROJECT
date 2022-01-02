package com.example.project;

import javafx.scene.image.ImageView;

public class Living extends GameObject {

    private double jumpHeight;
    private boolean isAlive;

    Living(ImageView i, double x, double y, double width, double height, double jumpHeight) {
        super(i, x, y, width, height );
        //TODO Auto-generated constructor stub

        this.jumpHeight = jumpHeight;
        this.isAlive = true;
    }



    public Living(ImageView i, double x, double y, double widthx, double height) {
        super(i, x, y, widthx, height );

    }


    public boolean getAlive() {
        return isAlive;
    }
   


    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }




    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }
    
}
