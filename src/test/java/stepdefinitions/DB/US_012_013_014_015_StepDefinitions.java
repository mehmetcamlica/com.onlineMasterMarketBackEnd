package stepdefinitions.DB;

import io.cucumber.java.en.Given;
import manage.Query_Manage_Bilal;
import org.junit.Assert;
import utilities.DB_Utilities.JDBCMethods;
import utilities.DB_Utilities.JDBC_Structure_Methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class US_012_013_014_015_StepDefinitions {

    String query;
    ResultSet resulset;
    int expectedResult;
    int actualResult;
    String expectedResultNewestDateTime;
    String expectedResultOldestDateTime;
    String actualResultNewestDateTime;
    String  actualResultOldestDateTime;
    List actualResultSetList;

    Map<String, Integer> category_count_Map;

    Query_Manage_Bilal queryManage = new Query_Manage_Bilal();


    @Given("Database connection established,bilal")
    public void database_connection_established() {

        JDBC_Structure_Methods.createConnection();
    }
    @Given("Prepare query to calculate the shop_id with the hihgest number of services in the book_service table,bilal")
    public void prepare_query_to_calculate_the_shop_id_with_the_hihgest_number_of_services_in_the_book_service_table() {

        query = queryManage.getQuery_US_012();
        try {
            resulset = JDBC_Structure_Methods.getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("verify that {int} is the highest number of services,bilal")
    public void verify_that_is_the_highest_number_of_services(Integer shop_id) throws SQLException {

        expectedResult = shop_id;

        try {
            if (resulset.next())

              actualResult = resulset.getInt("shop_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualResult : " + resulset.getInt("shop_id"));

        assertEquals(expectedResult,actualResult);

    }
    @Given("Database closed,bilal")
    public void database_closed() {
        JDBC_Structure_Methods.closeConnection();
    }
    @Given("Prepare query to calculate the number of categories grouped by gender and category type in the categories table,bilal")
    public void prepare_query_to_calculate_the_number_of_categories_grouped_by_gender_and_category_type_in_the_categories_table_bilal() throws SQLException {
        query = queryManage.getQuery_US_014();
        try {
            resulset= JDBC_Structure_Methods.getStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
        while (resulset.next()){
            String key = resulset.getString("gender_type"+"-"+resulset.getString("category_type"));
            int category_count = resulset.getInt("category_count");
            category_count_Map.put(key,category_count);
        }
         */

    }
    @Given("verify that correct {int} is calculated,bilal")
    public void verify_that_correct_is_calculated_bilal(int category_count) throws SQLException {
        expectedResult = category_count;

        try {
            if (resulset.next())

                actualResult = resulset.getInt("category_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("actualResult : " + resulset.getInt("category_count"));

        assertEquals(expectedResult,actualResult);

    }
    @Given("Prepare query to get the dates of the newest and oldest categories among category creation dates in the categories table,bilal")
    public void prepare_query_to_get_the_dates_of_the_newest_and_oldest_categories_among_category_creation_dates_in_the_categories_table_bilal() {
        query = queryManage.getQuery_US_015();
        try {
            resulset = JDBC_Structure_Methods.getStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Given("verify that  newest creation date should be {string} and the oldest creation date should be {string},bilal")
    public void verify_that_newest_creation_date_should_be_and_the_oldest_creation_date_should_be_bilal(String newest_creation_date, String oldest_creation_date) {

        expectedResultNewestDateTime = newest_creation_date;
        expectedResultOldestDateTime = oldest_creation_date;

        try {
            if (resulset.next()){
                actualResultNewestDateTime = resulset.getString("newest_creation_date");
                actualResultOldestDateTime = resulset.getString("oldest_creation_date");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expectedResultNewestDateTime,actualResultNewestDateTime);
        assertEquals(expectedResultOldestDateTime,actualResultOldestDateTime);

    }
    @Given("Prepare query to get the overlaps on the same day in the business_hours table,bilal")
    public void prepare_query_to_get_the_overlaps_on_the_same_day_in_the_business_hours_table_bilal() throws SQLException {

        query = queryManage.getQuery_US_013();
        try {
            resulset = JDBC_Structure_Methods.getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        actualResultSetList = JDBCMethods.getQueryResultList(query);

        System.out.println(actualResultSetList);
        System.out.println(actualResultSetList.get(0));

    }

    @Given("list and verify the {string}, {string}, {string}, {string}, {string},bilal")
    public void list_and_verify_the_bilal(String provider1, String provider2, String day, String overlap_start, String overlap_end) {

        List<Object> expectedList = new ArrayList<>();
        ArrayList<String> expectedDataArray = new ArrayList<>();
        expectedDataArray.add("5");
        expectedDataArray.add("6");
        expectedDataArray.add("1");
        expectedDataArray.add("09:00  AM");
        expectedDataArray.add("5:00 PM");
        System.out.println(expectedDataArray);

        expectedList.add(expectedDataArray);

        System.out.println(expectedList);
        Assert.assertEquals(expectedDataArray,actualResultSetList.get(0));
       // assertEquals(provider1, actualResultSetList.get(0));
    }





}
