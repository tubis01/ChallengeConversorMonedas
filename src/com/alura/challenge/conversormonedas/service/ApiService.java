package com.alura.challenge.conversormonedas.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private static final String URL = "https://v6.exchangerate-api.com/v6/42d93cb98177c43690551192/latest/";


    public HttpResponse<String> getConversionRates(String monedaOrigen) throws IOException, InterruptedException {
        URI uri = URI.create(URL + monedaOrigen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}


