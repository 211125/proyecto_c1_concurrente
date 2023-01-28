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

        posicion.setX(500);
        posicion.setY(400);
        distanciaX = 50;
        distanciaY = 50;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
    @Override
    public void run() {
        while(status) {
            //Notificar cambio
            this.setChanged();
            this.notifyObservers(this.posicion);
            //Dormir el hilo
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Realizar nuevos cálculos
            posicion.setX(posicion.getX() - distanciaX);
            posicion.setY(posicion.getY() - distanciaY);
            System.out.println(posicion.getX()+":"+posicion.getY());

            if (posicion.getX() >= 590)
                distanciaX *= -1;
            /*
            if (pos.getX() < 10)
                distanciaX *= -1;*/
            if (posicion.getY() < 200)
                distanciaY *= -1;
            if (posicion.getY() >= 490)
                distanciaY *= -1;
        }

    }
}
