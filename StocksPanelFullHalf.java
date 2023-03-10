package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StocksPanelFullHalf extends JPanel {
    public CustomTable stockItems;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;

    String[] columnNames = {"ID", "Item", "Buying Price", "Selling Price", "Quantity"};
    StocksPanelFullHalf()
    {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        stockItems = new CustomTable();
        stockItems.tableColumns = columnNames;
        stockItems.resetSQL = "SELECT instance.itemInstanceId, item.name, " +
                "instance.buyingPrice, instance.sellingPrice, " +
                "instance.quantity - IFNULL(SUM(sales.quantity), 0) AS diff " +
                "FROM tbl_Item item INNER JOIN tbl_ItemInstance instance " +
                "ON item.itemId = instance.itemId LEFT JOIN tbl_OrderAssignment " +
                "sales ON instance.itemInstanceId = sales.itemInstanceId " +
                "GROUP BY instance.itemInstanceId HAVING diff > 0";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = stockItems.tableData(stockItems.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                stockItems.tableColumns);
        stockItems.setModel(model);
        stockItems.getColumnModel().getColumn(0).setPreferredWidth(1);
        stockItems.getColumnModel().getColumn(1).setPreferredWidth(3);
        stockItems.getColumnModel().getColumn(2).setPreferredWidth(6);
        scrollPane = new JScrollPane(stockItems);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);

        this.setVisible(true);
    }
    public CustomTable getTable()
    {
        return stockItems;
    }
}