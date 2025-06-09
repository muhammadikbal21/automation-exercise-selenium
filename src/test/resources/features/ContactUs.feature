Feature: Contact Us
  Scenario: User success submit contact us
    Given user is on login page
    And click contact us menu
    And input name at contact us form
    And input email at contact us form
    And input subject at contact us form
    And input message at contact us form
    And browse file at contact us form
    When click submit button
    Then user see wording success submit form
    When click home button
    Then user is navigated to the home page