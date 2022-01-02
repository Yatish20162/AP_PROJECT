package com.example.project;

import javafx.scene.image.ImageView;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Orcs extends Living {

    int size;
    int color;
    int upp_steps = 0;


    Orcs(ImageView i, double x, double y, double widthx, double height) {
        super(i, x, y, widthx,height);
        //TODO Auto-generated constructor stub
        this.size = size;
        this.color = color;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (upp_steps > 0) {
                            i.setY(i.getY() - 1);
                            upp_steps--;
                        } else {
                            i.setY(i.getY() + 1);
                        }
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
