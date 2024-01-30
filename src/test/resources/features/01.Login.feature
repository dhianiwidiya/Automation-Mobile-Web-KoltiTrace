@regression @TestSuiteID=19059
  Feature: Login
    Scenario: Login with wrong username
      Given User is on Login Page
      And User Hold On KoltiTrace Logo
      And Select Demo as Environment
      And Click Button Login
      And User Login with wrong username
      Then Pop up error failed to sign in, wrong password should be displayed

    Scenario: Login with wrong password
      Given User is on Login Page
      And User Hold On KoltiTrace Logo
      And Select Demo as Environment
      And Click Button Login
      And User Login with wrong password
      Then Pop up error failed to sign in, wrong password should be displayed

    Scenario: Login with wrong username and password
      Given User is on Login Page
      And User Hold On KoltiTrace Logo
      And Select Demo as Environment
      And Click Button Login
      And User Login with wrong username password
      Then Pop up error failed to sign in, wrong password should be displayed

