Feature:As a provider I want to be able to access blogs via API connection.



  Scenario Outline:When a GET request is sent to the /api/myService endpoint with valid authorization, the test should verify
  that the status code is 200, the response message is "Service List Successfully," and the blog information returned
  for id(x) includes the correct details such as.



    * The api user sets "api/myServices" path parameters DAMRA.
    * The api user sends a GET request and saves the returned response DAMRA.
    * The api user verifies that the status code is 200 DAMRA.
    * The api user verifies that the "response.response_message" information in the response body is "Service list" DAMRA.
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including "<service_id>", "<service_title>", "<finalAmount>", "<currency_code>", "<service_location>" DAMRA.



    Examples:
      | dataIndex | service_id | service_title| finalAmount | currency_code | service_location  |
      | 0         | 108        | Test Service    | 150        |   USD         |           |



  Scenario: When a GET request is sent to /api/Service endpoint with invalid (invalid API key) authorization information, it should be
  verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/myServices" path parameters.

    * The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized DAMRA.
