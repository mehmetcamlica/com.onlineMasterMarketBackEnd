Feature: Verify Category Creation Dates in the categories table.
  @US
  Scenario Outline: US_015 Verify the dates of the newest and oldest categories among category creation dates.

    * Database connection established,bilal
    * Prepare query to get the dates of the newest and oldest categories among category creation dates in the categories table,bilal
    * verify that  newest creation date should be "<newest_creation_date>" and the oldest creation date should be "<oldest_creation_date>",bilal
    * Database closed,bilal

    Examples:
      |newest_creation_date   |oldest_creation_date   |
      |2024-08-22 16:49:41    |2024-06-23 15:31:48    |
