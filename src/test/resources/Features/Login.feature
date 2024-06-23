Feature: The user need to chech curry's home page
Scenario: Login to the Curry App
    Given I launch the Curry app
    When I navigate to the login screen
    And I enter valid credentials
    And I tap on the login button
    Then I should be logged in successfully
    And I should be directed to the home screen