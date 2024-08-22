
Feature:

  Scenario Outline: When a GET request with valid authorization information and correct data (id) is sent to the /api/category_details/{id} endpoint,
  it should be verified that the status code returned is 200 and the response_message in the response body is "Category  Details".

    * The api user sets "api/category_details/<id>" path parameters Gokcen.
    * The api user sends a GET request and saves the returned response Gokcen.
    * The api user verifies that the status code is 200 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Category  Details" Gokcen.
    Examples:
      | id |
      | 4  |

    Scenario Outline:When a GET request with valid authorization information and correct data (id) is sent to the /api/category_details/{id} endpoint,
    the data in the response body (id, category_name, category_slug, category_type, gender_type, category_image, thumb_image, category_mobile_icon, status, is_featured, created_at) should be verified.

      * The api user sets "api/category_details/<id>" path parameters Gokcen.
      * The api user sends a GET request and saves the returned response Gokcen.
      * The api user verifies the information in the response body for the entry with the specified "<id>", including "<category_name>", "<category_slug>", "<category_type>", "<gender_type>", "<category_image>" ,"<thumb_image>","<category_mobile_icon>","<status>" Gokcen.

      Examples:
        |id| id |    category_name          | category_slug              | category_type | gender_type | category_image                                  |thumb_image                                              |category_mobile_icon|status|
        |4  | 4 | Moving & Transportation   | moving-and-transportation  |     0         |             |uploads/category_images/1719141125rm_381_286.png | uploads/category_images/thu_1719141125rm_50_50.png      |                    |  1   |

  Scenario Outline: When a GET request is sent to the /api/category_details/{id} endpoint that does not contain
  valid authorization information and (id), it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".
    * The api user sets "api/category_details/<id>" path parameters Gokcen.
    * The api user sends a GET request and saves the returned response Gokcen.
    * The api user verifies that the status code is 203 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Id missing" Gokcen.
    Examples:
      | id  |
      |     |

  Scenario Outline: When sending a GET request to the /api/category_details/{id} endpoint with valid authorization information and an unregistered (id),
  it should be verified that the status code returned is 203 and the response_message in the response body is "No Details for this id.".
    * The api user sets "api/category_details/<id>" path parameters Gokcen.
    * The api user sends a GET request and saves the returned response Gokcen.
    * The api user verifies that the status code is 203 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "No Details for this id." Gokcen.
    Examples:
      | id  |
      |   100  |

  Scenario Outline: When a GET request is sent to the /api/category_details/{id} endpoint with invalid (invalid API key) authorization information,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/category_details/<id>" path parameters Gokcen.
    * The api user sends a GET request with invalid authorization, saves the returned response Gokcen.
    * The api user verifies that the status code is 401 with the reason phrase "Unauthorized" Gokcen.
    Examples:
      | id |
      |  4  |