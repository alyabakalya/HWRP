Feature: As a user I want to see the message about successful adding of items to the basket

  @Test
  Scenario: After searching for a product and clicking on Add To Basket button, a user can see the message about successful adding of items to the basket
    Given User opens Home Page
    And User enters Lord of the Rings into the search input field
    And User is able to click on Search button
    When User clicks on Add to Basket button at Search Results page
    Then Add to Basket pop-up with a success message is shown - Item added to your basket