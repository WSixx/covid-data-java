package br.com.lucad;

import br.com.lucad.models.CovidData;
import com.google.gson.Gson;

public class JsonConvert {

    public static CovidData fromJson(String body) {
        Gson gson = new Gson(); // conversor
        CovidData fromJson = gson.fromJson(body, CovidData.class);
        return fromJson;
    }
}
