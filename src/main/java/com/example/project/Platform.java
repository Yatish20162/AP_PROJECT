package com.example.project;

import javafx.scene.image.ImageView;

public class Platform extends GameObject {

    double width;

    Platform(ImageView i, double x, double y, double width, double height) {
        super(i, x, y, width, height);

        this.width = width;

        //TODO Auto-generated constructor stub
    }


    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getWidth() {
        return width;
    }
   
    
}
