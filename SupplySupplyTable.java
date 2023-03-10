package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SupplySupplyTable extends JPanel {
    CustomTable supplyItems;
    JScrollPane scrollPane;

    String[] columnNames = {"ID", "Item", "Buying Price", "Selling Price", "Quantity"};

    SupplyProfile parentFrame;
    SupplySupplyTable(SupplyProfile parentFrame)
    {
        this.parentFrame = parentFrame;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        supplyItems = new CustomTable();
        supplyItems.tableColumns = columnNames;

        supplyItems.resetSQL = "SELECT ins.itemInstanceId, i.name, ins.buyingPrice," +
                " ins.sellingPrice, ins.quantity FROM tbl_ItemInstance ins " +
                " JOIN tbl_Item i ON i.itemId = ins.itemId WHERE ins.supplyId = " + parentFrame.id;

        String[] columnNames = {"ID", "Item", "Quantity", "BP", "SP", "Present"};

        SupplierDatabaseManager supplierManager = new SupplierDatabaseManager();
        Object[][] tableDataArray = supplyItems.tableData(supplyItems.reset());

        DefaultTableModel tableModel = new DefaultTableModel(tableDataArray,
                supplyItems.tableColumns);
        supplyItems.setModel(tableModel);
        scrollPane = new JScrollPane(supplyItems);

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
        return supplyItems;
    }
}
