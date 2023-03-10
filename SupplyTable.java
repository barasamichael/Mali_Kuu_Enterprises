package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplyTable extends JPanel {
    CustomTable supplyItems;
    JScrollPane scrollPane;
    JFramePopUp parentFrame;

    String[] columnNames = {"Supply ID", "Date Created", "Payment", "Status"};
    DefaultTableModel tableModel;
    SupplyTable(JFramePopUp parentFrame)
    {
        this.parentFrame = parentFrame;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        supplyItems = new CustomTable();
        supplyItems.tableColumns = columnNames;
        supplyItems.resetSQL = "SELECT supplyId, dateCreated, payment, " +
                "completed FROM tbl_Supply WHERE supplierId = " +
                parentFrame.id;

        SupplierDatabaseManager supplierManager = new SupplierDatabaseManager();
        Object[][] tableDataArray = supplyItems.tableData(supplyItems.reset());

        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                supplyItems.tableColumns);
        supplyItems.setModel(model);
        scrollPane = new JScrollPane(supplyItems);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);

        this.setVisible(true);
        supplyItems.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();
                int column = 0;
                int id = (int) target.getValueAt(row, column);

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                    JFramePopUp major = new SupplyProfile(id);
                    major.setVisible(true);
                }
            }
        });
    }
    public CustomTable getTable()
    {
        return supplyItems;
    }
}