package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;


public class DownloadResourcePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Download data done\"]")
    private MobileElement labelDownloadDataDone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"100\"]")
    private MobileElement percentageValue;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_next")
    private MobileElement buttonClose;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_msg")
    private MobileElement errorMessageFailedLogin;

    public DownloadResourcePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getErrorMessageFailedLogin(){
        waitForVisibility(errorMessageFailedLogin);
        return getText(errorMessageFailedLogin,"");
    }

    public String getTextDownloadDataDone(){
        WebDriverWait wait = new WebDriverWait(driver, 1500);
        wait.until(ExpectedConditions.visibilityOf(labelDownloadDataDone));
        return labelDownloadDataDone.getText();
    }

    public void waitDownloadDataDone(){
        WebDriverWait wait = new WebDriverWait(driver, 1500);
        wait.until(ExpectedConditions.visibilityOf(labelDownloadDataDone));
    }

    public String getTextDownlaodPercentage(){
        return getText(percentageValue,"100");
    }

    public void clickOnCloseButton(){
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.elementToBeClickable(buttonClose));
        click(buttonClose);
    }
}
