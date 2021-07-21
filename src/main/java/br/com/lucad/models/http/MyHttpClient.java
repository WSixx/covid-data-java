package br.com.lucad.models.http;

import br.com.lucad.controller.CovidDataController;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.Callable;

public class MyHttpClient implements Callable<CovidDataController> {

    private final static String BASE_URL = "https://api.covid19api.com/summary";
    private final OkHttpClient client = new OkHttpClient();

    CovidDataController retorno = new CovidDataController();

    public CovidDataController httpRequest() {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            CovidDataController covidDataController = new CovidDataController().fromJson(response.body().string());
            retorno = covidDataController;
            return retorno;
        } catch (IOException e) {
            e.printStackTrace();
            return retorno;
        }
    }

    @Override
    public CovidDataController call() throws Exception {
        return httpRequest();
    }
}


/*    public String run() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
            //System.out.println(convertFromJson(response.body().string()));
            return response.body().string();
        }
    }*/
