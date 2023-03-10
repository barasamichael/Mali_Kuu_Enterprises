package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrdersPanel extends JPanel {
    JButton filterBtn;
    CustomTable ordersTable;
    JScrollPane scrollPane;
    String[] columnNames = {"Date", "Order ID", "Customer", "Item Count", "Total", "Payment Method", "Completed"};
    DefaultTableModel tableModel;
    OrdersPanel()
    {
        filterBtn = new JButton("Filter Results by Parameters");

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        ordersTable = new CustomTable();
        ordersTable.tableColumns = columnNames;

        ordersTable.resetSQL = "SELECT o.dateCreated, o.orderId, CONCAT(c.firstName, ' "+
                "', IFNULL(c.middleName, ''), ' ', c.lastName) AS customerName, " +
                "COUNT(s.orderAssignmentId) AS numSales, SUM(s.quantity * i.buyingPrice) " +
                "AS totalAmount, o.payment, o.completed FROM tbl_Order o " +
                "INNER JOIN tbl_Customer c ON o.customerId = c.customerId " +
                "INNER JOIN tbl_OrderAssignment s ON o.orderId = s.orderId " +
                "INNER JOIN tbl_ItemInstance i ON s.itemInstanceId = i.itemInstanceId " +
                "GROUP BY o.orderId ORDER BY o.orderId DESC";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = ordersTable.tableData(
                ordersTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                ordersTable.tableColumns);
        ordersTable.setModel(model);

        scrollPane = new JScrollPane(ordersTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(filterBtn, gbc);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.weighty = 1.0;
        gbc1.weightx = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc1);
    }
}