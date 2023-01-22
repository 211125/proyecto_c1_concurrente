package com.example.proyecto_c1.models;


public class UpdateArgs {
    private VectorEnemigo enem1;
    private Vector ob1;

    public UpdateArgs() {
        this.enem1 = getEnem1();
        this.ob1 = getOb1();
    }

    public VectorEnemigo getEnem1() {
        return enem1;

    }

    public VectorEnemigo setEnem1(VectorEnemigo enem1) {
        this.enem1 = enem1;
        return null;
    }

    public Vector getOb1() {
        return ob1;
    }

    public void setOb1(Vector ob1) {
        this.ob1 = ob1;
    }
}