package com.example.proyecto_c1.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Modelo extends ImageView {

    private int id;
    private Vector posicion;

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }

    public Modelo(Image image) {
        super(image);
    }

    public void setPosicion(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
