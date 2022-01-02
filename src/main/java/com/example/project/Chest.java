package com.example.project;

import javafx.scene.image.ImageView;

public class Chest extends GameObject {
    private  boolean opened;

    Chest(ImageView i,int x,int y,int widthx, boolean opened) {
        super(i, x, y, widthx);
        this.opened = opened;
    }

    public boolean getOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}
