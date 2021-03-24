package com.fl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fl.controller.utils.HttpBaseUtil;
import com.fl.controller.utils.HttpUtil;
import com.fl.controller.utils.NetUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static com.fl.controller.utils.Constants.*;

public class Test {

    public static void test() {
        // get请求
        MultiValueMap<String, String> params0 = new LinkedMultiValueMap<>();
        params0.add("type", "qiche");
        params0.add("page", "1");
        params0.add("page_size", "3");
        params0.add("key", KEY_NEWS);
        //String res = HttpUtil.get(API_NEWS, params0);

        String res = HttpUtil.get(String.format(API_NEWS2, "qiche", "1", "3", KEY_NEWS), null);
        System.out.println("No.1 get:\n" + res + "\n");

        // 带参数
        //MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        //params.add("name", "hahaha");
        String res2 = HttpUtil.get(API_NEWS, params0);
        System.out.println("No.2 get params:\n" + res2 + "\n");

        // json参数提交
        //User params2 = new User();
        //params2.name = "lopez";
        //params2.age = 27;
        //params2.gender = 1;
        /*try {
            String res3 = HttpUtil.request(API_NEWS, params0, null, HttpMethod.POST, MediaType.APPLICATION_JSON);
            System.out.println("No.3 post:\n" + res3 + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //POST提交參數
/*        Map<String, Object> params1 = new HashMap<>();
        params1.put("type", "qiche");
        params1.put("page", 1);
        params1.put("page_size", 3);
        params1.put("key", KEY_NEWS);
        //JSONObject jsonObject = JSONObject.fromObject(params1);

        JSONObject jsonObject = new JSONObject(params1);
        String json = jsonObject.toString();
        System.out.println("post json: \n" + json);
        // 更多使用方法看源码中的注释
        NetUtil.doPost(API_NEWS, json);*/

        //POST提交參數
        Map<String, Object> params2 = new HashMap<>();
        params2.put("type", "OL风");
        params2.put("order", "1");
        params2.put("page", "1");

        JSONObject jsonObject = new JSONObject(params2);
        String json = jsonObject.toString();
        System.out.println("post json: \n" + json);
        // 更多使用方法看源码中的注释
        NetUtil.doPost(API_GIRLS, json);
        System.out.println("\n —————————  分割線 —————————— \n" + json);

        //放棄了 TODO org.springframework.web.client.RestClientException: No HttpMessageConverter for java.util.HashMap and content type "multipart/form-data"
        /*try {
            String res3 = HttpUtil.request(API_GIRLS, params2, null, HttpMethod.POST, MediaType.APPLICATION_JSON);
            System.out.println("No.3    ——————       post:\n" + res3 + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //此方法也有效
        Map<String, String> params3 = new HashMap<>();
        params3.put("type", "OL风");
        params3.put("order", "1");
        params3.put("page", "1");
        HttpBaseUtil.postAsyn(API_GIRLS, params3, new HttpBaseUtil.OnHttpResult() {
            @Override
            public void onSuccess(String result) {
                System.out.println("\n ——— 淘女郎 onSuccess ———— \n" + result);
            }

            @Override
            public void onError(String message) {
                System.out.println("\n ——— 淘女郎 onError ———— \n" + message);
            }
        });
        System.out.println("\n —————————  最後的分割線 —————————— \n" + json);


        //        POST測試頭條
        Map<String, String> params4 = new HashMap<>();
        params4.put("type", "qiche");
        params4.put("page", "1");
        params4.put("page_size", "3");
        params4.put("key", KEY_NEWS);

        HttpBaseUtil.postAsyn(API_NEWS, params4, new HttpBaseUtil.OnHttpResult() {
            @Override
            public void onSuccess(String result) {
                System.out.println("\n ——— 頭條 onSuccess ———— \n" + result);
            }

            @Override
            public void onError(String message) {
                System.out.println("\n ——— 頭條 onError ———— \n" + message);
            }
        });
        System.out.println("\n —————————  最後的短信推薦測試 —————————— \n" + json);

        //        POST測試短信
        String url = "https://apis.17wo.cn/share-center-flowq/order/orderbyphonebill";

        Map<String, String> param5 = new HashMap<>();
        param5.put("wealthUserId", "326518");
        param5.put("productId", "1016010");
        param5.put("rebateType", "2");
        param5.put("sdt", "OEQtHx7P3uqCp1aRS5JRmSsHW3zscWr87PTE11Zay76CaLOdkXob5BHXAO5YNGOSvJgACCi5LTDXJJW0Gaqyf2d9ZXqqE9pstGhVIJr8+OS+QXcM7hajE6WDwGJ6gPAEs+4Hfw/wxEIMDzzOCFLRlDZWNFTVMtpUE/aSKyfao8z8KRJKbU9H75RlMxCBc501fX5lqb0CD4tGBLVxyxacMNGRMS+ATXaMTXXOsuUQBc0e2oLPl8H59dRJmPQPpMmtzKwWnWpky68eQSMlZuqUdzCp67z9Ezmoyl4trAKJOcEwCX7DPZqMP6/Rk/9ZWSE90XLC5kDAWvC5EBQcuYn/n1jqQzbDfU7Es6QGSgWGigM=");

        HttpBaseUtil.postAsyn(url, param5, new HttpBaseUtil.OnHttpResult() {
            @Override
            public void onSuccess(String result) {
                System.out.println("\n ——— 短信 onSuccess ———— \n" + result);
            }

            @Override
            public void onError(String message) {
                System.out.println("\n ——— 短信 onError ———— \n" + message);
            }
        });
    }

    /**
     * 传入你要填的服务器url
     *
     * @param url
     */
    public static void toGetFromUrl(String url) {
        String res = HttpUtil.get(url, null);
        System.out.println("No.1 get:\n" + res + "\n");
    }

    public static void toPostFromUrl(String url, MultiValueMap<String, String> params) {
        String res3 = HttpUtil.request(url, params, null, HttpMethod.POST, MediaType.APPLICATION_JSON);
        System.out.println("No.3 post:\n" + res3 + "\n");
    }

    public static void test2() {
        Map<String, String> params0 = new HashMap<>();
        params0.put("type", "qiche");
        params0.put("page", "1");
        params0.put("page_size", "3");
        params0.put("key", KEY_NEWS);

        // get请求
        String res = HttpBaseUtil.get(API_NEWS, null);
        System.out.println("不带参数的get请求:\n" + res);

        // 带参数
        //Map<String, String> params = new HashMap<>();
        String res2 = HttpBaseUtil.get(API_NEWS, params0);
        System.out.println("带参数的Get请求:\n" + res2);

        // 异步请求
        System.out.println("开始请求...." + System.currentTimeMillis());
        HttpBaseUtil.getAsyn(API_NEWS, params0, new HttpBaseUtil.OnHttpResult() {
            @Override
            public void onSuccess(String result) {
                System.out.println("异步Get ———————————— 请求结束...." + System.currentTimeMillis());
                System.out.println(result);
            }

            @Override
            public void onError(String message) {
                System.out.println(message);
            }
        });
        System.out.println("---我来证明GET请求是异步的---");

        // json参数提交
        User user = new User();
        final String params3 = JSON.toJSONString(user);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String res3 = HttpBaseUtil.request(API_NEWS, params3, null, "POST", "application/json");
                System.out.println(res3);
                System.out.println("---异步POST请求 ———————————— 结束 ---");
            }
        }).start();
        System.out.println("---我来证明POST请求是异步的2333---");
        // 更多使用方法看源码中的注释
    }

}
