Feature:Database testing

  Scenario:US036-Add 5 data to the chat_table table at the same time

    * Database connection established,gokcen
    * Prepare query to insert 5 data entry into the chat_table, gokcen
    * Database closed,gokcen

  Scenario:US037-chat_table tablosunda read_status=1 okunmus mesaj sayısını dogrulayınız

    * Database connection established,gokcen
    * Prepare query to find read message count from chat_table, gokcen
    * Verify that 46 message is listed
    * Database closed,gokcen

  Scenario:US038-List the id, email and message information of the messages sent between certain dates in the contact_form_details table.( '2024-08-01' AND '2024-08-10')

    * Database connection established,gokcen
    * Prepare query to find messages that are sent between "2024-08-01" AND "2024-08-10" from contact_form_details, gokcen
    * Verify that 37 messages between dates are listed ,gokcen
    * Database closed,gokcen

  Scenario:US039-In the employee_basic_details table, calculate and verify the number of workers entered in August.

    * Database connection established,gokcen
    * Prepare query to find employees that are created in August from employee_basic_details, gokcen
    * Verify that 7 employees are listed ,gokcen
    * Database closed,gokcen
