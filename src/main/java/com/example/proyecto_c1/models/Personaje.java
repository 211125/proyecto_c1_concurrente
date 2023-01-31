package com.example.proyecto_c1.models;

import java.util.Observable;
import java.util.Random;

public class Personaje extends Observable implements Runnable{
    private Vector posicion;
    private boolean statusAriba;
    private boolean statusAbajo;

    public Personaje() {
        statusAriba = true;
        statusAbajo = true;

    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }

    public void setStatusAriba(boolean statusAriba) {
        this.statusAriba = statusAriba;
    }
    public void setStatusAbajo(boolean statusAbajo) {this.statusAbajo = statusAbajo;}


    @Override
    public void run() {
      while (statusAriba){
          posicion.setY(posicion.getY()-10);
          setChanged();
          notifyObservers(posicion);

          try {
              Thread.sleep(50L);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          if ( posicion.getY() < 66){
              while (statusAbajo){
                  posicion.setY(posicion.getY()+10);
                  setChanged();
                  notifyObservers(posicion);
                  try {
                      Thread.sleep(50L);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  if (posicion.getY()>238){
                      setStatusAriba(false);
                      setStatusAbajo(false);
                  }
              }
          }
      }
    }
}
