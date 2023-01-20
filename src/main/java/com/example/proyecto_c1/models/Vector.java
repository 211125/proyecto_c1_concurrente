package com.example.proyecto_c1.models;

public class Vector {
    private int id;
    private int y;
    private int x;

    public Vector(int id, int y, int x) {
        this.id = id;
        this.y = y;
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
