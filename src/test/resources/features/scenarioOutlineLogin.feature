Feature: Login

  @login
  Scenario Outline: verify login functionality with invalid credentials

    When User is on the login page
    And User enters invalid "<username>" in username field
    And User enters invalid "<password>" in password field
    And User clicks on login button
    Then User should see an "<errorMessage>"

    Examples:
      | username | password | errorMessage              |
      | test1    | test1    | Your username is invalid! |
      |          |          | Your username is invalid! |
      | test2    | test8989 | Your username is invalid! |
      | test00   | testing  | Your username is invalid! |