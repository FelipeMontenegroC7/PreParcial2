package org.edu.uniquindio.edu.co.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Cliente {
    private String nombre;
    private String cedula;
    private String correo;
    private String direccion;
    private List<Envio> listaEnvios;

    public Cliente(String nombre, String cedula, String correo, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.direccion = direccion;
        this.listaEnvios = new ArrayList<>();
    }

    public String realizarEnvio(Envio envio) {
        String mensaje = "";
        Optional<Envio> envioEmcontrado = buscarEnvio(envio.getCodigoEnvio());
        if(!envioEmcontrado.isPresent()) {
            listaEnvios.add(envio);
            mensaje = "Envio realizado exitosamente";
        }else{
            mensaje = "Este envio ya ha sidfo realizado";
        }
        return mensaje;
    }

    private Optional<Envio> buscarEnvio(String codigoEnvio) {
        return listaEnvios.stream().filter(envio -> envio.getCodigoEnvio().equals(codigoEnvio)).findFirst();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
