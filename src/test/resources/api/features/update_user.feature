Feature: Update dummy user
  @api
  Scenario: Update an existing dummy user
    Given I have an existing dummy user id
    When I send PUT request to update the user
    Then the response status should be 200
    And the response should reflect updated data
