package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class OrderItemsTable extends JPanel {
    CustomTable itemsTable;
    JScrollPane scrollPane;
    Object[][] data = {};
    String[] columnNames = {"ID", "Item", "Buying Price", "Quantity"};
    DefaultTableModel tableModel;
    JFramePopUp parentFrame;
    OrderItemsTable(OrderProfile parentFrame)
    {
        this.parentFrame = parentFrame;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        itemsTable = new CustomTable();
        itemsTable.tableColumns = columnNames;
        itemsTable.resetSQL = "SELECT instance.itemInstanceId, item.name, " +
                "instance.sellingPrice, instance.quantity - " +
                "IFNULL(SUM(sales.quantity), 0) AS diff " +
                "FROM tbl_Item item INNER JOIN tbl_ItemInstance instance " +
                "ON item.itemId = instance.itemId LEFT JOIN tbl_OrderAssignment " +
                "sales ON instance.itemInstanceId = sales.itemInstanceId " +
                "GROUP BY instance.itemInstanceId HAVING diff > 0 ";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = itemsTable.tableData(
                itemsTable.reset());
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
                    BigDecimal value = (BigDecimal) target.getValueAt(row, 2);
                    String sellingPrice = value.toString();

                    parentFrame.searchItem.itemId.setText(id);
                    parentFrame.searchItem.itemEntry.setText(name);
                    parentFrame.searchItem.bpEntry.setText(sellingPrice);
                }
            }
        });
    }

    public CustomTable getTable()
    {
        return itemsTable;
    }
}
