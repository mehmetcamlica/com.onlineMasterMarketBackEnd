package stepdefinitions.DB;

import utilities.DB_Utilities.CommonData;
import io.cucumber.java.en.Given;
import manage.Manage;

import java.sql.SQLException;
import java.util.ArrayList;

import static utilities.DB_Utilities.CommonData.*;
import static utilities.DB_Utilities.JDBC_Structure_Methods.*;
import static org.junit.Assert.*;

public class DB_Stepdefinitions extends Manage {
    CommonData data = new CommonData();

    public DB_Stepdefinitions() throws SQLException {
    }


    // O
    @Given("Database connection established")
    public void database_connection_established() {
       createConnection();
    }

    @Given("Database closed")
    public void database_closed() {
        closeConnection();
    }

    @Given("Prepare query to insert data entry into the administrators table")
    public void prepare_query_to_insert_data_entry_into_the_administrators_table() throws SQLException {
        query= getUS04insert_data_administrator();
        preparedStatement=getPraperedStatement(query);
        // email, password, username, full_name, profile_img, role, token
        preparedStatement.setString(1,data.getEmail());
        preparedStatement.setString(2,data.getPassword());
        preparedStatement.setString(3,data.getUsername());
        preparedStatement.setString(4,data.getFullName());
        preparedStatement.setString(5,data.getProfileImg());
        preparedStatement.setInt(6,data.getRole());
        preparedStatement.setString(7,data.getToken());
    }

    @Given("Verify that {int} added to the table")
    public void verify_that_added_to_the_table(int row) {

   int rowCount=0;
        try {
            rowCount=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(row,rowCount);
    }

    @Given("Delete the added data")
    public void delete_the_added_data() throws SQLException {
        userId=getLastInsertedUserId(getUS04getLastUserIdAdministrator(), data.getEmail());
        query=getUS04delete_added_data_administrator();
        preparedStatement=getPraperedStatement(query);
        preparedStatement.setInt(1,userId);
    }

    @Given("Update password")
    public void update_password() throws SQLException {
        userId=getLastInsertedUserId(getUS04getLastUserIdAdministrator(), data.getEmail());
        String newPassword=data.generateNewPassword(faker,data.getPassword());
        query=getUS5update_data_administrator();
        preparedStatement=getPraperedStatement(query);
        preparedStatement.setString(1,newPassword);
        preparedStatement.setInt(2,userId);
    }


    /**
     * US19
     ****/
    @Given("Prepare query to insert data entry into the contact_reply table")
    public void prepare_query_to_insert_data_entry_into_the_contact_reply_table() throws SQLException {
        query=getUS19contact_reply_message();
        rowCount=getStatement().executeUpdate(query);
    }

    @Given("Verify that {int} added data to the table")
    public void verify_that_added_data_to_the_table(int row) {
        // Sonuç kümesinde satır varsa, bir girişin eklendiğini doğrula
          assertEquals("Giriş eklenemedi.", row, rowCount);
    }

    /**
     * US25
     ****/

    @Given("prepare query to  into the service_coupons table")
    public void prepare_query_to_into_the_service_coupons_table() throws SQLException {
        query=getUS25_service_coupons_user_limit();
        resultSet=getStatement().executeQuery(query);
    }

    @Given("Verify results are obtained in the table")
    public void verify_results_are_obtained_in_the_table() throws SQLException {
            couponNames=new ArrayList<>();
            while (resultSet.next()){
                couponNames.add(resultSet.getString("coupon_name"));
            }
            if(!couponNames.isEmpty()) {
                for (int i = 0; i <couponNames.size() ; i++) {
                    //assertTrue(couponNames.get(i).conteins("...."));
                }
            }else{
                assertFalse("Resultset is empty",resultSet.next());
            }

    }

    /**
     * US27
     */

    // (mobileno, country_code, currency_code, status, usertype)
    @Given("prepare query to  into the users table")
    public void prepare_query_to_into_the_users_table() throws SQLException {
        query=getUS27_incomplated_data_insert_users_table();
        preparedStatement=getPraperedStatement(query);
        preparedStatement.setString(1,data.getMobileNo());
        preparedStatement.setString(2,data.getCountry_code());
        preparedStatement.setString(3,data.getCurrency_code());
        preparedStatement.setInt(4,data.getStatus());
        preparedStatement.setInt(5,data.getUsertype());
    }
    @Given("I attempt to insert the data into the users table")
    public void i_attempt_to_insert_the_data_into_the_users_table() {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           exception=e;
        }

    }

    @Given("the insertion should fail with an error")
    public void the_insertion_should_fail_with_an_error() {
        System.err.println("************"+exception+"************");
        assertTrue("Veri girişi sırasında hata bekleniyordu",exception.getMessage().contains("Field 'name' doesn't have a default value"));
    }

    }









