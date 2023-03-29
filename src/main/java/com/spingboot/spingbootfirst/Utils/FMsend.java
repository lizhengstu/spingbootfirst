package com.spingboot.spingbootfirst.Utils;


import com.alibaba.fastjson.JSONObject;
import com.fbank.openapi.sdk.client.FBankOpenApiClient;
import com.fbank.openapi.sdk.client.OpenParameters;
import com.spingboot.spingbootfirst.config.MerchantNoConfig;

public class FMsend {

    public static String send(JSONObject jsonObject,String apiName ) throws Exception {
        //平台配置文件
        MerchantNoConfig configurationDemo=new MerchantNoConfig();
        //发送请求
        FBankOpenApiClient fBankOpenApiClient = new FBankOpenApiClient(configurationDemo);

        OpenParameters op = new OpenParameters.Builder()
                .apiName(apiName)
                .apiCode("")
                .moduleCode("")
                .apiVersion("")
                .param(JSONObject.toJSONString(jsonObject))
                .userId("")
                .build();


        String result = fBankOpenApiClient.send(op);

        return result;
    }

}
