package io.araf.desafioConversorDeMonedas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.lineSeparator;

public class GeneradorDeArchivos {
    public void guardarJson(ArrayList<Moneda> moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("conversor.json");
        escritura.write("[" + lineSeparator());
        for (int i = 0; i< moneda.size(); i++) {
            if(i==0) {
                escritura.write(gson.toJson(moneda.get(i)));
            } else {
                escritura.write("," + lineSeparator() + gson.toJson(moneda.get(i)));
            }
        }
        escritura.write(lineSeparator()+"]");
        escritura.close();
    }
}
