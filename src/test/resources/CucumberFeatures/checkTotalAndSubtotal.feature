Feature: As a user I want to see that subtotal and total are displayed correctly

  Scenario: After adding a product to the basket, order's total and subtotal should be correctly displayed
    Given User goes to Home Page
    And User enters lord of the rings into the search input field
    And User can click on Search button
    When User clicks on Add to Basket button at Search Page
    And User clicks on Basket \ Checkout button at Add to Basket pop-up
    And User clicks on Checkout button at Your basket page
    Then Payment Details Page is displayed with URL https://www.bookdepository.com/checkout/guest
    And Subtotal and total are as following:
      |field   |value  |
      |Total   |28,23 €|
      |Subtotal|28,23 €|


