package com.example.project;

import javafx.scene.image.ImageView;

public class Coin_Chest extends Chest {
    
    private int chest_coins;
    
    Coin_Chest(ImageView i, double x, double y, double widthx, double height) {
        super(i,x,y,widthx,height,false);

        this.chest_coins = (int)(Math.random() * (10+1 -1)) + 1;

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
