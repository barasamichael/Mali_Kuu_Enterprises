package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderSearchItem extends JPanel {
    JTextField itemEntry, bpEntry, quantityEntry, searchStockEntry,
            searchItemEntry, itemId;
    JButton submitBtn, searchStockBtn, searchItemBtn, summaryBtn, deleteBtn,
            paymentBtn;
    JSeparator separator1, separator2;

    CustomTable itemsTable;
    CustomTable orderTable;
    JFramePopUp parentFrame;
    ArrayList<Object> widgets;
    OrderSearchItem(JFramePopUp parentFrame, CustomTable itemsTable, CustomTable orderTable)
    {
        this.parentFrame = parentFrame;
        this.itemsTable = itemsTable;
        this.orderTable = orderTable;

        itemId = new JTextField();
        itemEntry = new JTextField();
        bpEntry = new JTextField();
        quantityEntry = new JTextField();
        submitBtn = new JButton("Add To Cart");

        searchStockEntry = new JTextField();
        searchStockBtn = new JButton("Search Cart");

        searchItemEntry = new JTextField();
        searchItemBtn = new JButton("Search Stock");

        summaryBtn = new JButton("Summary");
        deleteBtn = new JButton("Cancel Order");
        paymentBtn = new JButton("Payment Details");

        separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.HORIZONTAL);

        separator2 = new JSeparator();
        separator2.setOrientation(SwingConstants.HORIZONTAL);

        itemId.setEditable(false);
        itemEntry.setEditable(false);
        bpEntry.setEditable(false);

        // set layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {0.2, 1.0, 1.0, 1.0, 1.0, 0.2, 1.0, 1.0};
        layout.columnWeights = new double[] {1.0, 0.2, 1.0};

        widgets = new ArrayList<Object>();
        widgets.add(itemId);
        widgets.add(quantityEntry);

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

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(quantityEntry, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(submitBtn, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 2;
        gbc4.gridy = 1;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(searchStockEntry, gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 2;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(searchStockBtn, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 2;
        gbc6.gridy = 3;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemEntry, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 2;
        gbc7.gridy = 4;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemBtn, gbc7);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 0;
        gbc9.gridy = 5;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.gridwidth = 3;
        gbc9.insets = new Insets(0, 10, 0, 10);
        this.add(separator1, gbc9);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 6;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        gbc8.gridwidth = 3;
        this.add(paymentBtn, gbc8);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 7;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(summaryBtn, gbc10);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 2;
        gbc11.gridy = 7;
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

        this.setVisible(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt){
                if (action())
                {
                    JOptionPane.showMessageDialog(null,
                            "Order item added successful!",
                            "Order Assignment",
                            JOptionPane.INFORMATION_MESSAGE);

                    FieldValidator.cleanUp(widgets);

                    ItemDatabaseManager itemManager = new ItemDatabaseManager();

                    // refresh contents of order table
                    Object[][] tableDataArrayOne = orderTable.tableData(
                            orderTable.reset());
                    DefaultTableModel modelOne = new DefaultTableModel(
                            tableDataArrayOne, orderTable.tableColumns);
                    orderTable.setModel(modelOne);


                    // refresh contents of items table
                    Object[][] tableDataArrayTwo = itemsTable.tableData(
                            itemsTable.reset());
                    DefaultTableModel modelTwo = new DefaultTableModel(
                            tableDataArrayTwo, itemsTable.tableColumns);
                    itemsTable.setModel(modelTwo);
                }
            }
        });

        searchStockBtn.addActionListener(new ActionListener() {
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
            int quantity = Integer.valueOf(quantityEntry.getText().trim());

            CustomerDatabaseManager customerManager = new CustomerDatabaseManager();
            success = customerManager.addOrderItem(quantity, item, parentFrame.id);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null,
                        "Addition of Order Item Failed!",
                        "Order Item Assignment",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Please fill in all required fields",
                    "Order Item Assignment",
                    JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }
}