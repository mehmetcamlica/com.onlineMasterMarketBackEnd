Feature: business_hours comparison.
@US_013
  Scenario Outline: US_013 Write the query that checks whether the hour intervals of the providers
            in business_hours table overlap on the same day and list the comparison.

    * Database connection established,bilal
    * Prepare query to get the overlaps on the same day in the business_hours table,bilal
    * list and verify the "<provider1>", "<provider2>", "<day>", "<overlap_start>", "<overlap_end>",bilal
    * Database closed,bilal

    Examples:
    |provider1  |provider2  |day  |overlap_start  |overlap_end   |
    |   5       |   6       | 1   |09:00  AM      |5:00 PM       |
    |   4       |   6       | 1   |09:00  AM      |10:00 PM      |
    |   4       |   5       | 1   |09:00  AM      |10:00 PM      |
