package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StocksPanelSecondHalf extends JPanel {
    CustomTable stockItems;
    JScrollPane scrollPane;
    String[] columnNames = {"Item ID", "Name", "Description"};
    ItemDatabaseManager itemManager;

    DefaultTableModel tableModel;
    StocksPanelSecondHalf()
    {

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        tableModel = new DefaultTableModel();
        stockItems = new CustomTable();
        stockItems.tableColumns = columnNames;
        stockItems.resetSQL = "SELECT itemId, description, name FROM tbl_Item";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = stockItems.tableData(stockItems.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                stockItems.tableColumns);
        stockItems.setModel(model);

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