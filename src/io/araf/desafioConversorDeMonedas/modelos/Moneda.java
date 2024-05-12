package io.araf.desafioConversorDeMonedas.modelos;

public class Moneda {
    private String base_code;
    private String target_code;
    private float base_value;
    private float conversion_value;

    public Moneda(MonedaERA monedaERA, float base_value) {
        this.base_code = monedaERA.base_code();
        this.target_code = monedaERA.target_code();
        this.conversion_value = monedaERA.conversion_rate();
        this.base_value = base_value;
    }

    public float calcular() {
        return conversion_value * base_value;
    }

    public void mostrar () {
        String resultado = """
                ==============================================================
                
                El valor %f [%s] corresponde al valor final de ==> %f [%s]
                
                ==============================================================
                """.formatted(base_value, base_code, this.calcular(), target_code);
        System.out.println(resultado);
    }
}
