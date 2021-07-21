package br.com.lucad.http;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MyHttpClient {

    private final static String BASE_URL = "https://api.covid19api.com/summary";

    OkHttpClient client = new OkHttpClient();

    public String run() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
