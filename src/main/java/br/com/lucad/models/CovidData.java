package br.com.lucad.models;

import java.util.List;

public class CovidData {

    private CovidGlobal Global;
    private List<CovidBrasil> Countries;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public CovidGlobal getGlobal() {
        return Global;
    }

    public void setGlobal(CovidGlobal global) {
        this.Global = global;
    }

    public List<CovidBrasil> getCountries() {
        return Countries;
    }

    public void setCountries(List<CovidBrasil> countries) {
        this.Countries = countries;
    }
}
