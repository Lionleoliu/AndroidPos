package MethodTest;

import POSAutomationPageResource.Base;
import POSAutomationPageResource.StartApp;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMethod {
    private AndroidDriver driver;
    Logger logger = Logger.getLogger("TestMethod");

    public static void configure(){
    PropertyConfigurator.configure("E:\\YJPWork\\Code\\YJPRetailAutoTestDemo\\log4j.properties");
    }

    @BeforeSuite//设置
    public void setUp() throws IOException, InterruptedException {
        configure();
        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
        Thread.sleep(5000L);
        driver = Base.SetUp();
    }

    public String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());//获取当前系统时间
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置日期格式
        String retStrFormatNowDate = sdFormatter.format(nowTime);//使当前系统时间用到模板是设置好的模板
        return retStrFormatNowDate;//返回这个设置好的时间模板
    }

    @AfterMethod
    public void screenShot() throws IOException {
        String filePath = "E:\\YJPLPIC";
        String fileName = refFormatNowDate()+".png";
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(filePath + "\\" + fileName));
    }

    @Test(priority = 1)//登陆
    public void login() throws IOException, SQLException {
//        System.out.println("login start");
        logger.info("App opened");
        StartApp.login(driver);
//        System.out.println("login success");
        logger.info("User have been entered");
    }

    @Test(priority = 13)//散客散货现金支付
    public void bulkGoodsCashSale() {
        StartApp.bulkGoodsCashSale(driver);
        logger.info("WalkingMember_BulkGoods_CashSale");
    }

    @Test(priority = 14)//散客散货储蓄卡支付
    public void bulkGoodsDebitCardSale() {
        StartApp.bulkGoodsDebitCardSale(driver);
    }

    @Test(priority = 15)//散客散货信用卡支付
    public void bulkGoodsCreditCardSale() {
        StartApp.bulkGoodsCreditCardSale(driver);
    }

}
