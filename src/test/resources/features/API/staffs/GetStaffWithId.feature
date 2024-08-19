Feature: As a provider, I should be able to access the detailed information 
          of the staff with the specified id number via API connection.
  
  Scenario Outline: Verify GET /api/staff-detail/{id} returns 200 status and "Staff Details" response message
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/staff-detail/<id>" path parameters.Selcuk
    * The api user sends a get request and saves the returned response.Selcuk
    * The api user verifies that the status code is 200.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Staff Details".Selcuk
    * The api user close the api connection.Selcuk
    
    Examples: 
    |id|
    |1 |

  Scenario Outline: Verify response data fields for GET /api/staff-detail/{id} with valid authorization and correct ID
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/staff-detail/<id>" path parameters.Selcuk
    * The api user sends a get request and saves the returned response.Selcuk
    * The api user verifies that data in the respond body
      |id|provider_id|first_name         |last_name|country_code|contact_no|email                      |gender|status|
      |1 |6          |James Anderson     |[blank]  |[blank]     |2589635874|jamesanderson@gmail.com    |Male  |1     |
    * The api user close the api connection.Selcuk
    Examples:
    |id|
    |1 |

  Scenario Outline: Verify GET /api/staff-detail/{id} with unregistered ID returns 203 status and "No Details found" message
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/staff-detail/<id>" path parameters.Selcuk
    * The api user sends a get request and saves the returned response.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "No Details found".Selcuk

    Examples:
    |id    |
    |10000 |
    |-1    |

  Scenario: GET /api/staff-detail/{id} - Verify 203 Status and 'Id missing' Response for Invalid Authorization and Missing Id
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/staff-detail" path parameters.Selcuk
    * The api user sends a get request and saves the returned response.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Id missing".Selcuk

  Scenario: Verify 401 status code and "Invalid token or token missing" message for GET /api/staff-detail/{id} with invalid authorization
      * The api user sets up spec for base url and invalid token.Selcuk
      * The api user sets "api/staff-detail/1" path parameters.Selcuk
      * The api user sends a get request, and verifies that the status code is 401 and message is "unauthorizedExceptionMessage".Selcuk
      * The api user close the api connection.Selcuk
