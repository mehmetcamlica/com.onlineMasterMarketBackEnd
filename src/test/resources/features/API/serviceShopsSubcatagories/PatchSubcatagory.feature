Feature: As a provider, I want to be able to update the information of the subcategory with the specified id number via API connection.



  Scenario Outline: TC01 When a PATCH body is sent to the /api/editSubcategory/{id} endpoint with valid authorization information and correct (id) and correct data (category, subcategory_name), it must be verified that the status code returned is 200 and the response_message in the response body is "SubCategory updated successfully".

    * The api user sets "api/editSubcategory/<id>" path parameters, beyza
    * The api user sends a PATCH request and saves the returned response , beyza
    * The API user verifies that the status code is 200 , beyza
    * The API user verifies that the "response.response_message" in the response body is "SubCategory updated successfully" , beyza
Examples:
    | id |
    |37 |


   Scenario Outline: TC02 When a PATCH request is sent to the /api/editSubcategory/{id} endpoint with valid authorization information with the correct (id) and no data, it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".
     * The api user sets "api/editSubcategory/<id>" path parameters, beyza
     *  The API user sends a PATCH body with no data, beyza
     * The API user verifies that the status code is 203 , beyza
     * The API user verifies that the "response.response_message" in the response body is "No data for updated." , beyza
     Examples:
       | id |
       | 28  |

     Scenario: TC03 When a PATCH body is sent to /api/editSubcategory/{id} endpoint with valid authorization information (id) and correct data (category, subcategory_name), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

       * The api user sets "api/editSubcategory" path parameters, beyza
       *  The API user sends a PATCH body with no id, beyza
       * The API user verifies that the status code is 203 , beyza
       * The API user verifies that the "response.response_message" in the response body is "Id missing" , beyza



  Scenario Outline: TC04 When sending a PATCH body containing an unregistered (id) and correct data (category, subcategory_name) with valid authorization information to the /api/editSubcategory/{id} endpoint, it should be verified that the status code returned is 203 and the response_message in the response body is "No Results found for the given ID".

        * The api user sets "api/editSubcategory/<id>" path parameters, beyza
        *  The API user sends a PATCH body with no  correct data (category, subcategory_name) with valid authorization information , beyza
        * The API user verifies that the status code is 203 , beyza
        * The API user verifies that the "response.response_message" in the response body is "No Results found for the given ID" , beyza

    Examples:
    | id |
    | 2785 |



     Scenario Outline: TC05 When a PATCH body is sent to /api/editSubcategory/{id} endpoint with invalid (invalid API key) authorization information and correct (id) and correct data (category, subcategory_name), it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".
       * The api user sets "api/editSubcategory/<id>" path parameters, beyza
      * The api userr sends a "PATCH" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized , beyza

    Examples:
      | id |
      | 28 |


     Scenario Outline: TC 06 Verify that the updated_subcategory_id in the response body returned from the /api/editSubcategory/{id} endpoint is the same as the id path parameter in the /api/editSubcategory/{id} endpoint.

        * The api user sets "api/editSubcategory/<id>" path parameters, beyza
        * the api user ends a patch request with valid data and saves the pdated subcategory_id, beyza
    Examples:
      | id |
      | 37 |

Scenario Outline: TC 07 The subcategory record that is requested to be updated through the API must be verified that it has been updated through the API.
(It can be verified that the record has been updated by sending a GET request to the /api/subcategory/{id} endpoint with the updated_subcategory_id returned in the response body).

      * The api user sets "api/subcategory/<id>" path parameters, beyza
    * The api user sends a GET request and saves the returned response , beyza
    * The api user subcatagory name "New Sub Category Updated" Verification, beyza


    Examples:
      |id|
      |37|