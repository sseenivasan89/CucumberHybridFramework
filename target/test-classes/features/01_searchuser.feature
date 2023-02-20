@overall
Feature: User Search Functionality

@saerchuser
  Scenario Outline: Search the user
    Given I login to the application with below details
      | username | password |
      | Admin    | admin123 |
    Then I navigate to admin page
    When I search for the "<username>" user
    And I validate the search results have only "<username>" user

    Examples: 
      | username |
      | admin    |

  