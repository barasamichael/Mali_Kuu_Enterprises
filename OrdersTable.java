package gui;

import gui.CustomTable;
import gui.ItemDatabaseManager;
import gui.JFramePopUp;
import gui.OrderProfile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrdersTable extends JPanel {
    CustomTable ordersTable;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;
    String[] columnNames = {"Order ID", "Date Created", "Payment", "Status"};

    OrdersTable(JFramePopUp parentFrame)
    {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        ordersTable = new CustomTable();
        ordersTable.tableColumns = columnNames;
        ordersTable.resetSQL = "SELECT orderId, dateCreated, payment, " +
                "completed FROM tbl_order WHERE customerId = " +
                parentFrame.id;

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = ordersTable.tableData(
                ordersTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                ordersTable.tableColumns);
        ordersTable.setModel(model);

        scrollPane = new JScrollPane(ordersTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);

        this.setVisible(true);
        ordersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();
                int column = 0;
                int id = (int) target.getValueAt(row, column);

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                    JFramePopUp major = new OrderProfile(id);
                    major.setVisible(true);
                }
            }
        });
    }
    public CustomTable getTable()
    {
        return ordersTable;
    }
}