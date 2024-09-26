Feature: Print product titles

  Scenario: print product titles
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page
    And print all product titles