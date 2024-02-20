package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

public class LoginKoltivaPage extends BasePage {


    @AndroidFindBy(id = "com.koltiva.koltitrace:id/edittext_username")
    private MobileElement username;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/edittext_password")
    private MobileElement password;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_login_bottom")
    private MobileElement continueButton;

    @AndroidFindBy(xpath = "//*[@text=\"While using the app\"]")
    private MobileElement textWhileUsingTheApp;

    @AndroidFindBy(xpath = "//*[@text=\"Allow\"]")
    private MobileElement textAllow;

    public LoginKoltivaPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void setUsername(String usernamed) {

      //  username.sendKeys(usernamed);
        sendKeys(username,usernamed);
    }

    public void setPassword(String passworded) {

        sendKeys(password,passworded);
    }

    public void clickContinueButton(){
        continueButton.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(textWhileUsingTheApp));
            click(textWhileUsingTheApp);
            click(textAllow);
            click(textAllow);
            click(textAllow);
            click(textAllow);
            click(textAllow);
            click(textAllow);
        }catch (Exception e){
            System.out.println("element not found");
        }
    }

    public void login(String username,String password) {
        setUsername(username);
        setPassword(password);
    }

    public boolean isUserOnLoginPage(){
        username.isDisplayed();
        password.isDisplayed();
        return true;
    }
}
