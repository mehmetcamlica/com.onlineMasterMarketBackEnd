 Feature: As a provider, I should be able to access the detailed information of the subcategory with the specified id number via API connection.



   Scenario Outline: TC01  Verify GET request to /api/subcategory/{id} endpoint returns status code 200 and correct response_message

  * The api user sets "api/subcategory/<id>" path parameters, beyza
  * The api user sends a GET request and saves the returned response , beyza
  * The API user verifies that the status code is 200 , beyza
  * The API user verifies that the "response.response_message" in the response body is "Sub Category Details" , beyza


    Examples:
      |id|
      |1 |


  Scenario Outline:  TC02 When a GET request with valid authorization information and correct data (id) is sent to the /api/subcategory/{id} endpoint, the data in the response body (subcategory_id, subcategory_name, category_id, category_name) should be validated

    * The api user sets "api/subcategory/<id>" path parameters, beyza
     * The api user sends a GET request and saves the returned response , beyza
     * The api user verifies that the "data.subcategory.subcategory.subcategory_id" information in the response body is "<subcategory_id>" , beyza
     * The api user verifies that the "data.subcategory.subcategory.subcategory_name" information in the response body is "<subcategory_name>" , beyza
     * The api user verifies that the "data.subcategory.subcategory.category_id" information in the response body is "<category_id>" , beyza
     * The api user verifies that the "data.subcategory.subcategory.category_name" information in the response body is "<category_name>" , beyza


 Examples:
   | id  | subcategory_id | subcategory_name     | category_id      | category_name     |
   | 1   | 1              | Cleaning             | 1                |  Home Services    |



    Scenario: TC 03 When a GET request is sent to the /api/subcategory/{id} endpoint that does not contain valid authorization information and (id), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".


      * The api user sets "api/subcategory" path parameters, beyza
      * The API user sends a Get body with no record, beyza
      * The API user verifies that the status code is 203 , beyza
      * The API user verifies that the "response.response_message" in the response body is "Id missing" , beyza


      Scenario: TC04 When a GET request is sent to the /api/subcategory/{id} endpoint with valid authorization information and an unregistered (id), it should be verified that the status code returned is 203 and the response_message in the response body is "No Results found for the given ID".
        * The api user sets "api/subcategory/100" path parameters, beyza
     * The API user sends a Get body with no record, beyza
        * The API user verifies that the status code is 203 , beyza
        *  The API user verifies that the "response.response_message" in the response body is "No Results found for the given ID" , beyza


Scenario Outline: TC 05 When a GET request is sent to the /api/subcategory/{id} endpoint with invalid (invalid API key) authorization information, it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

  * The api user sets "api/subcategory/<id>" path parameters, beyza
  * The api user sends a "GET" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized , beyza
    # Api kullanicisi GET request gonderir, donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular



     Examples:
       |id|
       |1 |












