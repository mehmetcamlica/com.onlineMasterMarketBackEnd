Feature: As a provider, I should be able to access the detailed information of the shop with the specified id number via API connection.
@US37
  Scenario Outline:When a GET request with valid authorization information and correct data (id) is sent to the /api/shop-details/{id} endpoint,
  it should be verified that the status code returned is 200 and the response_message in the response body is "Shop Details". When a GET request with valid authorization
  information and correct data (id) is sent to the /api/shop-details/{id} endpoint,the data in the response body (id, shop_code, shop_name, tax_allow, tax_number,
  contact_no, email, address, country_name, state_name, city_name, postal_code) should be verified.


    * The api user sets "api/shop-details/<id>" path parameters TOPRAK.

    * The api user sends a GET request and saves the returned response TOPRAK.

    * The api user verifies that the status code is 200 TOPRAK.

    * The api user verifies that the "response.response_message" information in the response body is "Shop Details" TOPRAK.

    * The api user verifies that the data in the response body includes <id>, "<shop_code>", "<shop_name>", "<tax_allow>", "<tax_number>", "<contact_no>", "<email>", "<address>", "<country_name>", "<state_name>", "<city_name>", "<postal_code>" TOPRAK.



    Examples:

      | id | shop_code | shop_name    |  tax_allow        | tax_number  |contact_no        |  email            |address                                                     |country_name      |state_name      |city_name             |postal_code |
      | 10 | SHOP4Q0CN5| FixIt Pros   |  No               |  null       | 2587456321       | info@fixit.com    |7990 California City Blvd, California City, CA 93505, USA   |   USA (+1)       |   California   |     California City  |   93505    |


  Scenario: When a GET request is sent to the /api/shop-details/{id} endpoint that does not contain valid authorization information and (id),
  it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/shop-details" path parameters.

    * The api user sends a GET request and saves the returned response TOPRAK.

    * The api user verifies that the status code is 203 TOPRAK.

    * The api user verifies that the "response.response_message" information in the response body is "Id missing" TOPRAK.




  Scenario Outline: When sending a GET request to the /api/shop-details/{id} endpoint with valid authorization information and an unregistered (id),
  it should be verified that the status code returned is 203 and the response_message in the response body is "No Details found".

    * The api user sets "api/shop-details/<id>" path parameters.

    * The api user sends a GET request and saves the returned response TOPRAK.

    * The api user verifies that the status code is 203 TOPRAK.

    * The api user verifies that the "response.response_message" information in the response body is "No Details found" TOPRAK.


    Examples:
      | id |
      | 1000 |


  Scenario Outline: When a GET request is sent to the /api/shop-details/{id} endpoint with invalid (invalid API key) authorization information,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/shop-details/<id>" path parameters.

    * The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized TOPRAK.


    Examples:
      | id |
      | 1  |