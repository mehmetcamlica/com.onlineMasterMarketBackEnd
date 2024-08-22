Feature: As a provider, I want to be able to update the information of the editService with the specified id number via API connection.

  Scenario Outline: When a PATCH body is sent to the endpoint /api/editService/{id} containing the correct (id) and correct data
  (shop_id, staff_id, duration, service_title, category, subcategory, service_amount, about) with valid authorization information, it must be verified that the status code returned is 200 and the
  response_message in the response body is "Service updated successfully".

    * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService" path parametrelerini olusturur
    * The api user prepares a patch request containing <id> <shop_id>, <staff_id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<shop_id>", <staff_id>, "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir post request hazirlar
    * The api user sends a "PATCH" request and saves the returned response DAMRA.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Service updated successfully" DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Service  Updated successfully" oldugunu dogrular
    * The api user verifies that the updated_service_id information in the response body "data.updated_service_id" is the same as the id path parameter DAMRA.
    # Api kullanicisi response body icindeki updated_service_id bilgisinin id path parametresi ile ayni oldugunu dogrular

    Examples:
      | id   | shop_id    | staff_id | duration      | service_title        | category | subcategory    | service_amount | about    |
      |  10 | 10         | 41       | 60            | Test Service Updated  | 1       | 5               | 200            | Test Service Description New Service etc.      |





  Scenario Outline: When a PATCH body is sent to /api/editService/{id} endpoint with valid authorization information and correct (id) and correct data
  (duration, service_title, category, subcategory, service_amount, about), it should be verified that the status code
  returned is 200 and the response_message in the response body is "Service updated successfully".

    * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService" path parametrelerini olusturur
    * The api user prepares a patch request containing <id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir post request hazirlar
    * The api user sends a "PATCH" request and saves the returned response DAMRA.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Service updated successfully" DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Service  Updated successfully" oldugunu dogrular


    Examples:
      | id     | duration  | service_title         | category | subcategory     | service_amount | about                                         |
      | 10     | 100        | Test Service Updated  | 1        | 5               | 500            | Test Service Description New Service etc.      |




  Scenario Outline: When a PATCH request is sent to the /api/editService/{id} endpoint with valid authorization information with the correct (id) and no data,
  it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".

    * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService" path parametrelerini olusturur
    * The api user prepares a patch request containing <id>, <damra>, "<genc>", "<Wisequarter>", "<noName>", <AleynaDilan>, "<teacher>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir post request hazirlar
    * The api user sends a "PATCH" request and saves the returned response DAMRA.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "No Results found for the given ID" DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "No data for updated." oldugunu dogrular


    Examples:
      | id     | damra  | genc                  | Wisequarter | noName     | AleynaDilan| teacher                                        |
      | 10000     | 100    | Test Service Updated  | 1        | 5               | 500            | Test Service Description New Service etc.      |




  Scenario Outline: When sending a PATCH body to /api/editService/{id} endpoint with valid authorization information
  (id) and correct data (shop_id, staff_id, duration, service_title, category, subcategory, service_amount, about),
  it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService" path parametrelerini olusturur
    * The api user prepares a patch request containing   <shop_id>, <staff_id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir post request hazirlar
    * The api user sends a "PATCH" request and saves the returned response DAMRA.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Id missing" DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "No data for updated." oldugunu dogrular


       Examples:
         | id | shop_id    | staff_id | duration      | service_title        | category | subcategory    | service_amount | about    |
         |    | 10         | 41       | 60            | Test Service Updated  | 1       | 5               | 200            | Test Service Description New Service etc.      |


    Scenario Outline: When a PATCH request is sent to the /api/editService/{id} endpoint with valid authorization information with the correct
    (id) and no data, it should be verified that the status code returned is 203 and the response_message in the response body is "No data for updated.".


      * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService/id" path parametrelerini olusturur
      * The api user sends a "PATCH" request and saves the returned response DAMRA.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder
      * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
      * The api user verifies that the "response.response_message" information in the response body is "No data for updated." DAMRA.
    # Api kullanicisi response bodydeki response.response_message bilgisinin "No data for updated." oldugunu dogrular

  Examples:

    |id|
    | 10 |


  Scenario Outline: When sending a PATCH body with invalid (invalid API key) authorization information and correct (id) and
  correct data (shop_id, staff_id, duration, service_title, category, subcategory, service_amount, about) to /api/editService/{id} endpoint,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/editService/<id>" path parameters DAMRA.
    # Api kullanicisi "api/editService/id" path parametrelerini olusturur
    * The api user prepares a patch request containing <shop_id>, <staff_id>, <duration>, "<service_title>", "<category>", "<subcategory>", <service_amount>, "<about>" information to send to the api addService endpoint DAMRA.
    # Api kullanicisi api addService endpointine gondermek icin "<duration>", "<category>" ,"<subcategory>", "<service_title>" bilgilerini iceren bir patch request hazirlar
    * The api user sends a "PATCH" request and saves the returned response damraa.
    # Api kullanicisi PATCH request gonderir ve donen responsei kaydeder



    Examples:
      | id | shop_id    | staff_id | duration      | service_title        | category | subcategory    | service_amount | about    |
      |  20  | 10         | 41       | 60            | Test Service Updated  | 1       | 5               | 200            | Test Service Description New Service etc.      |





Scenario Outline: It should be verified from the API that the service record requested to be updated from the API has been updated.
(With the updated_service_id returned in the response body, a GET request can be sent to the /api/service-details/{id} endpoint to verify that the record has been updated.)


  * The api user sets "api/service-details/<id>" path parameters DAMRA.

  * The api user sends a GET request and saves the returned response DAMRA.

  * The api user service_title information "Test Service Updated" verification.

  Examples:
    | id |
    | 10 |

