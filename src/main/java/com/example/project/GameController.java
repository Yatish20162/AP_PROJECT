/**
 * Sample Skeleton for 'Game.fxml' Controller Class
 */

package com.example.project;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private Pane pause_menu;

    @FXML // fx:id="AnchorPane"
    private AnchorPane anchorPane; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="coins"
    private Label coins; // Value injected by FXMLLoader

    @FXML // fx:id="note"
    private Label note; // Value injected by FXMLLoader

    @FXML // fx:id="willhero"
    private ImageView willhero; // Value injected by FXMLLoader

    @FXML
    private ImageView gameover;

    ArrayList<GameObject> gamearray=new ArrayList<GameObject>();

    Hero hero;
    Data data;
    Random ran=new Random();

    Boolean isRunning = true;



    // GameController(){
    //     data = new Data();
    //     ran=new Random();
    // }

    @FXML
    void doPause(MouseEvent event) throws IOException {
        System.out.println("Game Paused");


        // Parent root= FXMLLoader.load(getClass().getResource("Pause.fxml"));

        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

        isRunning = false;
        System.out.println(isRunning);

        pause_menu.setVisible(true);
    }

    @FXML
    void doResume(MouseEvent event) throws IOException {
        System.out.println("Game Resumed");


        // Parent root= FXMLLoader.load(getClass().getResource("Pause.fxml"));

        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

        isRunning = true;


        pause_menu.setVisible(false);
    }


    @FXML
    void deFeedback(MouseEvent event) throws IOException {
        System.out.println("Game Feedback");

        Runtime rt = Runtime.getRuntime();
        String url = "https://forms.gle/s3dpj9nqwmJuyc2H7";
        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);


        // Parent root= FXMLLoader.load(getClass().getResource("Pause.fxml"));

        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

        // isRunning = true;

    }





    AnimationTimer collisoionTime=new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            checkCollisions(willhero,data.getOrcsView(),data.getPlatformView(),data.getCoinObjects(),data.getCoinObjects(), data.getChestObjects(), data.getObstruction());
            //System.out.println(";oll");
        }
    };

    void checkCollisions(ImageView heroImg,ArrayList<Orcs> orcsview,ArrayList<GameObject> img,ArrayList<Coin> coinsview, ArrayList<Coin> arrayList, ArrayList<Chest> chestview, ArrayList<TNT> obstructions)
    {
        for(int i=0;i<img.size();i++)
        {
            if(heroImg.getBoundsInParent().intersects(img.get(i).getImg().getBoundsInParent()))
            {
               hero.upp_steps=100;
                // System.out.println("Collision" + i);
            }
            for(int j=0;j<orcsview.size();j++){
               
                if (orcsview.get(j).getImg().getBoundsInParent().intersects(img.get(i).getImg().getBoundsInParent())) {
                    // System.out.println("ORCS COLLIDED");
                    orcsview.get(j).upp_steps = 50;
                }
            }

         

            for(int j=0;j< coinsview.size();j++) {
                if (heroImg.getBoundsInParent().intersects(coinsview.get(j).getImg().getBoundsInParent())) {
                    //coins = hero.coins;
                    hero.updateCoins(coinsview.get(j).getValue());
                    // System.out.println("COINS " + hero.getCoins());


                    coins.setText(Double.toString(hero.getCoins()));

                    coinsview.get(j).getImg().setVisible(false);
                    coinsview.get(j).setValue(0);
                }
            }

            for(int j=0;j<chestview.size();j++){
               
                if (chestview.get(j).getImg().getBoundsInParent().intersects(heroImg.getBoundsInParent())) {
                    // System.out.println("Chesttt COLLIDED");

                    Image  whichone = new Image("coinopen.png");


                    if( chestview.get(j) instanceof Weapon_Chest){
                        whichone = new Image("ChestOpen.png");

                    }
                   

                    chestview.get(j).getImg().setImage(whichone);
                   
                }
            }

            for(int j=0;j<obstructions.size();j++){
               
                if (obstructions.get(j).getImg().getBoundsInParent().intersects(heroImg.getBoundsInParent())) {
                    System.out.println("TNT TNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNTTNT TNTTNTTNTTNTTNT COLLIDED");

                    Image  whichlone = new Image("TNT_Explode.png");

                    obstructions.get(j).getImg().setImage(whichlone);

                                        // hero.updateHealth(obstructions.get(j).getEffect());

                    // note.setText("H: " + Double.toString( hero.getHealth()));

                    // obstructions.get(j).setEffect(0);

                    hero.setAlive(false);

                    gameover.setVisible(true);



                }
            }

            for(int j=0;j<orcsview.size();j++){
               
                if (orcsview.get(j).getImg().getBoundsInParent().intersects(heroImg.getBoundsInParent())) {
                    System.out.println("hERO MEWT oRG");

                    gameover.setVisible(true);

                    hero.setAlive(false);


                }
            }
        }
    }
    

    void initiate2() {

        data = new Data();
        
        double numIslands = data.getNumIslands();


        int picker = ran.nextInt(10);
        int orcpicker=ran.nextInt(4);
        int orcgetter=ran.nextInt(20);
        int chestpicker=ran.nextInt(2);
        int chestgetter=ran.nextInt(40);
        int coinpicker=ran.nextInt(10);

        double islandGap = 0;

        hero=new Hero(willhero,0,300,20, islandGap);

      


        for(int i=0; i<numIslands; i++){
            System.out.println(islandGap);

            String s = data.getPlatformList().get(picker);
            //TODO: #1 make index getter

            if(i>0 && i< numIslands-4){
                if(orcgetter < 10)
                {
                    System.out.println("this is djkvfnkjajdb"+ Integer.toString(orcpicker));
                    String o = data.getGreenorcsList().get(orcpicker);
                    addOrcs(o,islandGap);
                }

                if(chestgetter < 10)
                {
                    addChest(islandGap);
                }

                if(chestgetter>30){
                    addTNT(islandGap);
                }
                
                if(i%5==0){
                    addCoins(islandGap+70,220 - 20 - ran.nextInt(100));
                }

            }

            if(i == numIslands-3){
                addBoss(islandGap);
            }


            picker = ran.nextInt(10);
            orcpicker=ran.nextInt(4);
            orcgetter=ran.nextInt(20);
            // chestpicker=ran.nextInt(2);
            chestgetter=ran.nextInt(40);

            double old = addIsland(s,islandGap,220);
            double  newly = old + islandGap +  ran.nextInt(150);
            islandGap = newly;
        }



        //hero.animate();


    }


    void start(Scene scene)
    {

        System.out.println(" main firse dhappa kar gya");

        collisoionTime.start();

        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long l){

                // System.out.println(hero.getImg().getBoundsInParent().getMaxY() + " is YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");

                if(hero.getImg().getBoundsInParent().getMaxY() > 250){

                    System.out.println("Exited");

                    gameover.setVisible(true);
                    
                }

                if(hero.getAlive()){
                    System.out.println("Low Health!!!!!!!!!!!!!!!!!");

                }

            }
        };

        timer.start();



        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                // System.out.println(hero.getImg().getBoundsInParent().getMaxY() + " is YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");

                // if(hero.img.getY()<=-200)
                // {hero.setAlive(false);}

                    if( hero.getImg().getBoundsInParent().getMaxY() < 250 && event.getCode()==KeyCode.getKeyCode("Z") )
                    {
                        System.out.println("Pagal hai kya???????????");

                        for(int i=0;i < data.platformObjects.size();i++)
                        {
                            data.platformObjects.get(i).shiftleft();
                        }

                        for(int i=0;i< data.orcsObjects.size();i++)
                        {
                            data.orcsObjects.get(i).shiftleft();
                        }

                        for(int i=0;i< data.coinObjects.size();i++)
                        {
                            data.coinObjects.get(i).shiftleft();
                        }

                        for(int i=0;i< data.chestObjects.size();i++)
                        {
                            data.chestObjects.get(i).shiftleft();
                        }

                        for(int i=0; i < data.getObstruction().size();i++)
                        {
                            data.getObstruction().get(i).shiftleft();
                        }
                    }
                }
        });

        willhero=(ImageView) scene.lookup("#willhero") ;
        coins=(Label) scene.lookup("#coins") ;
        note=(Label) scene.lookup("#note") ;

        pause_menu=(Pane) scene.lookup("#pause_menu") ;
        pause_menu.setVisible(false);

        anchorPane=(AnchorPane) scene.lookup("#anchorPane");

        gameover = (ImageView) scene.lookup("#gameover");
        gameover.setVisible(false);

        this.initiate2();

    }


    double addIsland(String s, double x, double y){

        Platform newIsland = (Platform) data.generate_island(s, x, y);
        anchorPane.getChildren().add(newIsland.getImg());
        return newIsland.getWidth();

    }

    void addBoss(double islandGap){
        Orcs newOrc = data.generate_boss(islandGap);
        anchorPane.getChildren().add(newOrc.getImg());
    }

    void addTNT(double x){
        TNT newOrc = data.generate_tnt(x);
        anchorPane.getChildren().add(newOrc.getImg());
    }

    void addChest(double islandGap){

        boolean rand = ran.nextBoolean();        
        Chest newchest =  data.generate_chest(islandGap + 50, rand);
        anchorPane.getChildren().add(newchest.getImg());
    }


    

    void addOrcs(String o,double islandGap){
        
        Orc newOrc = (Orc) data.generate_orc(o, islandGap);
        anchorPane.getChildren().add(newOrc.getImg());
    }

    void addCoins(double x, double y){
        
        Coin coin = data.generate_coins(x,y, 1);
        anchorPane.getChildren().add(coin.getImg());
    }

 
    // void generate_chests(String c,int x)
    // {
    //     System.out.println(" chest printed ");
    //     int y=220-30;
    //     Image img=new Image(c);
    //     ImageView chests=new ImageView();
    //     chests.setImage(img);
    //     chests.setFitHeight(30);
    //     chests.setFitWidth(30);
    //     chests.setX(x);
    //     chests.setY(y);

    //     anchorPane.getChildren().add(chests);
    //     GameObject g=new GameObject(chests,x,y,50, y);
    //     gamearray.add(g);

    // }

    // void generate_coins(int x,int coinpicker)
    // {
    //     System.out.println(" coins printed ");
    //     int y= 220 - 20 - ran.nextInt(100);
    //     for(int i=0;i<coinpicker;i++) {
    //         Image img = new Image("Coin.png");
    //         ImageView coin = new ImageView();
    //         coin.setImage(img);
    //         coin.setFitHeight(20);
    //         coin.setFitWidth(20);
    //         coin.setX(x+i);
    //         coin.setY(y);
    //         anchorPane.getChildren().add(coin);
    //         GameObject g = new GameObject(coin, x+i, y, 50, i);
    //         gamearray.add(g);
    //     }

    // }

}
