package MethodTest;

import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * 描述：接口测试的数据源
 */
public class myApiTestData {
    MyExcel myExcel = new MyExcel();

    @DataProvider(name = "BarCode")
    public Object[][] getLoginData() throws IOException {
        return myExcel.readExcel("E:\\DataProviderFile\\BarcodeAndUserID.xlsx","BarCode");
    }
}
