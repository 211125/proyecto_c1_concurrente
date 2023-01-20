package com.example.proyecto_c1.models;

import javafx.scene.image.ImageView;

public class Modelo extends ImageView {

    private int id;
    private Vector posicion;

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
}
