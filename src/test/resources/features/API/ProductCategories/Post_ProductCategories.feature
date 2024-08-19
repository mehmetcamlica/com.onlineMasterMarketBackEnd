Feature: US_063 As a provider, I want to be able to create a new product category record via API connection.

  Scenario Outline: TC_01 When a POST body with valid authorization information and
                    correct data (category_name) is sent to /api/addProductCategory endpoint,
                    it should be verified that the status code returned is 200 and
                    the response_message in the response body is "Product Category added successfully".

    * The api user sets "api/addProductCategory" path parameters,bilal.
    * The api user prepares a post request containing "<category_name>" information to send to the "api addProductCategory" endpoint,bilal.
    * The api user sends a POST request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product Category added successfully",bilal.

    Examples:
      | category_name             |
      | Moving And Transportation |

  Scenario Outline: TC_02 When a POST request is sent to /api/addProductCategory endpoint
                    with valid authorization information but no data,
                    it should be verified that the status code returned is 203 and
                    the response_message in the response body is "Product Category name is required.".

    * The api user sets "api/addProductCategory" path parameters,bilal.
    * The api user prepares a post request containing "<category_name>" information to send to the "api addProductCategory" endpoint,bilal.
    * The api user sends a POST request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product Category name is required.",bilal.

    Examples:
      | category_name             |
      |                           |

  Scenario Outline: TC_03 When a POST body with invalid authorization information (invalid API key)
                    and correct data (category_name) is sent to /api/addProductCategory endpoint,
                    it should be verified that the status code returned is 401 and
                    the response_message in the response body is "Invalid token or token missing"

    * The api user sets "api/addProductCategory" path parameters,bilal.
    * The api user prepares a post request containing "<category_name>" information to send to the "api addProductCategory" endpoint,bilal.
    * The api user sends a POST request with invalid authorization information 'invalid API key' and correct data 'category_name' and saves the returned response,bilal.
    * The api user verifies that the status code is 401,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing",bilal.

    Examples:
      | category_name             |
      | Moving And Transportation |

  Scenario Outline: TC_04 The creation of the new product category record should be verified from the API.
                    (It can be verified that the record was created by sending a GET request
                    to the /api/productCategory/{id} endpoint with the added_product_category_id returned in the response body).

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.

    Examples:
      | id |
      | 21  |


