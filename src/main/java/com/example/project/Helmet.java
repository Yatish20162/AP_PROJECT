package com.example.project;

import java.util.ArrayList;

public class Helmet {
    String name;
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    Helmet(String name, ArrayList<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
    }

}
