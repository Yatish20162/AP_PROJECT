package com.example.project;

import javafx.scene.image.ImageView;

public class TNT extends GameObject {

    Range range;
    int effect;

    TNT(ImageView i, double x, double y, double widthx, double height, Range range,int effect) {
        super(i, x, y, widthx, height);

        this.range = range;
        this.effect = effect;
        
        //TODO Auto-generated constructor stub
    }


    public int getEffect() {
        return effect;
    }
    public void setEffect(int effect) {
        this.effect = effect;
    }
    
    
}
