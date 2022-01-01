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
//        TranslateTransition jump=new TranslateTransition();
//        jump.setNode(img);
//        jump.setByY(-100);
//        jump.setAutoReverse(false);
//        jump.play();

        jump=new TranslateTransition();
        fall=new TranslateTransition();
        jump.setNode(img);
        jump.setDuration(Duration.millis(5000));
        jump.setByY(-100);



        fall.setNode(img);
        fall.setDuration(Duration.millis(5000));
        fall.setByY(100);



        jump.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(" jumppp ");
                fall.play();
            }
        });

        fall.play();

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
