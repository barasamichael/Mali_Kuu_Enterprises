package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSupply extends JPanel {
    JButton	newSupplyBtn, searchBtn;
    JTextField searchEntry;
    JLabel searchLbl;
    JSeparator separator;

    CustomTable supplyTable;
    JFramePopUp parentFrame;

    CreateSupply(CustomTable supplyTable, JFramePopUp parentFrame)
    {
        this.supplyTable = supplyTable;
        this.parentFrame = parentFrame;

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {1.0};
        searchLbl = new JLabel("Search Supply");
        searchEntry = new JTextField();
        searchBtn = new JButton("submit");

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                actionSearchSupply();
            }
        });

        separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);

        newSupplyBtn = new JButton("New Supply");
        newSupplyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if (action()) {
                    JOptionPane.showMessageDialog(null,
                            "Supply Application Successful!",
                            "Supply Application",
                            JOptionPane.INFORMATION_MESSAGE);

                    SupplierDatabaseManager supplierManager = new SupplierDatabaseManager();

                    Object[][] tableDataArray = supplyTable.tableData(
                            supplyTable.reset());
                    DefaultTableModel model = new DefaultTableModel(
                            tableDataArray, supplyTable.tableColumns);
                    supplyTable.setModel(model);
                }
            }
        });

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 10);
        this.add(searchLbl, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(searchEntry, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(searchBtn, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(separator, gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 4;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(newSupplyBtn, gbc5);

        this.setVisible(true);
    }

    private boolean action()
    {
        boolean success = false;
        SupplierDatabaseManager supplyManager = new SupplierDatabaseManager();
        success = supplyManager.registerSupply(parentFrame.id);

        if (!(success)) {
            JOptionPane.showMessageDialog(null, "Supply Application Failed!",
                    "Supply Application", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchSupply()
    {
        String search = searchEntry.getText().trim();
        JFramePopUp parentFrame = (JFramePopUp) SwingUtilities.getWindowAncestor(this);
        String SQL = "SELECT supplyId, dateCreated, payment, completed " +
                "FROM tbl_Supply WHERE supplierId = " +
                parentFrame.id + " AND " +
                "(supplyId LIKE '%" + search + "%' OR " +
                " dateCreated LIKE '%"+ search +"%' OR " +
                " payment LIKE '%"+ search +"%' OR " +
                " completed LIKE '%"+ search +"%')";

        Object[][] tableDataArray = supplyTable.tableData(
                supplyTable.filterTable(SQL));
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                supplyTable.tableColumns);
        supplyTable.setModel(model);
    }
}