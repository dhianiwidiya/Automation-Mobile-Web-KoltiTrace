@Test @Positive @Login @regression
Feature: Login
  Background:
    Given User open the app and click next for all step onboarding section
    And User is On Home Page
    And Click On Masuk button

  Scenario: User should be able to Login with wrong email
    Given User is on Login Page
    And Input wrong username and valid password
    When User click On Continue Button
    Then Pop up error incorect username or password should be displayed

  Scenario: User should be able to Login with valid credentials
    Given User is on Login Page
    And Input valid username and wrong password
    When User click On Continue Button
    Then Pop up error incorect username or password should be displayed

  Scenario: User should be able to Login with valid credentials
    Given User is on Login Page
    And Input wrong username and password
    When User click On Continue Button
    Then Pop up error incorect username or password should be displayed

  Scenario: User should be able to Login with valid credentials
    Given User is on Login Page
    And Input valid username and password
    And User click On Continue Button
    And Wait Until download data is completed
    When User click on closed button
    Then Verify that user is on Dashboard Page



