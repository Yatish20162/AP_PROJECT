package com.example.project;
import javafx.scene.image.ImageView;

public class Boss_orc extends Orcs {

    public double health;

    Boss_orc(ImageView i, double x, double y, double widthx, double height) {
        super(i, x, y, widthx, height);
        //TODO Auto-generated constructor stub
        this.health = 30;
    }


    public void setHealth(double health) {
        this.health = health;
    }
    public double getHealth() {
        return health;
    }

    // jump 
    // if_collides 



}

