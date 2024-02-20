package com.koltiva.stepdef.onboarding;

import com.koltiva.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.login.DownloadResourcePage;
import pages.login.LoginKoltivaPage;
import pages.onboarding.GreatingPage;
import pages.onboarding.HomeKoltivaPage;
import pages.onboarding.StartingPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class OnboardingStep {
    private final AndroidDriver<AndroidElement> driver;

    private Properties props = new PropertyManager().getPropsDemo();


    public OnboardingStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }
    @Given("User is on Greating Page")
    public void user_is_on_greating_page() {
        GreatingPage greatingPage = new GreatingPage(driver);
        Assert.assertTrue(greatingPage.isUserIsOnGreatingPage());
    }
    @Given("Click on right arrow button")
    public void click_on_right_arrow_button() {
        GreatingPage greatingPage = new GreatingPage(driver);
        greatingPage.clickOnArrowButton();
    }
    @Given("User is On Software Description Page")
    public void user_is_on_software_description_page() {
        StartingPage startingPage = new StartingPage(driver);
        Assert.assertTrue(startingPage.isUserOnStartingPage());
    }
    @Given("Click on GET STARTED button")
    public void click_on_get_started_button() {
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickOnGetStartedButton();
    }
    @Given("User is On Home Page")
    public void user_is_on_home_page() {
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        Assert.assertTrue(homeKoltivaPage.isUserOnHomePage());
    }
    @Given("Click On Masuk button")
    public void click_on_masuk_button() {
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.clickLoginButton();
    }

    @And("User click on logo koltiva 3 times")
    public void clickonLogoKoltiva(){
        HomeKoltivaPage homeKoltivaPage= new HomeKoltivaPage(driver);
        homeKoltivaPage.clickImgLogo();
    }

    @Given("User open the app and click next for all step onboarding section")
    public void userOpenTheAppAndClickNextAllStep(){
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.userOpenTheAppAndClickNextAllStep();
    }

    @And("The users already accept the reception from collector account")
    public void theUserAlreadyAccept(){
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.userOpenTheAppAndClickNextAllStep();
        Assert.assertTrue(homeKoltivaPage.isUserOnHomePage());
        homeKoltivaPage.clickLoginButton();
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.password"));
        loginKoltivaPage.clickContinueButton();
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
        downloadResourcePage.clickOnCloseButton();
    }

    @And("The users already reject the reception from collector account")
    public void theUserAlreadyReject(){
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.userOpenTheAppAndClickNextAllStep();
        Assert.assertTrue(homeKoltivaPage.isUserOnHomePage());
        homeKoltivaPage.clickLoginButton();
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.password"));
        loginKoltivaPage.clickContinueButton();
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
        downloadResourcePage.clickOnCloseButton();

    }
}
