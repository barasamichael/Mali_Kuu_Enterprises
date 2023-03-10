package gui;

import gui.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupplySearchItem extends JPanel {
    JTextField itemId, itemEntry;
    DefaultClearTextField bpEntry, spEntry, quantityEntry,
            searchSupplyEntry, searchItemEntry;
    JButton submitBtn, searchSupplyBtn, searchItemBtn, summaryBtn, deleteBtn,
            paymentBtn;
    JSeparator separator1, separator2, separator0;
    CustomTable itemsTable;
    CustomTable supplyTable;
    JFramePopUp parentFrame;
    ArrayList<Object> widgets;
    SupplySearchItem(JFramePopUp parentFrame, CustomTable itemsTable, CustomTable supplyTable)
    {
        this.parentFrame = parentFrame;
        this.itemsTable = itemsTable;
        this.supplyTable = supplyTable;

        itemId = new JTextField();
        itemEntry = new JTextField();
        bpEntry = new DefaultClearTextField("Buying Price");
        spEntry = new DefaultClearTextField("Selling Price");
        quantityEntry = new DefaultClearTextField("Quantity");

        itemId.setEditable(false);
        itemEntry.setEditable(false);

        submitBtn = new JButton("Add To Cart");

        searchSupplyEntry = new DefaultClearTextField("Supply Entry");
        searchSupplyBtn = new JButton("Search Cart");

        searchItemEntry = new DefaultClearTextField("Item Entry");
        searchItemBtn = new JButton("Search Items");

        summaryBtn = new JButton("Summary");
        deleteBtn = new JButton("Cancel Supply");
        paymentBtn = new JButton("Payment Details");

        separator0 = new JSeparator();
        separator0.setOrientation(SwingConstants.HORIZONTAL);

        separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.HORIZONTAL);

        separator2 = new JSeparator();
        separator2.setOrientation(SwingConstants.HORIZONTAL);

        widgets = new ArrayList<Object>();
        widgets.add(itemId);
        widgets.add(bpEntry);
        widgets.add(spEntry);
        widgets.add(quantityEntry);

        // set layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {0.2, 1.0, 1.0, 1.0, 1.0, 1.0, 0.2, 1.0, 1.0};
        layout.columnWeights = new double[] {1.0, 0.2, 1.0};

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.insets = new Insets(10, 10, 10, 10);
        this.add(itemEntry, gbc0);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 10);
        this.add(bpEntry, gbc1);

        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 0;
        gbc13.gridy = 3;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 10);
        this.add(spEntry, gbc13);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(quantityEntry, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 5;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(submitBtn, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 2;
        gbc4.gridy = 1;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(searchSupplyEntry, gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 2;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(searchSupplyBtn, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 2;
        gbc6.gridy = 4;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemEntry, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 2;
        gbc7.gridy = 5;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemBtn, gbc7);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 0;
        gbc9.gridy = 6;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.gridwidth = 3;
        gbc9.insets = new Insets(0, 10, 0, 10);
        this.add(separator1, gbc9);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 7;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        gbc8.gridwidth = 3;
        this.add(paymentBtn, gbc8);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 8;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(summaryBtn, gbc10);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 2;
        gbc11.gridy = 8;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 10);
        this.add(deleteBtn, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 0;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.gridwidth = 3;
        gbc12.insets = new Insets(0, 10, 0, 10);
        this.add(separator2, gbc12);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 2;
        gbc14.gridy = 3;
        gbc14.fill = GridBagConstraints.BOTH;
        gbc14.insets = new Insets(10, 10, 10, 10);
        this.add(separator0, gbc14);

        this.setVisible(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                if (action())
                {
                    JOptionPane.showMessageDialog(null,
                            "Supply item added successful!",
                            "Supply Assignment",
                            JOptionPane.INFORMATION_MESSAGE);

                    FieldValidator.cleanUp(widgets);

                    ItemDatabaseManager itemManager = new ItemDatabaseManager();

                    Object[][] tableDataArray = supplyTable.tableData(
                            supplyTable.reset());
                    DefaultTableModel model = new DefaultTableModel(
                            tableDataArray, supplyTable.tableColumns);
                    supplyTable.setModel(model);
                }
            }
        });

        searchSupplyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            }
        });

        searchItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            }
        });

        summaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            }
        });
    }

    private boolean action()
    {
        boolean success = false;
        if (FieldValidator.validate(widgets))
        {
            int item = Integer.valueOf(itemId.getText().trim());
            double buyingPrice = Double.valueOf(bpEntry.getText().trim());
            double sellingPrice = Double.valueOf(spEntry.getText().trim());
            int quantity = Integer.valueOf(quantityEntry.getText().trim());

            ItemDatabaseManager itemManager = new ItemDatabaseManager();
            success = itemManager.addSupplyItem(buyingPrice, sellingPrice,
                    quantity, item, parentFrame.id);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null,
                        "Addition of Supply Item Failed!",
                        "Supply Item Assignment",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Please fill in all required fields",
                    "Supply Item Assignment",
                    JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchSupply()
    {
        String SQL = "SELECT itemId, name, description FROM tbl_Instance " +
                "WHERE name LIKE ";

        String search = searchSupplyEntry.getText().trim();
        Object[][] tableDataArray = supplyTable.tableData(
                supplyTable.filterTable(SQL, search));
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                supplyTable.tableColumns);
        supplyTable.setModel(model);
    }

    private void actionSearchItem()
    {
        String search = searchItemEntry.getText().trim();
        String SQL = "SELECT itemId, name, description FROM tbl_Item " +
                "WHERE name LIKE '%" + search + "%' OR " +
                "description LIKE ";

        Object[][] tableDataArray = itemsTable.tableData(
                itemsTable.filterTable(SQL, search));
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                itemsTable.tableColumns);
        itemsTable.setModel(model);
    }
}