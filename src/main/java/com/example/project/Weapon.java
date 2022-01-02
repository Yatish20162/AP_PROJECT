package com.example.project;

import javafx.scene.image.ImageView;

public class Weapon extends GameObject {
    String name;
    int level;
    double damage;
    Range range;


    Weapon(ImageView i,int x,int y,int widthx,String name, int level ,double damage,Range range) {
        super(i, x, y, widthx);
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.range = range;
    }

    public int getLevel() {
        return level;
    }

    public Location getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }

    public Range getRange() {
        return range;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRange(Range range) {
        this.range = range;
    }
    
}
