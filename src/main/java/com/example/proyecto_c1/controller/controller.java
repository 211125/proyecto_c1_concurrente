package com.example.proyecto_c1.controller;

import com.example.proyecto_c1.models.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;

public class controller implements Observer {

    private Line linea;
    private Circle per;
    private Personaje personaje;
    private Modelo modelo;

    private Enemigos enemigo1;
    private Enemigos enemigo2;
    private Semaphore puente1;
    private Semaphore puente2;
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane rootScene;
    @FXML
    private Button btnPreparar;

    @FXML
    private Button btnsaltar;

    @FXML
    public void initialize(){
        // ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/styles/img/fondo.jpg")));
       // rootScene.getChildren().add(fondo);
        linea = new Line(600,162,0,162);
        linea.setStrokeWidth(5);
        linea.setStroke(Color.BLUE);
        rootScene.getChildren().add(linea);
        //personaje principal
        per = new Circle(10,Color.WHITE);
        per.setLayoutY(150);
        per.setLayoutX(60);
        rootScene.getChildren().add(per);

    }


    @FXML
    void btnPrepararOnMouse(MouseEvent event) {

    }

    @FXML
    void btnSaltarOnMouse(MouseEvent event) {
        personaje = new Personaje();
        personaje.setPosicion(new Vector(1,140,60));
        personaje.addObserver(this);
        new Thread(personaje).start();
            System.out.println("hola");

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Thread.currentThread().getName());
        Vector pos = (Vector)arg;
        switch (pos.getId()){
            case 1:
                Platform.runLater(()->per.setLayoutY(pos.getY()));
                break;
        }



    }

}