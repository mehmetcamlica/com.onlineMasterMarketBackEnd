Feature: US_065 As a provider, I want to be able to delete product category information with the specified id number via API connection.

  Scenario Outline: TC_01 When a DELETE request is sent to the /api/deleteProductCategory/{id} endpoint
                    with valid authorization information and the correct (id), it should be verified that
                    the status code returned is 200 and the response_message in the response body is
                    "Product Category deleted successfully".

    * The api user sets "api/deleteProductCategory/<id>" path parameters,bilal.
    * The api user sends a DELETE request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product Category deleted successfully",bilal.

    Examples:
      | id |
      | 21 |

  Scenario Outline: TC_02 When a DELETE request is sent to the /api/deleteProductCategory/{id} endpoint
                    that does not contain valid authorization information and (id),
                    it should be verified that the status code returned is 203 and
                    the response_message in the response body is "Id missing".

    * The api user sets "api/deleteProductCategory/<id>" path parameters,bilal.
    * The api user sends a DELETE request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Id missing",bilal.

    Examples:
      | id |
      |    |

  Scenario Outline: TC_03 When a DELETE request is sent to the /api/deleteProductCategory/{id} endpoint
                    with valid authorization information and an unregistered (id),
                    the status code returned is 203 and the response_message in the response body is
                    "Product category not found. Invalid ID." should be verified.

    * The api user sets "api/deleteProductCategory/<id>" path parameters,bilal.
    * The api user sends a DELETE request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product category not found. Invalid ID.",bilal.

    Examples:
      | id |
      | 99 |

  Scenario Outline: TC_04 When a DELETE request is sent to the /api/deleteProductCategory/{id} endpoint
                    with invalid (invalid API key) authorization information, it should be verified that
                    the status code returned is 401 and the response_message in the response body is
                    "Invalid token or token missing".

    * The api user sets "api/deleteProductCategory/<id>" path parameters,bilal.
    * The api user sends a DELETE request with invalid authorization information 'invalid API key' and saves the returned response,bilal.
    * The api user verifies that the status code is '401' with the reason phrase Unauthorized,bilal.

    Examples:
      | id |
      | 21 |
  
  Scenario Outline: TC_05 Verify that the deleted_product_category_id in the response body
                    returned from the /api/deleteProductCategory/{id} endpoint is the same as
                    the id path parameter in the /api/deleteProductCategory/{id} endpoint.

    * The api user sets "api/deleteProductCategory/<id>" path parameters,bilal.
    * The api user sends a DELETE request and saves the returned response,bilal.
    * The api user verifies that the deleted_product_category_id in the response body is <id>,bilal.

    Examples:
      | id |
      | 21 |

  Scenario Outline: TC_06 The deletion of the product category record that is requested to be deleted
                    from the API must be verified from the API.(It can be verified that the record was
                    deleted by sending a GET request to the /api/productCategory/{id} endpoint with
                    the deleted_product_category_id returned in the response body).

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "No Details for this id.",bilal.

    Examples:
      | id |
      | 18  |




