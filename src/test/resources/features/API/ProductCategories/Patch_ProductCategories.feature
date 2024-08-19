Feature: US_064 As a provider, I want to be able to update the information of the product category with the specified id number via API connection.

  Scenario Outline: TC_01 When a PATCH body is sent to the /api/editProductCategory/{id} endpoint
                    containing the correct (id) and correct data (category_name) with
                    valid authorization information, it should be verified that the status code returned is 200
                    and the response_message in the response body is "Product Category updated successfully".

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a patch request containing "<category_name>" information to send to the "api editProductCategory {id}" endpoint,bilal.
    * The api user sends a PATCH request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product Category updated successfully",bilal.

    Examples:
     | id | category_name             |
     | 20 | Transportation            |

  Scenario Outline: TC_02 When a PATCH request is sent to the /api/editProductCategory/{id} endpoint
                    with valid authorization information with the correct (id) and no data,
                    it should be verified that the status code returned is 203 and
                    the response_message in the response body is "No data for updated.".

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a PATCH request that contains no data,bilal.
    * The api user sends a PATCH request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "No data for updated.",bilal.

    Examples:
      | id |
      | 15 |

  Scenario Outline: TC_03 When a PATCH body is sent to the /api/editProductCategory/{id} endpoint
                    that (does not contain valid authorization information id)
                    and the correct data (category_name), it should be verified that
                    the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a patch request containing "<category_name>" information to send to the "api editProductCategory {id}" endpoint,bilal.
    * The api user sends a PATCH request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Id missing",bilal.

    Examples:
      | id | category_name             |
      |    | Transportation            |

  Scenario Outline: TC_04 When sending a PATCH body containing an unregistered (id)
                    and correct data (category_name) with valid authorization information
                    to the /api/editProductCategory/{id} endpoint, it should be verified
                    that the status code returned is 203 and the response_message
                    in the response body is "No Results found for the given ID".

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a patch request containing "<category_name>" information to send to the "api editProductCategory {id}" endpoint,bilal.
    * The api user sends a PATCH request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "No Results found for the given ID",bilal.

    Examples:
      | id | category_name             |
      | 99 | Transportation            |

  Scenario Outline: TC_05 When a PATCH body is sent to /api/editProductCategory/{id} endpoint
                    with invalid (invalid API key) authorization information and correct (id)
                    and correct data (category_name), it should be verified that the status code
                    returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a patch request containing "<category_name>" information to send to the "api editProductCategory {id}" endpoint,bilal.
    * The api user sends a PATCH request with invalid authorization information 'invalid API key' and correct data 'category_name' and saves the returned response,bilal.
    * The api user verifies that the status code is '401' with the reason phrase Unauthorized,bilal.

    Examples:
      | id | category_name             |
      | 15 | Transportation            |

  Scenario Outline: TC_06 Verify that the updated_product_category_id in the response body
                    returned from the /api/editProductCategory/{id} endpoint
                    is the same as the id path parameter in the /api/editProductCategory/{id} endpoint..

    * The api user sets "api/editProductCategory/<id>" path parameters,bilal.
    * The api user prepares a patch request containing "<category_name>" information to send to the "api editProductCategory {id}" endpoint,bilal.
    * The api user sends a PATCH request and saves the returned response,bilal.
    * The api user verifies that the updated_product_category_id in the response body is <id>,bilal.

    Examples:
      | id | category_name             |
      | 20 | Transportation            |

  Scenario Outline: TC_07 The product category record that is requested to be updated via API
                    should be verified that it has been updated via API.(It can be verified that
                    the record has been updated by sending a GET request to the /api/productCategory/{id}
                    endpoint with the updated_product_category_id returned in the response body).

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.

    Examples:
      | id |
      | 20  |



