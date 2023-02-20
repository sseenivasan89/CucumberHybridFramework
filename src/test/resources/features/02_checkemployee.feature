@overall
Feature: Check Emplyee Infomration

@pim
  Scenario Outline: Search Employee
    Given I login to the application with below details
      | username | password |
      | Admin    | admin123 |
    Then I navigate to pim page
    When I search for the employees in "<jobtitle>"
    And I validate the search results of "<jobtitle>" 

    Examples: 
      | jobtitle |
      | Software Engineer    |
