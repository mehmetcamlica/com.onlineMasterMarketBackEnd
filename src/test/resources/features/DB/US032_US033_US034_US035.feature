Feature: US032_InsertNotificationsForProvider

  Background: Database connectivity
    * Database connection established, esra

  @US
  Scenario: Add a push notification only for providers from the push_notification table.
    # ayni mesaji database deki butun provider lara gonderme
    * Prepare query to insert data entry into the push_notification table, esra
    * Verify that 56 data added to the table, esra
    * Database closed, esra

  Scenario: Add a push notification(dinamik) only for providers from the push_notification table.
    # dinamik bir mesaj gonderme
    * Prepare dynamic query to insert data entry into the push_notification table, esra
    * Verify that 1 data added to the table, (dinamik) esra
    #* Delete the added data, esra
    * Database closed, esra

  Scenario: Activate the message with the subject 'System Maintenance' for users as well (user_status=1)
    # data olmadigi icin data ekledim.
    * Prepare dynamic query to insert data entry into the push_notification table for users, esra
    * Verify that 1 data added to the table, (dinamik) esra
    * Database closed, esra


  Scenario: Activate the message with the subject 'System Maintenance' for users as well (user_status=1)

    * Prepare a query to update data in the Push Notification table, esra
    * Verify that 1 data updated in the table, esra
    * Database closed, esra

  @US
  Scenario: Select and list products whose discounted price is 20 percent or more than the normal price.

    * Prepare a query to select data in the products table, esra
    * Verify that 1 data selected in the table
    * Database closed, esra

  Scenario: Calculate total revenues by grouping by providers in the revenue table.

    * Prepare a query to select data in the revenue table, esra
    #* Verify that provider 4 has the highest revenue
    * Database closed, esra






