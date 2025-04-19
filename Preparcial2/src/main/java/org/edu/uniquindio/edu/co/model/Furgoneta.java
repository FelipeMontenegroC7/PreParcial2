package org.edu.uniquindio.edu.co.model;

public class Furgoneta extends Vehiculo {
    private Transmision transmision;
    public Furgoneta(String placa, String marca, String modelo, Transmision transmision) {
        super();
        this.transmision = transmision;
    }
    @Override
    public double calcularCostoEnvio(Ruta ruta, int numPaquetes, double pesoTotal, ZonaEntrega zona){
        double resultado = 0;
        double Costoklilometros = ruta.getDistanciaKms() * 3000;
        double fleteFijo = 10000;
        resultado = Costoklilometros + fleteFijo;
        return resultado;
    }
}
