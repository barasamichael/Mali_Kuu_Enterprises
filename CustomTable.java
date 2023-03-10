package gui;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomTable extends JTable {
    String[] tableColumns = {};
    String resetSQL = null;
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public DatabaseResult reset()
    {
        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        DatabaseResult databaseResult = itemManager.query(resetSQL);
        return databaseResult;
    }

    public DatabaseResult filterTable(String SQL)
    {
        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        DatabaseResult databaseResult = itemManager.query(SQL);
        return databaseResult;
    }
    public DatabaseResult filterTable(String SQL, String search)
    {
        SQL += "'%" + search + "%'";
        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        DatabaseResult databaseResult = itemManager.query(SQL);
        return databaseResult;
    }
    public Object[][] tableData(DatabaseResult databaseResult) {
        ResultSet resultSet = databaseResult.getResultSet();
        Object[][] tableDataArray = new Object[0][];
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<List<Object>> tableData = new ArrayList<>();
            while (resultSet.next()) {
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(resultSet.getObject(i));
                }
                tableData.add(rowData);
            }

            tableDataArray = new Object[tableData.size()][columnCount];
            for (int i = 0; i < tableData.size(); i++) {
                List<Object> rowData = tableData.get(i);
                for (int j = 0; j < rowData.size(); j++) {
                    tableDataArray[i][j] = rowData.get(j);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        try {
            databaseResult.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableDataArray;
    }
}