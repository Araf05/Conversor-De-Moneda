package io.araf.desafioConversorDeMonedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moneda {
    private String time;
    private String base_code;
    private String target_code;
    private float base_value;
    private float conversion_value;
    private float result;

    public Moneda(MonedaERA monedaERA, float base_value) {
        this.base_code = monedaERA.base_code();
        this.target_code = monedaERA.target_code();
        this.conversion_value = monedaERA.conversion_rate();
        this.base_value = base_value;
    }

    private void calcular() {
        result = conversion_value * base_value;
    }

    private void time(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.time = ahora.format(formatter);
    }

    public void mostrar () {
        calcular();
        time();
        String resultado = """
                ==============================================================
                %s
                El valor %.4f [%s] corresponde al valor final de ==> %.4f [%s]
                
                ==============================================================
                """.formatted(time, base_value, base_code, result, target_code);
        System.out.println(resultado);
    }
}
