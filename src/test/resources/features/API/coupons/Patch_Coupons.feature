Feature: As a provider, I want to be able to update coupon information with the specified id number via API connection.

  Scenario: When sending a PATCH body with valid authorization information and correct (id) and correct data (service_id, coupon_name, coupon_percentage, start_date, valid_days, user_limit, description) to /api/editCoupon/{id} endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Coupon Details Updated successfully".

    * The api user sets "api/addCoupon" path parameters, esra.
    * The api user creates a new coupon, esra.
    * The api user edits the created coupon, sends patch request and saves the returned response, esra
    * The api user verifies that the status code is 200 and the "response.response_message" information in the response body is "Coupon Details Updated successfully", esra
    * The api user deletes edited coupon, esra.

  @wip
  Scenario Outline: When a PATCH request is sent to the /api/editCoupon/{id} endpoint with valid authorization information with the correct (id) and no data, it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".

    * The api user sets "api/editCoupon/<id>" path parameters, esra.
    * The api user sends a "PATCH" request with no data and saves the returned response, esra.
    * The api user verifies that the status code is 203, esra.
    * The api user verifies that the "response.response_message" information in the response body is "No data for updated.", esra.

    Examples:
      | id |
      | 1  |


