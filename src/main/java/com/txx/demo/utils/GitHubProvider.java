package com.txx.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.txx.demo.dto.AcessTokenDto;
import com.txx.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {

    //获取令牌
    public String  getAccessToken(AcessTokenDto acessTokenDto){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(acessTokenDto),mediaType);//请求体
        //post请求，向浏览器发送请求令牌的网址
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

            try (Response response = client.newCall(request).execute()) {
                //github颁发令牌
                String tokenJson=response.body().string();//响应
                System.out.println("tokenjson"+tokenJson);
                String token=tokenJson.split("&")[0].split("=")[1];
                System.out.println("token"+token);
                return tokenJson;
            } catch (IOException e) {
                e.printStackTrace();
            }
              return null;

    }

    //获取github用户信息,get请求
    public GithubUser getGithubUer(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user/user?access_token="+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
           String user= response.body().string();
           System.out.println("user"+user);
            return JSON.parseObject(user,GithubUser.class);//把json形式的user转换成GithubUser
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
