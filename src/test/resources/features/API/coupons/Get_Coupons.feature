Feature: As a provider I want to be able to access coupons via API connection.

  Scenario: When a GET request is sent to /api/myCoupons endpoint with valid authorization information,it should be verified that the status code returned is 200 and the response_message in the response body is "Service Coupon History Listed Successfully". (Valid Authorization)

    * The api user sets "api/myCoupons" path parameters, esra.
    * The api user sends a "GET" request and saves the returned response, esra.
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Service Coupon History Listed Successfully", esra.

  Scenario: (Invalid Token) When a GET request is sent to /api/myCoupons endpoint with invalid (invalid API key) authorization information,it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid Token or token missing" .

    * The api user sets "api/myCoupons" path parameters, esra.
    * The api user sends a "GET" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized, esra.

  Scenario Outline: When a GET request is sent to /api/myCoupons endpoint with valid authorization information, the information(service_id, coupon_name, coupon_type, coupon_type_text, coupon_percentage, coupon_amount, start_date, end_date, valid_days,user_limit, user_limit_count, description, service_title, status) returned in the response body of id(x) should be verified.(Response Body Validation of a specific coupon by id)

    * The api user sets "api/coupon-details/<id>" path parameters, esra.
    * The api user sends a "GET" request and saves the returned response, esra.
    * The api user verifies that the "data.service_id" information in the response body is "<service_id>", esra.
    * The api user verifies that the "data.coupon_name" information in the response body is "<coupon_name>", esra.
    * The api user verifies that the "data.coupon_type" information in the response body is "<coupon_type>", esra.
    * The api user verifies that the "data.coupon_type_text" information in the response body is "<coupon_type_text>", esra.
    * The api user verifies that the "data.coupon_percentage" information in the response body is "<coupon_percentage>", esra.
    * The api user verifies that the "data.coupon_amount" information in the response body is "<coupon_amount>", esra.
    * The api user verifies that the "data.start_date" information in the response body is "<start_date>", esra.
    * The api user verifies that the "data.end_date" information in the response body is "<end_date>", esra.
    * The api user verifies that the "data.valid_days" information in the response body is "<valid_days>", esra.
    * The api user verifies that the "data.user_limit" information in the response body is "<user_limit>", esra.
    * The api user verifies that the "data.user_limit_count" information in the response body is "<user_limit_count>", esra.
    * The api user verifies that the "data.description" information in the response body is "<description>", esra.
    * The api user verifies that the "data.service_title" information in the response body is "<service_title>", esra.
    * The api user verifies that the "data.status" information in the response body is "<status>", esra.

    Examples:
      | id | service_id | coupon_name | coupon_type | coupon_type_text | coupon_percentage | coupon_amount | start_date | end_date   | valid_days | user_limit | user_limit_count | description          | service_title                         | status  |
      | 1  | 56         | PROer345    | 1           | Percentage       | 20                | 0             | 2024-07-09 | 2024-07-19 | 10         | 20         | 0                | xyz                  | Electrical Repairs (Service Call Fee) | Expired |
      | 2  | 57         | PROWise     | 1           | Percentage       | 25                | 0             | 2024-07-26 | 2024-08-10 | 15         | 10         | 1                | Wise English Academy | Leanguage                             | Expired |