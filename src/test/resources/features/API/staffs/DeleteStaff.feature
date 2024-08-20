Feature: As a provider, I want to be able to delete staff
          information with the specified id number via API connection.
  Scenario Outline: Verify DELETE /api/deleteStaff/{id} returns 200 and 'Staff deleted successfully' message with valid ID.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/deleteStaff/<id>" path parameters.Selcuk
    * The api user send delete request for that spesific <id>.Selcuk
    * The api user verifies that the status code is 200.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Staff deleted successfully".Selcuk
    * The api user close the api connection.Selcuk
    Examples:
    |id |
    |107|

  Scenario: Verify 203 status and 'Id missing' message when DELETE /api/deleteStaff/ called without {id}
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/deleteStaff" path parameters.Selcuk
    * The api user send delete request for that spesific 0.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Id missing".Selcuk
    * The api user close the api connection.Selcuk

  Scenario Outline: Verify 203 status and 'Failed to delete staff' message for unregistered {id} in DELETE /api/deleteStaff/
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/deleteStaff/<id>" path parameters.Selcuk
    * The api user send delete request for that spesific <id>.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Failed to delete staff.It can be wrong ID.".Selcuk
    * The api user close the api connection.Selcuk
    Examples:
      |id |
      |10000|

  @nl
  Scenario Outline: Verify 203 status and 'Failed to delete staff' message for unregistered {id} in DELETE /api/deleteStaff/
    * The api user sets up spec for base url and invalid token.Selcuk
    * The api user sets "api/deleteStaff/<id>" path parameters.Selcuk
    * The api user send delete request for that spesific <id>.Selcuk
    * The api user verifies that the status code is 401.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing".Selcuk
    * The api user close the api connection.Selcuk
    Examples:
      |id |
      |107|
