
Feature:As a provider, I want to be able to delete category information with the specified id number via API connection.

  Scenario Outline:TC001- When a DELETE request with valid authorization information and the correct (id) is
  sent to the /api/deleteCategory/{id} endpoint, it should be verified that the
  status code returned is 200 and the response_message in the response body is "Category,Sub-category and Services deleted successfully".
    * The api user sets "api/deleteCategory/<id>" path parameters Gokcen.
    * The api user sends a DELETE request and saves the returned response Gokcen.
    * The api user verifies that the status code is 200 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Category,Sub-category and Services deleted successfully" Gokcen.
    Examples:
      | id |
      |34  |

    Scenario Outline:TC002- When a DELETE request is sent to the /api/deleteCategory/{id} endpoint that does not contain valid authorization information and (id), it should be verified that the
    status code returned is 203 and the response_message in the response body is "Id missing".
      * The api user sets "api/deleteCategory/<id>" path parameters Gokcen.
      * The api user sends a DELETE request and saves the returned response Gokcen.
      * The api user verifies that the status code is 203 Gokcen.
      * The api user verifies that the "response.response_message" information in the response body is "Id missing" Gokcen.
      Examples:
        | id |
        |    |
      Scenario Outline:TC003-  When a DELETE request is sent to the /api/deleteCategory/{id} endpoint
      with valid authorization information and an unregistered (id), it should be verified that the
      status code returned is 203 and the response_message in the response body is "No Results found for the given ID".
        * The api user sets "api/deleteCategory/<id>" path parameters Gokcen.
        * The api user sends a DELETE request and saves the returned response Gokcen.
        * The api user verifies that the status code is 203 Gokcen.
        * The api user verifies that the "response.response_message" information in the response body is "No Results found for the given ID" Gokcen.
        Examples:
          | id |
          | 345  |

        Scenario Outline:TC004-  When a DELETE request is sent to the /api/deleteCategory/{id} endpoint
        with invalid (invalid API key) authorization information, it should be verified that the
        status code returned is 401 and the response_message in the response body is "Invalid token or token missing".
          * The api user sets "api/deleteCategory/<id>" path parameters Gokcen.
          * The api user sends a DELETE request with an invalid api key and saves the returned response Gokcen.
          * The api user verifies that the status code is 401 with the reason phrase "Unauthorized" Gokcen.
          Examples:
            | id |
            | 18 |

  Scenario Outline:TC005-  Verify that the deleted_category_id in the response body returned from the
  /api/deleteCategory/{id}endpoint is the
  same as the id path parameter in the /api/deleteCategory/{id} endpoint.

    * The api user sets "api/deleteCategory/<id>" path parameters Gokcen.
    * The api user sends a DELETE request and saves the returned response Gokcen.
    * The api user verifies that the deleted_category_id in the response body is <id> Gokcen.
    Examples:
      | id |
      | 20 |


  #Scenario Outline: The deletion of the category record that is requested to be deleted from the API must be
  #verified from the API.(It can be verified that the record was deleted by sending aGET request to the /api/category_details/{id} endpoint

   # * The api user sets "api/category_details/<id>" path parameters Gokcen.
   # * The api user verifies that the "response.response_message" is "No Details for this id." by sending a GET request to the "api" "category_details/16" endpoint with the "data.deleted_category_id" returned in the response body.

   # Examples:
   #  | id |
    #| 16  |