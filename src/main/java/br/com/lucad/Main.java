package br.com.lucad;

import br.com.lucad.http.MyHttpClient;

public class Main {

    public static void main(String[] args) {
        MyHttpClient myHttpClient = new MyHttpClient();
        myHttpClient.whenAsynchronousGetRequest_thenCorrect();
        try {
           // System.out.println(myHttpClient.run());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
