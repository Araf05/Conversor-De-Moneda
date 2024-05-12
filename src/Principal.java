import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.araf.desafioConversorDeMonedas.modelos.ConsultaConversionDeMoneda;
import io.araf.desafioConversorDeMonedas.modelos.Moneda;
import io.araf.desafioConversorDeMonedas.modelos.MonedaERA;

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
        String base = "";
        String target = "";
        float base_value;
        int opcion;

        while (true) {
            System.out.println(menu);
            opcion = Integer.parseInt(lectura.nextLine());

            switch (opcion) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    target = "USD";
                    break;
                case 3:
                    base = "USD";
                    target = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    target = "USD";
                    break;
                case 5:
                    base = "USD";
                    target = "COP";
                    break;
                case 6:
                    base = "COP";
                    target = "USD";
                    break;
                case 7:
                    System.out.println("La aplicación está finalizando");
                    return;
                default:
                    System.out.println("Opción invalida.");
                    break;
            }

            System.out.println("Ingrese el monto que desea convertir: ");
            base_value = lectura.nextFloat();
            MonedaERA monedaERA = consulta.buscarMoneda( base, target);

            Moneda moneda = new Moneda(monedaERA, base_value);
            moneda.mostrar();

        }
    }
}
