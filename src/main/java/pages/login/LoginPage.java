package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    private MobileElement loginPageButtonLogin;
    
    @AndroidFindBy(xpath = "(//*[@text=\"Login\"]/parent::*/parent::*/preceding-sibling::*)[3]/child::*")
    private MobileElement loginPageLogoKoltiTrace;
    
    @AndroidFindBy(xpath = "//*[@text=\"Devel\"]/preceding-sibling::*")
    private MobileElement loginPageSelectDemoAsEnvironment;

    @AndroidFindBy(xpath = "(//*[@text=\"Choose Application Server\"]/parent::*/parent::*/parent::*/parent::*/parent::*/child::*)[1]")
    private MobileElement sideBar;

    @AndroidFindBy(xpath = "(//*[@text=\"Email or Username\"]/parent::*/child::*)[4]/child::*")
    private MobileElement txtUserName;

    @AndroidFindBy(xpath = "((//*[@text=\"Email or Username\"]/parent::*/child::*)[6]/child::*)[2]")
    private MobileElement txtPassword;

    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    private MobileElement buttonContinue;

    @AndroidFindBy(xpath = "//*[@text=\"Profil\"]")
    private MobileElement menuPageLabelProfil;

    @AndroidFindBy(xpath = "//*[@text=\"LOG OUT\"]")
    private MobileElement logoutButton;

    @AndroidFindBy(xpath = "//*[@text=\"YA\"]")
    private MobileElement yaButton;

    @AndroidFindBy(xpath = "//*[@text=\"Akun\"]")
    private MobileElement labelAkun;

    @AndroidFindBy(xpath = "//*[@text=\"Failed to sign in, wrong password\"]")
    private MobileElement textFailedToSignInWrongPassword;

    @AndroidFindBy(accessibility = "Group")
    private MobileElement groupButton;

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickGroupButton(String text){
        click(groupButton);
        sendKeys(groupButton,text);
    }

    public String getErrorMessageFailedLogin(){
        waitForVisibility(textFailedToSignInWrongPassword);
        return getText(textFailedToSignInWrongPassword,"");
    }

    public void loginPageClickButtonLogin(){
        click(loginPageButtonLogin);
    }

    public boolean isUserOnLoginPage(){
        waitForVisibility(loginPageButtonLogin);
        return loginPageButtonLogin.isDisplayed();
    }

    public void userOpenTheAppAndClickNextAllStep() {
        driver.closeApp();
        driver.launchApp();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(labelAkun));
            click(labelAkun);
            click(logoutButton);
            click(yaButton);
        } catch (Exception e) {
            System.out.println("already on login page");
        }
    }

    public void loginPageHoldLogoKoltiTrace(){
        waitForVisibility(loginPageLogoKoltiTrace);
      TouchAction action = new TouchAction(driver);
        action.press(ElementOption.element(loginPageLogoKoltiTrace));
        action.perform();
    }

    public void loginPageSelectDemoAsEnvironment(){
        click(loginPageSelectDemoAsEnvironment);
        click(sideBar);
    }

    public void loginValidCredentials(){
        click(txtUserName);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.B));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.K));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.R));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        click(txtPassword);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        sendKeys(txtPassword,"Ktv@123!");
        driver.getKeyboard().pressKey(Keys.SHIFT);
        driver.getKeyboard().pressKey(Keys.NUMPAD1);
        waitForVisibility(buttonContinue);
        click(buttonContinue);
      //  waitForVisibility(menuPageLabelProfil);
    }

    public void loginWrongEmailAndPassword(){
        click(txtUserName);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.E));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.S));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.N));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.G));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        sendKeys(txtPassword,"Password1234!");
        driver.getKeyboard().pressKey(Keys.SHIFT);
        driver.getKeyboard().pressKey(Keys.NUMPAD1);
        waitForVisibility(buttonContinue);
        click(buttonContinue);

        //  waitForVisibility(menuPageLabelProfil);
    }

    public void loginWrongUsername(){
        click(txtUserName);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.E));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.S));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.N));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.G));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        sendKeys(txtPassword,"Ktv@123!");
        driver.getKeyboard().pressKey(Keys.SHIFT);
        driver.getKeyboard().pressKey(Keys.NUMPAD1);
        waitForVisibility(buttonContinue);
        click(buttonContinue);
        //  waitForVisibility(menuPageLabelProfil);
    }

    public void loginWrongPassword(){
        click(txtUserName);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.B));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.K));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.R));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        click(txtPassword);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
        click(txtPassword);
        sendKeys(txtPassword,"Password1234!");
        driver.getKeyboard().pressKey(Keys.SHIFT);
        driver.getKeyboard().pressKey(Keys.NUMPAD1);
        waitForVisibility(buttonContinue);
        click(buttonContinue);
    }
}
