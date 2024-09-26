Feature: Validate check out functionality

  Scenario: Verify user can checkout an item
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page
    When user click first item
    Then verify product page is displayed
    And user click add to cart button
    When user click cart icon from product page
    Then verify cart page is displayed
    When user clicks on checkout button
    And user enters "firstname" "lastname" and "postal.code"
    And user clicks on finish button
    Then verify "THANK YOU FOR YOU ORDER" note is displayed