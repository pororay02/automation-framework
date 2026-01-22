@api
Feature: Get User API

  Scenario: Get user detail
    Given I have a valid dummy user id
    When I send GET request to get user detail
    Then the response status should be 200
