Feature: Contact Automation

  Scenario: customer is on homepage
    Given customer is on add to cart page
    When click on contact
    Then modal from appear
    Then user click on close button


  Scenario:customer wants to fill input box
    Given customer is on home page
    Then click on contact
    Then modal form opens
    Then user fills form
    Then click on send massage
    Then click on ok






