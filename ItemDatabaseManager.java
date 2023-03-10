package gui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ItemDatabaseManager extends Database {
    ItemDatabaseManager() {
    }

    public boolean registerItem(String name, String description)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_Item (name, description) VALUES (?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);

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

    public boolean addSupplyItem(double buyingPrice, double sellingPrice,
                                 int quantity, int itemId, int supplyId)
    {
        boolean success = false;
        String SQL = "INSERT INTO tbl_ItemInstance (buyingPrice, sellingPrice, quantity, itemId, supplyId) VALUES (?, ?, ?, ?, ?)";
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setDouble(1, buyingPrice);
            preparedStatement.setDouble(2, sellingPrice);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, itemId);
            preparedStatement.setInt(5, supplyId);

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