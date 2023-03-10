package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalesPanel extends JPanel {
    JButton filterBtn;
    CustomTable salesTable;
    JScrollPane scrollPane;
    String[] columnNames = {
            "Sales ID", "Date", "Order ID", "Customer",
            "Item", "Quantity", "Total", "Payment Method", "completed"};
    DefaultTableModel tableModel;
    SalesPanel()
    {
        filterBtn = new JButton("Filter Results by Parameters");

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        salesTable = new CustomTable();
        salesTable.tableColumns = columnNames;
        salesTable.resetSQL = "SELECT Sales.orderAssignmentId, Sales.dateCreated, " +
                "Sales.orderId, CONCAT(Customer.firstName,' ',Customer.middleName, " +
                "' ', Customer.lastName) AS customerName, Item.name, Sales.quantity, " +
                "(instance.buyingPrice * Sales.quantity) AS total, _Order.payment, " +
                "_Order.completed FROM tbl_OrderAssignment Sales " +
                "INNER JOIN tbl_Order _Order ON Sales.orderId = _Order.orderId " +
                "INNER JOIN tbl_Customer Customer ON _Order.customerId = Customer.customerId " +
                "INNER JOIN tbl_ItemInstance instance ON Sales.itemInstanceId = instance.itemInstanceId " +
                "INNER JOIN tbl_Item Item ON instance.ItemId = Item.ItemId";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = salesTable.tableData(
                salesTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                salesTable.tableColumns);
        salesTable.setModel(model);

        scrollPane = new JScrollPane(salesTable);

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