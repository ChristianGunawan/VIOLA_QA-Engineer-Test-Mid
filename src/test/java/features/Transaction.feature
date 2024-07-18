Feature: Transaction

  Scenario: Successful Login
    Given the user is on the login page
    When the user make transaction from homepage
    And the user click add to bag button
    And the user click cart button
    And the user click checkout button
    And the user fill address label, name, phone number, city, and full address
    And the user choose shipping method
    And the user choose payment method
    Then the user click place order button
