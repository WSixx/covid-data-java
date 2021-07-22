package br.com.lucad.models;

import br.com.lucad.controller.CovidDataController;
import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.views.ShowResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public abstract class MyThread {

    //TODO: TIRAR O THREAD DO CONTROLLER E PASSAR PARA CÁ

    private final ExecutorService threadpool = Executors.newCachedThreadPool();
    private ShowResult showResult;

    MyThread(ShowResult showResult) {
        this.showResult = showResult;
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

    public ShowResult futureIsComplete(Future<CovidDataController> futureMyHttpClient) throws InterruptedException, ExecutionException {
        if (futureMyHttpClient.isDone()) {
            showResult = new ShowResult(futureMyHttpClient.get());
            showResult.printBrasilResult();
            threadpool.shutdown();
        }
        return showResult;
    }

}
