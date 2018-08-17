package com.example.demo;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 14:26
 **/
public class Main {
    public static void main(String[] args) {
        OkHttpClient mHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8888/hello")
                .build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                User user = gson.fromJson(string,User.class);
                System.out.println(user);
            }
        });
    }
}
