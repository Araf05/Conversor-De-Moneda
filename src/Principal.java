import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.araf.desafioConversorDeMonedas.modelos.ConsultaConversionDeMoneda;
import io.araf.desafioConversorDeMonedas.modelos.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        ConsultaConversionDeMoneda consulta = new ConsultaConversionDeMoneda();

        // BRL , ARS, USD, COP
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
        while (true) {
            System.out.println(menu);
            Moneda moneda = null;
            int opcion = Integer.parseInt(lectura.nextLine());
            switch (opcion) {
                case 1:
                    moneda = consulta.buscarMoneda("USD" , "ARS");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 2:
                    moneda = consulta.buscarMoneda("ARS" , "USD");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 3:
                    moneda = consulta.buscarMoneda("USD" , "BRL");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 4:
                    moneda = consulta.buscarMoneda("BRL" , "USD");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 5:
                    moneda = consulta.buscarMoneda("USD" , "COP");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 6:
                    moneda = consulta.buscarMoneda("COP" , "USD");
                    System.out.println(gson.toJson(moneda));
                    break;
                case 7:
                    System.out.println("La aplicación está finalizando");
                    return;
                default:
                    System.out.println("Opción invalida.");
                    break;
            }

        }


    }
}
