package com.example.project;

import javafx.scene.image.ImageView;

public class GameObject {
    ImageView img;
    int shiftvaue=10;
    int minX,minY,maxX,maxY;

    Location location;

    GameObject(ImageView i,int x,int y,int widthx)
    {
        img=i;
        this.location  = new Location(x,y);
        minX=x;
        maxX=x+widthx;
        minY=y;
        maxY=y;
    }

    void shiftleft()
    {
        this.minX-=10;
        this.maxX-=10;
        img.setX(minX);
        this.location.x=minX;
    }

}
