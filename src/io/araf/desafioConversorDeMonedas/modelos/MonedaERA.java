package io.araf.desafioConversorDeMonedas.modelos;

public record MonedaERA(String base_code,
                     String target_code,
                     float conversion_rate) {
}
