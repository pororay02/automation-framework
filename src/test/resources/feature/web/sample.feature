Feature: Sample Testing
  @web

  Scenario: testing sample api
    Given I hit the sample API
    Then response should be OK
