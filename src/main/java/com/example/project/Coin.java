package com.example.project;

import javafx.scene.image.ImageView;

public class Coin extends GameObject{

    double value;


    Coin(ImageView i, double x, double y, double width, double height, double val) {
        super(i, x, y, width, height);
        //TODO Auto-generated constructor stub
        this.value = val;
    }

    @Override
    public ImageView getImg() {
        return super.getImg();
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    
}
