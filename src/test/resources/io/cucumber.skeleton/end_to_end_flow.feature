Feature: End To End Testing

  Scenario: customer is on homepage
    Given at list one product is present on homepage
    When user click on first product
    # user verify product, prise and description
    And user verify product, prise and description
    And click add to cart
    Then popup appear user click on okay
    Then user click on cart
    Then clicks on place order
    Then fills his details
    Then clicks on purchase



