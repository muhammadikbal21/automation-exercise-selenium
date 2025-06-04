Feature: Logout
  Background:
    Given user is on login page
    When input email "ikbal@gmail.com"
    And input password "12345678"
    And click login button
    Then user is navigated to the home page

  Scenario: User success logout and redirect to login page
    When user click logout button
    Then user is navigated to login page