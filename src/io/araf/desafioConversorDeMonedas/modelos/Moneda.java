package io.araf.desafioConversorDeMonedas.modelos;

import java.util.List;

public record Moneda(String result,
                     String base_code,
                     List<Integer> conversion_rate) {
}
