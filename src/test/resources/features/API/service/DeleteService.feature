Feature: As a provider, I want to be able to delete service information with the specified id number via API connection.

  Scenario Outline: When a DELETE request is sent to the /api/deleteService/{id} endpoint with valid authorization information and the
  correct (id), it should be verified that the status code returned is 200 and the response_message in the response body is
  "Service deleted successfully".

    * The api user sets "api/deleteService/<id>" path parameters.
    # Api kullanicisi "api/deleteService/{id}" path parametrelerini olusturur
    * The api user sends a DELETE request and saves the returned response.
    # Api kullanicisi DELETE request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200 DAMRA.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Service deleted successfully".
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Service deleted successfully" oldugunu dogrular
    * The api user verifies that the deleted_service_id information in the response body "delete_service_id" is the same as the id path parameter
    # Api kullanicisi response body icindeki deleted_service_id bilgisinin id path parametresi ile ayni oldugunu dogrular

    Examples:
      | id |
      | 109 |


  Scenario: When a DELETE request is sent to the /api/deleteService/{id} endpoint with valid authorization information but without (id),
  it should be verified that the status code returned is 203 and the response_message in the response body is "Id missing".

    * The api user sets "api/deleteService" path parameters.
    # Api kullanicisi "api/deleteService/{id}" path parametrelerini olusturur
    * The api user sends a DELETE request and saves the returned response.
    # Api kullanicisi DELETE request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Id missing".
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Id missing" oldugunu dogrular



  Scenario Outline: When a DELETE request with valid authorization information and an unregistered (id) is sent to the
  /api/deleteService/{id} endpoint, the status code returned is 203 and the response_message in the response body is
  "Blog not found. Invalid ID." should be verified.

    * The api user sets "api/deleteService/<id>" path parameters.
    # Api kullanicisi "api/deleteBlog/{id}" path parametrelerini olusturur
    * The api user sends a DELETE request and saves the returned response.
    # Api kullanicisi DELETE request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 203 DAMRA.
    # Api kullanicisi status codeun 203 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Service delete failed.No service this id.".
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Service delete failed.No service this id." oldugunu dogrular

    Examples:
      | id   |
      | 2000 |


  Scenario Outline: When a DELETE request is sent to the /api/deleteService/{id} endpoint with invalid (invalid API key) authorization
  information, it should be verified that the status code returned is 401 and the response_message in the response body is
  "Invalid token or token missing".

    * The api user sets "api/deleteService/<id>" path parameters.
    # Api kullanicisi "api/deleteService/{id}" path parametrelerini olusturur
    * The api user sends a DELETE request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.
    # Api kullanicisi DELETE request gonderir, donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 22 |


  Scenario Outline: The deletion of the Service record requested to be deleted from the API must be verified from the API.

    * The api user sets "api/deleteService/<id>" path parameters.
    * The api user sends a DELETE request and saves the returned response DAMRA.
    * The api user verifies that the status code is 401 DAMRA.
    * The api user verifies that the "response_message" information in the response body is "Invalid token or token missing"



    Examples:
      | id |
      | 49 |