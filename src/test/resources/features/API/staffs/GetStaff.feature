Feature: As a provider I want to be able to access staffs via API connection.

Scenario: When a GET request is sent to /api/myStaffs endpoint with valid
    authorization information, it should be verified that the status code
    returned is 200 and the response_message in the response body is
    "Staffs Listed Successfully".

  * The api user sets up spec for base url and valid token.Selcuk
  * The api user sets "api/myStaffs" path parameters.Selcuk
  * The api user sends a get request and saves the returned response.Selcuk
  * The api user verifies that the status code is 200.Selcuk
  * The api user verifies that the "response.response_message" information in the response body is "Staffs Listed Successfully".Selcuk
  * The api user close the api connection.Selcuk

  Scenario Outline: When a GET request is sent to /api/myStaffs endpoint with
    valid authorization information, the information returned in the response body of
    id(x) (provider_id, first_name, last_name, country_code,
    contact_no, email, dob, gender, profile_img, designation, exp_year, exp_month, status)
    should be verified.

  * The api user sets up spec for base url and valid token.Selcuk
  * The api user sets "api/myStaffs" path parameters.Selcuk
  * The api user sends a get request and saves the returned response.Selcuk
  * The api user verifies that the data in the response body index[<index>] includes <id>, <provider_id>, "<first_name>", "<contact_no>", "<email>", "<status>".Selcuk
  * The api user close the api connection.Selcuk

    Examples:
    |index|id|provider_id|first_name    |contact_no|email                  |status|
    |0    |1 |6          |James Anderson|2589635874|jamesanderson@gmail.com|Active|

    Scenario: When a GET request is sent to /api/myStaffs endpoint with invalid (invalid API key)
      authorization information, it should be verified that the status code returned is 401 and the
      response_message in the response body is "Invalid token or token missing".

    * The api user sets up spec for base url and invalid token.Selcuk
    * The api user sets "api/myStaffs" path parameters.Selcuk
    * The api user sends a get request, and verifies that the status code is 401 and message is "unauthorizedExceptionMessage".Selcuk
    * The api user close the api connection.Selcuk
