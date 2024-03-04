@transaction @regression
Feature: Transaction

  Scenario: Create transaction
    Given The user is on home page
    And The user click transaction feature
    And The user click add transaction button
    And User click transaction type
    And The user select option RA as transaction type
    And The user input transaction number
    And User select producer farmer
    And User select M.Muhlisin producer
    And User input Packing Code
    And User click Commodity Type
    And User select Roasted Coffee Bean as Commodity Type
    And User click Arabica for Species Type
    And User click kg for Unit Type
    And User click Package Form
    And User select option Box as Package
    And User input Gross form
    And User input Number Of Package
    Then User seen Package Weight
    Then User seen Net Weight
    And User click Grade
    Then User select Option Grade 1 as Grade
    And User Input Price Per Unit
    Then User seen Nett Price
    Then User seen Total Payment
    And User Input Notes
    Then User click Submit


