import io.araf.desafioConversorDeMonedas.modelos.ConsultaConversionDeMoneda;
import io.araf.desafioConversorDeMonedas.modelos.GeneradorDeArchivos;
import io.araf.desafioConversorDeMonedas.modelos.Moneda;
import io.araf.desafioConversorDeMonedas.modelos.MonedaERA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
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
        String base;
        String target;
        float base_value;
        int opcion;
        ArrayList<Moneda> monedaList = new ArrayList<>();
        GeneradorDeArchivos archivo = new GeneradorDeArchivos();

        while (true) {
            System.out.println(menu);
            opcion = lectura.nextInt();
            lectura.nextLine();

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
                    lectura.close();
                    archivo.guardarJson(monedaList);
                    return;
                default:
                    System.out.println("Opción invalida.");
                    continue;
            }

            System.out.println("Ingrese el monto que desea convertir: ");
            base_value = lectura.nextFloat();
            lectura.nextLine();

            MonedaERA monedaERA = consulta.buscarMoneda( base, target);
            Moneda moneda = new Moneda(monedaERA, base_value);
            moneda.mostrar();
            monedaList.add(moneda);
        }
    }
}
