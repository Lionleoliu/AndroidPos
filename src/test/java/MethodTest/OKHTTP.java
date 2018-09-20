package MethodTest;

import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class OKHTTP {

    static String url = "https://jsonplaceholder.typicode.com/todos/1";
    static String postUrl = "https://jsonplaceholder.typicode.com/todos/1/posts";
    static String loginUrl = "https://ua2.test.yijiupidev.com/himalaya-ApiService-UA2//user/login";
    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static String jsonStr ="{\n" +
            "    \"appCode\": \"ReatailPOS\",\n" +
            "    \"appVersion\": \"19\",\n" +
            "    \"deviceId\": \"PFSNU17929105871\",\n" +
            "    \"deviceOS\": \"24\",\n" +
            "    \"deviceType\": \"1\",\n" +
            "    \"mobileNo\": \"17786410583\",\n" +
            "    \"password\": \"410583\"\n" +
            "}";


    //Get请求
    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    //Post请求
    String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
//                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    //测试post请求
    @Test
    public static void runPost() throws IOException {
        OKHTTP okhttp = new OKHTTP();
        String post = okhttp.post(loginUrl, jsonStr);
        System.out.println(post);
    }

    //测试get请求
    @Test
    public static void runGet() throws IOException {
        OKHTTP okhttp = new OKHTTP();
        String run = okhttp.run(url);
        System.out.println(run);
    }
}


