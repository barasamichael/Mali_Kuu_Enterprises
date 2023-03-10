package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrder extends JPanel {
    JButton	newOrderBtn, searchBtn;
    JTextField searchEntry;
    JLabel searchLbl;
    JSeparator separator;

    CustomTable ordersTable;
    JFramePopUp parentFrame;

    CreateOrder(CustomTable ordersTable, JFramePopUp parentFrame)
    {
        this.ordersTable = ordersTable;
        this.parentFrame = parentFrame;

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {1.0};
        searchLbl = new JLabel("Search Order");
        searchEntry = new JTextField();
        searchBtn = new JButton("submit");

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                actionSearchOrder();
            }
        });

        separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);

        newOrderBtn = new JButton("New Order");
        newOrderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if (action()) {
                    JOptionPane.showMessageDialog(null,
                            "Order Application Successful!",
                            "Order Application",
                            JOptionPane.INFORMATION_MESSAGE);

                    Object[][] tableDataArray = ordersTable.tableData(
                            ordersTable.reset());
                    DefaultTableModel model = new DefaultTableModel(
                            tableDataArray, ordersTable.tableColumns);
                    ordersTable.setModel(model);
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
        this.add(newOrderBtn, gbc5);

        this.setVisible(true);
    }

    private boolean action()
    {
        boolean success = false;
        CustomerDatabaseManager customerManager = new CustomerDatabaseManager();
        success = customerManager.registerOrder(parentFrame.id);

        if (!(success)) {
            JOptionPane.showMessageDialog(null, "Order Application Failed!",
                    "Order Application", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchOrder()
    {
        String search = searchEntry.getText().trim();
        JFramePopUp parentFrame = (JFramePopUp) SwingUtilities.getWindowAncestor(this);
        String SQL = "SELECT orderId, dateCreated, payment, completed " +
                "FROM tbl_Order WHERE customerId = " +
                parentFrame.id + " AND " +
                "(orderId LIKE '%" + search + "%' OR " +
                " dateCreated LIKE '%"+ search +"%' OR " +
                " payment LIKE '%"+ search +"%' OR " +
                " completed LIKE '%"+ search +"%')";

        Object[][] tableDataArray = ordersTable.tableData(
                ordersTable.filterTable(SQL));
        DefaultTableModel model = new DefaultTableModel(tableDataArray,
                ordersTable.tableColumns);
        ordersTable.setModel(model);
    }
}
