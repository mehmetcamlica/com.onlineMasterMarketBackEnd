Feature: US_053 Provider Subscription Management

  Scenario Outline: Request with valid authorization and correct data
   # Given The provider is authenticated with valid credentials
    * The api user sets "api/addSubscription" path parameters.
    * The provider prepares a post request containing "<Subscription name>", <fee>, <duration>, "<fee description>" information to send to the api addSubscription endpoint
    * The api user sends a POST request and saves the returned response mehmet.
    * The api user verifies that the status code is 203.
    And The response should "response.response_message" containn "Subscription added successfully"
    And The created subscription should be verified via API
    Examples:
      | Subscription name | fee  | duration | fee description |
      | Basic             | 0.00 | 365      | 365 Days        |

  Scenario: Request with valid authorization and missing data
    #Given The provider is authenticated with valid credentials
    When The provider sends a POST request to "api/addSubscription" with missing data
    Then The status code should be 203, mehmett
    And The response should "response.response_message" containnn "Subscription name, fee, duration, fee description are required."

  Scenario: Request with valid authorization and no data
    Given The provider is authenticated with valid credentials
    When The provider sends a POST request to "api/addSubscription" with no data
    Then The status code should be 203, mehmett
   # And The response should "response.response_message" contain "Subscription name, fee, duration, fee description are required."

  Scenario: Request with invalid authorization and correct data
    Given The provider is authenticated with invalid token
    When The provider sends a POST request to "api/addSubscription" with valid data
    Then The status code should be 401, mehmett
   # And The response should "response.response_message" contain "Invalid token or token missing"
