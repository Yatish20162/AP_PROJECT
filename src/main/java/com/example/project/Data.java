package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Data {

    Random ran=new Random();
    double numIslands;
    
    ArrayList<String> platformList;
    ArrayList<String> greenorcsList;
    ArrayList<String> redorcsList;
    ArrayList<String> chests;


    ArrayList<GameObject> platformObjects;
    ArrayList<GameObject> orcsObjects;
    ArrayList<GameObject> chestObjects;

    Data(){
        platformList = new ArrayList<String>((Arrays.asList("Islands1.png","Islands2.png","Islands3.png","Islands4.png","Islands5.png","Islands6.png","Islands7.png","Islands8.png","Islands9.png","Islands10.png")));
        greenorcsList = new ArrayList<String>((Arrays.asList("Orc2.png","Orc3.png","Orc4.png","Orc5.png")));
        redorcsList = new ArrayList<String>((Arrays.asList("RedOrc1.png","RedOrc2.png")));
        chests =new ArrayList<String>((Arrays.asList("ChestClosed.png","coinclose.png")));
        
        numIslands = 80;
    }

    GameObject generate_island(String s, double x, double y){
        
        double ly=220;

        Image img=new Image(s);
        ImageView newIsland=new ImageView();
        newIsland.setImage(img);

        int width = 100 +  ran.nextInt(100);

        newIsland.setFitWidth(width);
        newIsland.setFitHeight(50);

        newIsland.setX(x);
        newIsland.setY(y);

        GameObject island = new Platform(newIsland,x,y, width, 50);

        platformObjects.add(island);

        return island;
        
    } 

    
    GameObject generate_orc(String o, double x){
        
        int ly=220-30;

        Image img=new Image(o);
        ImageView orcs = new ImageView();
        orcs.setImage(img);
        orcs.setFitHeight(30);
        orcs.setFitWidth(30);
        orcs.setX(x);
        orcs.setY(ly);

        GameObject orc = new Orc(orcs,x,ly,50,50);
        orcsObjects.add(orc);

        return orc;
        
    } 




































































































    public ArrayList<String> getPlatformList() {
        return platformList;
    }
    public ArrayList<String> getGreenorcsList() {
        return greenorcsList;
    }
    public ArrayList<String> getRedorcsList() {
        return redorcsList;
    }
    public ArrayList<String> getChests() {
        return chests;
    }
    
    public void setPlatformList(ArrayList<String> platformList) {
        this.platformList = platformList;
    }
    public void setGreenorcsList(ArrayList<String> greenorcsList) {
        this.greenorcsList = greenorcsList;
    }
    public void setRedorcsList(ArrayList<String> redorcsList) {
        this.redorcsList = redorcsList;
    }
    public void setChests(ArrayList<String> chests) {
        this.chests = chests;
    }


    public void setPlatformView(ArrayList<ImageView> platformView) {
        this.platformObjects = platformObjects;
    }

    public void setOrcsView(ArrayList<ImageView> orcsView) {
        this.orcsObjects = orcsObjects;
    }
    public ArrayList<GameObject> getOrcsView() {
        return orcsObjects;
    }
    public ArrayList<GameObject> getPlatformView() {
        return platformObjects;
    }

    public double getNumIslands() {
        return numIslands;
    }
    public void setNumIslands(double numIslands) {
        this.numIslands = numIslands;
    }

    public void updateplatformView(GameObject island){
        this.platformObjects.add(island);

    }

    public void updateorcsView(GameObject orc){
        this.orcsObjects.add(orc);

    }
    
}
