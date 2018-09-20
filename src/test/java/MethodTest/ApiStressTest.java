/*
 * 1.需求：调用POS的通过条码查询商品的接口多次，并打印出每次调用的时间且计算出每次调用接口的时间差
 * 思路：1：通过OKHttp请求调用登陆和通过条码搜寻商品的接口，因为如果直接调用条码搜索接口不带token的话不会成功所以需要同时调用登陆接口，
 *       2：数据要使用ArrayList里的数据，这里可以用到TestNG的数据驱动来驱动接口的调用
 *       3：获取到系统时间然后获取到调用接口后的server time相减
 *       4：计算出每次接口之间的间隔时间
 *
 *解析json返回值
 * */

package MethodTest;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiStressTest {

    static String baseUrl = "http://retailpos.test.yijiupidev.com/v220/";
    static String searchCodeApi = "/Product/ListProductByBarCode";
    static String token = "d041d8e3-7732-4682-a6ec-8b48b1bab86e";
    static String loginUrl = "https://ua2.test.yijiupidev.com/himalaya-ApiService-UA2//user/login";
    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    static String jsonStr = "{\n" +
            "    \"appCode\": \"ReatailPOS\",\n" +
            "    \"appVersion\": \"19\",\n" +
            "    \"deviceId\": \"PFSNU17929105871\",\n" +
            "    \"deviceOS\": \"24\",\n" +
            "    \"deviceType\": \"1\",\n" +
            "    \"mobileNo\": \"17786410583\",\n" +
            "    \"password\": \"410583\"\n" +
            "}";

    static String jsonSearchBarCode = "{\n" +
            "    \"param\": {\n" +
            "        \"barcode\": \"3211203421272\", \n" +
            "        \"bizUserId\": \"1\"\n" +
            "    }\n" +
            "}";


    public long getTime() {
        long time = System.currentTimeMillis();
        return time;
    }

    public long transferMillToSecond(long milliseconds) {
        long second = milliseconds / 1000;
        return second;
    }


    //获取JSON字符串
    public String getJson(String response) throws IOException {

        JSONObject jsonObject = JSONObject.parseObject(response);
        // 获取到key为shoppingCartItemList的值
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.get("data").toString());
        Object token = jsonObject1.get("token");
        return (String) token;
    }

    //登陆请求POST
    String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    //Post请求查询商品的接口
    String postSearchBarCodeApi(String url, String json, String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("token", token)
                .header("tsn", "PFSNU17929105871")
                .url(baseUrl + searchCodeApi)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @Test(priority = 1)
    public void loginTest() throws IOException {
        ApiStressTest apiStressTest = new ApiStressTest();
        String loginToken = apiStressTest.post(loginUrl, jsonStr);//获取登陆接口的所有json返回值
        String token = apiStressTest.getJson(loginToken);//获取token相对应的值、
    }

    //测试post请求
    @Test(priority = 2,invocationCount = 3, description = "调用BarCode接口", dataProvider = "BarCode", dataProviderClass = myApiTestData.class)
    public static void postTest(String barcode, String bizUserId) throws IOException {
        Logger logger = Logger.getLogger("Log4JDemo");
        PropertyConfigurator.configure("E:\\YJPWork\\Code\\YJPRetailAutoTestDemo\\log4j.properties");
        ApiStressTest apiStressTest = new ApiStressTest();
        String jsonSearchBarCode = "{" +
                "    \"param\": {\n" +
                "        \"barcode\": " + barcode + ", \n" +
                "        \"bizUserId\": " + bizUserId + "\n" +
                "    }\n" +
                "}";


//        String loginToken = apiStressTest.post(loginUrl, jsonStr);//获取登陆接口的所有json返回值
//        String token = apiStressTest.getJson(loginToken);//获取token相对应的值、
        // for (int i = 0; i <= 100; i++) {

        long startTime = apiStressTest.getTime();
        String post = apiStressTest.postSearchBarCodeApi(baseUrl + searchCodeApi, jsonSearchBarCode, token);//调用通过条码查询商品的接口
        long endTime = apiStressTest.getTime();
        //System.out.println(post);
        //System.out.println(endTime - startTime);
        logger.debug(endTime - startTime + "调用接口时间");
        //}
//        long marginTime = apiStressTest.transferMillToSecond(endTime - startTime);
//        System.out.println(marginTime);
    }
}


