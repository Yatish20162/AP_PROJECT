package com.example.project;

import javafx.scene.image.ImageView;

public class GameObject {
    protected ImageView img;
    int shiftvaue=10;
    int minX,minY,maxX,maxY;

    Location location;

    GameObject(ImageView i,double x,double y,double width, double height)
    {
        img=i;
        this.location  = new Location(x, y, x+width, y+height);
        
    }

    void shiftleft()
    {
        this.minX-=50;
        this.maxX-=50;
        img.setX(minX);
        this.location.setMin_x(minX);;
    }



    public void setImg(ImageView img) {
        this.img = img;
    }

    public ImageView getImg() {
        return img;
    }


    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

}
