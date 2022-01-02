package com.example.project;

import java.util.ArrayList;

public class Helmet {
    String name;
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    Helmet(String name, ArrayList<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

}
