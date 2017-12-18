Feature: Web Search

  Scenario: Simple Google Search
    Given user visits google home page
    When user enters "panda" into the search input
    And user clicks on search button
    Then search results for "panda" are shown