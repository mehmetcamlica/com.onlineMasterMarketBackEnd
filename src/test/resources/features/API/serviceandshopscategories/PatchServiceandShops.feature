Feature:
  Scenario Outline: When a PATCH body is sent to the /api/editCategory/{id} endpoint containing the correct (id) and correct data (category_name) with valid authorization information,
  it should be verified that the status code returned is 200 and the response_message in the response body is "Category updated successfully".
    * The api user sets "api/editCategory/<id>" path parameters Gokcen.
    * The api user sends a PATCH request with "<category_name>"  and saves the returned response Gokcen.
    * The api user verifies that the status code is 200 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Category updated successfully" Gokcen.
    Examples:
      | id | category_name |
      | 18 |  geriatric services |

    Scenario Outline:When a PATCH request is sent to the /api/editCategory/{id} endpoint with valid authorization information,
    it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".

      * The api user sets "api/editCategory/<id>" path parameters Gokcen.
      * The api user sends a PATCH request with no data and saves the returned response Gokcen.
      * The api user verifies that the status code is 203 Gokcen.
      * The api user verifies that the "response.response_message" information in the response body is "No data for updated." Gokcen.
      Examples:
        | id |
        | 16   |
      Scenario Outline: When a PATCH body is sent to the /api/editCategory/{id} endpoint with valid authorization information (id)
      and the correct data (category_name), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

        * The api user sets "api/editCategory/<id>" path parameters Gokcen.
        * The api user sends a PATCH request with "<category_name>"  and saves the returned response Gokcen.
        * The api user verifies that the status code is 203 Gokcen.
        * The api user verifies that the "response.response_message" information in the response body is "Id missing" Gokcen.
        Examples:
          | id | category_name |
          |  | Chilcare services   |

        Scenario Outline: When sending a PATCH body containing an unregistered (id) and correct data (category_name) with valid
        authorization information to the /api/editCategory/{id} endpoint, it should be verified that the
        status code returned is 203 and the response_message in the response body is "No Results found for the given ID".
          * The api user sets "api/editCategory/<id>" path parameters Gokcen.
          * The api user sends a PATCH request with "<category_name>"  and saves the returned response Gokcen.
          * The api user verifies that the status code is 203 Gokcen.
          * The api user verifies that the "response.response_message" information in the response body is "No Results found for the given ID" Gokcen.
          Examples:
            | id | category_name |
            |   203 |  Child Daycare Services|

          Scenario Outline: When sending a PATCH body with invalid (invalid API key) authorization information
          and correct (id) and correct data (category_name) to the /api/editCategory/{id} endpoint,
          it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

            * The api user sets "api/editCategory/<id>" path parameters Gokcen.
            * The api user sends a PATCH request with an invalid api key, "<category_name>"  and saves the returned response Gokcen.
            * The api user verifies that the status code is 401 Gokcen.
          * The api user verifies that the status code is 401 with the reason phrase "Unauthorized" Gokcen.

            Examples:
              | id | category_name |
              | 16 | child alldaycare services|

  Scenario Outline: Verify that the updated_category_id in the response body
  returned from the /api/editCategory/{id} endpoint is the
  same as the id path parameter in the /api/editCategory/{id} endpoint.

    * The api user sets "api/editCategory/<id>" path parameters Gokcen.
    * The api user sends a PATCH request with "<category_name>"  and saves the returned response Gokcen.
    * The api user verifies that the updated_category_id in the response body is <id> Gokcen.

    Examples:
      | id | category_name |
      | 16 | child alldaycare services|

    #Scenario Outline: "The category record that is requested to be updated via API should be verified that it has been updated via API.(It can be verified that the record has been updated by sending a GET request to the /api/category_details/{id}endpoint with the updated_category_id returned in the response body)."

