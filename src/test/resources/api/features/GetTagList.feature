Feature: Get tags from dummy api
  @api
  Scenario: Get list of tags
    When I send GET request to list tags
    Then the response status should be 200
    And the response should contain tags list
