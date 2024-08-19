Feature:As a provider, I want to be able to access the shops via API connection.
@US1
  Scenario Outline:When a GET request is sent to /api/myShops endpoint with valid authorization information,
  it should be verified that the status code returned is 200 and the response_message in the response body is "Shops Listed Successfully"
  .When a GET request is sent to /api/myShops endpoint with valid authorization information, the information
  (shop_code, shop_name, country_code, tax_allow, tax_number, contact_no, email, address, country_name, state_name, city_name, postal_code)
  returned in the response body of id(x) should be verified.

    * The api user sets "api/myShops" path parameters TOPRAK.
    * The api user sends a GET request and saves the returned response TOPRAK.
    * The api user verifies that the status code is 200 TOPRAK.
    * The api user verifies that the "response.response_message" information in the response body is "Shops Listed Successfully" TOPRAK.
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index,"<shop_code>", "<shop_name>", "<tax_allow>", "<contact_no>", "<email>", "<address>", "<country_name>", "<state_name>", "<city_name>", "<postal_code>" TOPRAK.

    Examples:
      |dataIndex|shop_code|shop_name|tax_allow|contact_no|email|address|country_name|state_name|city_name|postal_code|
      |0|SHOP4Q0CN5|FixIt Pros|No|2587456321|info@fixit.com|7990 California City Blvd, California City, CA 93505, USA|USA (+1)|California|California City|93505|

  Scenario:  When a GET request is sent to /api/myShops endpoint with invalid (invalid API key) authorization information,
  it should be verified that the status code returned is 401 and the response_message in the response body is "Invalid token or token missing".

    * The api user sets "api/myShops" path parameters TOPRAK.
    * The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized TOPRAK.
