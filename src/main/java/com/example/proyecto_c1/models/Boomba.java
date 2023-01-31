package com.example.proyecto_c1.models;

import java.util.Observable;
import java.util.Random;

public class Boomba extends Observable implements Runnable{

    private VectorBoomba posicion;

    private int distanciaX;
    private int distanciaY;
    private Random random;
    private boolean status = true;

    public Boomba() {

        random = new Random(System.currentTimeMillis());
        posicion = new VectorBoomba();

    }



    public VectorBoomba getPos() {
        return posicion;
    }



    public void setPosicion(){

        posicion.setX(569);
        posicion.setY(237);
        distanciaX = 50;
        distanciaY = 50;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
    @Override
    public void run() {
        while(status) {
            this.setChanged();
            this.notifyObservers(this.posicion);

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            posicion.setX(posicion.getX() - distanciaX);
            posicion.setY(posicion.getY() - distanciaY);

            if (posicion.getX() >= 590)
                distanciaX *= -1;
            /*
            if (pos.getX() < 10)
                distanciaX *= -1;*/
            if (posicion.getY() < 400)
                distanciaY *= -1;
            if (posicion.getY() >= 490)
                distanciaY *= -1;
        }

    }
}
