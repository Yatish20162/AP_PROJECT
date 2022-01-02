package com.example.project;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends GameObject{

    Helmet helmet;
    String name;
    double score;
    double coins;

    int upp_steps=0;

    Hero(ImageView i,double x, double y, double widthx, double height) {
        super(i, x, y, widthx, height);
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                            if(upp_steps>0)
                            {
                                img.setY(img.getY()-1);
                                upp_steps--;
                            }
                            else
                            {
                                img.setY(img.getY()+1);
                            }
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }



    public void setCoins(double coins) {
        this.coins = coins;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public double getCoins() {
        return coins;
    }
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }







}
