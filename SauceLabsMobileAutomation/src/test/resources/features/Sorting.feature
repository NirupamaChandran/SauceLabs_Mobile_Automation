Feature: Validate price sorting functionality

  Scenario: Verify user can sort price high to low
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page
    When user click filter button
    And select price high to low
    Then verify home page is sorted