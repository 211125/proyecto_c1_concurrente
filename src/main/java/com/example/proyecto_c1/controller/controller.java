package com.example.proyecto_c1.controller;

import com.example.proyecto_c1.models.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.proyecto_c1.models.Boomba;
import com.example.proyecto_c1.models.Personaje;
import com.example.proyecto_c1.models.VectorBoomba;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class controller implements Observer {
    private ImageView villano;

    private Personaje personaje;
    private ImageView perosaje;

    @FXML
    private AnchorPane rootScene;
    @FXML
    private ImageView bomba;
    @FXML
    private Button btnCrear;


    @FXML
    private Button btnSalir;
    @FXML
    private Button btnSaltar;

    private Boomba boomba;
    private Enemigos enemigo1;
    @FXML
    public void initialize(){

        villano = new ImageView(new Image(getClass().getResourceAsStream("/styles/img/enemigo.gif")));
        villano.setFitWidth(70);
        villano.setFitHeight(70);
        villano.setLayoutX(530);
        villano.setLayoutY(200);
        rootScene.getChildren().add(villano);

        //  per = new Circle(10,Color.WHITE);
        perosaje = new ImageView(new Image(getClass().getResourceAsStream("/styles/img/caminar.gif")));
        perosaje.setFitWidth(50);
        perosaje.setFitHeight(50);
        perosaje.setLayoutY(200);
        perosaje.setLayoutX(60);
        rootScene.getChildren().add(perosaje);


    }
    @FXML
    void btnSaltarKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE){
            personaje = new Personaje();
            personaje.setPosicion(new Vector(80,60));
            personaje.addObserver(this);
            new Thread(personaje).start();
            System.out.println("hola");
        }
    }
    @FXML
    void btnCrearOnMouse(MouseEvent event) {
        enemigo1 = new Enemigos();
        //VectorEnemigo(1,590,150)
        enemigo1.setPosicion(new VectorEnemigo(1,530,94));
        enemigo1.addObserver(this);
        new Thread(enemigo1).start();
        //
        boomba = new Boomba();
        boomba.addObserver(this);
        boomba.setPosicion();
        Thread hilo01 = new Thread(boomba);
        hilo01.setDaemon(true);
        hilo01.start();
    }


    @FXML
    void btnSalirOnMouse(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Enemigos){
            VectorEnemigo posi = (VectorEnemigo) arg;
            Platform.runLater(()->villano.setLayoutX(posi.getX_enemigo()));
            if (posi.getX_enemigo() + 10 < -300) {
                enemigo1.setStatus(false);
                enemigo1 = new Enemigos();
                //VectorEnemigo(1,590,150)
                enemigo1.setPosicion(new VectorEnemigo(1, 530, 94));
                enemigo1.addObserver(this);
                new Thread(enemigo1).start();
            }
        } else if (o instanceof Personaje) {
               Vector pos = (Vector)arg;
             Platform.runLater(()->perosaje.setLayoutY(pos.getY()));

        }else {
            VectorBoomba pos = (VectorBoomba)arg;

            bomba.setLayoutX (pos.getX());
            bomba.setLayoutY (pos.getY());
            if (pos.getX() < 10){
                boomba.setStatus(false);
                boomba = new Boomba();
                boomba.addObserver(this);
                boomba.setPosicion();
                Thread hilo01 = new Thread(boomba);
                hilo01.setDaemon(true);
                hilo01.start();
            }
        }

    }

}