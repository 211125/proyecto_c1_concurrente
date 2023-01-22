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
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;

public class controller implements Observer {

    private Line linea;
    private Circle per;

    private Rectangle recEne;
    private Personaje personaje;
    private Modelo modelo;

    private Enemigos enemigo1;
    private UpdateArgs data;

    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane rootScene;
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnsaltar;


    @FXML
    void btnIniciarOnMouse(MouseEvent event) {
       enemigo1 = new Enemigos();
       //VectorEnemigo(1,590,150)
        enemigo1.setPosicion(new VectorEnemigo(1,22,116));
        enemigo1.addObserver(this);
        new Thread(enemigo1).start();
        System.out.println("no mames ");

    }

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
        recEne = new Rectangle(522, 116, 80, 50);
        rootScene.getChildren().add(recEne);


    }



    @FXML
    void btnSaltarOnMouse(MouseEvent event) {
        personaje = new Personaje();
        personaje.setPosicion(new Vector(140,60));
        personaje.addObserver(this);
        new Thread(personaje).start();
            System.out.println("hola");

    }

    @Override
    public void update(Observable o, Object arg) {
      //  UpdateArgs dato =(UpdateArgs)arg;

        System.out.println(Thread.currentThread().getName());
       Vector pos = (Vector)arg;
        VectorEnemigo posi = (VectorEnemigo) arg;
      //  Platform.runLater(()->per.setLayoutY(pos.getY()));
        Platform.runLater(()->recEne.setLayoutX(posi.getX_enemigo()));
      //  VectorEnemigo posE = dato.getEnem1();
        //Vector pos = dato.getOb1();
          //  Platform.runLater(()->per.setLayoutY(dato.getOb1().getY()));
          //  Platform.runLater(()->recEne.setLayoutX(dato.getEnem1().getX_enemigo()));
        if (posi.getX_enemigo() + 10 < -600){
            enemigo1.setStatus(false);
            enemigo1 = new Enemigos();
            //VectorEnemigo(1,590,150)
            enemigo1.setPosicion(new VectorEnemigo(1,22,116));
            enemigo1.addObserver(this);
            new Thread(enemigo1).start();

        }
    }


}