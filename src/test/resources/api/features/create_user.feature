Feature: Create dummy user
  @api
  Scenario: Create a new dummy user
    Given I have valid new user data
    When I send POST request to create the user
    Then the response status should be 200
    And the response should contain created user id
  Scenario: Get user by ID successfully
    When I get the user by ID
    Then the user data should be returned
