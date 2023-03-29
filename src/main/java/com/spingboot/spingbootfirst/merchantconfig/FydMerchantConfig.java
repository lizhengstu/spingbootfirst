package com.spingboot.spingbootfirst.merchantconfig;

public class FydMerchantConfig implements Merchantconfig{
    @Override
    public String merchantNo() {
        return "8808002003338467";
    }

    @Override
    public String businessMerchantNo() {
        return "8888001000801031";
    }

    @Override
    public String siteId() {
        return "100002392737368416";
    }

    @Override
    public String appId() {
        return "100003864006080230";
    }

    @Override
    public String channelNo() {
        return "825512";
    }

    @Override
    public String businessCode() {
        return "FSD-FYD";
    }
}
