package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplyItemsTable extends JPanel {
    CustomTable itemsTable;
    JScrollPane scrollPane;
    String[] columnNames = {"ID", "Item", "Description"};
    ItemDatabaseManager itemManager;
    DefaultTableModel tableModel;

    SupplyItemsTable(SupplyProfile parentFrame) {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        itemsTable = new CustomTable();
        itemsTable.tableColumns = columnNames;
        itemsTable.resetSQL = "SELECT itemId, name, description FROM tbl_Item";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = itemsTable.tableData(itemsTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                itemsTable.tableColumns);
        itemsTable.setModel(model);
        scrollPane = new JScrollPane(itemsTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);

        this.setVisible(true);
        itemsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                    String id = Integer.toString(
                            (Integer) target.getValueAt(row, 0));
                    String name = (String) target.getValueAt(row, 1);

                    parentFrame.searchItem.itemId.setText(id);
                    parentFrame.searchItem.itemEntry.setText(name);
                }
            }
        });
    }

    public CustomTable getTable() {
        return itemsTable;
    }
}