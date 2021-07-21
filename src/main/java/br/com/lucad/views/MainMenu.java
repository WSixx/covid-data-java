package br.com.lucad.views;

import br.com.lucad.controller.CovidGlobalController;
import br.com.lucad.models.Validacao;
import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.controller.CovidDataController;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMenu {

    private ExecutorService threadpool = Executors.newFixedThreadPool(3);
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
            switch (menu) {
                case 1 -> result = covidGlobalController.getGlobalDataAndPrint();
                case 2 -> System.out.println(result.getCovidGlobal().getNewConfirmed());
                case 3 -> System.out.println("Gravar"); //Passar um result getCovidGlobal
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
