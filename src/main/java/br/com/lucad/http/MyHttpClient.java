package br.com.lucad.http;

import br.com.lucad.models.CovidData;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class MyHttpClient {

    private final static String BASE_URL = "https://api.covid19api.com/summary";

    private final OkHttpClient client = new OkHttpClient();

    public void whenAsynchronousGetRequest_thenCorrect() {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                //System.out.println(response.body().string());
                System.out.println(convertFromJson(response.body().string()));
            }

            public void onFailure(Call call, IOException e) {
                //
            }
        });
    }


    public String convertFromJson(String body){
        Gson gson = new Gson(); // conversor
        CovidData objCliente = gson.fromJson(body, CovidData.class);

        // exibindo dados em Java //
        final int totalDeaths = objCliente.getGlobal().getNewConfirmed();
        final int totalDeathsBrazil = objCliente.getCountries().get(23).getNewConfirmed();
        final String id = objCliente.getID();
        return String.valueOf(totalDeathsBrazil);
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
