package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseResult {
    private ResultSet resultSet;
    private Connection connection;
    private Statement statement;

    public DatabaseResult(ResultSet resultSet, Connection connection, Statement statement) {
        this.resultSet = resultSet;
        this.connection = connection;
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void close() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}