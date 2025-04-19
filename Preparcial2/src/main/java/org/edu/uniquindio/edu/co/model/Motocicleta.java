package org.edu.uniquindio.edu.co.model;

public class Motocicleta extends Vehiculo {
    private int cilindrada;
    public Motocicleta(String placa, String marca, String modelo, int cilindrada) {
        super();
        this.cilindrada = cilindrada;
    }
    @Override
    public double calcularCostoEnvio(Ruta ruta, int numPaquetes, double pesoTotal, ZonaEntrega zona){
        double resultado = 0;
        if(zona.equals(ZonaEntrega.RURAL)){
            resultado = numPaquetes * 15000;
        }else if(zona.equals(ZonaEntrega.URBANA)) {
            resultado = numPaquetes * 8000;
        }
        return resultado;
    }
}
