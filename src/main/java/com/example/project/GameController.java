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
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // fx:id="AnchorPane"
    private AnchorPane anchorPane; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="coins"
    private Label coins; // Value injected by FXMLLoader

    @FXML // fx:id="willhero"
    private ImageView willhero; // Value injected by FXMLLoader

    ArrayList<GameObject> gamearray=new ArrayList<GameObject>();

    Hero hero;
    Data data;
    Random ran=new Random();

    @FXML
    void doPause(MouseEvent event) throws IOException {
        System.out.println("Game Paused");
        Parent root= FXMLLoader.load(getClass().getResource("Pause.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    AnimationTimer collisoionTime=new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            // checkCollisions(willhero,data.getOrcsView(),data.getPlatformView());
            System.out.println(";oll");
        }
    };

    // void checkCollisions(ImageView heroImg,ArrayList<GameObject> orcsview,ArrayList<GameObject> img)
    // {
    //     for(int i=0;i<img.size();i++)
    //     {
    //         if(heroImg.getBoundsInParent().intersects(img.get(i).getImg().getBoundsInParent()))
    //         {
    //            hero.upp_steps=100;
    //             System.out.println("Collision" + i);
    //         }
    //         // if(orcsview.get(i) != null){
    //         // if (orcsview.get(i).getBoundsInParent().intersects(img.get(i).getBoundsInParent())) {
    //         //     System.out.println("ORCS COLLIDED");
    //         //     orc.upp_steps = 50;
    //         // }
    //         // }
    //     }
    // }
    


    void initiate(){

        

        double numIslands = data.getNumIslands();

        int picker = ran.nextInt(10);
        int orcpicker=ran.nextInt(5);
        int orcgetter=ran.nextInt(20);
        int chestpicker=ran.nextInt(2);
        int chestgetter=ran.nextInt(20);
        int coinpicker=ran.nextInt(10);

        double islandGap = 0;

        hero=new Hero(willhero,0,300,20, islandGap);



        for(int i=0; i<numIslands; i++){
            System.out.println(islandGap);

            String s = data.getPlatformList().get(picker);
            String c = data.greenorcsList.get(chestpicker);
            //TODO: #1 make index getter

            if(i>0){
                if(orcgetter < 10)
                {
                    String o = data.getGreenorcsList().get(orcpicker);
                    addOrcs(o,islandGap);
                }

                // if(chestgetter > 10)
                // {
                //     generate_chests(c,islandGap+50);
                // }

                // if(i%5==0)
                // {
                //     generate_coins(islandGap+70,coinpicker);

                // }
            }
            picker = ran.nextInt(10);
            orcpicker=ran.nextInt(5);
            orcgetter=ran.nextInt(20);
            // chestpicker=ran.nextInt(2);
            // chestgetter=ran.nextInt(20);

            double old = addIsland(s,islandGap,220);
            double  newly = old + islandGap +  ran.nextInt(150);
            islandGap = newly;
        }



        //hero.animate();




    }


    void start(Scene scene)
    {
        collisoionTime.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println(hero.img.getY());
                if( hero.img.getY()<=0 && event.getCode()==KeyCode.getKeyCode("Z") )
                {

                    for(int i=0;i< gamearray.size();i++)
                    {
                        gamearray.get(i).shiftleft();
                    }
                }
                else
                {
                    System.out.println("Exited");
                }
            }
        });

        willhero=(ImageView) scene.lookup("#willhero") ;
        anchorPane=(AnchorPane) scene.lookup("#anchorPane");

        this.initiate();

    }


    double addIsland(String s, double x, double y){

        Platform newIsland = (Platform) data.generate_island(s, x, y);
        anchorPane.getChildren().add(newIsland.getImg());
        return newIsland.getWidth();

    }

    void addOrcs(String o,double islandGap){
        
        Orc newOrc = (Orc) data.generate_orc(o, islandGap);
        anchorPane.getChildren().add(newOrc.getImg());
    }

    // int generte_islansd(String s,int x)
    // {
    //     int y=220;
    //     Image img=new Image(s);
    //     ImageView island1=new ImageView();
    //     island1.setImage(img);
    //     island1.setFitHeight(50);
    //     int width = 100 +  ran.nextInt(100);
    //     island1.setFitWidth(width);
    //     island1.setX(x);
    //     island1.setY(y);
    //     anchorPane.getChildren().add(island1);
    //     GameObject g=new GameObject(island1,x,y,50, width);
    //     gamearray.add(g);

    //     data.updateplatformView(island1);

    //     return width;
    // }

    // void generate_orcs(String o,int x)
    // {

    //     int y=220-30;
    //     Image img=new Image(o);
    //     ImageView orcs=new ImageView();
    //     orcs.setImage(img);
    //     orcs.setFitHeight(30);
    //     orcs.setFitWidth(30);
    //     orcs.setX(x);
    //     orcs.setY(y);

    //     Orc orc = new Orc(orcs,x,y,50, y);
    //     data.updateorcsView(orcs);

    //     anchorPane.getChildren().add(orcs);
    //     GameObject g=new GameObject(orcs,x,y,50, y);
    //     gamearray.add(g);


    // }

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
