package com.example.proyecto_c1.models;


import javafx.scene.image.ImageView;

import java.util.Observable;

public class Obstaculos extends ImageView {

    private int id;
    private Vector posicion;

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }

}
