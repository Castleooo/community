package com.txx.demo.utils;

import com.txx.demo.dto.AcessTokenDto;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    public String  getAccessToken(AcessTokenDto acessTokenDto){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
       RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()//??
                .url("https://github.com/login/oauth/access_token")//???
                .post(body)
                .build();

            try (Response response = client.newCall(request).execute()) {//???
                String string=response.body().string();
                System.out.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
              return null;

    }
}
