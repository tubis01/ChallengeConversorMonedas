package com.alura.challenge.conversormonedas.models;

public class Moneda {
    private final String codigo;
    private final String nombre;

    private final String pais;

    public Moneda(String codigo, String nombre, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }


    @Override
    public String toString() {
    return codigo + " - " + nombre + " - " + pais;
    }



}
