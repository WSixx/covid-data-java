package br.com.lucad.models;

import br.com.lucad.controller.CovidDataController;
import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.views.Result;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public abstract class MyThread {

    private final ExecutorService threadpool = Executors.newCachedThreadPool();
    private Result result;

    MyThread(Result result){
        this.result = result;
    }

    public Future<CovidDataController> iniciaThread() {
        MyHttpClient myHttpClient = new MyHttpClient();
        return threadpool.submit(myHttpClient);
    }

    public void loadingResult(Future<CovidDataController> futureMyHttpClient) throws InterruptedException {
        int i = 0;
        while (!futureMyHttpClient.isDone()) {
            System.out.println("Loading.. " + ++i);
            sleep(1000);
        }

    }

    public Result futureIsComplete(Future<CovidDataController> futureMyHttpClient) throws InterruptedException, ExecutionException {
        if (futureMyHttpClient.isDone()) {
            result = new Result(futureMyHttpClient.get());
            result.printBrasilResult();
            threadpool.shutdown();
        }
        return result;
    }

}
