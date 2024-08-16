Feature: As a provider, I should be able to access the detailed information of the service with the specified id number through the API connection.

  Scenario Outline:When a GET request with valid authorization information and correct data (id) is sent to the /api/service-details/{id}
  endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Service Details" and
  response body (service_id, service_title, service_amount, category_name, service_offered, service_latitude, service_longitude, about, ratings, rating_count, views, currency)
  should be validated.


      * The api user sets "api/service-details/<id>" path parameters DAMRA.

      * The api user sends a GET request and saves the returned response DAMRA.

    * The api user verifies that the status code is 200 DAMRA.

    * The api user verifies that the "response.response_message" information in the response body is "Service Details" DAMRA.

    * The api user verifies that the data in the response body includes <id>, "<service_id>", "<service_title>", "<service_amount>", "<category_name>", "<service_latitude>", "<service_longitude>", "<about>", "<ratings>", "<rating_count>", "<views>", "<currency>" DAMRA.



    Examples:

      | id | service_id | service_title           | service_amount  | category_name               | service_latitude    |service_longitude        |  about                                        |ratings  |rating_count|views|currency|
      |  67  | 67       |  Test Service Updated    |   200          | Home Services               |  35.125801       |        -117.9859038       | Test Service Description New Service etc.     |     0   |   0       |   7   |     $  |


  Scenario: When a GET request is sent to the endpoint /api/services-details/{id} that does not contain valid authorization information and
  (id), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/service-details" path parameters.

    * The api user sends a GET request and saves the returned response DAMRA.

    * The api user verifies that the status code is 203 DAMRA.

    * The api user verifies that the "response.response_message" information in the response body is "Id missing" DAMRA.




  Scenario Outline: When sending a GET request to the /api/service-details/{id} endpoint with valid authorization information and an unregistered
  (id), it should be verified that the status code returned is 203 and the response_message in the response body is "No Details for this id.".

    * The api user sets "api/service-details/<id>" path parameters.

    * The api user sends a GET request and saves the returned response DAMRA.

    * The api user verifies that the status code is 203 DAMRA.

    * The api user verifies that the "response.response_message" information in the response body is "No Details found" DAMRA.


    Examples:
      | id   |
      | 1000 |


  Scenario Outline: When a GET request is sent to the /api/Service-details/{id} endpoint with invalid (invalid API key) authorization information,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/service-details/<id>" path parameters.

    * The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized DAMRA.


    Examples:
      | id |
      | 1  |