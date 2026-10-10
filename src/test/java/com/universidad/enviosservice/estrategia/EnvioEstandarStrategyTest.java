package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioEstandarStrategyTest {

    private final EnvioEstandarStrategy estrategia = new EnvioEstandarStrategy();

    @ParameterizedTest
    @CsvSource({
        "3.0, 100.0, 50.0",
        "8.0, 100.0, 52.4",
        "25.0, 100.0, 68.0",
        "3.0, 600.0, 310.0"
    })
    void calculaCostoPorTramoDePesoYDistancia(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }
}
