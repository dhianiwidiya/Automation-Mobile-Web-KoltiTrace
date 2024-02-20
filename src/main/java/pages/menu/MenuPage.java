package pages.menu;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;


public class MenuPage extends BasePage {
    @AndroidFindBy(id = "com.koltiva.koltitrace:id/tvGreeting")
    private MobileElement txtGreatingHi;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/tvUserName")
    private MobileElement txtGreatingDescription;

    @AndroidFindBy(accessibility = "Dashboard")
    private MobileElement labelDashboard;

    @AndroidFindBy(accessibility = "Transaction")
    private MobileElement labelTransactions;

    @AndroidFindBy(accessibility = "Processing")
    private MobileElement labelProcessing;

    @AndroidFindBy(accessibility = "Delivery")
    private MobileElement labelDelivery;

    @AndroidFindBy(accessibility = "Producer")
    private MobileElement labelProducer;

    @AndroidFindBy(accessibility = "Setting")
    private MobileElement buttonSetting;

    @AndroidFindBy(accessibility = "Home")
    private MobileElement buttonHome;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_shortcut_account")
    private MobileElement buttonAccount;

    @AndroidFindBy(accessibility = "Reception")
    private MobileElement buttonReception;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/buttonAccept")
    private MobileElement labelAccept;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement labelNoThanks;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/koltipay_view")
    private MobileElement koltipayMenu;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_degree")
    private MobileElement weatherMenu;


    public MenuPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickDashboard(){
        click(labelDashboard);
    }

    public boolean weatherIsDisplayed() throws Exception {
        scrollToElement(weatherMenu,"up");
        return weatherMenu.isDisplayed();
    }

    public boolean receptionMenuDisplayed(){
        return buttonReception.isDisplayed();
    }

    public boolean deliveryMenuDisplayed(){
        return labelDelivery.isDisplayed();
    }

    public boolean processingMenuDisplayed(){
        return labelProcessing.isDisplayed();
    }

    public boolean transactionMenuDisplayed(){
        return labelTransactions.isDisplayed();
    }

    public boolean producerMenuDisplayed(){
        return labelProducer.isDisplayed();
    }

    public boolean dashboardMenuDisplayed(){
        return labelDashboard.isDisplayed();
    }

    public boolean koltipayMenuDisplayed(){
        return koltipayMenu.isDisplayed();
    }

    public void clickOnButtonAccount(){
        click(buttonAccount);
    }

    public void clickOnButtonReception(){
        click(buttonReception);
    }

    public boolean isUserOnDashboardPage(){
        driver.closeApp();
        driver.launchApp();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(labelAccept));
            click(labelAccept);
        }catch (Exception e){
            System.out.println("Element not found");
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(labelNoThanks));
            click(labelNoThanks);
        }catch (Exception e){
            System.out.println("Element not found");
        }
        waitForVisibility(txtGreatingHi);
        txtGreatingHi.isDisplayed();
        txtGreatingDescription.isDisplayed();
        return true;
    }
    public void clickOnLabelProducer(){
        click(labelProducer);
    }

    public void clickOnTransactions(){
        click(labelTransactions);
    }

    public void clickOnProcessing(){
        click(labelProcessing);
    }

    public void clickOnDelivery(){
        click(labelDelivery);
    }

    public void clickOnButtonSetting(){
        click(buttonSetting);
    }

    public void clickOnButtonHome(){
        click(buttonHome);
    }
}
