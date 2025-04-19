package org.edu.uniquindio.edu.co.model;

public abstract class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;

    public abstract double calcularCostoEnvio(Ruta ruta, int numPaquetes, double pesoTotal, ZonaEntrega zona);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
