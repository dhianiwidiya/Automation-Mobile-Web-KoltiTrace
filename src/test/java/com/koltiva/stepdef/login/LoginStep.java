package com.koltiva.stepdef.login;

import com.koltiva.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.login.LoginPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class LoginStep {

    private final AndroidDriver<AndroidElement> driver;
    private Properties props = new PropertyManager().getProps();

    public LoginStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("input group name")
    public void inputGroupName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickGroupButton(props.getProperty("data.groupName"));
    }


    @And("Verify that users is on login page")
    public void isUserOnLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUserOnLoginPage());
    }

    @Given("User is on Login Page")
    public void verifyLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userOpenTheAppAndClickNextAllStep();
        Assert.assertTrue(loginPage.isUserOnLoginPage());
    }

    @And("User Hold On KoltiTrace Logo")
    public void holdOnLogoKoltiTrace(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageHoldLogoKoltiTrace();
    }

    @And("Select Demo as Environment")
    public void selectDemoAsEnvironment(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageSelectDemoAsEnvironment();
    }

    @And("Click Button Login")
    public void clickButtonLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageClickButtonLogin();
    }

    @And("User Login with valid credentials")
    public void userLoginWithValidCredential(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidCredentials();
    }

    @And("User Login with wrong username")
    public void userLoginWithWrongUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWrongUsername();
    }

    @And("User Login with wrong password")
    public void userLoginWithWrongPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWrongPassword();
    }

    @And("Pop up error failed to sign in, wrong password should be displayed")
    public void verifyFailedLogin(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(props.getProperty("data.login.failedLoginMessag"),loginPage.getErrorMessageFailedLogin());
    }

    @And("User Login with wrong username password")
    public void userLoginWithWrongEmailAndPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWrongPassword();
    }


    @Given("Users open the app")
    public void usersOpenTheApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageClickButtonLogin();
    }
}
