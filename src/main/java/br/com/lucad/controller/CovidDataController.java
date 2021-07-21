package br.com.lucad.controller;

import br.com.lucad.models.Countries;
import br.com.lucad.models.CovidGlobal;

import java.util.List;

public class CovidDataController {

    private CovidGlobal Global;
    private List<br.com.lucad.models.Countries> Countries;


    public CovidGlobal getGlobal() {
        return Global;
    }
    public List<Countries> getCountries() {
        return Countries;
    }


    public CovidDataController fromJson(String body){
        return JsonConvert.fromJson(body);
    }

}
