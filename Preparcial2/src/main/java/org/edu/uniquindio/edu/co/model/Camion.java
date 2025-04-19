package org.edu.uniquindio.edu.co.model;

public class                Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super();
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoEnvio(Ruta ruta, int numPaquetes, double pesoTotal, ZonaEntrega zona){
        double resultado = 0;
        double costoPeajes = ruta.getNumeroPeajes() * 12000;
        double CostoPorPeso = pesoTotal * 7000;
        resultado = costoPeajes + CostoPorPeso;
        return resultado;
    }
}
