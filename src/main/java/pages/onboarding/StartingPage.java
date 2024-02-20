package pages.onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class StartingPage {
    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_title")
    private MobileElement txtManagementInformation;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_subtitle")
    private MobileElement txtManagementInformationSub;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_greeting_main")
    private MobileElement imgStartingPage;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/button_start")
    private MobileElement getStarted;

    private final AndroidDriver<AndroidElement> driver;

    public StartingPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public boolean isUserOnStartingPage(){
        txtManagementInformation.isDisplayed();
        txtManagementInformationSub.isDisplayed();
        imgStartingPage.isDisplayed();
        return true;
    }

    public void clickOnGetStartedButton(){
        getStarted.click();
    }
}
