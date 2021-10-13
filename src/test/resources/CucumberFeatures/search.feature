Feature: As a user I want to search products from the home page

  Scenario: After searching for a product, search results page should be displayed
    Given User is at Home Page
    When User enters lord of the rings into the search input
    And User clicks on Search button
    Then Search Results Page with URL https://www.bookdepository.com/search?searchTerm=lord+of+the+rings&search=Find+book is displayed
