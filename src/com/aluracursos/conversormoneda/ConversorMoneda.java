package com.aluracursos.conversormoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5e25cc1706b0adf6a1e232b5/latest/USD";

    public double convertir(double valor, String monedaOrigen, String monedaDestino) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + monedaOrigen))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                double tasaCambio = jsonResponse.getAsJsonObject("rates").get(monedaDestino).getAsDouble();
                return valor * tasaCambio;
            } else {
                System.out.println("Error al obtener la tasa de cambio: " + response.statusCode());
                return 0.0;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}