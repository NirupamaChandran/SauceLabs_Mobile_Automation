Feature: Validate add to cart functionality

  Background:
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page

  Scenario: Verify user can add an item to cart
    When user click first item
    Then verify product page is displayed
    And click add to cart button
    Then verify remove button is displayed



  Scenario: Verify double tap
    When user click first item
    Then verify product page is displayed
    And double click add to cart button