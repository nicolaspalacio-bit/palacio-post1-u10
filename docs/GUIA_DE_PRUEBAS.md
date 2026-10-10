# Guia Operativa de Pruebas Automatizadas (envios-service)

Este documento detalla el catalogo de pruebas automatizadas del microservicio `envios-service`, disenado bajo JUnit 5 con pruebas unitarias clasicas y pruebas parametrizadas con `@CsvSource`.

---

## 1. Resumen de la Suite de Pruebas (21 Casos de Prueba)

| Clase de Prueba | Metodo de Prueba | Casos Ejecutados | Proposito y Asercion |
| :--- | :--- | :---: | :--- |
| `EnvioEstandarStrategyTest` | `calculaCostoPorTramoDePesoYDistancia` | 4 | Valida tramos de peso (3 kg, 8 kg, 25 kg) y recargo de distancia > 500 km. |
| `EnvioExpressStrategyTest` | `calculaCostoPorTramoDePesoYDistancia` | 4 | Valida tramos de peso, factor multiplicador 1.3 y recargo > 500 km (+25). |
| `EnvioInternacionalStrategyTest` | `calculaCostoPorTramoDePesoYDistancia` | 4 | Valida tramos de peso base 50, tarifas por km y recargo > 5000 km (+100). |
| `EnvioOvernightStrategyTest` | `calculaCostoPorTramoDePeso` | 3 | Valida tramos de peso nocturno con tarifa base fija de 20. |
| `EnvioOvernightStrategyTest` | `rechazaDistanciasMayoresA300Km` | 1 | Valida rechazo con `IllegalArgumentException` cuando la distancia supera los 300 km. |
| `ServicioCalculoEnvioTest` | `calculaEnvioEstandarPesoBajo` | 1 | Flujo estandar regular base. |
| `ServicioCalculoEnvioTest` | `aplicaDescuentoClientePremium` | 1 | Valida reduccion del 10% para cliente `PREMIUM`. |
| `ServicioCalculoEnvioTest` | `aplicaDescuentoClienteCorporativo` | 1 | Valida reduccion del 15% para cliente `CORPORATIVO`. |
| `ServicioCalculoEnvioTest` | `aplicaRecargoPaqueteFragil` | 1 | Valida recargo adicional del 15% para envio fragil. |
| `ServicioCalculoEnvioTest` | `rechazaMetodoDeEnvioNoSoportado` | 1 | Valida excepcion `IllegalArgumentException` ante metodo invalido. |

**Total de Pruebas:** 21 pruebas automatizadas (todas en verde, 0 fallos, 0 errores).

---

## 2. Comandos de Ejecucion

### Ejecucion de Pruebas Unitarias
```bash
mvn test
```

### Ejecucion con Reporte de Cobertura JaCoCo
```bash
mvn clean test
# Inspeccionar reporte HTML en:
# target/site/jacoco/index.html
```

### Verificacion Completa de Construccion
```bash
mvn clean verify
```
