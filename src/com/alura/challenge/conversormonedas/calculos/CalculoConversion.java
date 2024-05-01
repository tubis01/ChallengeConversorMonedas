package com.alura.challenge.conversormonedas.calculos;

public class CalculoConversion {
    // JsonParserService.java


    public double ConversionMoneda(double cantidad, double tasaOrigen, double tasaDestino) {
        return (cantidad / tasaOrigen) * tasaDestino;
    }
}
