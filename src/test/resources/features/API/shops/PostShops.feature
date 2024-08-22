Feature: As a provider, I want to be able to create a new shop record via API connection.
  @US38
  Scenario Outline: When a POST body with valid authorization information and correct data (shop_title, description, contact_no, email, tax_allow, address, category, sub_category)
  is sent to /api/addShop endpoint, it should be verified that the status code returned is 200 and the response_message in the response body is "Shop added successfully".

    * The api user sets "api/addShop" path parameters.

    * The api user prepares a post request containing "<shop_title>", "<description>", "<contact_no>", "<email>", <tax_allow>, "<address>", <category>, <sub_category> information to send to the api addService endpoint TOPRAK.

    * The api user sends a POST request and saves the returned response TOPRAK.

    * The api user verifies that the status code is 200 TOPRAK.

    * The api user verifies that the "response.response_message" information in the response body is "Shop added successfully"

    Examples:
      |shop_title| description | contact_no      | email                | tax_allow  | address            | category | sub_category  |
      |New Shop|  New Shop Desc   | 12365478985   | newshop@gmail.com   | 1          | New York City,USA    | 1       |  3   |




  Scenario Outline: When a POST body (shop_title, description, contact_no, email, tax_allow, category, sub_category) with valid authorization information and missing data
  (address) is sent to /api/addShop endpoint, it should be verified that the status code returned is 203 and the response_message in the response body is "address is required".

    * The api user sets "api/addShop" path parameters TOPRAK.

    * The api user prepares a post request containing "<shop_title>", "<description>", "<contact_no>", "<email>", <tax_allow>, <category>, <sub_category> information to send to the api addService endpoint TOPRAK.
    # Api kullanicisi api addService endpointine gondermek icin "<shop_title>", "<description>", "<contact_no>", "<email>", <tax_allow>, <category>, <sub_category> bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response TOPRAK.

    * The api user verifies that the status code is 203.

    * The api user verifies that the "response.response_message" information in the response body is "address is required"


    Examples:
      | shop_title    | description     | contact_no    |  email                |  tax_allow              |  category             |sub_category |
      |New Shop      |  New Shop Desc   | 12365478985   | newshop@gmail.com      | 1                       |  1                    |  3                   |




  Scenario: When a POST request is sent to /api/addShop endpoint with valid authorization information but no data, the status code returned is 203 and the response_message
  in the response body is "No data for updated. Required fields empty\"" should be verified.

    * The api user sets "api/addShop" path parameters TOPRAK.
    # Api kullanicisi "api/addShop" path parametrelerini olusturur
    * The api user prepares a POST request that contains no data TOPRAK.
    # Api kullanicisi data icermeyen bir post request hazırlar
    * The api user sends a POST request and saves the returned response TOPRAK.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "No data for updated. Required fields empty\"" TOPRAK.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Add service failed, required fields empty." oldugunu dogrular





  Scenario Outline: When a POST body is sent to /api/addShop endpoint with invalid (invalid API key) authorization information and correct data
  (shop_title, description, contact_no, email, tax_allow, address, category, sub_category), it should be verified that the status code returned is 401 and the response_message
  in the response body is "Invalid token or token missing".

    * The api user sets "api/addShop" path parameters TOPRAK.
    # Api kullanicisi "api/addService" path parametrelerini olusturur
    * The api user prepares a post request containing "<shop_title>", "<description>", "<contact_no>", "<email>", <tax_allow>, "<address>", <category>, <sub_category> information to send to the api addService endpoint TOPRAK.
    # Api kullanicisi api addService endpointine gondermek icin "<shop_title>", "<description>", "<contact_no>", "<email>", <tax_allow>, "<address>", <category>, <sub_category> bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response TOPRAK.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 401.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing"
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Invalid token or token missing." oldugunu dogrular

    Examples:
      | shop_title    | description | contact_no      | email                    | tax_allow   | address          | category      | sub_category     |
      |New Shop      |  New Shop Desc   | 12365478985   | newshop@gmail.com      | 1          | New York City,USA |  1           |  3            |
