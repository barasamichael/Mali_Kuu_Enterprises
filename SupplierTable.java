package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplierTable extends JPanel {
    CustomTable suppliersTable;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;

    String[] columnNames = {"ID", "Name", "Specialty", "Email Address",
            "Phone Number", "Location"};
    SupplierTable() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        tableModel = new DefaultTableModel();
        suppliersTable = new CustomTable();
        suppliersTable.tableColumns = columnNames;
        suppliersTable.resetSQL = "SELECT supplierId, name, specialty, " +
                "emailAddress, phoneNumber, locationAddress " +
                "FROM tbl_Supplier";

        ItemDatabaseManager itemManager = new ItemDatabaseManager();
        Object[][] tableDataArray = suppliersTable.tableData(suppliersTable.reset());
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                suppliersTable.tableColumns);
        suppliersTable.setModel(model);

        scrollPane = new JScrollPane(suppliersTable);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);
        suppliersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CustomTable target = (CustomTable) e.getSource();
                int row = target.getSelectedRow();
                int column = 0;
                int id = (int) target.getValueAt(row, column);

                if (e.getClickCount() == 1) {
                    //
                } else if (e.getClickCount() == 2) {
                    JFramePopUp major = new SupplierProfile(id);
                    major.setVisible(true);
                }
            }
        });
    }
    public CustomTable getTable()
    {
        return suppliersTable;
    }
}