Feature: As a provider, I want to be able to delete subcategory information with the specified id number via API connection.




  Scenario Outline: TC01 When a DELETE request is sent to the /api/deleteSubcategory/{id} endpoint with valid authorization information and the correct (id), it should be verified that the status code returned is 200 and the response_message in the response body is "Sub-category and associated Services deleted successfully".

    * The api user sets "api/deleteSubcategory/<id>" path parameters, beyza
    *   The api user sends a DELETE request and saves the returned response , beyza
    * The API user verifies that the status code is 200 , beyza
    * The API user verifies that the "response.response_message" in the response body is "Sub-category and associated Services deleted successfully" , beyza
Examples:
    |id|
    | 39 |

  Scenario: TC02  When a DELETE request is sent to the /api/deleteSubcategory/{id} endpoint that does not contain valid authorization information and (id), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".
    * The api user sets "api/deleteSubcategory" path parameters, beyza
    *  The API user sends a DELETE body with no data, beyza
    * The API user verifies that the status code is 203 , beyza
    * The API user verifies that the "response.response_message" in the response body is "Id missing" , beyza



 Scenario Outline: TC03   When a DELETE request is sent to the /api/deleteSubcategory/{id} endpoint with valid authorization information and an unregistered (id), it should be verified that the status code returned is 203 and the response_message in the response body is "No Results found for the given ID".

   * The api user sets "api/deleteSubcategory/<id>" path parameters, beyza
   *  The API user sends a DELETE body with no id, beyza
   * The API user verifies that the status code is 203 , beyza
   * The API user verifies that the "response.response_message" in the response body is "No Results found for the given ID" , beyza
    Examples:
      |id|
      | 274 |



Scenario Outline: TC04 When a DELETE request is sent to the /api/deleteSubcategory/{id} endpoint with invalid (invalid API key) authorization information, it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

  * The api user sets "api/deleteSubcategory/<id>" path parameters, beyza
    * The api user sends a "DELETE" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized , beyzaaa
    Examples:
      |id|
      | 28 |


 Scenario Outline: TC 05 Verify that the deleted_subcategory_id in the response body returned from the /api/deleteSubcategory/{id} endpoint is the same as the id path parameter in the /api/deleteSubcategory/{id} endpoint.

    * The api user sets "api/deleteSubcategory/<id>" path parameters, beyza
  *  API user sends a DELETE request for that specific saves the returned response
    * The API user verifies that the deleted_subcategory_id in the response matches the sent ID




    Examples:
      |id|
      | 40 |



   Scenario Outline: TC06 The deletion of the subcategory record to be deleted from the API must be verified from the API.
   (It can be verified that the record was deleted by sending a GET request to the /api/subcategory/{id} endpoint with the deleted_subcategory_id returned in the response body).

    * The api user sets "api/subcategory/<id>" path parameters, beyza
    * The api user sends a GET request and saves the returned response , beyza
    * The api user response mesagge "No Results found for the given ID" Verification, beyza


    Examples:
      |id|
      |40|