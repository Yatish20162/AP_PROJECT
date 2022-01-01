/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
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
import javafx.stage.Stage;

public class HelloController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void dostart(ActionEvent event) throws IOException {
        GameController game=new GameController();
        System.out.println("Game started");
        Parent root= FXMLLoader.load(getClass().getResource("Game.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        game.start(scene);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

}
