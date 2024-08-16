Feature: Access Subscriptions via API

  Scenario: Verify successful access to subscriptions with valid authorization
    Given the user sets the valid API endpoint "/api/subscriptions"
    When the user sends a GET request to the subscriptions endpoint
    Then the status code should be 200
    And the response message should be "Subscription Fee Listed Successfully"
    And the subscription details should be verified as valid

  Scenario: Verify subscription details with valid authorization
    Given the user sets the valid API endpoint "/api/subscriptions"
    When the user sends a GET request to the subscriptions endpoint
    Then the status code should be 200
    And the response should contain valid subscription information

  Scenario: Verify access to subscriptions with invalid authorization
    Given the user sets the invalid API endpoint "/api/subscriptions"
    When the user sends a GET request to the subscriptions endpoint
    Then the status code should be 401
    And the response message should be "Invalid token or token missing"
