/**
 * Sample Skeleton for 'Pause.fxml' Controller Class
 */

package com.example.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PauseController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="currentscore"
    private Label currentscore; // Value injected by FXMLLoader

    @FXML // fx:id="highscore"
    private Label highscore; // Value injected by FXMLLoader

    @FXML
    void dohome(ActionEvent event) throws IOException {
        System.out.println("home Reached ");
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void domusic(ActionEvent event) {

        // stop or start music

    }

    @FXML
    void dorestart(ActionEvent event) throws IOException {
        System.out.println("Game Restarted ");
        Parent root= FXMLLoader.load(getClass().getResource("Game.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void doresume(ActionEvent event) throws IOException {
        // same page with co-ordinates stored

        System.out.println("Resumed ");
        Parent root= FXMLLoader.load(getClass().getResource("Game.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void dosave(ActionEvent event) {
        System.out.println("Game Saved");

        //store the co-ordinates of the will hero

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert currentscore != null : "fx:id=\"currentscore\" was not injected: check your FXML file 'Pause.fxml'.";
        assert highscore != null : "fx:id=\"highscore\" was not injected: check your FXML file 'Pause.fxml'.";

    }

}
