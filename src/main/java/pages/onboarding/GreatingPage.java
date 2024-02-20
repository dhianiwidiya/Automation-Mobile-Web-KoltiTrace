package pages.onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class GreatingPage extends BasePage {
    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_title")
    private MobileElement txtGreating;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_greeting_subtitle")
    private MobileElement txtGreatingSub;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_greeting_main")
    private MobileElement imgGreating;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_greeting_next")
    private MobileElement arrow;

    public GreatingPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isUserIsOnGreatingPage(){
        txtGreating.isDisplayed();
        txtGreatingSub.isDisplayed();
        imgGreating.isDisplayed();
        return true;
    }

    public void clickOnArrowButton(){
        click(arrow);
    }


}
