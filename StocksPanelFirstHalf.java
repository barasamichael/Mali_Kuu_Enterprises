package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StocksPanelFirstHalf extends JPanel {
    JLabel title, searchInstanceLbl, searchItemLbl, itemLbl, itemDescriptionLbl;
    JButton submitBtn, searchInstanceBtn, searchItemBtn;
    JTextField searchInstanceEntry, searchItemEntry, itemEntry, itemDescriptionEntry;
    JSeparator separator;
    CustomTable itemsTable, stockTable;
    ArrayList<Object> widgets;

    StocksPanelFirstHalf(CustomTable itemsTable, CustomTable stockTable)
    {
        this.itemsTable = itemsTable;
        this.stockTable = stockTable;

        title = new JLabel ("Register Stock Items");
        searchInstanceLbl = new JLabel ("Search Stock");
        searchItemLbl = new JLabel ("Search Stock Item");
        itemLbl = new JLabel ("Enter Name");
        itemDescriptionLbl = new JLabel ("Enter Description");

        submitBtn = new JButton("submit");
        searchInstanceBtn = new JButton("search");
        searchItemBtn = new JButton("search");

        searchInstanceEntry = new JTextField();
        searchItemEntry = new JTextField();
        itemEntry = new JTextField();
        itemDescriptionEntry = new JTextField();

        separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);

        // populate widgets ArrayList
        widgets = new ArrayList<Object>();

        widgets.add(itemEntry);
        widgets.add(itemDescriptionEntry);

        // set layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {1.0, 0.2, 1.0};

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 10);
        this.add(title, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(itemLbl, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(itemEntry, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(itemDescriptionLbl, gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 4;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(itemDescriptionEntry, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 5;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(submitBtn, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 2;
        gbc7.gridy = 0;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemLbl, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 2;
        gbc8.gridy = 1;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemEntry, gbc8);

        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 2;
        gbc9.gridy = 2;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.insets = new Insets(10, 10, 10, 10);
        this.add(searchItemBtn, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 2;
        gbc10.gridy = 3;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(searchInstanceLbl, gbc10);

        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 2;
        gbc11.gridy = 4;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 10);
        this.add(searchInstanceEntry, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 2;
        gbc12.gridy = 5;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.insets = new Insets(10, 10, 10, 10);
        this.add(searchInstanceBtn, gbc12);

        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 1;
        gbc13.gridy = 0;
        gbc13.gridheight = 6;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 10);
        this.add(separator, gbc13);

        this.setVisible(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (action()) {
                    JOptionPane.showMessageDialog(null,
                            "Stock Item Registration Successful!",
                            "Stock Item Registration",
                            JOptionPane.INFORMATION_MESSAGE);

                    FieldValidator.cleanUp(widgets);

                    ItemDatabaseManager itemManager = new ItemDatabaseManager();

                    Object[][] tableDataArray = itemsTable.tableData(
                            itemsTable.reset());
                    DefaultTableModel model = new DefaultTableModel(
                            tableDataArray, itemsTable.tableColumns);
                    itemsTable.setModel(model);
                }
            }
        });

        searchInstanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSearchInstance();
            }
        });

        searchItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSearchItem();
            }
        });
    }

    private boolean action()
    {
        boolean success = false;
        if (FieldValidator.validate(widgets))
        {
            String description = itemEntry.getText().trim();
            String item = itemDescriptionEntry.getText().trim();

            ItemDatabaseManager itemManager = new ItemDatabaseManager();
            success = itemManager.registerItem(item, description);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null, "Stock Item Registration Failed!",
                        "Stock Item Registration", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields",
                    "Stock Item Registration", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchInstance()
    {
        String search = searchInstanceEntry.getText().trim();
        String SQL = "SELECT instance.itemInstanceId, item.name, " +
                "instance.buyingPrice, instance.sellingPrice, " +
                "instance.quantity - IFNULL(SUM(sales.quantity), 0) AS diff " +
                "FROM tbl_Item item INNER JOIN tbl_ItemInstance instance " +
                "ON item.itemId = instance.itemId LEFT JOIN tbl_OrderAssignment " +
                "sales ON instance.itemInstanceId = sales.itemInstanceId " +
                "WHERE  item.name LIKE '%" + search +"%' " +
                "GROUP BY instance.itemInstanceId HAVING diff > 0";

        Object[][] tableDataArray = stockTable.tableData(
                stockTable.filterTable(SQL));
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                stockTable.tableColumns);
        stockTable.setModel(model);
    }

    private void actionSearchItem()
    {
        String search = searchItemEntry.getText().trim();
        String SQL = "SELECT itemId, name, description FROM tbl_Item " +
                "WHERE name LIKE '%" + search + "%' OR " +
                "description LIKE ";

        Object[][] tableDataArray = itemsTable.tableData(itemsTable.filterTable(SQL, search));
        DefaultTableModel model = new DefaultTableModel(tableDataArray, itemsTable.tableColumns);
        itemsTable.setModel(model);
    }
}