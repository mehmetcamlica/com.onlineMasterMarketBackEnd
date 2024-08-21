Feature: As a provider, I want to be able to create a new coupon record via API connection.


  Scenario Outline: When a POST body with valid authorization information and correct data (service_id, coupon_name, percentage, start_date, valid_days, user_limit, description) is sent to /api/addCoupon endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Coupon added successfully".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, <user_limit>, "<description>", esra
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon added successfully", esra.
    * The api user deletes created coupon, esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | user_limit | description  |
      | 102        | CPNNEK745   | 20         | 2024-07-17 | 15         | 10         | Coupon Desc. |

  Scenario Outline: When a POST body with valid authorization information and missing data is sent to /api/addCoupon endpoint, it should be verified that the status code returned is 203 and the response_message in the response body is "Missing required fields".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, "<description>", esra
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Missing required fields", esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | description  |
      | 103        | CPNNEW746   | 20         | 2024-07-17 | 15         | Coupon Desc. |


  Scenario: When a POST request is sent to /api/addCoupon endpoint with valid authorization information but no data, it should be verified that the status code returned is 203 and the response_message in the response body is "Missing required fields".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sends a "POST" request with valid authorization information but no data and saves the returned response, esra.
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Missing required fields", esra.


  Scenario Outline: When a POST body (service_id, coupon_name, percentage, start_date, valid_days, user_limit, description) with valid authorization information and the same name (coupon_name) is sent to /api/addCoupon endpoint, it should be verified that the status code returned is 203 and the response_message in the response body is "The Coupon Name is already exist.".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, <user_limit>, "<description>", esra
    # zaten mevcut olan bir coupon name gonderiyoruz. same coupon_name = PROer345
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "The Coupon Name is already exist.", esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | user_limit | description  |
      | 56         | PROer345    | 20         | 2024-07-17 | 15         | 10         | Coupon Desc. |


  Scenario Outline:When a POST body (service_id, coupon_name, percentage, start_date, valid_days, user_limit, description) with valid authorization information and an invalid service_id is sent to /api/addCoupon endpoint, the status code returned should be 203, and the response_message in the response body should be "Invalid service id".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, <user_limit>, "<description>", esra
    # invalid bir service_id = 1000000 gonderiyoruz
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Invalid service id", esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | user_limit | description  |
      | 100000     | CPNNEW885   | 20         | 2024-07-17 | 15         | 10         | Coupon Desc. |


  Scenario Outline: (Invalid Token) When sending a POST body with invalid (invalid API key) authorization information and correct data (service_id, coupon_name, percentage, start_date, valid_days, user_limit, description) to /api/addCoupon endpoint, it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing"
    # invalid token gonderiyoruz

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, <user_limit>, "<description>", esra
    * The api user verifies that the status code is 401, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing", esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | user_limit | description  |
      | 110        | CPNNEW900   | 20         | 2024-07-17 | 15         | 10         | Coupon Desc. |


  Scenario Outline: The API must verify that the new coupon record to be created through the API has been created. (With the added_coupon_id returned in the response body, a GET request can be sent to the /api/coupon-details/{id} endpoint to verify that a record was created.)

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user sets "POST" request body with <service_id>, "<coupon_name>", <percentage>, "<start_date>", <valid_days>, <user_limit>, "<description>", esra
    * The api user verifies that the "response.response_message" is "Coupon Details" by sending a GET request to the "api" "coupon-details" endpoint with the "data.added_coupon_id" returned in the response body.
    * The api user deletes created coupon, esra.

    Examples:
      | service_id | coupon_name | percentage | start_date | valid_days | user_limit | description  |
      | 66         | CPCNSW166   | 20         | 2024-07-17 | 15         | 10         | Coupon Desc. |
