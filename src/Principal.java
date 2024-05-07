import io.araf.desafioConversorDeMonedas.modelos.ConsultaConversionDeMoneda;
import io.araf.desafioConversorDeMonedas.modelos.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversionDeMoneda consulta = new ConsultaConversionDeMoneda();

        Moneda moneda = consulta.buscarMoneda("USD" , "ARS");
        System.out.println(moneda);
        // reales , ARS, USD, POLICÍA
        String menu = """
                **************************
                MENU
                1- Dolar ==> Peso Argentino
                2- Peso Argentino ==> Dolar
                3- Dolar ==> Real Brasileño
                4- Real Brasileño ==> Dolar
                5- Dolar ==> Peso Colombiano
                6- Peso Colombiano ==> Dolar
                7- Salir
                
                Elija una opcion válida: 
                **************************
                """;

    }
}
