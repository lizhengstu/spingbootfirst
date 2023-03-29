package com.spingboot.spingbootfirst.cases;

import com.alibaba.fastjson.JSONObject;
import com.spingboot.spingbootfirst.Utils.FMsend;
import com.spingboot.spingbootfirst.merchantconfig.FydMerchantConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.UUID;

public class FsdCase {
    private static final Logger logger= LoggerFactory.getLogger(XDTest.class);
    private String clientSerialNo=UUID.randomUUID().toString().replaceAll("-", "");
    private FydMerchantConfig fsdMerchantConfig =new FydMerchantConfig();


    //4.6.2	关联企业添加
    @Test
    public void  addEnterprise(){
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("channelNo",fsdMerchantConfig.channelNo());
        jsonObject.put("version","1.0.0");
        jsonObject.put("FSDMerchantNo",fsdMerchantConfig.businessMerchantNo());
        jsonObject.put("businessCode",fsdMerchantConfig.businessCode());
        jsonObject.put("custId","3000002003338647");
        jsonObject.put("custName","李政");
        jsonObject.put("idCardType","1");
        jsonObject.put("idCardNo","500382199509031935");
        jsonObject.put("enterpriseName","重庆渝北区公司");
        jsonObject.put("creditCode","9222010OMA4F1LJ003");
        jsonObject.put("clientSerialNo",clientSerialNo);
        String send =null;
        try {
            send= FMsend.send(jsonObject, "com.fbank.lucifer.RelatedEnterpriseAddAction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(send);
    }
    //4.6.6	客户授信申请信息提交
    @Test
    public void creditSubmit(){

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("clientSerialNo",clientSerialNo);
        jsonObject.put("channelNo",fsdMerchantConfig.channelNo());
        jsonObject.put("version","1.0.0");
        jsonObject.put("FSDMerchantNo",fsdMerchantConfig.businessMerchantNo());
        jsonObject.put("businessCode",fsdMerchantConfig.businessCode());
        jsonObject.put("custId","3000002003338647");
        jsonObject.put("custName","李政");
        jsonObject.put("idCardType","1");
        jsonObject.put("idCardNo","500382199509031935");
        jsonObject.put("enterpriseName","重庆渝北区公司");
        jsonObject.put("creditCode","9222010OMA4F1LJ003");
        jsonObject.put("creditOutApplyId","111111115we33331123423");
        jsonObject.put("custMobile","13658596614");
        jsonObject.put("channel","H5");
        jsonObject.put("driverName","br0001");
        jsonObject.put("salesChannelNumber",fsdMerchantConfig.channelNo());
        jsonObject.put("sourceIp","127.0.0.1");
        jsonObject.put("platform","WEB");

        String send =null;
        try {
            send= FMsend.send(jsonObject, "com.fbank.lucifer.CustCreditApplyInfoSubmitAction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(send);
    }



    //4.6.6	客户授信申请信息提交
    @Test
    public void creditApply(){
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("clientSerialNo",clientSerialNo);
        jsonObject.put("version","1.0.0");
        jsonObject.put("FSDMerchantNo",fsdMerchantConfig.merchantNo());
        jsonObject.put("businessCode",fsdMerchantConfig.businessCode());
        jsonObject.put("custId","3000002003338647");
        jsonObject.put("custName","李政");
        jsonObject.put("idCardType","1");
        jsonObject.put("idCardNo","500382199509031935");
        jsonObject.put("enterpriseName","重庆渝北区公司");
        jsonObject.put("creditCode","9222010OMA4F1LJ003");
        jsonObject.put("creditOutApplyId","111111115we33331123423");

        String send =null;
        try {
            send= FMsend.send(jsonObject, "com.fbank.lucifer.CustCreditApplyAction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(send);
    }


    }





