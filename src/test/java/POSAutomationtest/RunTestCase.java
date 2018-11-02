package POSAutomationtest;

import POSAutomationPageResource.Appium_Env;
import POSAutomationPageResource.Base;
import POSAutomationPageResource.CashierPage;
import POSAutomationPageResource.StartApp;
import PageSource.ProductPage;
import PageSource.YJPPurchasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import util.BarcodeList;
import util.Environment;

import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class RunTestCase extends Appium_Env {

    private AndroidDriver driver;//全局变量

//    @BeforeClass//设置
//    public void setUp() throws IOException, InterruptedException {
////        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
////        Thread.sleep(3000L);
//        driver = Base.SetUp();
//    }

    public static ResultSet connectJDBC() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://Mysql-Retail.yjp.com:3313/yjpl_product?serverTimezone=UTC";
        String username = "root";
        String password = "yijiupi";


        //2.通过DriverManager的Connection链接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String querySql = "Select barcode\n" +
                "From product_info_specification_barcode \n" +
                "order by create_time desc";
        ResultSet resultSet = statement.executeQuery(querySql);

//        resultSet.close();
//        statement.close();
//        connection.close();
        return resultSet;
    }


    @Test(priority = 1)//登陆
    public void login() throws IOException, SQLException {
        StartApp.login(driver);
    }

    @Test(priority = 2)//新VIP会员赊账支付
    public void vipMemberCreditSale() throws InterruptedException {
        StartApp.vipMemberCreditSale(driver);
    }

    @Test(priority = 3)
    public void vipMemberCashSale() throws InterruptedException {
        StartApp.vipMemberCashSale(driver);
    }

    @Test(priority = 4)
    public void vipMemberDebitCardSale() throws InterruptedException {
        StartApp.vipMemberDebitCardSale(driver);
    }

    @Test(priority = 4)
    public void vipMemberCreditCardSale() throws InterruptedException {
        StartApp.vipMemberCreditCardSale(driver);
    }


    @Test(priority = 5)//普通会员赊账支付
    public void regularMemberCreditSale() throws InterruptedException {
        StartApp.switchToOldCashier(driver);
        StartApp.regularMemberCreditSale(driver);
    }

    @Test(priority = 6)//普通会员现金支付
    public void regularMemberCashSale() throws InterruptedException {
        StartApp.regularMemberCashSale(driver);
    }

    @Test(priority = 7)//普通会员储蓄卡支付
    public void regularMemberDebitCardSale() throws InterruptedException {
        StartApp.regularMemberDebitCardSale(driver);
    }

    @Test(priority = 8)//普通会员信用卡支付
    public void regularMemberCreditCardSale() throws InterruptedException {
        StartApp.regularMemberCreditCardSale(driver);
    }

    @Test(priority = 9)//清除商品
    public void clearProduct() throws InterruptedException {
        StartApp.clearProduct(driver);
    }

    @Test(priority = 10)//优惠券扫描
    public void couponScan() throws InterruptedException {
        StartApp.couponScan(driver);
    }

    @Test(priority = 11)//挂单
    public void  pendingAndHangingOrder(){
        StartApp.pendingAndHangingOrder(driver);
    }

    @Test(priority = 12)//添加优惠券
    public void addfreebie(){
        StartApp.addfreebie(driver);
    }

    @Test(priority = 13)//输入物流码
    public void logisticsCodeAdd(){
        StartApp.logisticsCodeAdd(driver);
    }

    @Test(priority = 14)//改价
    public void changePrice(){
        StartApp.changePrice(driver);
    }

    @Test(priority = 15) //删除商品
    public void deleteProduct(){
        StartApp.deleteProduct(driver);
    }


    @Test(priority = 16)//批发会员赊账支付
    public void wholeSaleMemberCreditSale() throws InterruptedException {
        StartApp.wholeSaleMemberCreditSale(driver);
    }

    @Test(priority = 17)//批发会员现金支付
    public void wholeSaleMemberCashSale() throws InterruptedException {
        StartApp.wholeSaleMemberCashSale(driver);
    }

    @Test(priority = 18)//批发会员现金支付
    public void wholeSaleMemberDebitCardSale() throws InterruptedException {
        StartApp.wholeSaleMemberDebitCardSale(driver);
    }

    @Test(priority = 19)//批发会员现金支付
    public void wholeSaleMemberCreditCardSale() throws InterruptedException {
        StartApp.wholeSaleMemberCreditCardSale(driver);
    }

    @Test(priority = 20)//散客赊账支付，支付应该不成功
    public void walkingMemberCreditSale() throws InterruptedException {
        StartApp.walkingMemberCreditSale(driver);
    }

    @Test(priority = 21)//散客现金支付
    public void walkingMemberCashSale() throws InterruptedException {
        StartApp.walkingMemberCashSale(driver);
    }

    @Test(priority = 22)//散客会员储蓄卡支付
    public void walkingMemberDebitCardSale() throws InterruptedException {
        StartApp.walkingMemberDebitCardSale(driver);
    }

    @Test(priority = 23)//散客会员信用卡支付
    public void walkingMemberCreditCardSale() throws InterruptedException {
        StartApp.walkingMemberCreditCardSale(driver);
    }

    @Test(priority = 24)//散客散货现金支付
    public void bulkGoodsCashSale(){
        StartApp.bulkGoodsCashSale(driver);
    }

    @Test(priority = 25)//散客散货储蓄卡支付
    public void bulkGoodsDebitCardSale(){
        StartApp.bulkGoodsDebitCardSale(driver);
    }

    @Test(priority = 26)//散客散货信用卡支付
    public void bulkGoodsCreditCardSale() throws InterruptedException {
        Thread.sleep(4000);
        StartApp.bulkGoodsCreditCardSale(driver);
    }

    @Test(priority = 27)//退款
    public void reFund(){
        StartApp.reFund(driver);
    }

    @Test(priority = 28)//点击当日流水
    public void pressDailyTrade() throws InterruptedException {
        StartApp.pressDailyTrade(driver);
    }

    @Test(priority = 29)//点击日报
    public void pressDailyReport() throws InterruptedException {
        StartApp.pressDailyReport(driver);
    }

    @Test(priority = 30)//点击收银提成
    public void pressRegisterCommission() throws InterruptedException {
        StartApp.pressRegisterCommission(driver);
    }

    @Test(priority = 31)//点击交接班
    public void handOver() throws InterruptedException {
        StartApp.handOver(driver);
    }

    //上下架
    @Test(priority = 32)
    public void putawayAndUnshelve() throws SQLException, InterruptedException {
        StartApp.loginOnlyForPassword(driver);
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

//    //盘存打印
    @Test(priority = 33)
    public void inventoryPrint() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSearchBar().sendKeys(Environment.ProductOfGoods);
        productPage.getSearch().click();
        productPage.getOnlineSale().click();
        productPage.getOnlineSale().click();
        //productPage.getSearchBar().clear();
        productPage.getRicewineCategory().click();
        productPage.getInventoryPrint().click();
        productPage.getConfirm().click();
    }

    //进货
    @Test(priority = 34)
    public void purchaseGoods() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getExpansion().click();//点击展开按钮
        productPage.getWineCategory().click();//点击葡萄酒类目
        String beforeStock = productPage.getGetStockOfBeforePurchase().getText();//获取购买之前的数量
        String beforeStock1 = beforeStock.substring(0, beforeStock.length() - 1);//使购买之前的数量去掉后面的瓶以便比对
        productPage.getPurchase().click();//点击购买按钮
        productPage.getPurchaseCount().sendKeys(Environment.PurchaseCount);//输入购买1瓶
        productPage.getPurchase().click();//点击购买按钮
        String afterStock = productPage.getGetStockOfBeforePurchase().getText();//获取购买后的库存文本
        Thread.sleep(1500);
        String afterStock1 = afterStock.substring(0, beforeStock.length() - 1);//使购买后的数量去掉后面的瓶以便比对
        int afterStockInt = Integer.parseInt(afterStock1);
        int beforeStockAdd = Integer.parseInt(beforeStock1);//将购买前的字符串变成int类型以便加1
        int beforeStockAfterAdd = beforeStockAdd + 1;//购买前的数量+1
        Assert.assertEquals(afterStockInt,beforeStockAfterAdd);//比较购买后的数量和购买前的数量是否一致
    }

    //添加规格
    @Test(priority = 35)
    public void addingSpecifications() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getAddNewsSpecifications().click();
        productPage.getChooseSpecifications().click();
        productPage.getBottle().click();
        productPage.getSpecificationsAmount().sendKeys(Environment.SpecificationsAmount);
        productPage.getSpecificationsRetailPriceInputBox().sendKeys(Environment.SpecificationsRetailPrice);
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }

    //修改成本价
    @Test(priority = 36)
    public void costPriceChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getCostPriceChangeButton().click();
        productPage.getCostPriceInputBox().sendKeys(Environment.CostPrice);
        productPage.getConfirm().click();
    }

    //修改规格
    @Test(priority = 37)
    public void specificationsChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSpecificationsChangeButton().click();
        productPage.getBottle().click();
        productPage.getConfirm().click();
    }

    //修改零售价
    @Test(priority = 38)
    public void retailPriceChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getRetailPriceChangeButton().click();
        productPage.getRetailPriceInputBox().sendKeys(Environment.RetailPrice);
        productPage.getConfirm().click();
    }

    //修改批发价
    @Test(priority = 39)
    public void wholeSalePriceChange() {
        ProductPage productPage = new ProductPage(driver);
        WebElement category = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName+":id/tv_fix_discount_price")));
        category.click();
        //productPage.getWholeSalePriceChangeButton().click();
        productPage.getWholeSalePriceInputBox().sendKeys(Environment.WholeSalePrice);
        productPage.getConfirm().click();
    }

    //修改条码
    @Test(priority = 40)
    public void barCodeChange() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getBarCodeChangeButton().click();
        productPage.getBarCodeInputBox().sendKeys(Environment.BarCode);
        productPage.getBarCodeAdding().click();
        productPage.getConfirm().click();
        Thread.sleep(1500);
        List<AndroidElement> deleteButton = driver.findElementsByClassName("android.widget.Button");
        Thread.sleep(1000);
        deleteButton.get(2).click();
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }

    //修改会员价
    @Test(priority = 41)
    public void memberPriceChange() throws InterruptedException, SQLException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSetUpMemberPrice().click();
        productPage.getSettingButtonForMemberPrice().click();
        productPage.getMemberPriceInputBox().sendKeys(Environment.MemberPrice);
        productPage.getConfirm().click();
        productPage.getSelectAll().click();
        productPage.getSetUpAllMemberPrice().click();
        productPage.getSetUpMemberPriceInputBox().sendKeys(Environment.MemberPrice);
        productPage.getConfirm().click();
        productPage.getSelectAll().click();
        productPage.getSetUpAllMemberPrice().click();
        productPage.getClearMemberPrice().click();
        Thread.sleep(1000);
        productPage.getDetermine().click();
        productPage.getBackButton().click();
    }

    //需求：扫码新增商品的判断
    //思路：首先连接到开发环境的数据库环境，拿到开发环境的数据
    @Test(priority = 42)
    public void searchBarCodeAddProduct() throws SQLException, ClassNotFoundException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getProduct().click();
        ResultSet resultSet = connectJDBC();
        productPage.getAddProduct().click();
        while (resultSet.next()) {
            productPage.getSearchCodeBarToAddProduct().sendKeys(resultSet.getString("barcode"));
            break;
        }
        productPage.getSearch().click();
        productPage.getLongTerm().click();
        productPage.getSubmit().click();
        productPage.getConfirm().click();
        productPage.getBackButton().click();
    }

    //添加商品
    @Test(priority = 43)
    public void addingNewProduct() throws InterruptedException, SQLException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getAddProduct().click();
        Thread.sleep(1000);
        productPage.getSearch().click();

        WebElement category = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/tv_data")));
        category.click();
        //productPage.getCategoryOfAddingNewProduct().click();
        WebElement ricewineCategory = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/title")));
        ricewineCategory.click();

        Thread.sleep(1000);
        productPage.getSoap().click();
        productPage.getProductName().sendKeys(Environment.ProductName + Environment.getTime());
        productPage.getLongTerm().click();
        productPage.getSelect().click();
        Thread.sleep(1500);
        productPage.getBottle().click();
        productPage.getBarCodeForAddingProduct().click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys("1" + Environment.getRandomNum());
        productPage.getConfirm().click();
        productPage.getSalePriceForAddingProduct().click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.RetailPrice);
        productPage.getConfirm().click();
        productPage.getAddNewsSpecifications().click();
        //第二行的规格单位选择
        Thread.sleep(2000);
        addSecondProductInfo();
        productPage.getDelete().click();
        productPage.getAddNewsSpecifications().click();
        addSecondProductInfo();
        productPage.getSubmit().click();
        productPage.getInputBoxClearButton().click();
        productPage.getRicewineCategory().click();
        productPage.getPutaway().click();
        productPage.getConfirm().click();
    }

    public void addSecondProductInfo() {
        ProductPage productPage = new ProductPage(driver);
        List<AndroidElement> chooseButton = driver.findElementsById(Environment.PackageName + ":id/btn_choose_unit");
        chooseButton.get(1).click();
        productPage.getPiece().click();
        productPage.getAddingSecondSpecifications().click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.SecondSpecifications);
        productPage.getConfirm().click();
        List<AndroidElement> barCodeButton = driver.findElementsById(Environment.PackageName + ":id/ed_barcode");
        barCodeButton.get(1).click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys("2" + Environment.getRandomNum());
        productPage.getConfirm().click();
        List<AndroidElement> retailPriceButton = driver.findElementsById(Environment.PackageName + ":id/ed_retail_price");
        retailPriceButton.get(1).click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.SecondSpecificationsPrice);
        productPage.getConfirm().click();
    }

    //需求：先获取进货前的库存，然后获取进货后的库存，最后比对进货后的库存是不是等于进货前的库存-1
    //外采
    @Test(priority = 45)
    public void outSidePurchase() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getAllOfSpinner().click();
        productPage.getOnShelvesOfSpinner().click();
        productPage.getDrinkCategory().click();
        List<WebElement> beforeStock = driver.findElementsById(Environment.PackageName + ":id/tv_stock");
        Thread.sleep(1500);
        String text = beforeStock.get(1).getText();//获取外采前的库存数量
        String beforeStockNumber = text.substring(0, text.length() - 1);
        int beforeStockNumber1 = Integer.parseInt(beforeStockNumber);
        int beforeStockNumber2 = beforeStockNumber1 + 1;
        productPage.getOutsidePurcase().click();
        productPage.getOutsidePurchaseAmount().sendKeys(Environment.PurchaseCount);
        productPage.getPurchase().click();
        List<WebElement> afterStock = driver.findElementsById(Environment.PackageName + ":id/tv_stock");
        String afterStockNumber = afterStock.get(1).getText();
        String afterStockNumber1 = afterStockNumber.substring(0, afterStockNumber.length() - 1);
        int afterStockNumber2 = Integer.parseInt(afterStockNumber1);
        Assert.assertEquals(afterStockNumber2,beforeStockNumber2);
    }

    //作废
    @Test(priority = 46)
    public void cancellation() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getOnShelvesOfSpinner().click();
        productPage.getSoldOutOfSpinner().click();
        productPage.getFoodAndOil().click();
        productPage.getDeleteProductButton().click();
        productPage.getConfirm().click();
        productPage.getDeleteProduct().click();
        productPage.getCancelDelete().click();
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }
}
