Feature: Book Service Count

  Scenario Outline: US_012 .

    * Database connection established,bilal
    * Prepare query to calculate the shop_id with the hihgest number of services in the book_service table,bilal
    * verify that <shop_id> is the highest number of services,bilal
    * Database closed,bilal

    Examples:
      |shop_id|
      |   4   |

