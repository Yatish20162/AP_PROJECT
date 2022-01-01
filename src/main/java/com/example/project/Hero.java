package com.example.project;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends GameObject{


    Hero(ImageView i, int x, int y, int widthx) {

        super(i, x, y, widthx);

        TranslateTransition transition=new TranslateTransition();
        transition.setNode(i);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setByY(-100);
        transition.play();

    }







}
