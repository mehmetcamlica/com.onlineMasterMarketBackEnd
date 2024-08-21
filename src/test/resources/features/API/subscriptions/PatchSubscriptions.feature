Feature: Subscription Update API

  As a provider, I want to be able to update the information of the subscription with the specified id number via API connection.

  Scenario: Valid subscription update
    Given the endpoint is "api/editSubscription/<id>"
    And valid authorization is provided
    And the request body contains valid subscription data
    When I send a PATCH request to the endpoint
    Then the status code should be 200
    And the response message should be "Subscription Updated successfully"














  Scenario: No data for update
    Given the endpoint is "api/editSubscription/{id}"
    And valid authorization is provided
    And the request body is empty
    When I send a PATCH request to the endpoint
    Then the status code should be 203
    And the response message should be "No data for updated."

  Scenario: Missing ID in request
    Given the endpoint is "api/editSubscription/"
    And valid authorization is provided
    And the request body contains valid subscription data
    When I send a PATCH request to the endpoint
    Then the status code should be 203
    And the response message should be "Id missing"

  Scenario: Unregistered ID
    Given the endpoint is "api/editSubscription/9999"
    And valid authorization is provided
    And the request body contains valid subscription data
    When I send a PATCH request to the endpoint
    Then the status code should be 203
    And the response message should be "No Results found for the given ID"

  Scenario: Invalid Token
    Given the endpoint is "api/editSubscription/{id}"
    And invalid authorization is provided
    And the request body contains valid subscription data
    When I send a PATCH request to the endpoint
    Then the status code should be 401
    And the response message should be "Invalid token or token missing"

  Scenario: Verify subscription update
    Given the endpoint is "api/editSubscription/{id}"
    And valid authorization is provided
    And the request body contains valid subscription data
    When I send a PATCH request to the endpoint
    Then the status code should be 200
    And the updated_subscription_id should match the id parameter
    And the updated subscription should be verified through the API
