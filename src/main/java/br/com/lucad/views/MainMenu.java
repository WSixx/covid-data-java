package br.com.lucad.views;

import br.com.lucad.controller.CovidBrazilController;
import br.com.lucad.controller.CovidGlobalController;
import br.com.lucad.models.Validacao;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;


public class MainMenu {

    private Boolean inMenu = true;
    private Result result;

    public void menuInit() {
        Scanner userInput = new Scanner(System.in);
        Validacao validacoes = new Validacao();
        try {
            menuEscolha(userInput, validacoes);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void menuEscolha(Scanner userInput, Validacao validacoes) throws InterruptedException, ExecutionException {
        while (inMenu) {
            printMenuOpcoes();
            int menu = validacoes.checkIsANumber(userInput);
            CovidGlobalController covidGlobalController = new CovidGlobalController();
            CovidBrazilController covidBrazilController = new CovidBrazilController();
            switch (menu) {
                case 1 -> result = covidGlobalController.getCovidDataAndPrint();
                case 2 -> result = covidBrazilController.getCovidDataAndPrint();
                //TODO: Passar um result getCovidGlobal e gravar em um arq Texto
                //TODO: Criar uma classe responsável por isso
                case 3 -> System.out.println(result.getCountries().getNewConfirmed());
                case 4 -> {
                    inMenu = false;
                    userInput.close();
                    System.exit(0);
                }
                default -> System.out.println("Entrada errada");
            }
        }
    }

    private void printMenuOpcoes() {
        System.out.println("-----COVID MENU------");
        System.out.println("1-COVID Global\n2-COVID Brasil\n3-Gravar em Texto\n4-Sair\n");
    }
}
