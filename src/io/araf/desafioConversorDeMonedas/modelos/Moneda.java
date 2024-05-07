package io.araf.desafioConversorDeMonedas.modelos;

import java.util.Dictionary;
import java.util.List;

public record Moneda(String base_code,
                     String target_code,
                     float conversion_rate) {
}
