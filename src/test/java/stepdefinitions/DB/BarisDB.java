package stepdefinitions.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BarisDB {

    private static final String URL = "jdbc:mysql://45.87.83.5:3306/u168183796_qaonlineuser";
    private static final String USERNAME = "u168183796_qaonlineuser";
    private static final String PASSWORD = "Fi8]K0dv*7g";
    private Connection connection;

    public void SQLTestCases() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testAddAndDeleteAdministrator() {
        givenAdministratorInserted();
        thenVerifyAdministratorInserted();
        givenAdministratorDeleted();
        thenVerifyAdministratorDeleted();
    }

    private void givenAdministratorInserted() {
        String insertSQL = "INSERT INTO administrators (email, password, username, full_name, profile_img, role, token) "
                + "VALUES ('test@example.com', 'password123', 'testuser', 'Test User', 'profile.png', 0, 'token123')";
        try {
            executeUpdate(insertSQL);
            System.out.println("Administrator inserted.");
        } catch (SQLException e) {
            System.out.println("Error inserting administrator: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void thenVerifyAdministratorInserted() {
        String selectSQL = "SELECT * FROM administrators WHERE role = 0";
        try {
            ResultSet rs = executeQuery(selectSQL);
            if (rs.next()) {
                System.out.println("Test Case 1 - Admin Insertion Passed");
            } else {
                System.out.println("Test Case 1 - Admin Insertion Failed");
            }
        } catch (SQLException e) {
            System.out.println("Error verifying administrator insertion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void givenAdministratorDeleted() {
        String deleteSQL = "DELETE FROM administrators WHERE role = 0";
        try {
            executeUpdate(deleteSQL);
            System.out.println("Administrator deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting administrator: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void thenVerifyAdministratorDeleted() {
        String selectSQL = "SELECT * FROM administrators WHERE role = 0";
        try {
            ResultSet rs = executeQuery(selectSQL);
            if (!rs.next()) {
                System.out.println("Test Case 1 - Admin Deletion Passed");
            } else {
                System.out.println("Test Case 1 - Admin Deletion Failed");
            }
        } catch (SQLException e) {
            System.out.println("Error verifying administrator deletion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.executeUpdate();
    }

    private ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    


}
