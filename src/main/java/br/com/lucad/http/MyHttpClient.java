package br.com.lucad.http;

import br.com.lucad.models.CovidData;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.Callable;

public class MyHttpClient implements Callable<CovidData> {

    private final static String BASE_URL = "https://api.covid19api.com/summary";
    private final OkHttpClient client = new OkHttpClient();

    CovidData retorno = new CovidData();

    public CovidData httpRequest() {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            CovidData covidData = new CovidData().fromJson(response.body().string());
            retorno = covidData;
            return retorno;
        } catch (IOException e) {
            e.printStackTrace();
            return retorno;
        }
    }

    @Override
    public CovidData call() throws Exception {
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
