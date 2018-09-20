package POSAutomationPageResource;

import PageSource.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Environment;

import java.sql.SQLException;
import java.util.List;

public class StartApp extends Base {

//    public static ResultSet accessDataBaseForLogin() throws SQLException {
//        String host = "localhost";
//        String port = "3306";
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/posandroid", "root", "Liuyongfei1991");
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("select * from LoginInfo");
//        return result;
//    }

    public static void login(AndroidDriver driver) throws SQLException {
        //ResultSet result = accessDataBaseForLogin();
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.inputUserName().sendKeys(ExcelDataDriven.getValueFromExcel(0,1));
        loginPage.inputUserName().sendKeys(LoginPage.USERNAME);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        //loginPage.inputPassword().sendKeys(ExcelDataDriven.getValueFromExcel(1,1));
        loginPage.inputPassword().sendKeys(LoginPage.PASSWORD);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

        loginPage.submit().click();
        WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        allowButton.click();
    }

    //需求：如果登陆框有账号直接输入密码，如果登陆框没有账号输入账号和密码
    public static void loginOnlyForPassword(AndroidDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword().sendKeys(LoginPage.PASSWORD);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

        loginPage.submit().click();
    }

    public static void switchToOldCashier(AndroidDriver driver){
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.getSwitchToOldCashier().click();
    }


    public static void addRegularMemberNumber(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/memberCardScanTV")));
//        CashButton.click();
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.REGULARMEMBER);
        cashierPage.confirmButton().click();
    }

    public static void addWholeSaleMemberNumber(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.WHOLESALEMEMBER);
        cashierPage.confirmButton().click();
    }

    public static void addVipMember(AndroidDriver driver){
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.VIPMEMBER);
        cashierPage.confirmButton().click();
    }

    public static void clearProduct(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPSMALLPACK);
        cashierPage.search().click();
        cashierPage.clearProduct().click();
        cashierPage.confirmButton().click();
    }

    //优惠券扫描
    public static void couponScan(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPSMALLPACK);
        cashierPage.search().click();
        cashierPage.couponScanButton().click();
        cashierPage.confirmButton().click();
    }

    //挂单与解挂
    public static void pendingAndHangingOrder(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pendingOrder().click();
        cashierPage.hangingOrder().click();
    }

    //添加赠品
    public static void addfreebie(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addfreebies().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPBIGPACK);
        cashierPage.confirmButton().click();
    }

    //输入物流码
    public static void logisticsCodeAdd(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.logisticsCodeButton().click();
        cashierPage.logisticsCodeInputLine().sendKeys(cashierPage.LOGISTICSCODE);
        driver.hideKeyboard();
        cashierPage.confirmButton().click();
    }

    //改价
    public static void changePrice(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.changePrice().click();
        cashierPage.changePriceInputLine().sendKeys(cashierPage.PRICEAFTERCHANGED);
        cashierPage.confirmButton().click();
    }

    //删除商品
    public static void deleteProduct(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.deleteProductButton().click();
        cashierPage.confirmButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    //普通会员信用卡买单非统一销售商品
    public static void regularMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.creditSaleButton().click();
        cashierPage.creditSaleSureButton().click();
    }

    public static void vipMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.getNewCashier().click();
        cashierPage.creditSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void wholeSaleMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.creditSaleButton().click();
        cashierPage.creditSaleSureButton().click();
    }

    public static void vipMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.getNewCashier().click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void regularMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        WebElement CashButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void wholeSaleMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        WebElement CashButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void vipMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.getNewCashier().click();
        cashierPage.debitCardButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void regularMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        WebElement CashButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.debitCardButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void wholeSaleMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        WebElement CashButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
        CashButton.click();
        //cashierPage.cashSaleButton().click();
        cashierPage.debitCardButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void vipMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.getNewCashier().click();
        cashierPage.creditCardButton().click();
        cashierPage.confirmButton().click();
        cashierPage.getPrintReceipt().click();
        cashierPage.totalPayButton().click();
    }

    public static void regularMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.cashSaleButton().click();
        cashierPage.creditCardButton().click();
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void wholeSaleMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.cashSaleButton().click();
        cashierPage.creditCardButton().click();
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void walkingMemberCreditSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
        cashierPage.creditSaleButton().click();
    }

    public static void walkingMemberCashSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void walkingMemberDebitCardSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.debitCardButton().click();
        cashierPage.totalPayButton().click();
    }

    public static void walkingMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
        cashierPage.cashSaleButton().click();
        cashierPage.creditCardButton().click();
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
    }

    //带分的散装商品现金支付
    public static void bulkGoodsCashSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 2; i++) {
            cashierPage.noCodeProductAddButton.click();
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
    }

    //带分的散装商品储蓄卡支付
    public static void bulkGoodsDebitCardSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 2; i++) {
            cashierPage.noCodeProductAddButton.click();
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.debitCardButton().click();
        cashierPage.totalPayButton().click();
    }

    //带分的散装商品信用卡支付
    public static void bulkGoodsCreditCardSale(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 2; i++) {
            cashierPage.noCodeProductAddButton.click();
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.cashSaleButton().click();
        cashierPage.creditCardButton().click();
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
    }

    //退款
    public static void reFund(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyTrade().click();
        WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/orderNoTV")));
        List<WebElement> orderlists = driver.findElementsById(Environment.PackageName + ":id/orderNoTV");
        String text = orderlists.get(1).getText();
        System.out.println(text);
        cashierPage.reFundButton().click();
        cashierPage.reFundInputLine().sendKeys(text);
        cashierPage.search().click();
        cashierPage.getChooseAllItem().click();
        //cashierPage.noCodeProductAddButton().click();
        cashierPage.secondRefundButton().click();
        cashierPage.enSureRefundButton().click();
        cashierPage.getInputBoxOfLastSixNumber().sendKeys(text.substring(12));
        cashierPage.confirmButton().click();

    }

    public static void pressDailyTrade(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyTrade().click();
    }

    public static void pressDailyReport(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyReport().click();
    }

    public static void pressRegisterCommission(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.registerCommission().click();
    }

    public static void handOver(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.handOvers().click();
        Thread.sleep(4000);
        cashierPage.handOversButton().click();
        driver.findElement(By.id(Environment.PackageName + ":id/tv_ok")).click();
    }
}
