Feature: Google search

  Scenario: Finding some cheese
    Given I am on Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"