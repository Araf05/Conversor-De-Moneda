package io.araf.desafioConversorDeMonedas.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversionDeMoneda {
        public MonedaERA buscarMoneda(String monedaBase, String monedaDestino ) {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/119dc6aa52f388a4e30839ff/pair/" +
                            monedaBase + "/" + monedaDestino );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), MonedaERA.class);
            } catch (Exception e) {
                throw new RuntimeException("No encontré esa moneda");
            }
        }
}
