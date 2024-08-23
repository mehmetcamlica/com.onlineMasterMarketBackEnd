Feature:As a provider, I want to be able to access service and shop categories via API connection.

  Scenario Outline:TC001-When a GET request is sent to /api/categories endpoint with valid authorization information,
  it should be verified that the status code returned is 200 and the response_message in the response body is "Category List".



    * The api user sets "api/categories" path parameters Gokcen.
    * The api user sends a GET request and saves the returned response Gokcen.
    * The api user verifies that the status code is 200 Gokcen.
    * The api user verifies that the "response.response_message" information in the response body is "Category List" Gokcen.
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including "<category_name>", "<category_slug>", "<category_type>", "<gender_type>", "<category_image>" ,"<thumb_image>","<category_mobile_icon>","<status>" Gokcen.
    Examples:
      | dataIndex | category_name   | category_slug       | category_type | gender_type | category_image                                  |thumb_image                                              |category_mobile_icon|status|
      | 0         | Home Services   | home-services       |     0         |             |uploads/category_images/17191404842_381_286.png  | uploads/category_images/thu_17191404842_50_50.png       |                    |  1    |
      | 1         |Personal Services|  personal-services  |     0         |             |uploads/category_images/17191404603_381_286.png  |uploads/category_images/thu_17191404603_50_50.png        |                    |  1    |
      | 2         |Events           |events               |      0        |             |uploads/category_images/17191404674_381_286.png  |uploads/category_images/thu_17191404674_50_50.png        |                    |  1    |

  Scenario: TC002-When a GET request is sent to /api/categories endpoint with invalid (invalid API key) authorization information, it should beverified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/categories" path parameters Gokcen.

    * The api user sends a GET request with invalid authorization, saves the returned response Gokcen.
    * The api user verifies that the status code is 401 with the reason phrase "Unauthorized" Gokcen.