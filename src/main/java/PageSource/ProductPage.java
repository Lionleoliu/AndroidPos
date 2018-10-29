package PageSource;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import util.Environment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductPage {
    AndroidDriver driver;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(uiAutomator = "text(\"全部\")")
    AndroidElement allOfSpinner;

    @AndroidFindBy(uiAutomator = "text(\"已下架\")")
    AndroidElement soldOutOfSpinner;

    @AndroidFindBy(id = Environment.PackageName+":id/ll_item_bg")
    AndroidElement firstProduct;

    @AndroidFindBy(uiAutomator = "text(\"上架\")")
    AndroidElement putaway;

    @AndroidFindBy(uiAutomator = "text(\"取消\")")
    AndroidElement cancel;

    @AndroidFindBy(uiAutomator = "text(\"确认\")")
    AndroidElement confirm;

    @AndroidFindBy(uiAutomator = "text(\"确定\")")
    AndroidElement determine;

    @AndroidFindBy(uiAutomator = "text(\"已上架\")")
    AndroidElement onShelvesOfSpinner;

    @AndroidFindBy(uiAutomator = "text(\"下架\")")
    AndroidElement unShelve;

    @AndroidFindBy(uiAutomator = "text(\"请输入商品名称/条码/助记码\")")
    AndroidElement searchBar;

    @AndroidFindBy(uiAutomator = "text(\"搜索\")")
    AndroidElement search;

    @AndroidFindBy(id = Environment.PackageName+":id/btn_sale_online")
    AndroidElement onlineSale;

    @AndroidFindBy(uiAutomator = "text(\"白酒\")")
    AndroidElement ricewineCategory;

    @AndroidFindBy(uiAutomator = "text(\"盘存打印\")")
    AndroidElement inventoryPrint;

    @AndroidFindBy(uiAutomator = "text(\"展开\")")
    AndroidElement expansion;

    @AndroidFindBy(uiAutomator = "text(\"葡萄酒\")")
    AndroidElement wineCategory;

    @AndroidFindBy(uiAutomator = "text(\"进货\")")
    AndroidElement purchase;
    //进货数量
    @AndroidFindBy(id = Environment.PackageName+":id/ed_purchase_count")
    AndroidElement purchaseCount;

    @AndroidFindBy(uiAutomator = "text(\"编辑\")")
    AndroidElement update;

    @AndroidFindBy(uiAutomator = "text(\"提交\")")
    AndroidElement submit;

    @AndroidFindBy(uiAutomator = "text(\"⊕新增规格\")")
    AndroidElement addNewsSpecifications;

    @AndroidFindBy(uiAutomator = "text(\"选择规格单位\")")
    AndroidElement chooseSpecifications;

    @AndroidFindBy(uiAutomator = "text(\"瓶\")")
    AndroidElement bottle;

    @AndroidFindBy(uiAutomator = "text(\"件\")")
    AndroidElement piece;

    //新增规格的规格数量
    @AndroidFindBy(id = Environment.PackageName+":id/unitNumber")
    AndroidElement specificationsAmount;
    //新增规格的零售价
    @AndroidFindBy(id = Environment.PackageName+":id/retailPrice")
    AndroidElement specificationsRetailPriceInputBox;
    //成本价修改按钮
    @AndroidFindBy(id = Environment.PackageName+":id/btn_fix_costPrice")
    AndroidElement costPriceChangeButton;
    //成本价修改框
    @AndroidFindBy(id = Environment.PackageName+":id/productSetRetailET")
    AndroidElement costPriceInputBox;
    //销售规格修改按钮
    @AndroidFindBy(id = Environment.PackageName+":id/tv_fix_spec")
    AndroidElement specificationsChangeButton;
    //零售价修改按钮
    @AndroidFindBy(id = Environment.PackageName+":id/tv_fix_retail_price")
    AndroidElement retailPriceChangeButton;
    //零售价设置输入框
    @AndroidFindBy(id = Environment.PackageName+":id/productSetRetailET")
    AndroidElement retailPriceInputBox;
    //批发价修改按钮
    @AndroidFindBy(id = Environment.PackageName+":id/tv_fix_discount_price")
    AndroidElement wholeSalePriceChangeButton;
    //批发价输入框
    @AndroidFindBy(id = Environment.PackageName+":id/productPriceDiscountET")
    AndroidElement wholeSalePriceInputBox;
    //条码修改按钮
    @AndroidFindBy(id = Environment.PackageName+":id/tv_fix_bar_code")
    AndroidElement barCodeChangeButton;
    //条码修改输入框
    @AndroidFindBy(id = Environment.PackageName+":id/barcodeET")
    AndroidElement barCodeInputBox;
    //条码的添加按钮
    @AndroidFindBy(uiAutomator = "text(\"添加\")")
    AndroidElement barCodeAdding;
    //设置会员价
    @AndroidFindBy(uiAutomator = "text(\"设置会员价\")")
    AndroidElement setUpMemberPrice;

    //会员价里的设置按钮
    @AndroidFindBy(id = Environment.PackageName+":id/tv_member_setprice")
    AndroidElement settingButtonForMemberPrice;

    //会员价设置输入框
    @AndroidFindBy(id = Environment.PackageName+":id/ed_member_price")
    AndroidElement memberPriceInputBox;

    //会员价的全选按钮
    @AndroidFindBy(id = Environment.PackageName+":id/selectAllIV")
    AndroidElement selectAll;

    //批量设置会员价
    @AndroidFindBy(uiAutomator = "text(\"批量设置会员价\")")
    AndroidElement setUpAllMemberPrice;

    //批量设置会员价输入框
    @AndroidFindBy(id = Environment.PackageName+":id/et_set_price")
    AndroidElement setUpMemberPriceInputBox;

    @AndroidFindBy(uiAutomator = "text(\"清空会员价\")")
    AndroidElement clearMemberPrice;


    //返回按钮
    @AndroidFindBy(uiAutomator = "text(\"返回\")")
    AndroidElement backButton;

    @AndroidFindBy(uiAutomator = "text(\"新增商品\")")
    AndroidElement addProduct;

    //新增商品的类目
    @AndroidFindBy(id = Environment.PackageName+":id/tv_data")
    AndroidElement categoryOfAddingNewProduct;

    @AndroidFindBy(uiAutomator = "text(\"金沙\")")
    AndroidElement goldSand;


    @AndroidFindBy(uiAutomator = "text(\"肥皂\")")
    AndroidElement soap;


    @AndroidFindBy(uiAutomator = "text(\"请按照品牌+品名+口味/度数+净重（规格）\")")
    AndroidElement productName;

    @AndroidFindBy(id = Environment.PackageName+":id/et_zhujinma")
    AndroidElement mnemonicCode;
    //规格的选择
    @AndroidFindBy(uiAutomator = "text(\"选择\")")
    AndroidElement select;
    //新增商品的条码
    @AndroidFindBy(id = Environment.PackageName+":id/ed_barcode")
    AndroidElement barCodeForAddingProduct;
    //条码的输入框
    @AndroidFindBy(id = Environment.PackageName+":id/barcodeET")
    AndroidElement barCodeInputBoxForAddingProduct;
    //新增商品的售价框
    @AndroidFindBy(id = Environment.PackageName+":id/ed_retail_price")
    AndroidElement salePriceForAddingProduct;

    @AndroidFindBy(id = Environment.PackageName+":id/ed_spec_num")
    AndroidElement addingSecondSpecifications;

    @AndroidFindBy(uiAutomator = "text(\"最多输入20字\")")
    AndroidElement introduction;

    @AndroidFindBy(uiAutomator = "text(\"删除\")")
    AndroidElement delete;

    @AndroidFindBy(id = Environment.PackageName+":id/iv_product_img")
    AndroidElement addingPicture;

    @AndroidFindBy(id = Environment.PackageName+":id/iv_album_content_image")
    AndroidElement firstImage;

    @AndroidFindBy(id = Environment.PackageName+":id/menu_action_ok")
    AndroidElement pictureConfirm;

    //
    @AndroidFindBy(uiAutomator = "text(\"饮料\")")
    AndroidElement drinkCategory;

    //外采
    @AndroidFindBy(uiAutomator = "text(\"外采\")")
    AndroidElement outsidePurcase;

    @AndroidFindBy(id = Environment.PackageName+":id/ed_purchase_count")
    AndroidElement outsidePurchaseAmount;

    @AndroidFindBy(uiAutomator = "text(\"作废\")")
    AndroidElement deleteProductButton;

    @AndroidFindBy(uiAutomator = "text(\"作废商品\")")
    AndroidElement deleteProduct;

    @AndroidFindBy(uiAutomator = "text(\"取消作废\")")
    AndroidElement cancelDelete;

    @AndroidFindBy(id = Environment.PackageName+":id/cancel_img")
    AndroidElement closeButton;

    @AndroidFindBy(uiAutomator = "text(\"商品\")")
    AndroidElement product;

    //删除输入框的X的按钮
    @AndroidFindBy(id = Environment.PackageName+":id/clearRL")
    AndroidElement inputBoxClearButton;

    //新增商品的长期
    @AndroidFindBy(id = Environment.PackageName+":id/rb_long")
    AndroidElement longTerm;

    //食品粮油类目
    @AndroidFindBy(uiAutomator = "text(\"食品粮油\")")
    AndroidElement foodAndOil;

    //食品粮油类目
    @AndroidFindBy(uiAutomator = "text(\"扫码录入商品\")")
    AndroidElement searchCodeBarToAddProduct;


    //购买前库存
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[6]")
    AndroidElement getStockOfBeforePurchase;

    public AndroidElement getProduct() {

        return product;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public AndroidElement getAllOfSpinner() {
        return allOfSpinner;
    }

    public AndroidElement getSoldOutOfSpinner() {
        return soldOutOfSpinner;
    }

    public AndroidElement getFirstProduct() {
        return firstProduct;
    }

    public AndroidElement getPutaway() {
        return putaway;
    }

    public AndroidElement getCancel() {
        return cancel;
    }

    public AndroidElement getConfirm() {
        return confirm;
    }

    public AndroidElement getDetermine() {
        return determine;
    }

    public AndroidElement getOnShelvesOfSpinner() {
        return onShelvesOfSpinner;
    }

    public AndroidElement getUnShelve() {
        return unShelve;
    }

    public AndroidElement getSearchBar() {
        return searchBar;
    }

    public AndroidElement getSearch() {
        return search;
    }

    public AndroidElement getOnlineSale() {
        return onlineSale;
    }

    public AndroidElement getRicewineCategory() {
        return ricewineCategory;
    }

    public AndroidElement getInventoryPrint() {
        return inventoryPrint;
    }

    public AndroidElement getExpansion() {
        return expansion;
    }

    public AndroidElement getWineCategory() {
        return wineCategory;
    }

    public AndroidElement getPurchase() {
        return purchase;
    }

    public AndroidElement getPurchaseCount() {
        return purchaseCount;
    }

    public AndroidElement getUpdate() {
        return update;
    }

    public AndroidElement getSubmit() {
        return submit;
    }

    public AndroidElement getAddNewsSpecifications() {
        return addNewsSpecifications;
    }

    public AndroidElement getChooseSpecifications() {
        return chooseSpecifications;
    }

    public AndroidElement getBottle() {
        return bottle;
    }

    public AndroidElement getSpecificationsAmount() {
        return specificationsAmount;
    }

    public AndroidElement getSpecificationsRetailPriceInputBox() {
        return specificationsRetailPriceInputBox;
    }

    public AndroidElement getCostPriceChangeButton() {
        return costPriceChangeButton;
    }

    public AndroidElement getCostPriceInputBox() {
        return costPriceInputBox;
    }

    public AndroidElement getSpecificationsChangeButton() {
        return specificationsChangeButton;
    }

    public AndroidElement getRetailPriceChangeButton() {
        return retailPriceChangeButton;
    }

    public AndroidElement getRetailPriceInputBox() {
        return retailPriceInputBox;
    }

    public AndroidElement getWholeSalePriceChangeButton() {
        return wholeSalePriceChangeButton;
    }

    public AndroidElement getWholeSalePriceInputBox() {
        return wholeSalePriceInputBox;
    }

    public AndroidElement getBarCodeChangeButton() {
        return barCodeChangeButton;
    }

    public AndroidElement getBarCodeInputBox() {
        return barCodeInputBox;
    }

    public AndroidElement getBarCodeAdding() {
        return barCodeAdding;
    }

    public AndroidElement getSetUpMemberPrice() {
        return setUpMemberPrice;
    }

    public AndroidElement getSettingButtonForMemberPrice() {
        return settingButtonForMemberPrice;
    }

    public AndroidElement getMemberPriceInputBox() {
        return memberPriceInputBox;
    }

    public AndroidElement getSelectAll() {
        return selectAll;
    }

    public AndroidElement getSetUpAllMemberPrice() {
        return setUpAllMemberPrice;
    }

    public AndroidElement getSetUpMemberPriceInputBox() {
        return setUpMemberPriceInputBox;
    }

    public AndroidElement getClearMemberPrice() {
        return clearMemberPrice;
    }

    public AndroidElement getBackButton() {
        return backButton;
    }

    public AndroidElement getAddProduct() {
        return addProduct;
    }

    public AndroidElement getCategoryOfAddingNewProduct() {
        return categoryOfAddingNewProduct;
    }

    public AndroidElement getGoldSand() {
        return goldSand;
    }

    public AndroidElement getProductName() {
        return productName;
    }

    public AndroidElement getMnemonicCode() {
        return mnemonicCode;
    }

    public AndroidElement getSelect() {
        return select;
    }

    public AndroidElement getBarCodeForAddingProduct() {
        return barCodeForAddingProduct;
    }

    public AndroidElement getBarCodeInputBoxForAddingProduct() {
        return barCodeInputBoxForAddingProduct;
    }

    public AndroidElement getSalePriceForAddingProduct() {
        return salePriceForAddingProduct;
    }

    public AndroidElement getPiece() {
        return piece;
    }

    public AndroidElement getAddingSecondSpecifications() {
        return addingSecondSpecifications;
    }

    public AndroidElement getDelete() {
        return delete;
    }

    public AndroidElement getIntroduction() {
        return introduction;
    }

    public AndroidElement getAddingPicture() {
        return addingPicture;
    }

    public AndroidElement getFirstImage() {
        return firstImage;
    }

    public AndroidElement getPictureConfirm() {
        return pictureConfirm;
    }

    public AndroidElement getDrinkCategory() {
        return drinkCategory;
    }

    public AndroidElement getOutsidePurcase() {
        return outsidePurcase;
    }

    public AndroidElement getOutsidePurchaseAmount() {
        return outsidePurchaseAmount;
    }

    public AndroidElement getDeleteProductButton() {
        return deleteProductButton;
    }

    public AndroidElement getDeleteProduct() {
        return deleteProduct;
    }

    public AndroidElement getCancelDelete() {
        return cancelDelete;
    }

    public AndroidElement getCloseButton() {
        return closeButton;
    }

    public AndroidElement getSoap() {
        return soap;
    }

    public AndroidElement getInputBoxClearButton() {
        return inputBoxClearButton;
    }

    public AndroidElement getLongTerm() {
        return longTerm;
    }

    public AndroidElement getFoodAndOil() {
        return foodAndOil;
    }

    public AndroidElement getGetStockOfBeforePurchase() {
        return getStockOfBeforePurchase;
    }

    public AndroidElement getSearchCodeBarToAddProduct() {
        return searchCodeBarToAddProduct;
    }


    public void SwipeDown() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        int y1 = height * 3 / 4; //上滑的开始点，从y1开始也就是屏幕的四分之三处
        int y2 = height * 1 / 3; //上滑的结束点，到y2结束也就是屏幕的三分之一处
        TouchAction tAction = new TouchAction(driver);
        tAction.press(width / 2, y1).waitAction(Duration.ofMillis(1000)).moveTo(width / 2, y2).release().perform();

    }

    //下滑
    public void SwipeUp(){
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;

        int y1 = height*1/2; //下滑的开始点，从y1开始也就是屏幕的二分之一处
        int y2 = height*6/7; //下滑的结束点，到y2结束也就是屏幕的七分之六处
        TouchAction tAction = new TouchAction(driver);
        tAction.press(width/2,y1).waitAction(Duration.ofMillis(1000)).moveTo(width/2,y2).release().perform();
    }

}
