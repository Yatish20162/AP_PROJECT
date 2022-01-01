/**
 * Sample Skeleton for 'Game.fxml' Controller Class
 */

package com.example.project;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
        // if conditions required on the basis of the island clash

        TranslateTransition transition=new TranslateTransition();
        transition.setNode(willhero);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setByY(-100);
        transition.play();
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
                }
            }
        });



        ArrayList<String> platformList = new ArrayList<String>();
        platformList.add("Islands1.png");
        platformList.add("Islands2.png");
        platformList.add("Islands3.png");
        platformList.add("Islands4.png");
        platformList.add("Islands5.png");
        platformList.add("Islands6.png");
        platformList.add("Islands7.png");
        platformList.add("Islands8.png");
        platformList.add("Islands9.png");
        platformList.add("Islands10.png");


        willhero=(ImageView) scene.lookup("#willhero") ;
        anchorPane=(AnchorPane) scene.lookup("#anchorPane");
        move();
        for(int i=0;i<9;i++){
            int x;
            // we will generate random integer
            x=i*120;
            System.out.println(x);
            String s=platformList.get(i);
            generte_islansd(s,x);
        }

    }

    void generte_islansd(String s,int x)
    {
        int y=220;
        Image img=new Image(s);
        ImageView island1=new ImageView();
        island1.setImage(img);
        island1.setFitHeight(50);
        island1.setFitWidth(100);
        island1.setX(x);
        island1.setY(y);

        anchorPane.getChildren().add(island1);
        GameObject g=new GameObject(island1,x,y,50);
        gamearray.add(g);
    }

    void generate_orcs()
    {

    }


//    @FXML // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        start();
//
//
//    }

}
