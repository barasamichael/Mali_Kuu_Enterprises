package gui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SupplierDatabaseManager extends Database {
    SupplierDatabaseManager() {
    }

    public boolean registerSupplier(String name, String specialty,
                                    String emailAddress, String phoneNumber, String locationAddress)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Supplier (name, specialty, emailAddress, " +
                "phoneNumber, locationAddress, passcode) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specialty);
            preparedStatement.setString(3, emailAddress);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, locationAddress);
            preparedStatement.setString(6, "passcode");

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

    public boolean registerSupply(int supplierId)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Supply (supplierId, payment) VALUES (?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, supplierId);
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
}
