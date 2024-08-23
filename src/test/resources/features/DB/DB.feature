@DB
Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  @US04
  Scenario: Enter 1 data entry in the administrators table  After verifying that it is done, delete the added data.
    * Prepare query to insert data entry into the administrators table
    # PreparedStatement ile insert islemi dogrulama
    * Verify that 1 added to the table
    * Delete the added data
    * Verify that 1 added to the table
    * Database closed

  @US05
  Scenario: Update safety Password administrators
    * Prepare query to insert data entry into the administrators table
     # PreparedStatement ile insert islemi dogrulama
    * Verify that 1 added to the table
    * Update password
    * Verify that 1 added to the table
    * Database closed

  @US19
  Scenario: Insert message contact_reply table
    * Prepare query to insert data entry into the contact_reply table
    # Statement ile insert islemi dogrulama
    * Verify that 54 added data to the table
    * Database closed

  @US25
  Scenario: List the coupons that have reached the maximum user limit.
    * prepare query to  into the service_coupons table
    * Verify results are obtained in the table
    * Database closed

  @US27
  Scenario:incomplete data insert test
    * prepare query to  into the users table
    * I attempt to insert the data into the users table
    * the insertion should fail with an error
    * Database closed