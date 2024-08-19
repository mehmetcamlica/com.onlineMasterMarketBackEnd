Feature: As a provider, I want to be able to create a new staff record via API connection.

  Scenario: Verify 200 status code and "Staff added successfully" message for POST /api/addStaff with valid data and authorization
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/addStaff" path parameters.Selcuk
    * The api user sends a post request with the body.Selcuk
  """json
  {
    "firstname":"Test Data",
    "mobileno" :"55555555555",
    "email":"martin@gmail.com",
    "gender":"Male",
    "dob":"1985-04-18",
    "shop_id":15,
    "about_emp":"About Test"
  }
  """
    * The api user verifies that the status code is 200.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Staff added successfully".Selcuk
    * The api user deletes the post request.Selcuk
    * The api user close the api connection.Selcuk

  Scenario: Verify 203 status code and "Missing required fields" message for POST /api/addStaff with valid authorization and missing data.
    * The api user sets up spec for base url and valid token.Selcuk
    * The api user sets "api/addStaff" path parameters.Selcuk
    * The api user send request from "postStaffInvalidBody.json" file.Selcuk
    * The api user verifies that the status code is 203.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Missing required fields.Firstname,mobileno,email,gender,dob and shop_id.".Selcuk
    * The api user close the api connection.Selcuk

  Scenario: Verify 401 status code and "Invalid token or token missing" message for POST /api/addStaff with invalid authorization and valid data.
    * The api user sets up spec for base url and invalid token.Selcuk
    * The api user sets "api/addStaff" path parameters.Selcuk
    * The api user send request from "postStaffValidBody.json" file.Selcuk
    * The api user verifies that the status code is 401.Selcuk
    * The api user verifies that the "response.response_message" information in the response body is "Invalid token or token missing".Selcuk
    * The api user close the api connection.Selcuk
