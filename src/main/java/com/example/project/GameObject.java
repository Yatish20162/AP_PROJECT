package com.example.project;

import javafx.scene.image.ImageView;

public class GameObject {
     ImageView img;
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
        double newValue = this.location.getMin_x() - 30; 
        img.setX(newValue);
        // img.setX(this.location.min_x - 10);
        double newMax =  newValue + this.location.getWidth();
        this.location.setX(newValue, newMax);
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
