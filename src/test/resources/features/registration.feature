Feature: Registration

  @register
  Scenario: Verify registration form
    Given User is on registration page
    And User enters first name "Mark"
    And User enters last name "James"
    And User enters username "mjames"
    And User enters email "mjames@test.com"
    And User enters password "Test12345"
    And User enters phone number "999-999-9999"
    And User selects gender Male
    And User enters data of birth "01/01/1990"
    And User selects Department of Engineering "DE" from dropdown
    And User selects Job title "SDET" from dropdown
    And User selects programming language "Java"
    And User clicks on Sign up button
    Then User should able to register successfully


    @register2
  Scenario Outline: Verify registration form negative testing
    Given User is on registration page
    And User enters first name "<firstName>"
    And User enters last name "<lastName>"
    And User enters username "<username>"
    And User enters email "<email>"
    And User enters password "<password>"
    And User enters phone number "<phoneNumber>"
    And User selects gender Male
    And User enters data of birth "<dateOfBirth>"
    And User selects Department of Engineering "<department>" from dropdown
    And User selects Job title "SDET" from dropdown
    And User selects programming language "Java"
    And User clicks on Sign up button
    Then User should able to register successfully
    Examples:
      | firstName | lastName | username | email           | password  | phoneNumber  | dateOfBirth | department |
      | a         | b        | c        | d@tes           | test      | 87878787     | 698714      | DE         |
      | Jake      | Mark     | jmark123 | mjames@test.com | Test12345 | 888-222-0000 | 02/02/1981  | DE         |
