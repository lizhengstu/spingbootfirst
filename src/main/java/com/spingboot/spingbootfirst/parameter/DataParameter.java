package com.spingboot.spingbootfirst.parameter;

import org.testng.annotations.DataProvider;

public class DataParameter {

    @DataProvider(name ="login")
    public Object[][] LoginTest() {
        return new Object[][]{
                {"794666918@qq.com", "123456"},
        };
    }

}
