Feature: Login to Demoblaze
  @web
  Scenario: Login with valid credential
    Given I open Demoblaze homepage
    When I click Login menu
    And I input username and password
    And I click Login button
    Then I should see welcome message
