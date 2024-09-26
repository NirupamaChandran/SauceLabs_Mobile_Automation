Feature: Print context

  Scenario: print contexts
    Given user opens application
    And login using valid "username" and "password"
    Then verify user is on home page
    When user clicks on burger menu
    And clicks webView
    And enter url "https://www.google.com"
    And click go to site button
    Then verify website is displayed
    And print contexts
    When user search an item
    Then verify search item page is displayed