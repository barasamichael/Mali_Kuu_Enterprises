package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FinancesPanel extends JPanel {
    JButton filterBtn;
    CustomTable financesTable;
    JScrollPane scrollPane;
    String[] columnNames = {
            "Year", "Month", "Payable", "Receivable",
            "Paid", "Received", "Sold", "Bought", "Gross Profit"};
    DefaultTableModel tableModel;
    FinancesPanel()
    {
        filterBtn = new JButton("Filter Results by Parameters");

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        financesTable = new CustomTable();
        financesTable.tableColumns = columnNames;
        financesTable.resetSQL = "SELECT YEAR(tbl_Order.dateCreated) AS year, " +
                "MONTH(tbl_Order.dateCreated) AS month, " +
                "SUM(CASE WHEN tbl_Supply.completed = false THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity " +
                "ELSE 0 END) AS AccountsPayable, " +
                "SUM(CASE WHEN tbl_Order.completed = false THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) AS AccountsReceivable, " +
                "SUM(CASE WHEN tbl_Supply.completed = true THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity ELSE " +
                "0 END) AS AccountsPaid, " +
                "SUM(CASE WHEN tbl_Order.completed = true THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) AS AccountsReceived, " +
                "SUM(tbl_OrderAssignment.quantity) AS QuantitiesSold, " +
                "SUM(tbl_ItemInstance.quantity) AS QuantitiesBought, " +
                "SUM(CASE WHEN tbl_Order.completed = true THEN " +
                "tbl_ItemInstance.sellingPrice * tbl_OrderAssignment.quantity " +
                "ELSE 0 END) - SUM(CASE WHEN tbl_Supply.completed = true THEN " +
                "tbl_ItemInstance.buyingPrice * tbl_ItemInstance.quantity ELSE 0 " +
                "END) AS GrossProfit FROM tbl_Order " +
                "INNER JOIN tbl_OrderAssignment ON tbl_Order.orderId = " +
                "tbl_OrderAssignment.orderId " +
                "INNER JOIN tbl_ItemInstance ON tbl_OrderAssignment.itemInstanceId " +
                "= tbl_ItemInstance.itemInstanceId " +
                "INNER JOIN tbl_Supply ON tbl_ItemInstance.supplyId = " +
                "tbl_Supply.supplyId GROUP BY year, month";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = financesTable.tableData(
                financesTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                financesTable.tableColumns);
        financesTable.setModel(model);

        scrollPane = new JScrollPane(financesTable);

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