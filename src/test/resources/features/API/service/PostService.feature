Feature: As a provider, I want to be able to create a new service record via API connection.
@Damra
  Scenario Outline: When a POST body with valid authorization information and correct data (shop_id, staff_id, duration, service_title, category, subcategory, service_amount,about)
  is sent to /api/addService endpoint, it should be verified that the status code returned is 200 and the response_message in the
  response body is "Service added successfully".

    * The api user sets "api/addService" path parameters.

    * The api user prepares a post request containing <shop_id>, <staff_id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.

   * The api user sends a POST request and saves the returned response DAMRA.

    * The api user verifies that the status code is 200.

    * The api user verifies that the "response.response_message" information in the response body is "Service added successfully"

    Examples:
      | shop_id    | staff_id | duration      | service_title      | category                | subcategory       | service_amount      | about                                          |
      | 10         | 41       | 60            | Test Service       | Repairs & Maintenance   | Handyman Services | 150                 | Test Service Description New Service etc.      |



  Scenario Outline: When a POST body with valid authorization information and missing data is sent to the /api/addService endpoint,
  it should be verified that the status code returned is 203 and the response_message in the response body is
  "shop_id, staff_id, duration and category is required.".

    * The api user sets "api/addService" path parameters DAMRA.

    * The api user prepares a post request containing <shop_id>, <staff_id>, <duration>, "<category>", "<subcategory>", "<service_title>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<shop_id>", <staff_id>, "<duration>", "<category>" bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response DAMRA.

    * The api user verifies that the status code is 203.

    * The api user verifies that the "response.response_message" information in the response body is "Add service failed, required fields empty"


  Examples:
    | shop_id    | staff_id | duration |  category                |  subcategory              |  service_title             |
    | 10         | 41       | 60       |  Repairs & Maintenance    |  Handyman Service               | Test Service              |

  Scenario: When a POST request with valid authorization information but no data is sent to the /api/addService endpoint, it should be
  verified that the status code returned is 203 and the response_message in the response body is "Add service failed, required fields empty.".


    * The api user sets "api/addService" path parameters DAMRA.
    # Api kullanicisi "api/addService" path parametrelerini olusturur
    * The api user prepares a POST request that contains no data DAMRA.
    # Api kullanicisi data icermeyen bir post request hazırlar
    * The api user sends a POST request and saves the returned response DAMRA.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Add service failed, required fields empty" DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Add service failed, required fields empty." oldugunu dogrular





  Scenario Outline: Invalid Token When a POST body with invalid (invalid API key) authorization information and correct data (shop_id, staff_id,
  duration, category, subcategory,service_title) is sent to /api/addService endpoint, it should be verified that the status code returned is 401 and the
  response_message in the response body is "Invalid token or token missing"

    * The api user sets "api/addService" path parameters DAMRA.
    # Api kullanicisi "api/addService" path parametrelerini olusturur
    * The api user prepares a post request containing <shop_id>, <staff_id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<shop_id>", <staff_id>, "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir post request hazirlar
    * The api user sends a POST request and saves the returned response DAMRA.
    # Api kullanicisi POST request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 401.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing"
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Invalid token or token missing." oldugunu dogrular

    Examples:
      | shop_id    | staff_id | duration      | service_title      | category                | subcategory       | service_amount      | about                                          |
      | 10         | 41       | 60            | Test Service       | Repairs & Maintenance   | Handyman Services | 150                 | Test Service Description New Service etc.      |



