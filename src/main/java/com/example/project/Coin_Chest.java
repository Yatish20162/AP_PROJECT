package com.example.project;

import javafx.scene.image.ImageView;

public class Coin_Chest extends Chest {
    
    private int chest_coins;
    
    Coin_Chest(ImageView i,int x,int y,int widthx, boolean opened, Location location, Weapon weapon) {
        super(i,x,y,widthx,opened);

        this.chest_coins = chest_coins;

    }

    public void if_collides(){

    }

    public int getChest_coins() {
        return chest_coins;
    }

    public void setChest_coins(int chest_coins) {
        this.chest_coins = chest_coins;
    }

    
}
