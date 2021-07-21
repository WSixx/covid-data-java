package br.com.lucad.views;

import br.com.lucad.Validacao;
import br.com.lucad.http.MyHttpClient;
import br.com.lucad.models.CovidData;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainMenu {

    ExecutorService threadpool = Executors.newFixedThreadPool(3);

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
        while (true) {
            printMenuOpcoes();
            int menu = validacoes.checkIsANumber(userInput);
            switch (menu) {
                case 1 -> {
                    MyHttpClient myHttpClient = new MyHttpClient();
                    Future<CovidData> futureMyHttpClient = threadpool.submit(myHttpClient);
                    System.out.println("--Covid Global--\n");
                    int i = 0;
                    while (!futureMyHttpClient.isDone()) {
                        System.out.println("Loading.. " + ++i);
                        Thread.sleep(1000); // sleep for 1 millisecond
                    }
                    if (futureMyHttpClient.isDone()){
                        Result result = new Result(futureMyHttpClient.get());
                        result.printResult();
                    }
                }
                case 2 -> System.out.println("Covid Brasil");
                case 3 -> {
                    userInput.close();
                    System.exit(0);
                }
                default -> System.out.println("Entrada errada");
            }
        }
    }

    private void printMenuOpcoes() {
        System.out.println("\n1-COVID Global\n2-COVID Brasil\n3-Sair\n");
    }

}
