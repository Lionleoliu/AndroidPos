package POSAutomationtest;

import POSAutomationPageResource.Base;
import POSAutomationPageResource.StartApp;
import PageSource.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.Environment;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class YJPLPurchase extends Base {

    private AndroidDriver driver;//全局变量

    @Test(priority = 1)//登陆
    public void login() throws IOException, SQLException {
        StartApp.login(driver);
    }
}
