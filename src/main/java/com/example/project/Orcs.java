package com.example.project;

import javafx.scene.image.ImageView;

public class Orcs extends Living {

    int size;
    int color;

    Orcs(ImageView i, double x, double y, double widthx, double height, double jumpHeight, boolean isAlive, int size , int color) {
        super(i, x, y, widthx,height,jumpHeight, isAlive);
        //TODO Auto-generated constructor stub
        this.size = size;
        this.color = color;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
