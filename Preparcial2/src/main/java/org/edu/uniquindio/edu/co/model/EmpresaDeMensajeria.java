package org.edu.uniquindio.edu.co.model;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpresaDeMensajeria {
    private String nombre;
    private String nit;
    private List<Cliente> listaClientes;
    private List<Vehiculo> listaVehiculos;

    public EmpresaDeMensajeria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaVehiculos = new ArrayList<Vehiculo>();
    }

    public String agregarVehiculo(Vehiculo vehiculo) {
        String mensaje = "";
        Optional<Vehiculo> vehiculoEncontrado = buscarVehiculo(vehiculo.getPlaca());
        if (vehiculoEncontrado.isPresent()) {
            mensaje = "Vehiculo ya existe en la lista de vehiculos";
        }else {
            listaVehiculos.add(vehiculoEncontrado.get());
            mensaje = "Vehiculo registrado correctamente";
        }
        return mensaje;
    }
    public String mostrarVehiculos() {
        String mensaje = "";
        if(!listaVehiculos.isEmpty()) {
        for (Vehiculo vehiculoaux : listaVehiculos) {
            mensaje += vehiculoaux.toString() + "\n";
        }
        }else {
            mensaje = "No se encontraron vehiculos";
        }
        return mensaje;
    }

    public String eliminarVehiculo(String placa) {
        String mensaje = "";
        Optional<Vehiculo> vehiculoEliminar = buscarVehiculo(placa);
        if (vehiculoEliminar.isPresent()) {
            listaVehiculos.remove(vehiculoEliminar.get());
            mensaje = "Vehiculo eliminado correctamente";
        }else{
            mensaje = "Vehiculo no encontrado para eliminar";
        }
        return mensaje;
    }

    public String editarVehiculo(String placa, Vehiculo vehiculo) {
        String mensaje = "";
        Optional<Vehiculo> vehiculoEditar = buscarVehiculo(placa);
        if (vehiculoEditar.isPresent()) {
            Vehiculo vehiculoReemplazo = vehiculoEditar.get();
            int indice = listaVehiculos.indexOf(vehiculoReemplazo);
            listaVehiculos.set(indice, vehiculo);
            mensaje = "Vehiculo editado correctamente";
        }else{
            mensaje = "Vehiculo no encontrado para editar";
        }
        return mensaje;
    }

    public String agregarCliente(Cliente cliente) {
        String mensaje = "";
        Optional<Cliente> ClienteEncontrado = buscarCliente(cliente.getCedula());
        if(ClienteEncontrado.isPresent()) {
            mensaje = "Cliente ya existe en la lista de clientes";
        }else{
            listaClientes.add(cliente);
            mensaje = "Cliente registrado correctamente";
        }
        return mensaje;
    }

    public String mostrarClientes () {
        String mensaje = "";
        if(!listaClientes.isEmpty()) {
        for (Cliente cliente : listaClientes) {
                mensaje += cliente.toString() + "\n";
            }
        }else{
            mensaje = "lista Clientes esta vacia";
        }
        return mensaje;
    }

    public String editarCliente(String cedula, Cliente cliente) {
        String mensaje = "";
        Optional<Cliente> ClienteEditar = buscarCliente(cedula);
        if (ClienteEditar.isPresent()) {
            Cliente clienteReemplazo = ClienteEditar.get();
            int indice = listaClientes.indexOf(clienteReemplazo);
            listaClientes.set(indice, cliente);
            mensaje = "Cliente editado correctamente";
        }else{
            mensaje = "Cliente no encontrado para editar";
        }
        return mensaje;
    }

    public String eliminarCliente(String cedula) {
        String mensaje = "";
        Optional<Cliente> ClienteEliminar = buscarCliente(cedula);
        if (ClienteEliminar.isPresent()) {
            listaClientes.remove(ClienteEliminar.get());
        }else{
            mensaje = "Cliente no encontrado para eliminar";
        }
        return mensaje;
    }

    private Optional<Cliente> buscarCliente(String cedula) {
        return listaClientes.stream().filter(clienteAux -> clienteAux.getCedula().equals(cedula)).findFirst();
    }

    private Optional<Vehiculo> buscarVehiculo(String placa){
        return listaVehiculos.stream().filter(vehiculoAux -> vehiculoAux.getPlaca().equals(placa)).findFirst();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}

