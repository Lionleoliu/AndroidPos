package PageSource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import util.Environment;

import java.util.concurrent.TimeUnit;

public class YJPPurchasePage {

    AndroidDriver driver;

    public YJPPurchasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(uiAutomator = "text(\"易久批采购\")")
    AndroidElement yjpPurchase;

    @AndroidFindBy(uiAutomator = "text(\"进货单\")")
    AndroidElement incomingOrder;

    public AndroidElement getYjpPurchase() {
        return yjpPurchase;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public AndroidElement getIncomingOrder() {
        return incomingOrder;
    }
}
