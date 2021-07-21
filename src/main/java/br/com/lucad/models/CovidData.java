package br.com.lucad.models;

import br.com.lucad.JsonConvert;
import com.google.gson.Gson;

import java.util.List;

public class CovidData {

    private CovidGlobal Global;
    private List<Countries> Countries;


    public CovidGlobal getGlobal() {
        return Global;
    }
    public List<Countries> getCountries() {
        return Countries;
    }


    public CovidData fromJson(String body){
        return JsonConvert.fromJson(body);
    }

}
