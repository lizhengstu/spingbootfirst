package com.spingboot.spingbootfirst.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String getRequset(HttpGet httpGet){
        CloseableHttpResponse repsone=null;
        try {
             repsone = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity repsoneEntity = repsone.getEntity();

        String result=null;

        try {
            result = EntityUtils.toString(repsoneEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static String PostRequset(HttpPost httpPost){
        CloseableHttpResponse repsone=null;
        try {
            repsone = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity repsoneEntity = repsone.getEntity();

        String result=null;

        try {
            result = EntityUtils.toString(repsoneEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void closeHttpClient() throws IOException {
        httpClient.close();
    }
}
