Feature: Access Subscriptions via API
  #US_051
  Scenario: Verify successful access to subscriptions with valid authorization
    Given the user sets the valid API endpoint "api/subscriptions", mehmet
    When the user sends a GET request to the subscriptions endpoint, mehmet
    Then the status code should be 200, mehmet
    And the response message "response.response_message" should be "Subscription Fee Listed Successfully", mehmet
    And the subscription details should be verified as valid, mehmet

  Scenario: Verify subscription details with valid authorization
    Given the user sets the valid API endpoint "api/subscriptions", mehmet
    When the user sends a GET request to the subscriptions endpoint, mehmet
    Then the status code should be 200, mehmet
    And the response should contain valid subscription information, mehmet

  Scenario: Verify access to subscriptions with invalid authorization
    Given the user sets the invalid API endpoint "api/subscriptions", mehmet
    When the user sends a GET request to the subscriptions endpoint, mehmet
    Then the status code should be 401, mehmet
    And the response message "response.response_message" should be "Invalid token or token missing", mehmet

