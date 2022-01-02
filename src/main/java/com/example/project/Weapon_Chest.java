package com.example.project;

import javafx.scene.image.ImageView;

public class Weapon_Chest extends Chest{

    private Weapon weapon;

    Weapon_Chest(ImageView i,double x, double y, double widthx, double height) {
        super(i,x,y,widthx,height,false);

        // this.weapon = new Weapon(x,y,widthx,height);

    }

    public void if_collides(){

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
}
