Feature: As a provider, I want to be able to update the
            information of the staff with the specified id number via API connection.

  Scenario: Verify PATCH /api/editStaff/{id} returns 200 and 'Staff updated successfully' message with valid data.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/editStaff/107" path parameters.Selcuk
    * The api user send patch request from "patchStaffValidBody.json" file.Selcuk
    * The api user verifies that the status code is 200.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Staff updated successfully".Selcuk
    * The api user close the api connection.Selcuk

  Scenario: Verify PATCH /api/editStaff/{id} returns 203 and 'No data for updated' message when no data is provided
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/editStaff/107" path parameters.Selcuk
    * The api user send patch request from "nullData.json" file.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "No data for updated.".Selcuk
    * The api user close the api connection.Selcuk

  Scenario: Verify PATCH /api/editStaff/{id} returns 203 and 'Id missing' message with valid data but missing ID.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/editStaff" path parameters.Selcuk
    * The api user send patch request from "patchStaffValidBody.json" file.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Id missing".Selcuk
    * The api user close the api connection.Selcuk


  Scenario: Verify PATCH /api/editStaff/{id} returns 203 and 'Failed to update staff. No staff with this ID' message for unregistered ID.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/editStaff/10000" path parameters.Selcuk
    * The api user send patch request from "patchStaffValidBody.json" file.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Failed to update staff.No staff this id.".Selcuk
    * The api user close the api connection.Selcuk

  Scenario: Verify PATCH /api/editStaff/{id} returns 401 and 'Invalid token or token missing' message with invalid API key.
    * The api user sets up spec for base url and invalid token.Selcuk
    * The api user sets "api/editStaff/107" path parameters.Selcuk
    * The api user send patch request from "patchStaffValidBody.json" file.Selcuk
    * The api user verifies that the status code is 401.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing".Selcuk
    * The api user close the api connection.Selcuk

  Scenario Outline: Verify update_staff_id in response matches the id path parameter in PATCH /api/editStaff/{id}.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/editStaff/<id>" path parameters.Selcuk
    * The api user send patch request from "patchStaffValidBody.json" file.Selcuk
    * The api user verifies "data.update_staff_id" in response matches the id path parameter in PATCH id <id>.Selcuk
    * The api user close the api connection.Selcuk
    Examples:
    |id |
    |107|
