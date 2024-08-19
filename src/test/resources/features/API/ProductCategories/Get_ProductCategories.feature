Feature: US_061 As a provider, I want to be able to access product categories via API connection.

  Scenario: TC_01 When a GET request is sent to /api/productCategories endpoint with valid authorization
  information, it should be verified that the status code returned is 200 and
  the response_message in the response body is "Products Categories Listed Successfully".

    * The api user sets "api/productCategories" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Products Categories Listed Successfully",bilal.

  Scenario Outline:  TC_02 When a GET request is sent to /api/productCategories/{id} endpoint
  with valid authorization information, it should be verified that the response body includes
  information such as (category_name, slug, category_image, thumb_image, status, updated_on, created_on)

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the information in the response body includes "<id>", "<category_name>", "<slug>", "<category_image>", "<thumb_image>", "<status>","<updated_on>","<created_on>",bilal.

    Examples:
      | id | id | category_name       | slug     | category_image | thumb_image | status | updated_on           | created_on           |
      | 6  | 6  | Health & Wellness   | health&8 | null           |             | 0      | 2024-06-30 21:46:03  | 2024-06-30 21:46:03  |

  Scenario Outline: TC_03 When a GET request is sent to the /api/blog/{id} endpoint with invalid (invalid API key) authorization information,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request with invalid authorization information 'invalid API key' and saves the returned response,bilal.
    * The api user verifies that the status code is '401' with the reason phrase Unauthorized,bilal.

    Examples:
      | id |
      | 6  |
