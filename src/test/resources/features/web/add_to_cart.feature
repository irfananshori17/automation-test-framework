Feature: Add product to cart on demoblaze
  As a customer
  I want to add a product to shopping cart
  @web
  Scenario: Add first product to cart
    Given I open the demoblaze home page
    When I open the first product
    And I add it to the cart
    Then the product should be present in the cart