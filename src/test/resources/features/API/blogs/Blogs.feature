Feature: As a provider I want to be able to access blogs via API connection.

  Scenario: Blog List

    * The api user sets "api/blogs" path parameters.
    # Api kullanicisi "api/blogs" path parametrelerini olusturur
    * The api user sends a "GET" request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
<<<<<<< HEAD
    * The api user verifies that the "response.response_message" information in the response body is "Blogs Listed Successfully".
=======
    * The api user verifies that the "response.response_message" information in the response body is "".
>>>>>>> main
    # Api kullanicisi response bodydeki response.response_message bilgisinin "Blogs Listed Successfully" oldugunu dogrular


  Scenario: Invalid Token Blog List

    * The api user sets "api/blogs" path parameters.
    # Api kullanicisi "api/blogs" path parametrelerini olusturur
    * The api user sends a "GET" request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.
    # Api kullanicisi GET request gonderir, donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
