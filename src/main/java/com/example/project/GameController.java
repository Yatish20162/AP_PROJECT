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


    Random ran=new Random();


    public int randomx(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }



    @FXML
    void doPause(MouseEvent event) throws IOException {
        System.out.println("Game Paused");
        Parent root= FXMLLoader.load(getClass().getResource("Pause.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void move()
    {

    }

    boolean flag=false;

    AnimationTimer collisoionTime=new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            checkCollisions(willhero,platformview);
        }
    };

    void checkCollisions(ImageView heroImg,ArrayList<ImageView> img)
    {
        for(int i=0;i<img.size();i++)
        {

            if(heroImg.getBoundsInParent().intersects(img.get(i).getBoundsInParent()))
            {
                flag=true;
               hero.upp_steps=100;
                flag=false;
                System.out.println("Collision" + i);
            }
        }

    }
    ArrayList<ImageView> platformview=new ArrayList<ImageView>();

    void start(Scene scene)
    {

        collisoionTime.start();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode()==KeyCode.getKeyCode("Z"))
                {
                    for(int i=0;i< gamearray.size();i++)
                    {
                        gamearray.get(i).shiftleft();
                    }

                }
            }
        });



        ArrayList<String> platformList = new ArrayList<String>((Arrays.asList("Islands1.png","Islands2.png","Islands3.png","Islands4.png","Islands5.png","Islands6.png","Islands7.png","Islands8.png","Islands9.png","Islands10.png")));

        ArrayList<String> orcsList = new ArrayList<String>();
        orcsList.add("Orc2.png");
        orcsList.add("Orc3.png");
        orcsList.add("Orc4.png");
        orcsList.add("Orc5.png");
        orcsList.add("TNT.png");

        ArrayList<String> chests=new ArrayList<String>();
        chests.add("ChestClosed.png");
        chests.add("coinclose.png");

        ArrayList<Integer> coins =new ArrayList<Integer>(Arrays.asList(0,0,3,0,5,0,6,0,2));



        int numIslands = 90;

        int picker = ran.nextInt(10);
        int orcpicker=ran.nextInt(5);
        int orcgetter=ran.nextInt(20);
        int chestpicker=ran.nextInt(2);
        int chestgetter=ran.nextInt(20);
        int coinpicker=ran.nextInt(10);

        int islandGap = 0;



        willhero=(ImageView) scene.lookup("#willhero") ;
        anchorPane=(AnchorPane) scene.lookup("#anchorPane");

        hero=new Hero(willhero,0,300,20);
        hero.animate(flag);

        for(int i=0; i<numIslands; i++){
            // we will generate random integer
            System.out.println(islandGap);
            String s=platformList.get(picker);
            String c= chests.get(chestpicker);

            if(i>0){
                if(orcgetter < 10)
                {
                    String o=orcsList.get(orcpicker);
                    generate_orcs(o,islandGap);
                }

                if(chestgetter > 10)
                {
                    generate_chests(c,islandGap+50);
                }

                if(i%5==0)
                {
                    generate_coins(islandGap+70,coinpicker);

                }
            }

            picker = ran.nextInt(10);
            orcpicker=ran.nextInt(5);
            orcgetter=ran.nextInt(20);
            chestpicker=ran.nextInt(2);
            chestgetter=ran.nextInt(20);


            int old = generte_islansd(s,islandGap);
            int  newly = old + islandGap +  ran.nextInt(150);
            islandGap = newly;
        }

    }

    int generte_islansd(String s,int x)
    {
        int y=220;
        Image img=new Image(s);
        ImageView island1=new ImageView();
        island1.setImage(img);
        island1.setFitHeight(50);
        int width = 100 +  ran.nextInt(100);
        island1.setFitWidth(width);
        island1.setX(x);
        island1.setY(y);
        anchorPane.getChildren().add(island1);
        GameObject g=new GameObject(island1,x,y,50);
        gamearray.add(g);

        platformview.add(island1);

        return width;
    }

    void generate_orcs(String o,int x)
    {

        System.out.println(" ORCS PRINTINlnd.");

        int y=220-30;
        Image img=new Image(o);
        ImageView orcs=new ImageView();
        orcs.setImage(img);
        orcs.setFitHeight(30);
        orcs.setFitWidth(30);
        orcs.setX(x);
        orcs.setY(y);

        anchorPane.getChildren().add(orcs);
        GameObject g=new GameObject(orcs,x,y,50);
        gamearray.add(g);


    }

    void generate_chests(String c,int x)
    {
        System.out.println(" chest printed ");
        int y=220-30;
        Image img=new Image(c);
        ImageView chests=new ImageView();
        chests.setImage(img);
        chests.setFitHeight(30);
        chests.setFitWidth(30);
        chests.setX(x);
        chests.setY(y);

        anchorPane.getChildren().add(chests);
        GameObject g=new GameObject(chests,x,y,50);
        gamearray.add(g);

    }

    void generate_coins(int x,int coinpicker)
    {
        System.out.println(" coins printed ");
        int y= 220 - 20 - ran.nextInt(100);
        for(int i=0;i<coinpicker;i++) {
            Image img = new Image("Coin.png");
            ImageView coin = new ImageView();
            coin.setImage(img);
            coin.setFitHeight(20);
            coin.setFitWidth(20);
            coin.setX(x+i);
            coin.setY(y);
            anchorPane.getChildren().add(coin);
            GameObject g = new GameObject(coin, x+i, y, 50);
            gamearray.add(g);
        }

    }

}
