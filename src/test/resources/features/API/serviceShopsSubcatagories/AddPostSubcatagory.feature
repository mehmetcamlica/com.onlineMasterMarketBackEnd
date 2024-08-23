Feature: As a provider, I want to be able to create a new subcategory record via API connection.




  Scenario: TC01 When a POST body with valid authorization information and correct data (category, subcategory_name) is sent to /api/addSubcategory endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Sub Category added successfully".


    * The API user creates the "api/addSubcategory" post parameter, beyza
    * The API user sends a addPOST body with no record, beyza
    * The API user verifies that the status code is 200 , beyza
    * The API user verifies that the "response.response_message" in the response body is "Sub Category added successfully" , beyza



  Scenario: TC02 When a POST body (subcategory_name) with valid authorization information and missing data (category) is sent to the /api/addSubcategory endpoint, it should be verified that the status code returned is 203 and the response_message in the response body is "category is required".

      * The API user creates the "api/addSubcategory" post parameter, beyza
      * The API user sends a POST body with missing data (subcategory_name)with valid authorization information , beyza
      * The API user verifies that the status code is 203 , beyza
      * The API user verifies that the "response_message" in the response body is "category is required" , beyza

    Scenario: TC03  When a POST request is sent to /api/addSubcategory endpoint with valid authorization information but no data, it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".

      * The API user creates the "api/addSubcategory" post parameter, beyza
      * The API user sends a addPOST body with no data, beyza
      * The API user verifies that the status code is 203 , beyza
      * The API user verifies that the "response_message" in the response body is "No data for updated." , beyza

Scenario: TC04 When a POST body with invalid (invalid API key) authorization information and correct data (category, subcategory_name) is sent to /api/addSubcategory endpoint, it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing"

  * The API user creates the "api/addSubcategory" post parameter, beyza
  * The API user sends a addPOST body containing valid data (category) with invalid (invalid API key) authorization information to the endpoint. beyza
  * The API user verifies that the status code is 401 , beyza
  * The API user verifies that the "response.response_message" in the response body is "Invalid token or token missing" , beyza




  Scenario Outline: TC05 The new subcategory record to be created from the API must be verified from the API.
  (The record creation can be verified by sending a GET request to the /api/subcategory/{id} endpoint with the added_subcategory_id returned in the response body).

    * The api user sets "api/subcategory/<id>" path parameters, beyza
    * The api user sends a GET request and saves the returned response , beyza
    * The api user subcatagary id "38" Verification, beyza


    Examples:
      |id|
      |38|


