@background
Feature: Login feature
  // for repeated step
  Background:
    #this step runs before each scenario
    Given User is on the login page



  Scenario: verify login with invalid credential
    When User enters invalid username "invalidTest"
    And User enters invalid password "test333"
    And User clicks on login button
    Then User should not be able to login

    Scenario: verify login with valid credential
      When User enters valid username "test"
      And User enters valid password "test12"
      And User clicks on login button
      Then User should be able to login
