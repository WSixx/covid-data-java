package br.com.lucad.controller;

import br.com.lucad.models.http.MyHttpClient;
import br.com.lucad.views.ShowResult;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class CovidGlobalController implements BaseCovidController {

    private final ExecutorService threadpool = Executors.newCachedThreadPool();
    private ShowResult showResult;

    @Override
    public ShowResult getCovidDataAndPrint() throws InterruptedException, ExecutionException {
        Future<CovidDataController> futureMyHttpClient = iniciaThread();
        System.out.println("--Covid Global--\n");
        loadingResult(futureMyHttpClient);
        futureIsComplete(futureMyHttpClient);
        return showResult;
    }

    @Override
    public void futureIsComplete(Future<CovidDataController> futureMyHttpClient) throws InterruptedException, ExecutionException {
        if (futureMyHttpClient.isDone()){
            showResult = new ShowResult(futureMyHttpClient.get());
            showResult.printGlobalResult();
            threadpool.shutdown();
        }
    }

    @Override
    public void loadingResult(Future<CovidDataController> futureMyHttpClient) throws InterruptedException {
        int i = 0;
        while (!futureMyHttpClient.isDone()) {
            System.out.println("Loading.. " + ++i);
            sleep(1000);
        }
    }

    @NotNull
    @Override
    public Future<CovidDataController> iniciaThread() {
        MyHttpClient myHttpClient = new MyHttpClient();
        return threadpool.submit(myHttpClient);
    }


}
