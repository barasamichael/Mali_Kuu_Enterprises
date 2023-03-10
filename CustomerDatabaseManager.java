package gui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDatabaseManager extends Database {
    CustomerDatabaseManager() {
    }

    public boolean registerCustomer(
            String firstName, String middleName, String lastName, String emailAddress,
            String phoneNumber, String locationAddress, String gender)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Customer (firstName, middleName, lastName, " +
                "emailAddress, phoneNumber, locationAddress, gender, passcode) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            preparedStatement.setString(7, gender);
            preparedStatement.setString(8, "password");

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

    public boolean registerOrder(int customerId)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Order (customerId, payment) VALUES (?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, "Cash");

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

    public boolean addOrderItem(int quantity, int itemInstanceId, int orderId)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_OrderAssignment (quantity, orderId, " +
                "itemInstanceId) VALUES (?, ?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, orderId);
            preparedStatement.setInt(3, itemInstanceId);

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
