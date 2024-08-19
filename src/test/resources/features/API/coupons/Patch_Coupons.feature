Feature: As a provider, I want to be able to update coupon information with the specified id number via API connection.
  #Bir provider olarak API baglantisi üzerinden belirtilen id numarasına sahip coupon bilgilerini güncelleyebilmek istiyorum.

  Scenario: coupon When sending a PATCH body with valid authorization information and correct (id) and correct data (service_id, coupon_name, coupon_percentage, start_date, valid_days, user_limit, description) to /api/editCoupon/{id} endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Coupon Details Updated successfully".
  #/api/editCoupon/{id} endpoint'ine gecerli authorization bilgileri ile dogru (id) ve dogru datalar
  # (service_id, coupon_name, coupon_percentage, start_date, valid_days, user_limit, description)
  # iceren bir PATCH body gönderildiginde dönen status code'in 200 oldugu ve response body'deki
  # response_message bilgisinin "Coupon Details Updated successfully" oldugu dogrulanmali.

    * The api user sets "api/editCoupon" path parameters, esra.
    * The api user verifies that the status code is 200, esra.
    * The api user verifies that the "response.response_message" information in the response body is "Coupon Details Updated successfully", esra.


