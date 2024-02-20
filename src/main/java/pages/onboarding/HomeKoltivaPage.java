package pages.onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

public class HomeKoltivaPage extends BasePage {

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_title")
    private MobileElement txtManagementInformation;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_subtitle")
    private MobileElement txtManagementInformationSub;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_greeting_main")
    private MobileElement imgStartingPage;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/button_start")
    private MobileElement getStarted;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_title")
    private MobileElement txtGreating;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_subtitle")
    private MobileElement txtGreatingSub;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_greeting_main")
    private MobileElement imgGreating;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_greeting_next")
    private MobileElement arrow;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_login_bottom")
    private MobileElement masukButton;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_versi")
    private MobileElement appVersion;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo")
    private MobileElement logoKoltiTrace;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo")
    private MobileElement language;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo_koltiva")
    private MobileElement logoKoltiva;

    @AndroidFindBy(id="com.koltiva.koltitrace:id/rbDevel")
    private MobileElement serverSettingDevel;

    @AndroidFindBy(id="com.koltiva.koltitrace:id/btn_ok")
    private MobileElement serverSettingButtonOk;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/act_next")
    private MobileElement buttonNextArrow;

    @AndroidFindBy(accessibility = "Account")
    private MobileElement buttonAccount;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/logout")
    private MobileElement buttonLogout;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement buttonDeleteAndLogout;

    @AndroidFindBy(xpath = "//*[@text=\"ACCEPT\"]")
    private MobileElement labelAccept;

    @AndroidFindBy(xpath = "//*[@text=\"NO THANKS\"]")
    private MobileElement labelNoThanks;

    public HomeKoltivaPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickOnLogoutButton() throws Exception {
        scrollToElement(buttonLogout,"up");
        click(buttonLogout);
    }

    public void clickButtonDeleteAndLogout(){
        click(buttonDeleteAndLogout);
    }

    public void clickButtonNextArrowRight(){
        click(buttonNextArrow);
        click(buttonNextArrow);
        click(buttonNextArrow);
    }

    public void clickLoginButton() {
        masukButton.click();
    }

    public boolean isUserOnHomePage(){
     //   waitForVisibility(logoKoltiva);
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOf(logoKoltiva));
        logoKoltiva.isDisplayed();
        language.isDisplayed();
        logoKoltiTrace.isDisplayed();
        appVersion.isDisplayed();
        return true;
    }

    public void clickImgLogo(){
        click(logoKoltiva);
        click(logoKoltiva);
        click(logoKoltiva);
        click(logoKoltiva);
        click(logoKoltiva);
        click(serverSettingDevel);
        click(serverSettingButtonOk);
    }

    public void userOpenTheAppAndClickNextAllStep(){
        driver.closeApp();
        driver.launchApp();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(labelAccept));
            click(labelAccept);
            click(labelNoThanks);
        }catch (Exception e){
            System.out.println("Element not found");
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(buttonAccount));
            click(buttonAccount);
            clickOnLogoutButton();
            clickButtonDeleteAndLogout();
        }catch (Exception e){
            clickButtonNextArrowRight();
            clickImgLogo();
            try {
                driver.launchApp();
            }catch (Exception i){
                System.out.println("already open apps");
            }
            clickButtonNextArrowRight();
        }

    }

}
