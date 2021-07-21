package br.com.lucad.controller;

import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.views.Result;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class CovidGlobalController {

    private final ExecutorService threadpool = Executors.newFixedThreadPool(3);
    private Result result;

    public Result getGlobalDataAndPrint() throws InterruptedException, ExecutionException {
        MyHttpClient myHttpClient = new MyHttpClient();
        Future<CovidDataController> futureMyHttpClient = threadpool.submit(myHttpClient);
        System.out.println("--Covid Global--\n");
        int i = 0;
        while (!futureMyHttpClient.isDone()) {
            System.out.println("Loading.. " + ++i);
            sleep(1000);
        }
        if (futureMyHttpClient.isDone()){
            result = new Result(futureMyHttpClient.get());
            result.printResult();
        }
        return result;
    }

}
