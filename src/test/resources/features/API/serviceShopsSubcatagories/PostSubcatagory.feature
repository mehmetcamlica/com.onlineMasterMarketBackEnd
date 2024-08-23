Feature: Bir provider olarak API bağlantısı üzerinden service ve shop subcategories'a erişebilmek istiyorum.


  Scenario: TC01 Verify Successful Response for POST Request to /api/subcategories

    * The API user creates the "api/subcategories" post parameter, beyza
    * The API user sends a POST body and stores the returned response, beyza
    * The API user verifies that the status code is 200 , beyza
    * The API user verifies that the "response.response_message" in the response body is "Subcategory List" , beyza


   Scenario: TC02 Verify Information Returned in the Response for a POST Request to /api/subcategories

     * The API user creates the "api/subcategories" path parameter , beyza
     * The API user sends a POST body and stores the returned response, beyza
     * The API user verifies the "Cleaning" and "uploads/subcategory_images/1719146814home-s.png" in the response body.



Scenario: TC03  Verification of Response for POST Request with Non-Existing Category to /api/subcategories

  * The API user creates the "api/subcategories" post parameter, beyza
  * The API user sends a POST body with no record, beyza
  * The API user verifies that the status code is 203 , beyza
  * The API user verifies that the "response.response_message" in the response body is "No Results found" , beyza



Scenario: TC04 Verify Response When POST Request with No Data is Sent to /api/subcategories

  * The API user creates the "api/subcategories" path parameter , beyza
  * The API user sends a POST body with no data, beyza
  * The API user verifies that the status code is 203 , beyza
  * The API user verifies that the "response.response_message" in the response body is "Parent Category is required." , beyza


  Scenario: TC05 Invalid API Key for POST Request to /api/subcategories
    * The API user creates the "api/subcategories" post parameter, beyza
    * The API user sends a POST body containing valid data (category) with invalid (invalid API key) authorization information to the endpoint. beyza
    * The API user verifies that the status code is 401 , beyza
    * The API user verifies that the "response.response_message" in the response body is "Invalid token or token missing" , beyza