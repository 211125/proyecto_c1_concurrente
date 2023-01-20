package com.example.proyecto_c1.models;

import java.util.Observable;
import java.util.Random;

public class Personaje extends Observable implements Runnable{
    private Vector posicion;
    private boolean status;
    private Random random;

    public Personaje() {
        status = true;
        random = new Random(System.currentTimeMillis());
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void run() {
      while (status){
          posicion.setY(posicion.getY()+1);
          setChanged();
          notifyObservers(posicion);

          try {
              Thread.sleep(50L);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          if ( posicion.getY() > 170){
              setStatus(false);
          }
      }
    }
}
