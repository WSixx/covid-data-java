package br.com.lucad.views;

import br.com.lucad.controller.CovidDataController;
import br.com.lucad.models.Countries;
import br.com.lucad.models.CovidGlobal;
import br.com.lucad.models.SetDataToCovidObject;

public class ShowResult {

    private final CovidGlobal covidGlobal;
    private final Countries brazilCovidData;
    private SetDataToCovidObject setDataToCovidObject;

    public ShowResult(CovidDataController covidData) {
        this.covidGlobal = covidData.getGlobal();
        this.brazilCovidData = covidData.getCountries().get(23);
        setDataToCovidObject = new SetDataToCovidObject();
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
        setDataToCovidObject.setGlobalData(covidGlobal);
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
        setDataToCovidObject.setBrazilData(brazilCovidData);
    }

    public Countries getCountries() {
        return brazilCovidData;
    }

    public CovidGlobal getCovidGlobal() {
        return covidGlobal;
    }
}
