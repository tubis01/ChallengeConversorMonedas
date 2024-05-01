package com.alura.challenge.conversormonedas.calculos;

import com.alura.challenge.conversormonedas.historial.HistorialRevisiones;
import com.alura.challenge.conversormonedas.service.ApiService;
import com.alura.challenge.conversormonedas.service.JsonParserService;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class ConversorMonedas {
    private final ApiService apiService = new ApiService();
    private final JsonParserService jsonParserService = new JsonParserService();
    private final CalculoConversion conversionDivisas = new CalculoConversion();

    private final List<HistorialRevisiones> registroConversion = new ArrayList<>();
    public void ConvertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            HttpResponse<String> response = apiService.getConversionRates(monedaOrigen);
            String json = response.body();
            JsonObject conversionRates = jsonParserService.parseConversionRates(json);

            if (!conversionRates.has(monedaDestino)) {
                System.out.println("Moneda de destino no encontrada.");
                return;
            }

            double tasaOrigen = conversionRates.get(monedaOrigen).getAsDouble();
            double tasaDestino = conversionRates.get(monedaDestino).getAsDouble();

            double resultado = conversionDivisas.ConversionMoneda(cantidad, tasaOrigen, tasaDestino);
            DecimalFormat df = new DecimalFormat("#.###");
            String resultadoFormateado = df.format(resultado);


            HistorialRevisiones registro = new HistorialRevisiones(monedaOrigen, monedaDestino, cantidad, Double.parseDouble(resultadoFormateado));
            registroConversion.add(registro);

            System.out.println("\nTasa de conversión de " + monedaOrigen + " a " + monedaDestino + " es: " + tasaDestino);
            System.out.println("La cantidad convertida es: " + resultadoFormateado);
            System.out.println("-------------------------------------------------");

        } catch (InterruptedException | NullPointerException | IOException e) {
            System.out.println("Error al obtener las tasas de conversión: " + e.getMessage());
        }
    }

    public void mostrarHistorialRevisiones() {
        if (registroConversion.isEmpty()) {
            System.out.println("No hay registros de conversiones");
        } else {
            System.out.println("----------------HISTORIAL DE CONVERSIONES----------------");
            System.out.println(" MARCA TIEMPO  |MONEDA.O | MONEDA.D | CANTIDAD | RESULTADO|");

            for (HistorialRevisiones registro : registroConversion) {
                System.out.println(registro);
            }
        }

    }
}
