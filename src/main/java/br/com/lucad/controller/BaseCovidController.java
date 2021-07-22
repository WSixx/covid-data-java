package br.com.lucad.controller;

import br.com.lucad.views.Result;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

interface BaseCovidController {

    Result getCovidDataAndPrint() throws InterruptedException, ExecutionException;

    void futureIsComplete(Future<CovidDataController> futureMyHttpClient) throws InterruptedException, ExecutionException;

    void loadingResult(Future<CovidDataController> futureMyHttpClient) throws InterruptedException;

    @NotNull
    Future<CovidDataController> iniciaThread();
}