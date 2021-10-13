Feature: As a user I want to be able to create an account at the web site

  @Test
  Scenario Outline: After clicking on Join button at Home Page, a user is able to fill in the form for account creation
    Given User opens Home Page
    And User clicks on Sign In-Join button at Home Page
    When User fills "<name>", "<email>", and "<password>" at Join form
    And User clicks on Create Your Account button
    Then Message about successful registration is shown - Thank you for registering!
    When Registered user clicks on My Account button
    Then My Account Page is displayed with the URL https://www.bookdepository.com/account

    Examples:
      | name   | email            | password  |
      | Name30 |email95t@email.com|PassWoRd8# |
      | Name31 |email98y@email.com|PASSWORD987|
