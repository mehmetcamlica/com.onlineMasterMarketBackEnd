Feature: As a provider, I want to be able to delete coupon information with the specified id number via API connection.

  @Delete
  Scenario: coupon When a DELETE request is sent to the /api/deleteCoupon/{id} endpoint with valid authorization information and the correct (id), it should be verified that the status code returned is 200 and the response_message in the response body is "Coupon deleted successfully".

    * The api user sets "api/deleteCoupon" path parameters, esra.
    * The api user sends a "DELETE" request and saves the returned response, esra.
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon deleted successfully", esra.


  Scenario: When a DELETE request is sent to the /api/deleteCoupon/{id} endpoint that does not contain valid authorization information and (id), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/deleteCoupon" path parameters, esra.
    * The api user sends a "DELETE" request and saves the returned response, esra.
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Id missing", esra.


  Scenario: Invalid Token When a DELETE request is sent to the /api/deleteCoupon/{id} endpoint with invalid (invalid API key) authorization information, it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/deleteCoupon" path parameters, esra.
    * The api user sends a "DELETE" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized, esra.

  @Delete
  Scenario: coupon Verify that the deleted_coupon_id in the response body returned from the /api/deleteCoupon/{id} endpoint is the same as the id path parameter in the /api/deleteCoupon/{id} endpoint.

    * The api user sets "api/deleteCoupon" path parameters, esra.
    * The api user sends a "DELETE" request and saves the returned response, esra.
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon deleted successfully", esra.
    * The api user verifies that the "data.deleted_coupon_id" information in the returned response body is the same as the id path parameter written in the endpoint, esra.

  @Delete
  Scenario: coupon The deletion of the coupon record requested to be deleted from the API must be verified from the API.(With the deleted_coupon_id returned in the response body, a GET request can be sent to the /api/coupon-details/{id} endpoint to verify that the record has been deleted.)
  #API uzerinden silinmek istenen coupon kaydinin silindigi, API uzerinden dogrulanmali.
  # (Response body'de dönen deleted_coupon_id ile /api/coupon-details/{id} endpoint'ine GET request gönderilerek kaydın silindiği doğrulanabilir.)

    * The api user sets "api/deleteCoupon" path parameters, esra.
    * The api user sends a "DELETE" request and saves the returned response, esra.
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon deleted successfully", esra.
    * The api user verifies that the "data.deleted_coupon_id" information in the returned response body is the same as the id path parameter written in the endpoint, esra.
    * The api user verifies that the "response.response_message" is "No Details found" by sending a GET request to the "api" "coupon-details" endpoint with the "data.deleted_coupon_id" returned in the response body.


  Scenario Outline: When a DELETE request is sent to the /api/deleteCoupon/{id} endpoint with valid authorization information and an unregistered (id), the status code returned is 203 and the response_message in the response body is "Coupon not found. Invalid ID." should be verified.
    * The api user sets "api/deleteCoupon/<id>" path parameters, esra.
    * The api user sends a "DELETE" request and saves the returned response, esra.
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon not found. Invalid ID.", esra.

    Examples:
      | id    |
      | 10000 |

