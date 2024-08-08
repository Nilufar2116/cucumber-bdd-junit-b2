@parallel
Feature: Google search functionality

  @outline1
  Scenario Outline: Google search verification

    When User is on the google home page
    When User search for "<item>"
    Then User should see "<itemName>" in page title
    Examples:
      | item     | itemName |
      | java     | java     |
      | selenium | selenium |
      | testNG   | testNG   |

