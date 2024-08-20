Feature: As a provider, I want to be able to create a new category record via API connection.
Scenario Outline: TC001 When a POST body with valid authorization information and correct data (category_name)
is sent to the /api/addCategory endpoint, it should be verified that the status code returned is 200
and the response_message in the response body is "Category added successfully".

  * The api user sets "api/addCategory" path parameters Gokcen.
  * The api user sends a POST request with "<category_name>"  and saves the returned response Gokcen.
  * The api user verifies that the status code is 200 Gokcen.
  * The api user verifies that the "response.response_message" information in the response body is "Category added successfully" Gokcen.
  Examples:
    | category_name        |
    |Child Daycare Services|

  Scenario Outline: When a POST request is sent to /api/addCategory endpoint with valid authorization information but no data, it should be verified that the
  status code returned is 203 and the response_message in the response body is "Category name is required."
    * The api user sets "api/addCategory" path parameters Gokcen.
    * The api user sends a POST request with "<category_name>"  and saves the returned response Gokcen.
    * The api user verifies that the status code is 203 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Category name is required." Gokcen.
    Examples:
      | category_name        |
      |                      |

    Scenario Outline:         When a POST body with invalid (invalid API key) authorization information
    and correct data (category_name) is sent to /api/addCategory endpoint, it should be verified that
    the status code returned is 401 and the response_message in the response body is "Invalid token or token missing"

      * The api user sets "api/addCategory" path parameters Gokcen.
      * The api user sends a POST request with invalid api key "<category_name>"  and saves the returned response Gokcen.
      * The api user verifies that the status code is 401 Gokcen.
      * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing" Gokcen.
      Examples:
        | category_name        |
        | geriatric care center|

      Scenario Outline: "The creation of the new category record should be verified from the API.
      (It can be verified that the record was created by sending a
      GET request to the /api/category_details/{id} endpoint with
      the added_category_id returned in the response body)."
        * The api user sets "api/category_details/<id>" path parameters Gokcen.
        * The api user sends a GET request and saves the returned response Gokcen.
        * The api user verifies the information in the response body for the entry with the specified "<id>".
        Examples:
          | id |
          | 18  |