package br.com.lucad.views;

import br.com.lucad.controller.CovidDataController;
import br.com.lucad.models.Countries;
import br.com.lucad.models.CovidGlobal;

public class Result {

    private final CovidGlobal covidGlobal;
    private final Countries brazilCovidData;

    public Result(CovidDataController covidData) {
        this.covidGlobal = covidData.getGlobal();
        this.brazilCovidData = covidData.getCountries().get(23);
    }

    public void printGlobalResult() {
        System.out.println("\nDados Covid-19:");
        System.out.println("Novas confirmadas: " + covidGlobal.getNewConfirmed());
        System.out.println("Total confirmadas: " + covidGlobal.getTotalConfirmed());
        System.out.println("Novas mortes: " + covidGlobal.getNewDeaths());
    }

    public void printBrasilResult() {
        System.out.println("\nDados Covid-19:");
        System.out.println("Novas confirmadas: " + brazilCovidData.getNewConfirmed());
        System.out.println("Total confirmadas: " + brazilCovidData.getTotalConfirmed());
        System.out.println("Novas mortes: " + brazilCovidData.getNewDeaths());
    }

    public Countries getCountries() {
        return brazilCovidData;
    }

    public CovidGlobal getCovidGlobal() {
        return covidGlobal;
    }
}
