Feature: As a provider, I want to be able to delete blog information with the specified id number via API connection.

  @Delete @US
  Scenario: blog

    * The api user sets "api/deleteBlog" path parameters.
    # Api kullanicisi "api/deleteBlog/{id}" path parametrelerini olusturur
    * The api user sends a "DELETE" request and saves the returned response.
    # Api kullanicisi DELETE request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "response.response_message" information in the response body is "Blog deleted successfully".
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Blog deleted successfully" oldugunu dogrular
    * The api user verifies that the "data.deleted_blog_id" information in the returned response body is the same as the id path parameter written in the endpoint.
    # Api kullanicisi donen response body icindeki "data.deleted_blog_id" bilgisinin endpointde yazan id path parametresi ile ayni oldugunu dogrular
    * The api user verifies that the "response.response_message" is "No Details for this id." by sending a GET request to the "api" "blog" endpoint with the "data.deleted_blog_id" returned in the response body.
    # Api kullanicisi response bodyde donen "data.deleted_blog_id" ile "api" "blog" endpoint'ine GET request göndererek "response.response_message" bilgisinin "No Details for this id." oldugunu dogrular