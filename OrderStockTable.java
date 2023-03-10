package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderStockTable extends JPanel {
    CustomTable stockTable;
    JScrollPane scrollPane;
    String[] columnNames = {"ID", "Item", "Quantity", "BP", "Amount"};
    DefaultTableModel tableModel;
    JFramePopUp parentFrame;
    OrderStockTable(JFramePopUp parentFrame)
    {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        stockTable = new CustomTable();
        stockTable.tableColumns = columnNames;
        stockTable.resetSQL = "SELECT sales.orderAssignmentId, item.name, " +
                "instance.sellingPrice, sales.quantity, " +
                "(sales.quantity * instance.sellingPrice) AS Total " +
                "FROM tbl_Item item JOIN tbl_ItemInstance instance " +
                "ON item.itemId = instance.itemId JOIN tbl_OrderAssignment " +
                "sales ON instance.itemInstanceId = sales.itemInstanceId " +
                "JOIN tbl_order _order ON sales.orderId = _order.orderId " +
                "WHERE _order.orderId = " + parentFrame.id;

        Object[][] tableDataArray = stockTable.tableData(
                stockTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                stockTable.tableColumns);
        stockTable.setModel(model);

        scrollPane = new JScrollPane(stockTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);

        this.setVisible(true);
        stockTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();
                int column = 0;
                int id = (int) target.getValueAt(row, column);

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                }
            }
        });
    }

    public CustomTable getTable()
    {
        return stockTable;
    }
}