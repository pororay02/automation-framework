@api
Feature: User and Tag Management API
  As a user, I want to manage dummy user data and list tags via API

  Scenario: Get user detail by valid ID
    Given I have a valid dummy user id
    When I send GET request to get user detail
    Then the response status code should be 200
    And the response body should contain firstName "Adina"

  Scenario: Get list of all tags
    When I send GET request to list tags
    Then the response status code should be 200
    And the response body should contain tags list