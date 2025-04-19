package org.edu.uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Envio {
    private String codigoEnvio;
    private ZonaEntrega zonaEntrega;
    private Date fechaEnvio;
    private double totalCosto;
    private List<Paquete> listaPaquetes;
    private Vehiculo vehiculo;
    private Ruta ruta;

    public Envio(String codigoEnvio, ZonaEntrega zonaEntrega, Date fechaEnvio, Vehiculo vehiculo, Ruta ruta) {
        this.codigoEnvio = codigoEnvio;
        this.zonaEntrega = zonaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.vehiculo = vehiculo;
        this.ruta = ruta;
        this.listaPaquetes = new ArrayList<>();
        this.totalCosto = 0;
    }

    public String agregarPaquete(Paquete paquete) {
        String mensaje = "";
        Optional<Paquete> paqueteEncontrado = buscarPaquete(paquete.getCodigo());
        if (!paqueteEncontrado.isPresent()) {
            listaPaquetes.add(paquete);
            mensaje = "Paquete agrgado exitosamente";
        }else{
            mensaje = "el paquete ya existe";
        }
        return mensaje;
    }

    public double calcularCostoEnvio() {
        double pesoTotal = listaPaquetes.stream().mapToDouble(Paquete::getPeso).sum();
        int cantidadPaquetes = listaPaquetes.size();
        this.totalCosto = vehiculo.calcularCostoEnvio(ruta, cantidadPaquetes, pesoTotal, zonaEntrega);
        return this.totalCosto;
    }


    private Optional<Paquete> buscarPaquete(String codigoPaquete) {
        return listaPaquetes.stream().filter(paqueteAux -> paqueteAux.getCodigo().equals(codigoPaquete)).findFirst();
    }
    public double getTotalCosto() {
        return totalCosto;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public void setTotalCosto(double totalCosto) {
        this.totalCosto = totalCosto;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public ZonaEntrega getZonaEntrega() {
        return zonaEntrega;
    }

    public void setZonaEntrega(ZonaEntrega zonaEntrega) {
        this.zonaEntrega = zonaEntrega;
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }
}
