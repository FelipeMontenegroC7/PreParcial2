package org.edu.uniquindio.edu.co.model;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para probar el metodo calcularCostoDeEnvio
 * @author Felipe Montenegro
 * @since 2025-2
 *
 * Licencia GNU GPL V3
 */
class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());
    @BeforeEach
    void setUp() {
        Ruta rutaPrueba = new Ruta(12, 200);
        Vehiculo Camion = new Camion("PPRS12", "BMW", "2010", 20);
        Vehiculo furgoneta = new Furgoneta("PPRS12", "BMW", "2010", Transmision.MANUAL);
        Vehiculo motocicleta = new Motocicleta("PPRS12", "BMW", "2010", 250);
        Ruta rutaPrueba3 = new Ruta(12, 200);
    }

    @Test
    public void testCalcularCostoEnvio() {
        LOG.info("Inicializando prueba de CalcularCostoEnvio camion");
        Ruta rutaPrueba = new Ruta(12, 200);

        Vehiculo camion1 = new Camion("PPRS12", "BMW", "2010", 20);
        double actual1 = camion1.calcularCostoEnvio(rutaPrueba, 2, 20, ZonaEntrega.RURAL);
        double CostoEsperado1 = (12 * 12000) + (20 * 7000);
        assertEquals(CostoEsperado1, actual1, "El costo esperado difiere del resultado del metodo");

        LOG.info("Fin de la prueba calcularCosteEnvio camion");

        LOG.info("Inicializando prueba de CalcularCostoEnvio motocicleta");

        Vehiculo motocicleta1 = new Motocicleta("PPRS12", "BMW", "2010", 250);
        double actual2 = motocicleta1.calcularCostoEnvio(rutaPrueba, 2, 20, ZonaEntrega.RURAL);
        double CostoEsperado2 = 2 * 15000;

        assertEquals(CostoEsperado2, actual2, "El costo esperado difiere del resultado del metodo");

        LOG.info("Fin de la prueba calcularCosteEnvio motocicleta");

        LOG.info("Inicializando prueba de CalcularCostoEnvio furgoneta");

        Vehiculo furgoneta1 = new Furgoneta("PPRS12", "BMW", "2010", Transmision.MANUAL);
        double actual3 = furgoneta1.calcularCostoEnvio(rutaPrueba, 2, 20, ZonaEntrega.RURAL);
        double CostoEsperado3 = (200 * 3000) + 10000;

        assertEquals(CostoEsperado3, actual3, "El costo esperado difiere del resultado del metodo");

        LOG.info("Fin de la prueba calcularCosteEnvio furgoneta");
    }
}