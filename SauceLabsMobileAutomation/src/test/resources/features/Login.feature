Feature: Login Functionality

  Scenario: Verify user can login using valid credentials
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page