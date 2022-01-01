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




    void start(Scene scene)
    {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode()==KeyCode.getKeyCode("Z"))
                {
                    for(int i=0;i< gamearray.size();i++)
                    {
                        gamearray.get(i).shiftleft();
                    }

                    // collisions


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


        int numIslands = 90;

        int picker = ran.nextInt(10);
        int orcpicker=ran.nextInt(5);
        int orcgetter=ran.nextInt(20);

        int islandGap = 0;


        willhero=(ImageView) scene.lookup("#willhero") ;
        anchorPane=(AnchorPane) scene.lookup("#anchorPane");

        hero=new Hero(willhero,0,220,20);

        for(int i=0; i<numIslands; i++){
            // we will generate random integer
            System.out.println(islandGap);
            String s=platformList.get(picker);
            if(orcgetter < 10)
            {
                String o=orcsList.get(orcpicker);
                generate_orcs(o,islandGap);

            }
            picker = ran.nextInt(10);
            orcpicker=ran.nextInt(5);
            orcgetter=ran.nextInt(20);

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

        return width;
    }

    void generate_orcs(String o,int x)
    {

        System.out.println(" ORCS PRINTINlnd.");

        int y=220-40;
        Image img=new Image(o);
        ImageView orcs=new ImageView();
        orcs.setImage(img);
        orcs.setFitHeight(40);
        orcs.setFitWidth(40);
        orcs.setX(x);
        orcs.setY(y);

        anchorPane.getChildren().add(orcs);
        GameObject g=new GameObject(orcs,x,y,50);
        gamearray.add(g);


    }


//    @FXML // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        start();
//
//
//    }

}
