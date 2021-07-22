package br.com.lucad.models;

import br.com.lucad.controller.CovidDataController;

public class SetDataToCovidObject {


    public void setGlobalData(CovidGlobal covidGlobal) {
        covidGlobal.setNewConfirmed(covidGlobal.getNewConfirmed());
        covidGlobal.setTotalConfirmed(covidGlobal.getTotalConfirmed());
        covidGlobal.setNewDeaths(covidGlobal.getNewDeaths());
        covidGlobal.setTotalDeaths(covidGlobal.getTotalDeaths());
        covidGlobal.setNewRecovered(covidGlobal.getNewRecovered());
        covidGlobal.setTotalRecovered(covidGlobal.getTotalRecovered());
        covidGlobal.setDate(covidGlobal.getDate());
    }

    public void setBrazilData(Countries brazilCovidData) {
        brazilCovidData.setNewConfirmed(brazilCovidData.getNewConfirmed());
        brazilCovidData.setTotalConfirmed(brazilCovidData.getTotalConfirmed());
        brazilCovidData.setNewDeaths(brazilCovidData.getNewDeaths());
        brazilCovidData.setTotalDeaths(brazilCovidData.getTotalDeaths());
        brazilCovidData.setNewRecovered(brazilCovidData.getNewRecovered());
        brazilCovidData.setTotalRecovered(brazilCovidData.getTotalRecovered());
        brazilCovidData.setDate(brazilCovidData.getDate());
    }

}
