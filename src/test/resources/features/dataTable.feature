Feature: Google search functionality

  @dTable
  Scenario: Verify search with multiple input
#  Since the below  step has already been implemented,
  #  we don't need to implement the code/step for this
    When User is on the google home page
    When User search for
      | java     |
      | selenium |
      | TestNG   |
      | Junit    |

