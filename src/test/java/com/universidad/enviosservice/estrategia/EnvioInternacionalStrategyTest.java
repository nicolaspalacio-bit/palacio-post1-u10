package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioInternacionalStrategyTest {

    private final EnvioInternacionalStrategy estrategia = new EnvioInternacionalStrategy();

    @ParameterizedTest
    @CsvSource({
        "3.0, 1000.0, 1850.0",
        "8.0, 1000.0, 1859.0",
        "25.0, 1000.0, 1917.5",
        "3.0, 6000.0, 10950.0"
    })
    void calculaCostoPorTramoDePesoYDistancia(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }
}
