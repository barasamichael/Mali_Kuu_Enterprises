package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerTable extends JPanel {
    CustomTable customersTable;
    JScrollPane scrollPane;

    String[] columnNames = {"ID", "Names", "Email Address", "Phone Number", "Location"};
    DefaultTableModel tableModel;
    CustomerTable()
    {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        customersTable = new CustomTable();
        customersTable.tableColumns = columnNames;
        customersTable.resetSQL = "SELECT customerId, CONCAT(firstName, ' ', " +
                "IFNULL(middleName, ''), ' ', lastName) " +
                "AS name, emailAddress, " +
                "phoneNumber, locationAddress FROM tbl_Customer";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = customersTable.tableData(
                customersTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                customersTable.tableColumns);
        customersTable.setModel(model);

        scrollPane = new JScrollPane(customersTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);
    }

    public CustomTable getTable()
    {
        return customersTable;
    }
}