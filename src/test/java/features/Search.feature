Feature: Search

  Scenario Outline: Search Brand by Enter
    Given user click Search
    When user input "<search>"
    And user hit enter
    Then verify user see in brand page "<search>"

    Examples:
      | search | link   |
      | Adidas | adidas |


  Scenario Outline: Search Suggest Brand
    Given user click Search
    When user input "<search>"
    And user click suggest brand "<search>"
    Then verify user redirect suggest brand "<link>" page

    Examples:
      | search | link   |
      | Adidas | adidas |

  Scenario Outline: Search Suggest Collections
    Given user click Search
    When user input "<search>"
    And user click suggest collection "<collection>"
    Then verify user redirect suggest collection "<link>" page

    Examples:
      | search | collection     | link           |
      | Adidas | Adidas Gazelle | adidas-gazelle |

  Scenario Outline: Search Suggest Products
    Given user click Search
    When user input "<search>"
    And user click first suggest products
    Then verify user redirect product detail page "<link>" "<search>"

    Examples:
      | search |  | link   |
      | Adidas |  | adidas |