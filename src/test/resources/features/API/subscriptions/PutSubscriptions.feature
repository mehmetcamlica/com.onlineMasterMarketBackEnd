Feature: Access Subscription Details
  As a provider,
  I want to be able to access the detailed information of the subscription
  with the specified id number through the API connection.

  Scenario: Valid request with correct data
    Given I set the subscription endpoint "api/subscription_details/1"
    When I send a GET request to the subscription endpoint
    Then the status code should be 200
    And the response message "response.response_message" should be "Subscription Fee Details", mehmet
    #And the response should contain valid subscription details

  Scenario Outline: Request with valid authorization and correct data
    Given I set the subscription endpoint "api/subscription_details/1"
    When I send a GET request to the subscription endpoint
    Then the status code should be 200
    #And the response should contain the following details:
    Examples:
      | id                   | 1             |
      | subscription_name    | Basic         |
      | fee                  | 0.00          |
      | currency_code        | USD           |
      | duration             | 365           |
      | fee_description      | 365 Days      |
      | subscription_content | Only one shop |
      | subscription_type    | 1             |
      | status               | 1             |
      | type                 | 1             |

  Scenario: Request with missing ID and valid authorization
    Given I set the subscription endpoint "api/subscription_details/"
    When I send a GET request to the subscription endpoint
    Then the status code should be 203
    And the response message "response.response_message" should be "Id missing"

  Scenario: Request with unregistered ID
    Given I set the subscription endpoint "api/subscription_details/99999"
    When I send a GET request to the subscription endpoint
    Then the status code should be 203
    And the response message "response.response_message" should be "No Details for this id."

  Scenario: Request with invalid authorization token
    Given I set the subscription endpoint "api/subscription_details/1"
    When I send a GET request to the subscription endpoint with invalid token
    Then the status code should be 401
    And the response message should be "Invalid token or token missing"
