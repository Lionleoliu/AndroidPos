package POSAutomationPageResource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import util.Environment;

import java.util.concurrent.TimeUnit;

public class CashierPage {
    AndroidDriver driver;
    public static final String REGULARMEMBER = "17786410583";//普通会员
    public static final String UNIFORMPRODUCT = "1111111111111";//统一销售商品
    public static final String NonUNIFORMPRODUCT = "6954767470573";//非统一销售商品
    public static final String WHOLESALEMEMBER = "17671607988";//批发会员
    public static final String TESTSOAPSMALLPACK = "445678456";//测试肥皂小包装
    public static final String TESTSOAPBIGPACK = "456456456";//测试肥皂大包装
    public static final String LOGISTICSCODE = "123123123";
    public static final String PRICEAFTERCHANGED = "4.5";
    public static final String BULKGOODSWITHCENTS = "9900000";
    public static final String VIPMEMBER = "17728282828";//VIP会员


    //初始化页面元素

    public CashierPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    //第二个退款按钮
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.RelativeLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.support.v4.view.ViewPager/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.RelativeLayout/android.widget.TextView")
    AndroidElement secondRefundButton;

    //添加会员按钮
    @AndroidFindBy(uiAutomator = "text(\"添加会员\")")
    AndroidElement addMember;

    //输入会员手机号框
    @AndroidFindBy(uiAutomator = "text(\"请扫入或者输入会员号/手机号,支持后四位查询\")")
    AndroidElement inputMemberPhoneNumber;

    //点击会员手机号框确认按钮
    @AndroidFindBy(uiAutomator = "text(\"确认\")")
    AndroidElement confirmButton;

    //输入条码框
    @AndroidFindBy(uiAutomator = "text(\"请扫入或者输入商品条码或助记码\")")
    AndroidElement scanCodeBar;

    //搜索按钮
    @AndroidFindBy(uiAutomator = "text(\"搜索\")")
    AndroidElement search;

    //赊账按钮
    @AndroidFindBy(uiAutomator = "text(\"赊账\")")
    AndroidElement creditSaleButton;

    //赊账确定按钮
    @AndroidFindBy(uiAutomator = "text(\"确认\")")
    AndroidElement creditSaleSureButton;

    //现金按钮
    @AndroidFindBy(uiAutomator = "text(\"现金\")")
    AndroidElement cashSaleButton;

    //总支付按钮
    @AndroidFindBy(uiAutomator = "text(\"支付\")")
    AndroidElement totalPayButton;

    //储蓄卡支付按钮
    @AndroidFindBy(uiAutomator = "text(\"储蓄卡\")")
    AndroidElement debitCardButton;

    //信用卡支付按钮
    @AndroidFindBy(uiAutomator = "text(\"信用卡\")")
    AndroidElement creditCardButton;

    //散客按钮
    @AndroidFindBy(uiAutomator = "text(\"    散客    \")")
    AndroidElement walkingInMember;

    //无条码商品
    @AndroidFindBy(uiAutomator = "text(\"无条码商品\")")
    AndroidElement noCodeProductButton;

    //无条码商品调价按钮
    @AndroidFindBy(id = Environment.PackageName+":id/ll_add_number_iv")
    AndroidElement noCodeProductAddButton;

    //返回收银台按钮
    @AndroidFindBy(uiAutomator = "text(\"返回收银台\")")
    AndroidElement returnCashierDesktopButton;

    //清空按钮
    @AndroidFindBy(uiAutomator = "text(\"清空\")")
    AndroidElement clearProduct;

    //优惠券扫描按钮
    @AndroidFindBy(uiAutomator = "text(\"优惠券扫描\")")
    AndroidElement couponScanButton;

    //挂单按钮
    @AndroidFindBy(uiAutomator = "text(\"挂单\")")
    AndroidElement pendingOrder;

    //解挂按钮
    @AndroidFindBy(uiAutomator = "text(\"解挂\")")
    AndroidElement hangingOrder;

    //添加赠品
    @AndroidFindBy(uiAutomator = "text(\"添加赠品\")")
    AndroidElement addfreebies;

    //输入物流码按钮
    @AndroidFindBy(uiAutomator = "text(\"物流码输入\")")
    AndroidElement logisticsCodeButton;

    //物流码输入框
    @AndroidFindBy(uiAutomator = "text(\"请输入\")")
    AndroidElement logisticsCodeInputLine;

    //改价按钮
    @AndroidFindBy(uiAutomator = "text(\"改价\")")
    AndroidElement changePrice;

    //改价输入框
    @AndroidFindBy(id = Environment.PackageName+":id/productPriceET")
    AndroidElement changePriceInputLine;


    //删除商品按钮
    @AndroidFindBy(uiAutomator = "text(\"删除\")")
    AndroidElement deleteProductButton;

    //当日流水按钮
    @AndroidFindBy(uiAutomator = "text(\"当日流水\")")
    AndroidElement dailyTrade;

    //当日流水复制按钮
    @AndroidFindBy(uiAutomator = "text(\"复制\")")
    AndroidElement dailyTradeCopyButton;

    //退款按钮
    @AndroidFindBy(uiAutomator = "text(\"退款\")")
    AndroidElement reFundButton;

    //退款单号
    @AndroidFindBy(id = Environment.PackageName+":id/orderNoTV")
    AndroidElement reFundNumber;

    //退款输入框
    @AndroidFindBy(uiAutomator = "text(\"请输入或扫入商品订单号/会员卡号\")")
    AndroidElement reFundInputLine;

    //退款商品选择框
    @AndroidFindBy(id = Environment.PackageName+":id/selectAllIV")
    AndroidElement reFundSelectButton;

    //确定退款按钮
    @AndroidFindBy(uiAutomator = "text(\"确定退款\")")
    AndroidElement enSureRefundButton;

    //日报按钮
    @AndroidFindBy(uiAutomator = "text(\"日报\")")
    AndroidElement dailyReport;

    //收银提成按钮
    @AndroidFindBy(uiAutomator = "text(\"收银提成\")")
    AndroidElement registerCommission;

    //交接班
    @AndroidFindBy(uiAutomator = "text(\"交接班\")")
    AndroidElement handOvers;

    //交接按钮
    @AndroidFindBy(uiAutomator = "text(\"交接\")")
    AndroidElement handOversButton;

    //选择
    @AndroidFindBy(uiAutomator = "text(\"选择\")")
    AndroidElement select;

    //新旧收银页面切换按钮
    @AndroidFindBy(id = Environment.PackageName+":id/btn_open_old")
    AndroidElement switchToOldCashier;

    //新收银按钮
    @AndroidFindBy(id = Environment.PackageName+":id/ll_new_cash")
    AndroidElement newCashier;

    //整单全选
    @AndroidFindBy(uiAutomator = "text(\"整单全选\")")
    AndroidElement chooseAllItem;

    @AndroidFindBy(id = Environment.PackageName+":id/printReceiptSwitchBtn")
    AndroidElement printReceipt;

    //退货退款校验输入框
    @AndroidFindBy(uiAutomator = "text(\"请输入订单号后6位\")")
    AndroidElement inputBoxOfLastSixNumber;

    public AndroidElement getInputBoxOfLastSixNumber() {
        return inputBoxOfLastSixNumber;
    }

    public AndroidElement getPrintReceipt() {
        return printReceipt;
    }

    public AndroidElement addMember() {
        return addMember;
    }

    public AndroidElement inputMemberPhoneNumber() {
        return inputMemberPhoneNumber;
    }

    public AndroidElement confirmButton() {
        return confirmButton;
    }

    public AndroidElement scanCodeBar() {
        return scanCodeBar;
    }

    public AndroidElement search() {
        return search;
    }

    public AndroidElement creditSaleButton() {
        return creditSaleButton;
    }

    public AndroidElement creditSaleSureButton() {
        return creditSaleSureButton;
    }

    public AndroidElement cashSaleButton() {
        return cashSaleButton;
    }

    public AndroidElement totalPayButton() {
        return totalPayButton;
    }

    public AndroidElement debitCardButton() {
        return debitCardButton;
    }

    public AndroidElement creditCardButton() {
        return creditCardButton;
    }

    public AndroidElement walkingInMember() {
        return walkingInMember;
    }

    public AndroidElement noCodeProductButton() {
        return noCodeProductButton;
    }

    public AndroidElement noCodeProductAddButton() {
        return noCodeProductAddButton;
    }

    public AndroidElement returnCashierDesktopButton() {
        return returnCashierDesktopButton;
    }

    public void pressWalkingMemberButton(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.walkingInMember().click();
    }

    public AndroidElement clearProduct() {
        return clearProduct;
    }

    public AndroidElement couponScanButton() {
        return couponScanButton;
    }

    public AndroidElement pendingOrder() {
        return pendingOrder;
    }

    public AndroidElement hangingOrder() {
        return hangingOrder;
    }

    public AndroidElement addfreebies() {
        return addfreebies;
    }

    public AndroidElement logisticsCodeButton() {
        return logisticsCodeButton;
    }

    public AndroidElement logisticsCodeInputLine(){
        return logisticsCodeInputLine;
    }

    public AndroidElement changePrice() {
        return changePrice;
    }

    public AndroidElement changePriceInputLine(){
        return changePriceInputLine;
    }

    public AndroidElement deleteProductButton() {
        return deleteProductButton;
    }

    public AndroidElement dailyTrade(){
        return dailyTrade;
    }

    public AndroidElement dailyTradeCopyButton(){
        return dailyTradeCopyButton;
    }

    public AndroidElement reFundButton(){
        return reFundButton;
    }

    public AndroidElement reFundNumber(){
        return reFundNumber;
    }

    public AndroidElement reFundInputLine(){
        return reFundInputLine;
    }

    public AndroidElement reFundSelectButton(){
        return reFundSelectButton;
    }

    public AndroidElement enSureRefundButton(){
        return enSureRefundButton;
    }

    public AndroidElement secondRefundButton(){
        return secondRefundButton;
    }

    public AndroidElement dailyReport(){
        return dailyReport;
    }

    public AndroidElement registerCommission(){
        return registerCommission;
    }

    public AndroidElement handOvers(){
        return handOvers;
    }

    public AndroidElement handOversButton(){
        return handOversButton;
    }

    public AndroidElement getSelect() {
        return select;
    }

    public AndroidElement getSwitchToOldCashier() {
        return switchToOldCashier;
    }

    public AndroidElement getNewCashier() {
        return newCashier;
    }

    public AndroidElement getChooseAllItem() {
        return chooseAllItem;
    }
}
