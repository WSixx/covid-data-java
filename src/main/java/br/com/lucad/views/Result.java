package br.com.lucad.views;

import br.com.lucad.controller.CovidDataController;
import br.com.lucad.models.CovidGlobal;

public class Result {

    private CovidGlobal covidGlobal;

    public Result(CovidDataController covidGlobal){
        this.covidGlobal = covidGlobal.getGlobal();
    }

    public void printResult(){
        System.out.println("\nDados Covid-19:");
        System.out.println("Novas confirmadas: " + covidGlobal.getNewConfirmed());
        System.out.println("Total confirmadas: " + covidGlobal.getTotalConfirmed());
        System.out.println("Novas mortes: " + covidGlobal.getNewDeaths());
    }

    public CovidGlobal getCovidGlobal() {
        return covidGlobal;
    }
}
