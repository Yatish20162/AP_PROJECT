/**
 * Sample Skeleton for 'Game.fxml' Controller Class
 */

package com.example.project;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="coins"
    private Label coins; // Value injected by FXMLLoader

    @FXML // fx:id="willhero"
    private ImageView willhero; // Value injected by FXMLLoader

    @FXML // fx:id="island1"
    private ImageView island1; // Value injected by FXMLLoader


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

//        scene.setOnKeyPressed(keyEvent -> {
//            if(keyEvent.getCode()== KeyCode.SPACE)
//            {
//                move();
//            }
//        });
        willhero=(ImageView) scene.lookup("#willhero") ;
        move();
        InputStream stream = getClass().getResourceAsStream("src\\main\\resources\\com\\example\\project\\Islands1.png");
        Image newImage = new Image(stream);
        island1.setImage(newImage);

    }
//    @FXML // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        start();
//
//
//    }

}
