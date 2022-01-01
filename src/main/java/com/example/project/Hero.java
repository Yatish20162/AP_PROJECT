package com.example.project;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends GameObject{

    TranslateTransition transition ;
    TranslateTransition jump;
    TranslateTransition fall;

    Hero(ImageView i, int x, int y, int widthx) {

        super(i, x, y, widthx);
        jump=new TranslateTransition();
        fall=new TranslateTransition();
        jump.setNode(img);
        jump.setDuration(Duration.millis(1000));
        jump.setByY(-100);
        jump.setCycleCount(1);

        fall.setNode(img);
        fall.setDuration(Duration.millis(1000));
        fall.setByY(1);
        jump.setOnFinished(event -> {
            System.out.println(" jumppp " + img.getX()+" "+img.getY());
            fall.play();
        });

    }

    void animate(boolean flag)
    {
        if(flag)
        {
            fall.pause();
            jump.play();
        }
        else
        {
            fall.play();
        }
    }







}
