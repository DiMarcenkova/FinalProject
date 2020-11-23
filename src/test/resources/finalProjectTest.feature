@Test
Feature: Product choose in online store

  Background: Open online store web page.
    Given Open Chrome browser
    When I open web page "https://www.1a.lv/"
    Then I validate that page title is "Lielākais interneta veikals Latvijā | 1a.lv"

  Scenario: Test
    When I search product "dell datori"
    Then I select a "1" product from list
    And I validate selected product title and price on product page
    Then I add to cart chosen product
    And Go to cart
    And Validate that product title is equal with the title on the product page
    Then I proceed to check out
    And I choose authentication type "unauthorized"
    And Choose delivery option "clientCenter" on shipping page
    And Choose delivery clientCenter address on a shipping page
    Then I fill customer data on a shipping page
    And I press next on a shipping page
    And I press next on a shipping page
    Then I choose payment type "cash" on a billing page
    And Validate that final price is equal with the price on the product page
    Then Close browser