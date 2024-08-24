Feature: Count Categories by Gender and Type in the categories table.
  @US
  Scenario Outline: US_014 In the categories table, group and list
            the number of categories for each gender and category type.

    * Database connection established,bilal
    * Prepare query to calculate the number of categories grouped by gender and category type in the categories table,bilal
    * verify that correct <category_count> is calculated,bilal
    * Database closed,bilal

    Examples:
      |category_count|
      |     20       |

