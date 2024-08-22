package stepdefinitions.DB.gokcen;

import io.cucumber.java.en.Given;
import manage.ManageGokcen;
import org.junit.Assert;
import utilities.DB_Utilities.CommonData;
import utilities.DB_Utilities.CommonDataGokcen;

import java.sql.SQLException;
import java.util.ArrayList;

import static utilities.DB_Utilities.CommonDataGokcen.*;
import static utilities.DB_Utilities.CommonDataGokcen.employeeCreatedinAugust;
import static utilities.DB_Utilities.JDBC_Structure_Methods.*;
import static org.junit.Assert.*;

public class US036_US037_US038_US039_GokcenStepDefinitions extends ManageGokcen {
    CommonDataGokcen data = new CommonDataGokcen();


    public US036_US037_US038_US039_GokcenStepDefinitions(){

    }
    @Given("Database connection established,gokcen")
    public void database_connection_established_gokcen() {
        createConnection();
    }
   /* @Given("Prepare query to insert data entry into the chat_table, gokcen")
    public void prepare_query_to_insert_data_entry_into_the_chat_table_gokcen() throws SQLException {
        //sender_token, receiver_token, message, status, read_status, utc_date_time, created_at
        for (int i = 0; i <5 ; i++) {


            query = getUS036_addingto_chat_table();
            preparedStatement = getPraperedStatement(query);
            preparedStatement.setString(1, data.getSender_token());
            preparedStatement.setString(2, data.getReceiver_token());
            preparedStatement.setString(3, data.getMessage());
            preparedStatement.setInt(4, data.getStatus());
            preparedStatement.setInt(5, data.getRead_status());
            preparedStatement.setString(6, data.getUtc_date_time());
            preparedStatement.setString(7, data.getCreated_at());
        }


    }*/
    @Given("Prepare query to insert {int} data entry into the chat_table, gokcen")
    public void prepare_query_to_insert_data_entry_into_the_chat_table_gokcen(int addedDataCount) throws SQLException {
        int rowCount=0;
        for (int i = 0; i <addedDataCount ; i++) {
            query = getUS036_addingto_chat_table();
            preparedStatement = getPraperedStatement(query);
            preparedStatement.setString(1, data.getSender_token());
            preparedStatement.setString(2, data.getReceiver_token());
            preparedStatement.setString(3, data.getMessage());
            preparedStatement.setInt(4, data.getStatus());
            preparedStatement.setInt(5, data.getRead_status());
            preparedStatement.setString(6, data.getUtc_date_time());
            preparedStatement.setString(7, data.getCreated_at());

            rowCount=preparedStatement.executeUpdate();
            rowCount+=1;
    }


       int row=addedDataCount;

       // assertEquals(row,rowCount);
    }

    @Given("Database closed,gokcen")
    public void database_closed_gokcen() {
        closeConnection();
    }
    @Given("Prepare query to find read message count from chat_table, gokcen")
    public void prepare_query_to_find_read_message_count_from_chat_table_gokcen() throws SQLException {
        query = getUS037_readStatus();
        resultSet = getStatement().executeQuery(query);


    }

    @Given("Verify that {int} message is listed")
    public void verify_that_message_is_listed(int readStatusCount) throws SQLException {
        readStatusMessages = new ArrayList<>();
        while (resultSet.next()) {
            readStatusMessages.add(resultSet.getString("read_status"));

        }
        System.out.println(readStatusMessages.size());
        Assert.assertTrue(readStatusMessages.size()==readStatusCount);
        if (!readStatusMessages.isEmpty()) {
            for (int i = 0; i < readStatusMessages.size(); i++) {
                assertTrue(readStatusMessages.get(i).contains("1"));
            }
        } else {
            assertFalse("Resultset is empty", resultSet.next());
        }

    }
    @Given("Prepare query to find messages that are sent between {string} AND {string} from contact_form_details, gokcen")
    public void prepare_query_to_find_messages_that_are_sent_between_and_from_contact_form_details_gokcen(String startDate, String endDate) throws SQLException {
        query = getUS038_listingMessagesBetweenDates();
        resultSet = getStatement().executeQuery(query);

    }

    @Given("Verify that {int} messages between dates are listed ,gokcen")
    public void verify_that_message_between_dates_are_listed_gokcen(int messagesCount) throws SQLException {
        messageBetweenDates = new ArrayList<>();
        while (resultSet.next()) {
            messageBetweenDates.add(resultSet.getString("message"));

        }
        System.out.println(messageBetweenDates.size());
        Assert.assertTrue(messageBetweenDates.size() == messagesCount);
        if (!messageBetweenDates.isEmpty()) {
            for (int i = 0; i < messageBetweenDates.size(); i++) {
                //assertTrue(messageBetweenDates.get(i).contains(""));
            }
        } else {
            assertFalse("Result set is empty", resultSet.next());
        }
    }
    @Given("Prepare query to find employees that are created in August from employee_basic_details, gokcen")
    public void prepare_query_to_find_employees_that_are_created_in_august_from_employee_basic_details_gokcen() throws SQLException {
        query = getUS039_listingEmployeesCreatedinAugust();
        resultSet = getStatement().executeQuery(query);

    }
    @Given("Verify that {int} employees are listed ,gokcen")
    public void verify_that_employees_are_listed_gokcen(Integer employeeCount) throws SQLException {
        employeeCreatedinAugust = new ArrayList<>();
        while (resultSet.next()) {
            employeeCreatedinAugust.add(resultSet.getString("first_name"));

        }
        System.out.println(employeeCreatedinAugust.size());
        Assert.assertTrue(employeeCreatedinAugust.size() == employeeCount);
        if (!employeeCreatedinAugust.isEmpty()) {
            for (int i = 0; i < employeeCreatedinAugust.size(); i++) {
                //assertTrue(messageBetweenDates.get(i).contains(""));
            }
        } else {
            assertFalse("Result set is empty", resultSet.next());
        }
    }


}
