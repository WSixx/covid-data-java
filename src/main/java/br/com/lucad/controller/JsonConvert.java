package br.com.lucad.controller;

import com.google.gson.Gson;

public class JsonConvert {

    public static CovidDataController fromJson(String body) {
        Gson gson = new Gson();
        CovidDataController fromJson = gson.fromJson(body, CovidDataController.class);
        return fromJson;
    }
}
