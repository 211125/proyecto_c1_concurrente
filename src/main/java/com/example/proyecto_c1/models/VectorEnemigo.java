package com.example.proyecto_c1.models;

public class VectorEnemigo {
    private int id_enemigo;
    private int y_enemigo;
    private int x_enemigo;




    public VectorEnemigo(int id_enemigo, int x_enemigo, int y_enemigo) {
        this.id_enemigo = id_enemigo;
        this.y_enemigo = y_enemigo;
        this.x_enemigo = x_enemigo;
    }


    public int getId_enemigo() {
        return id_enemigo;
    }

    public void setId_enemigo(int id_enemigo) {
        this.id_enemigo = id_enemigo;
    }

    public int getY_enemigo() {
        return y_enemigo;
    }

    public void setY_enemigo(int y_enemigo) {
        this.y_enemigo = y_enemigo;
    }

    public int getX_enemigo() {
        return x_enemigo;
    }

    public void setX_enemigo(int x_enemigo) {
        this.x_enemigo = x_enemigo;
    }

}
