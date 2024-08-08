@parallel
@google
Feature: Search feature
  As a user, I want to be able to search when I am on the google search page


  Scenario: Google search verification
    Given User is on the google home page
    And  User searches for "java"
    Then User should see "java" in the tile