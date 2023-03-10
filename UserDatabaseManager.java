package gui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDatabaseManager extends Database {
    UserDatabaseManager() {
    }

    public boolean registerRole(String title, String description, int permissions)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Role (title, description, permissions) " +
                "VALUES (?, ?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, permissions);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0)
            {
                success = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeStatement(statement);
            closeConnection(connection);
        }
        return success;
    }

    public boolean registerUser(
            String firstName, String middleName, String lastName, String emailAddress,
            String phoneNumber, String locationAddress, String nationalID, String passcode,
            String gender, int roleId)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_User (firstName, middleName, lastName, emailAddress, " +
                "phoneNumber, locationAddress, nationalID, passcode, gender, roleId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, emailAddress);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, locationAddress);
            preparedStatement.setString(7, nationalID);
            preparedStatement.setString(8, passcode);
            preparedStatement.setString(9, gender);
            preparedStatement.setInt(10, roleId);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0)
            {
                success = true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeStatement(statement);
            closeConnection(connection);
        }
        return success;
    }
}