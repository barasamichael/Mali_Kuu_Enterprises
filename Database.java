package gui;

import java.sql.*;

public class Database {
    protected final String dbUrl;
    protected final String dbUser;
    protected final String dbPassword;

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;

    Database()
    {
        AppConfig config = new AppConfig();

        this.dbUrl = config.getDatabaseUrl();
        this.dbUser = config.getDatabaseUser();
        this.dbPassword = config.getDatabasePassword();
    }

    public DatabaseResult query(String SQL)
    {
        try
        {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  new DatabaseResult(resultSet, connection, statement);
    }

    protected void closeConnection(Connection connection)
    {
        if (connection != null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeStatement(Statement statement)
    {
        if (statement != null)
        {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closePreparedStatement(PreparedStatement preparedStatement)
    {
        if (preparedStatement != null)
        {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeResultSet(ResultSet resultSet)
    {
        if (resultSet != null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
