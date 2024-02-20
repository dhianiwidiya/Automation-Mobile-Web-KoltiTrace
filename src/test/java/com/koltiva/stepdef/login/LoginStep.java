package com.koltiva.stepdef.login;

import com.koltiva.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.login.DownloadResourcePage;
import pages.login.LoginKoltivaPage;
import pages.menu.MenuPage;
import pages.onboarding.HomeKoltivaPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class LoginStep {

    private final AndroidDriver<AndroidElement> driver;
    private Properties props = new PropertyManager().getPropsDemo();

    

    public LoginStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }
    @Given("Input valid username and password")
    public void input_valid_username_and_password() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.password"));
    }

    @Then("Pop up error incorect username or password should be displayed")
    public void verifyErrorMessageFailedLogin(){
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        Assert.assertEquals(props.getProperty("data.login.errorMessageFailedLogin"),downloadResourcePage.getErrorMessageFailedLogin());
    }

    @Given("Input wrong username and valid password")
    public void input_WrongUsername() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.login(props.getProperty("data.login.wrongUsername"),props.getProperty("data.login.password"));
    }

    @Given("Input valid username and wrong password")
    public void input_WrongPassword() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.wrongPassword"));
    }

    @Given("Input wrong username and password")
    public void input_Wrong_valid_username_and_password() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.login(props.getProperty("data.login.wrongUsername"),props.getProperty("data.login.wrongPassword"));
    }
    @Given("User is on Login Page")
    public void user_is_on_login_page()  {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
    }
    @When("User click On Continue Button")
    public void user_is_click_on_continue_button() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.clickContinueButton();
    }
    @Then("Wait Until download data is completed")
    public void verify_that_download_data_is_completed() throws InterruptedException{
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        downloadResourcePage.waitDownloadDataDone();
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
    }
    @When("User click on closed button")
    public void user_click_on_closed_button() {
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        downloadResourcePage.clickOnCloseButton();
    }

    @Then("Verify that user is on Dashboard Page")
    public void verify_that_user_is_on_dashboard_page() {
        MenuPage dashboardPage = new MenuPage(driver);
        Assert.assertTrue(dashboardPage.isUserOnDashboardPage());
    }

    @And("Login with user Automation 1")
    public void UserLoginWithValidCredentials(){
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.password"));
        loginKoltivaPage.clickContinueButton();
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
        Assert.assertEquals(expectedResult2,downloadResourcePage.getTextDownlaodPercentage());
        downloadResourcePage.clickOnCloseButton();
    }

    @Given("User is on Menu Page")
    public void isUserOnMenuPage(){
        MenuPage menuPage = new MenuPage(driver);
        Assert.assertTrue(menuPage.isUserOnDashboardPage());
    }

    @And("Login with user Automation 2")
    public void UserLoginWithUserAutomation2(){
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.clickLoginButton();
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
        loginKoltivaPage.login(props.getProperty("data.login.username2"),props.getProperty("data.login.password2"));
        loginKoltivaPage.clickContinueButton();
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
        downloadResourcePage.clickOnCloseButton();
    }

    @And("Verify that user is login page")
    public void isUserOnHomePage(){
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        Assert.assertTrue(homeKoltivaPage.isUserOnHomePage());
    }




}
