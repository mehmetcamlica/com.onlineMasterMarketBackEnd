Feature: US_062 As a provider, I should be able to access the detailed information
          of the product category with the specified id number via API connection

  Scenario Outline: TC_01 When a GET request with valid authorization information
                    and correct data (id) is sent to the /api/productCategory/{id} endpoint,
                    it should be verified that the status code returned is 200 and
                    the response_message in the response body is "Product Details".

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 200,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Product Details",bilal.

    Examples:
      | id |
      | 6  |

  Scenario Outline: TC_02 When a GET request with valid authorization information and correct data (id)
                    is sent to the /api/productCategory/{id} endpoint, the data in the response body
                    (id, category_name, slug, category_image, thumb_image, status, updated_on, created_on) should be verified.

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the information in the response body includes "<id>", "<category_name>", "<slug>", "<category_image>", "<thumb_image>", "<status>","<updated_on>","<created_on>",bilal.

    Examples:
      | id | id | category_name       | slug     | category_image | thumb_image | status | updated_on           | created_on           |
      | 6  | 6  | Health & Wellness   | health&8 | null           |             | 0      | 2024-06-30 21:46:03  | 2024-06-30 21:46:03  |

  Scenario Outline: TC_03 When a GET request is sent to the /api/productCategory/{id} endpoint
                    that does not contain valid authorization information and (id),
                    it should be verified that the status code returned is 203 and
                    the response_message in the response body is "Id missing".

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "Id missing",bilal.

    Examples:
      | id |
      |    |

  Scenario Outline: TC_04 When sending a GET request to the /api/productCategory/{id} endpoint
                    with valid authorization information and an unregistered (id),
                    it should be verified that the status code returned is 203 and
                    the response_message in the response body is "No Details for this id.".

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request and saves the returned response,bilal.
    * The api user verifies that the status code is 203,bilal.
    * The api user verifies that the "response.response_message" information in the response body is "No Details for this id.",bilal.

    Examples:
      | id |
      | 99 |

  Scenario Outline: TC_05 When a GET request is sent to the /api/productCategory/{id} endpoint
                    with invalid (invalid API key) authorization information,
                    it should be verified that the status code returned is 401 and
                    the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/productCategory/<id>" path parameters,bilal.
    * The api user sends a "GET" request with invalid authorization information 'invalid API key' and saves the returned response,bilal.
    * The api user verifies that the status code is '401' with the reason phrase Unauthorized,bilal.

    Examples:
      | id |
      | 6  |

