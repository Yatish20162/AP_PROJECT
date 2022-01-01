package com.example.project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Orc extends GameObject {

    int upp_steps = 0;

    Orc(ImageView i, int x, int y, int widthx) {
        super(i, x, y, widthx);
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
}