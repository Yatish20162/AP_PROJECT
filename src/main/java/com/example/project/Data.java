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
    ArrayList<Orcs> orcsObjects;
    ArrayList<Chest> chestObjects;
    ArrayList<Coin> coinObjects;


    Data(){
        platformList = new ArrayList<String>((Arrays.asList("Islands1.png","Islands2.png","Islands3.png","Islands4.png","Islands5.png","Islands6.png","Islands7.png","Islands8.png","Islands9.png","Islands10.png")));
        greenorcsList = new ArrayList<String>((Arrays.asList("Orc2.png","Orc3.png","Orc4.png","Orc5.png")));
        redorcsList = new ArrayList<String>((Arrays.asList("RedOrc1.png","RedOrc2.png")));
        chests =new ArrayList<String>((Arrays.asList("ChestClosed.png","coinclose.png")));
        

        platformObjects = new ArrayList<GameObject>();
        orcsObjects = new ArrayList<Orcs>();
        coinObjects = new ArrayList<Coin>();
        chestObjects = new ArrayList<Chest>();


        numIslands = 40;
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

    Orcs generate_boss(double x){

        int ly=220-30;

        Image img=new Image("OrcBoss.png");
        ImageView orcs = new ImageView();
        orcs.setImage(img);
        orcs.setFitHeight(60);
        orcs.setFitWidth(60);
        orcs.setX(x);
        orcs.setY(ly);

        Orcs orc = new Boss_orc(orcs,x,ly,50,50);
        orcsObjects.add(orc);

        return orc;
        

    }

    
    Orcs generate_orc(String o, double x){
        
        int ly=220-30;

        Image img=new Image(o);
        ImageView orcs = new ImageView();
        orcs.setImage(img);
        orcs.setFitHeight(30);
        orcs.setFitWidth(30);
        orcs.setX(x);
        orcs.setY(ly);

        Orcs orc = new Orc(orcs,x,ly,50,50);
        orcsObjects.add(orc);

        return orc;
        
    } 

    Coin generate_coins(double x, double y, double val){
        
        double ly= 220 -  y;
        Image img=new Image("Coin.png");
        ImageView coin = new ImageView();
        coin.setImage(img);
        coin.setFitHeight(20);
        coin.setFitWidth(20);
        coin.setX(x);
        coin.setY(y);

        Coin orc = new Coin(coin,x,ly,(double)50, (double)50,val);
        coinObjects.add(orc);

        return orc;
    } 


    Chest generate_chest(double x, boolean type){
        
        int ly=220-30;
        Image img;

        if(type){
            img=new Image("ChestClosed.png");
        }
        else{
            img=new Image("coinclose.png");
        }

        ImageView chest = new ImageView();
        chest.setImage(img);
        chest.setFitHeight(30);
        chest.setFitWidth(30);
        chest.setX(x);
        chest.setY(ly);

        if(type){
            Weapon_Chest wch=new Weapon_Chest(chest,x,(double)ly,(double)30,(double)30);
            chestObjects.add(wch);
            return wch;
        }
        else{
         
            Coin_Chest cch = new Coin_Chest(chest,x,(double)ly,(double)30,(double)30);
            chestObjects.add(cch);
            return cch;
        }       
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
    public ArrayList<Orcs> getOrcsView() {
        return orcsObjects;
    }
    public ArrayList<GameObject> getPlatformView() {
        return platformObjects;
    }

    public ArrayList<Coin> getCoinObjects() {
        return coinObjects;
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

    public void updateorcsView(Orc orc){
        this.orcsObjects.add(orc);

    }
    
}
