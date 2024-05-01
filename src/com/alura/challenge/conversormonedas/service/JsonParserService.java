package com.alura.challenge.conversormonedas.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserService {

    public JsonObject parseConversionRates(String json) {
        JsonObject jsonResponse = JsonParser.parseString(json).getAsJsonObject();
        return jsonResponse.getAsJsonObject("conversion_rates");
    }
}

