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

    @AndroidFindBy(uiAutomator = "text(\"易久批商城\")")
    AndroidElement yjpShop;

    @AndroidFindBy(uiAutomator = "text(\"购物车\")")
    AndroidElement shoppingCar;

    @AndroidFindBy(uiAutomator = "text(\"提交\")")
    AndroidElement submit;

    @AndroidFindBy(uiAutomator = "text(\"进货单\")")
    AndroidElement incomingOrder;

    @AndroidFindBy(id = Environment.PackageName+":id/ll_item_bg")
    AndroidElement firstOrder;

    @AndroidFindBy(xpath = "//android.view.View[@instance='45']")
    AndroidElement purchaseGoods;

    public AndroidElement getYjpPurchase() {
        return yjpPurchase;
    }

    public AndroidElement getYjpShop() {
        return yjpShop;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public AndroidElement getShoppingCar() {
        return shoppingCar;
    }

    public AndroidElement getSubmit() {
        return submit;
    }

    public AndroidElement getIncomingOrder() {
        return incomingOrder;
    }

    public AndroidElement getFirstOrder() {
        return firstOrder;
    }

    public AndroidElement getPurchaseGoods() {
        return purchaseGoods;
    }
}
