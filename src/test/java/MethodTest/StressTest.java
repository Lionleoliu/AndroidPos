package MethodTest;

import POSAutomationPageResource.Base;
import POSAutomationPageResource.CashierPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.BarcodeList;

import java.io.IOException;
import java.util.Iterator;

public class StressTest {
    private AndroidDriver driver;//全局变量
    Logger logger = Logger.getLogger("TestMethod");

    public static void configure(){
        PropertyConfigurator.configure("E:\\YJPWork\\Code\\YJPRetailAutoTestDemo\\log4j.properties");
    }

    @BeforeSuite//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        configure();
        driver = Base.SetUp();
    }

    public void stressTest() throws InterruptedException {

        for (int i = 1; i < 10; i++) {
            CashierPage cashierPage = new CashierPage(driver);
            Thread.sleep(2000);
            cashierPage.walkingInMember().click();
            Iterator<String> iterator = BarcodeList.barCode().iterator();
            while (iterator.hasNext()) {
                cashierPage.scanCodeBar().sendKeys(iterator.next());
                WebElement category = (new WebDriverWait(driver, 20))
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/btn_search")));
                category.click();
                Thread.sleep(1500);
                int select_size = driver.findElements(By.id("com.yijiupi.retail:id/selectTV")).size();
                int no_product_size = driver.findElements(By.id("com.yijiupi.retail:id/tv_ok")).size();
                if (select_size > 0) {
                    Thread.sleep(1500);
                    WebElement select = (new WebDriverWait(driver, 10))
                            .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/selectTV")));
                    select.click();
                } else if (no_product_size == 1){
                    Thread.sleep(1500);
                cashierPage.confirmButton().click();
                }
                else
                cashierPage.search().click();
                logger.info(util.Environment.getTime());
                //System.out.println(util.Environment.getTime());
            }
        }
    }
}
