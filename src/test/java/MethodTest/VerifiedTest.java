package MethodTest;

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

import static POSAutomationtest.RunTestCase.connectJDBC;

public class VerifiedTest {

    private AndroidDriver driver;//全局变量


    @BeforeSuite//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = Base.SetUp();
    }

    @Test(priority = 1)//登陆
    public void login() throws IOException, SQLException {
        StartApp.login(driver);
    }

    @Test(priority = 32)
    public void putawayAndUnshelve() throws SQLException, InterruptedException {
        //StartApp.loginOnlyForPassword(driver);
        ProductPage productPage = new ProductPage(driver);
        Thread.sleep(1500);
        productPage.getProduct().click();
        productPage.getAllOfSpinner().click();
        productPage.getSoldOutOfSpinner().click();
        productPage.getFirstProduct().click();
        productPage.getPutaway().click();
        productPage.getCancel().click();
        productPage.getPutaway().click();
        productPage.getConfirm().click();
        productPage.getSoldOutOfSpinner().click();
        productPage.getOnShelvesOfSpinner().click();
        productPage.getFirstProduct().click();
        productPage.getUnShelve().click();
        productPage.getCancel().click();
        productPage.getUnShelve().click();
        productPage.getConfirm().click();
    }
}