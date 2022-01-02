package com.example.project;

import javafx.scene.image.ImageView;

public class Weapon_Chest extends Chest{

    private Weapon weapon;

    Weapon_Chest(ImageView i,int x,int y,int widthx, boolean opened, Location location, Weapon weapon) {
        super(i,x,y,widthx,opened);

        this.weapon = weapon;

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
