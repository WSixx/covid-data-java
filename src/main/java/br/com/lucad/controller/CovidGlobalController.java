package br.com.lucad.controller;

import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.views.Result;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class CovidGlobalController {

    private final ExecutorService threadpool = Executors.newCachedThreadPool();
    private Result result;

    public Result getGlobalDataAndPrint() throws InterruptedException, ExecutionException {
        Future<CovidDataController> futureMyHttpClient = iniciaThread();
        System.out.println("--Covid Global--\n");
        loadingResult(futureMyHttpClient);
        futureIsComplete(futureMyHttpClient);
        return result;
    }

    private void futureIsComplete(Future<CovidDataController> futureMyHttpClient) throws InterruptedException, ExecutionException {
        if (futureMyHttpClient.isDone()){
            result = new Result(futureMyHttpClient.get());
            result.printGlobalResult();
            threadpool.shutdown();
        }
    }

    private void loadingResult(Future<CovidDataController> futureMyHttpClient) throws InterruptedException {
        int i = 0;
        while (!futureMyHttpClient.isDone()) {
            System.out.println("Loading.. " + ++i);
            sleep(1000);
        }
    }

    @NotNull
    private Future<CovidDataController> iniciaThread() {
        MyHttpClient myHttpClient = new MyHttpClient();
        Future<CovidDataController> futureMyHttpClient = threadpool.submit(myHttpClient);
        return futureMyHttpClient;
    }

}
