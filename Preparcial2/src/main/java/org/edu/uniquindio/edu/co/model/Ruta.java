package org.edu.uniquindio.edu.co.model;

public class Ruta {
    private int numeroPeajes;
    private double distanciaKms;

    public Ruta(int numeroPeajes, double distanciaKms) {
        this.numeroPeajes = numeroPeajes;
        this.distanciaKms = distanciaKms;
    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public void setNumeroPeajes(int numeroPeajes) {
        this.numeroPeajes = numeroPeajes;
    }

    public double getDistanciaKms() {
        return distanciaKms;
    }

    public void setDistanciaKms(double distanciaKms) {
        this.distanciaKms = distanciaKms;
    }
}
