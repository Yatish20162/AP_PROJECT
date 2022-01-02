package com.example.project;

import javafx.scene.image.ImageView;

public class Chest extends GameObject {
    private  boolean opened;

    Chest(ImageView i,double x,double y,double widthx,double height, boolean opened) {
        super(i, x, y, widthx, height);
        this.opened = opened;
    }

    public boolean getOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}
