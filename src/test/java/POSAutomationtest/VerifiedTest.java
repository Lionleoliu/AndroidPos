package POSAutomationtest;

import POSAutomationPageResource.Base;
import POSAutomationPageResource.CashierPage;
import POSAutomationPageResource.StartApp;
import PageSource.ProductPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.Environment;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class VerifiedTest {

    private AndroidDriver driver;//全局变量


    @BeforeSuite//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = Base.SetUp();
    }

    //
    @Test(priority = 1)//登陆
    public void login() throws IOException, SQLException {
        StartApp.login(driver);
    }

//    @Test(priority = 2)
//    public void getToastMessage(){
//
//        String key = "暂";
//        CashierPage cashierPage = new CashierPage(driver);
//        cashierPage.pendingOrder().click();
//
////        WebElement target = wait.until(
////                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'"+key+"')]")));
////        System.out.println(target.getText());
//
//        WebElement allowButton = (new WebDriverWait(driver, 5))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'"+key+"')]")));
//        System.out.println(allowButton.getText());
//    }

    @Test(priority = 3)
    public void spackButtonAction() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getProduct().click();
        productPage.getAddProduct().click();
        productPage.getSearchCodeBarToAddProduct().sendKeys("1163660235");
        driver.pressKeyCode(66);
    }
}

