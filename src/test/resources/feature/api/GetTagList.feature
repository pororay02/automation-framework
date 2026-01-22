@api
Feature: Get tags from dummy api

  Scenario: Get list of tags
    When I send GET request to list tags
    Then the response status should be 200
