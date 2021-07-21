package br.com.lucad.views;

import br.com.lucad.models.CovidData;

public class Result {

    private CovidData covidData;

    Result(CovidData covidData){
        this.covidData = covidData;
    }

    public void printResult(){
        System.out.println("Dados Covid-19");
        System.out.println("getNewConfirmed: " + covidData.getGlobal().getNewConfirmed());
        System.out.println("getTotalConfirmed: " + covidData.getGlobal().getTotalConfirmed());
        System.out.println("getNewDeaths: " + covidData.getGlobal().getNewDeaths());
    }

}
