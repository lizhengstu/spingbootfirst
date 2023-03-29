package com.spingboot.spingbootfirst.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spingboot.spingbootfirst.Utils.HttpClientUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XDTest {

    private static final Logger logger= LoggerFactory.getLogger(XDTest.class);
    private  String data;
    @Test()
    public void productLlist(){
        HttpGet httpGet=new HttpGet("http://192.168.11.20:8080/api/v1/product/list");
        httpGet.addHeader("Content-Type", "application/json");
        String result = HttpClientUtils.getRequset(httpGet);
        logger.info(result);
        logger.info(String.valueOf(Thread.currentThread()));
        Assert.assertNotNull(result,"这个对象不为空");
    }
    @Test(dataProvider = "login",dataProviderClass = com.spingboot.spingbootfirst.parameter.DataParameter.class)
    public void login(String name,String password){
        HttpPost httpPost=new HttpPost("http://192.168.11.20:8080/api/v1/user/login");
        httpPost.addHeader("Content-Type", "application/json");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("mail",name);
        jsonObject.put("pwd",password);


        StringEntity stringEntity= null;

        stringEntity = new StringEntity(jsonObject.toString(),"UTF-8");

        httpPost.setEntity(stringEntity);
        String result = HttpClientUtils.PostRequset(httpPost);
        logger.info(String.valueOf(Thread.currentThread()));
        logger.info(result);
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
