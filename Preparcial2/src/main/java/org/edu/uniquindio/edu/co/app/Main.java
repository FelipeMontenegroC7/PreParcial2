package org.edu.uniquindio.edu.co.app;
import org.edu.uniquindio.edu.co.model.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Crear empresa
        String nombreEmpresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa:");
        String nit = JOptionPane.showInputDialog("Ingrese el NIT de la empresa:");
        EmpresaDeMensajeria empresa = new EmpresaDeMensajeria(nombreEmpresa, nit);
        JOptionPane.showMessageDialog(null, "Bienvenido a " + nombreEmpresa);

        // Crear cliente
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");

        Cliente cliente = new Cliente(nombreCliente, cedula, correo, direccion);
        empresa.agregarCliente(cliente);

        // Código del envío
        String codigoEnvio = JOptionPane.showInputDialog("Ingrese el código del envío:");

        // Zona de entrega
        String[] opcionesZona = {"RURAL", "URBANA"};
        int seleccionZona = JOptionPane.showOptionDialog(null, "Seleccione la zona de entrega:", "Zona",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesZona, opcionesZona[0]);

        ZonaEntrega zonaSeleccionada = (seleccionZona == 0) ? ZonaEntrega.RURAL : ZonaEntrega.URBANA;

        // Ruta
        int peajes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de peajes:"));
        int distancia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la distancia (en km):"));
        Ruta ruta = new Ruta(peajes, distancia);

        // Vehículo
        String[] tiposVehiculo = {"Camión", "Furgoneta", "Motocicleta"};
        int tipoVehiculo = JOptionPane.showOptionDialog(null, "Tipo de vehículo:", "Vehículo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposVehiculo, tiposVehiculo[0]);

        Vehiculo vehiculo = null;
        String placa = JOptionPane.showInputDialog("Ingrese la placa:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");

        switch (tipoVehiculo) {
            case 0 -> {
                double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga (kg):"));
                vehiculo = new Camion(placa, marca, modelo, capacidad);
            }
            case 1 -> {
                String[] transmisiones = {"Manual", "Automática"};
                int tipoTransmision = JOptionPane.showOptionDialog(
                        null,
                        "Transmisión:",
                        "Furgoneta",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        transmisiones,
                        transmisiones[0]
                );

                Transmision transmisionSeleccionada = (tipoTransmision == 0) ? Transmision.MANUAL : Transmision.AUTOMATICA;

                vehiculo = new Furgoneta(placa, marca, modelo, transmisionSeleccionada);
            }

            case 2 -> {
                int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Cilindrada de la moto:"));
                vehiculo = new Motocicleta(placa, marca, modelo, cilindrada);
            }
        }

        // Lista de paquetes
        List<Paquete> listaPaquetes = new ArrayList<>();
        int cantidadPaquetes = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos paquetes desea agregar?"));
        for (int i = 0; i < cantidadPaquetes; i++) {
            String codigo = JOptionPane.showInputDialog("Código del paquete " + (i + 1));
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso del paquete " + (i + 1) + " (kg):"));
            listaPaquetes.add(new Paquete(codigo, peso));
        }

        // Crear envío
        Date fechaEnvio = new Date();
        Envio envio = new Envio(codigoEnvio, zonaSeleccionada, fechaEnvio, vehiculo, ruta);

        // Agregar paquetes al envío
        for (Paquete paquete : listaPaquetes) {
            envio.agregarPaquete(paquete);
        }
        // Calcular costo y asignarlo
        double costo = envio.calcularCostoEnvio();
        envio.setTotalCosto(costo);

        // Asociar el envío al cliente
        cliente.realizarEnvio(envio);

        // Mostrar confirmación
        JOptionPane.showMessageDialog(null, "¡Envío realizado con éxito!\n" +
                "Código: " + envio.getCodigoEnvio() +
                "\nTotal: $" + costo +
                "\nFecha: " + fechaEnvio);

}
}
