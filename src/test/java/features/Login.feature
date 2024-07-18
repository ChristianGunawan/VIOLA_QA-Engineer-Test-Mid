Feature: Login

  Scenario Outline: Login Success
    Given user click sign in
    When user input email "<email>"
    And user input password "<password>"
    And user click Sign In Button
    Then verify user redirect to homepage

    Examples:
      | email                  | password    |
      | gunawancg111@gmail.com | Password123 |

  Scenario Outline: Invalid Email
    Given user click sign in
    When user input email "<email>"
    And user click Sign In Button
    Then verify user redirect to register page

    Examples:
      | email                  | password    |
      | invalidemail@gmail.com | Password123 |

  Scenario Outline: Invalid Password
    Given user click sign in
    When user input email "<email>"
    And user input password "<password>"
    And user click Sign In Button
    Then verify failed pop up

    Examples:
      | email                  | password     |
      | gunawancg111@gmail.com | Password1234 |

  Scenario Outline: Blank Email
    Given user click sign in
    Then verify Sign In Button cannot clickable

    Examples:
      | email | password     |
      |       | Password1234 |

  Scenario Outline: Blank Password
    Given user click sign in
    When user input email "<email>"
    Then verify Sign In Button cannot clickable

    Examples:
      | email                  |  |
      | gunawancg111@gmail.com |  |