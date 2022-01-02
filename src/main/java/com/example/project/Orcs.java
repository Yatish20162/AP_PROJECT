package com.example.project;

import javafx.scene.image.ImageView;

public class Orcs extends Living {

    int size;
    int color;

    Orcs(ImageView i, int x, int y, int widthx, double jumpHeight, boolean isAlive, int size , int color) {
        super(i, x, y, widthx,jumpHeight, isAlive);
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
