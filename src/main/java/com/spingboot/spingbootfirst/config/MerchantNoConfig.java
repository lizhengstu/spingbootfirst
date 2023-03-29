package com.spingboot.spingbootfirst.config;


import com.fbank.openapi.sdk.config.Configuration;

import java.nio.charset.Charset;

public class MerchantNoConfig extends Configuration {

    @Override
    public int connectionTimeout() {
        return super.connectionTimeout();
    }

    @Override
    public int readTimeout() {
        return super.readTimeout();
    }

    @Override
    public Charset charset() {
        return super.charset();
    }

    @Override
    public String signType() {
        return super.signType();
    }

    @Override
    public String encryptType() {
        return super.encryptType();
    }

    @Override
    public String fbankEncPubKey() {
        return super.fbankEncPubKey();
    }

    @Override
    public String fbankEncFileName() {
        return "C:\\Users\\14408\\Desktop\\新公钥、私钥\\Fbank_Public_CFCA_Enc.cer";
    }

    @Override
    public String fbankSignPubKey() {
        return super.fbankSignPubKey();
    }

    @Override
    public String fbankSignFileName() {
        return "C:\\Users\\14408\\Desktop\\新公钥、私钥\\Fbank_Public_CFCA_Sign.cer";
    }

    @Override
    public String privateKey() {
        return super.privateKey();
    }

    @Override
    public String pfxFileName() {
        return "C:\\Users\\14408\\Desktop\\新公钥、私钥\\p1sign_new.pfx";
    }

    @Override
    public String pfxPassword() {
        return "11111111";
    }

    @Override
    public String channelNo() {
        return super.channelNo();
    }

    @Override
    public String remoteAddress() {
        return "https://opensandbox.fbank.com";
    }

    @Override
    public String merchantNo() {
        return "8808001003191421";
    }

    @Override
    public String appId() {
        return "100003864006080230";
    }

    @Override
    public String siteId() {
        return "100002906486219673";
    }
}

