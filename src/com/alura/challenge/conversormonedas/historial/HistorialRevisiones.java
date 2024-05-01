package com.alura.challenge.conversormonedas.historial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialRevisiones {
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double cantidad;
    private final double resultado;

    private final LocalDateTime marcaTiempo;
    public HistorialRevisiones(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.marcaTiempo = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String marcaFormateado = marcaTiempo.format(formatter);
        return marcaFormateado+  " De: " + monedaOrigen + " -->  " + monedaDestino + " Cantidad: " + cantidad + " Resultado: " + resultado;
    }

}
