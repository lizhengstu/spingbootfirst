package com.spingboot.spingbootfirst.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spingboot.spingbootfirst.Utils.HttpClientUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XDTest {
    private  String data;
    @Test()
    public void productLlist(){
        HttpGet httpGet=new HttpGet("http://192.168.31.212:8080/api/v1/product/list");
        httpGet.addHeader("Content-Type", "application/json");
        String result = HttpClientUtils.getRequset(httpGet);
        Assert.assertNotNull(result,"这个对象不为空");
    }
    @Test
    public void login(){
        HttpPost httpPost=new HttpPost("http://192.168.31.212:8080/api/v1/user/login");
        httpPost.addHeader("Content-Type", "application/json");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("mail","794666918@qq.com");
        jsonObject.put("pwd","123456");


        StringEntity stringEntity= null;

            stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");

        httpPost.setEntity(stringEntity);
        String result = HttpClientUtils.PostRequset(httpPost);
        JSONObject jsonObject2 = (JSONObject) JSON.parse(result);
        this.data=jsonObject2.getString("data");
        Assert.assertNotNull(result,"结果为空");

    }
    @Test(dependsOnMethods = {"login"})
    public void userInfo(){
        HttpGet httpGet=new HttpGet("http://192.168.31.212:8080/api/v1/user/info");
        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("token",data);
        String requset = HttpClientUtils.getRequset(httpGet);
        Assert.assertNotNull(requset,"结果为空");
    }



}
