package stepdefinitions.DB;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import utilities.DB_Utilities.DBReader;

import java.sql.*;

import static manage.ManageEsra.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EsraStepDefinitions {

    Connection connection;
    ResultSet resultSet;
    Statement statement;

    PreparedStatement preparedStatement;

    Faker faker;

    int affectedRow;

    String query;

    int count;

    @Given("Database connection established, esra")
    public void database_connection_established_esra() {
        String url = DBReader.getDbProperties("URL");
        String username = DBReader.getDbProperties("USERNAME");
        String password = DBReader.getDbProperties("PASSWORD");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error : " + e.getMessage(), e);
        }
    }

    @Given("Prepare query to insert data entry into the push_notification table, esra")
    public void prepare_query_to_insert_data_entry_into_the_push_notification_table_esra() throws SQLException {
        statement = connection.createStatement();
        query = US032_INSERT_NOTIFICATIONS_PROVIDER;
    }

    @Given("Prepare dynamic query to insert data entry into the push_notification table for users, esra")
    public void prepare_dynamic_query_to_insert_data_entry_into_the_push_notification_table_for_users_esra() throws SQLException {
        query = US033_INSERT_NOTIFICATIONS_USER;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, "System Maintenance");
        preparedStatement.setString(2, "New updates available in the system");
        preparedStatement.setInt(3, 0);
        preparedStatement.setInt(4, 0);
        preparedStatement.setInt(5, 0);
        affectedRow = preparedStatement.executeUpdate();
    }


    @Given("Verify that {int} data added to the table, esra")
    public void verify_that_data_added_to_the_table_esra(int row) {

        int rowCount = 0;
        try {
            rowCount = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error : " + e.getMessage(), e);
        }
        assertEquals(row, rowCount);
    }

    @Given("Prepare dynamic query to insert data entry into the push_notification table, esra")
    public void prepare_dynamic_query_to_insert_data_entry_into_the_push_notification_table_esra() throws SQLException {
        query = US032_DINAMIC_INSERT_NOTIFICATIONS_PROVIDER;
        faker = new Faker();
        affectedRow = insertNotification(query, 0, 1);
    }

    @Given("Verify that {int} data added to the table, \\(dinamik) esra")
    public void verify_that_data_added_to_the_table_dinamik_esra(int expectedRow) {
        assertEquals(expectedRow, affectedRow);
    }


    @Given("Prepare a query to update data in the Push Notification table, esra")
    public void prepare_a_query_to_update_data_in_the_push_notification_table_esra() throws SQLException {
        statement = connection.createStatement();
        query = US033_UPDATE_NOTIFICATIONS_USER;

    }

    @Given("Verify that {int} data updated in the table, esra")
    public void verify_that_data_updated_in_the_table_esra(int affectedRow) {

        int rowCount = 0;
        try {
            rowCount = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error : " + e.getMessage(), e);
        }
        assertEquals(affectedRow, rowCount);

    }


    @Given("Prepare a query to select data in the products table, esra")
    public void prepare_a_query_to_select_data_in_the_products_table_esra() throws SQLException {
        query = US034_SELECT_PRODUCTS;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @Given("Verify that {int} data selected in the table")
    public void verify_that_data_selected_in_the_table(int expectedSize) throws SQLException {

        int actualSize = 0;
        while (resultSet.next()) {
            actualSize++;
        }
        assertEquals(actualSize, expectedSize);

    }

    @Given("Prepare a query to select data in the revenue table, esra")
    public void prepare_a_query_to_select_data_in_the_revenue_table_esra() throws SQLException {
        query = US035_SELECT_REVENUE;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        String actualproviderId = resultSet.getString("provider");

        System.out.println(actualproviderId);
    }

    @Given("Verify that provider {int} has the highest revenue")
    public void verify_that_provider_has_the_highest_revenue(int expectedProviderId) throws SQLException {

    }

    @Given("Database closed, esra")
    public void database_closed_esra() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int insertNotification(String query, int userStatus, int providerStatus) throws SQLException {

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, faker.book().title());
        preparedStatement.setString(2, faker.lorem().sentence());
        preparedStatement.setInt(3, userStatus);
        preparedStatement.setInt(4, providerStatus);
        preparedStatement.setInt(5, 1);
        return preparedStatement.executeUpdate();
    }


}
