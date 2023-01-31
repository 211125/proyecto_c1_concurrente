package com.example.proyecto_c1.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Random;

public class Enemigos extends Observable implements Runnable {
    private VectorEnemigo posicion;
    private boolean status;
    private Random random;

    public Enemigos() {
        status = true;
        random = new Random(System.currentTimeMillis());
    }

    public void setPosicion(VectorEnemigo posicion) {
        this.posicion = posicion;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    @Override
    public void run() {
        while (status){
           posicion.setX_enemigo(posicion.getX_enemigo()-random.nextInt(30));
           // posicion.getEnem1().setX_enemigo(posicion.getEnem1().getX_enemigo()-10);
            setChanged();
            notifyObservers(posicion);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            posicion.setY_enemigo(posicion.getY_enemigo()-(random.nextInt(41)+10));
        }
    }
}
