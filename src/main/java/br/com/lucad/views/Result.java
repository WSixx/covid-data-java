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
        System.out.println("Total mortes: " + covidGlobal.getTotalDeaths());
        System.out.println("Novos recuperados: " + covidGlobal.getNewRecovered());
        System.out.println("Total recuperados: " + covidGlobal.getTotalRecovered());
        System.out.println("Data: " + covidGlobal.getDate());
        setGlobalData();
    }

    public void printBrasilResult() {
        System.out.println("\nDados Covid-19:");
        System.out.println("Novas confirmadas: " + brazilCovidData.getNewConfirmed());
        System.out.println("Total confirmadas: " + brazilCovidData.getTotalConfirmed());
        System.out.println("Novas mortes: " + brazilCovidData.getNewDeaths());
        System.out.println("Total mortes: " + brazilCovidData.getTotalDeaths());
        System.out.println("Novos recuperados: " + brazilCovidData.getNewRecovered());
        System.out.println("Total recuperados: " + brazilCovidData.getTotalRecovered());
        System.out.println("Data: " + covidGlobal.getDate());
        setBrazilData();

    }

    private void setGlobalData() {
        covidGlobal.setNewConfirmed(covidGlobal.getNewConfirmed());
        covidGlobal.setTotalConfirmed(covidGlobal.getTotalConfirmed());
        covidGlobal.setNewDeaths(covidGlobal.getNewDeaths());
        covidGlobal.setTotalDeaths(covidGlobal.getTotalDeaths());
        covidGlobal.setNewRecovered(covidGlobal.getNewRecovered());
        covidGlobal.setTotalRecovered(covidGlobal.getTotalRecovered());
        covidGlobal.setDate(covidGlobal.getDate());
    }

    private void setBrazilData() {
        brazilCovidData.setNewConfirmed(brazilCovidData.getNewConfirmed());
        brazilCovidData.setTotalConfirmed(brazilCovidData.getTotalConfirmed());
        brazilCovidData.setNewDeaths(brazilCovidData.getNewDeaths());
        brazilCovidData.setTotalDeaths(brazilCovidData.getTotalDeaths());
        brazilCovidData.setNewRecovered(brazilCovidData.getNewRecovered());
        brazilCovidData.setTotalRecovered(brazilCovidData.getTotalRecovered());
        brazilCovidData.setDate(brazilCovidData.getDate());
    }

    public Countries getCountries() {
        return brazilCovidData;
    }

    public CovidGlobal getCovidGlobal() {
        return covidGlobal;
    }
}
