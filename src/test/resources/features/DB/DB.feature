Feature: Database Testing


  @US01
  Scenario: Update the address row of your provider in the provider_address table according to your e-mail in the providers table.
    * Prepare query to insert data entry into the provider_email table
    * Verify that "email" added to the table
    * Database closed
