package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterSupplierPanel extends JPanel {
    JLabel titleLbl, searchLbl;
    JLabel nameLbl, emailAddressLbl, phoneNoLbl,
            locationAddressLbl, specialtyLbl;
    JTextField nameEntry, emailAddressEntry, specialtyEntry,
            phoneNoEntry, locationAddressEntry, searchEntry;
    JSeparator separator;
    JButton submitBtn, searchBtn;

    CustomTable suppliersTable;
    ArrayList<Object> widgets;

    RegisterSupplierPanel(CustomTable suppliersTable)
    {
        this.suppliersTable = suppliersTable;
        // title
        titleLbl = new JLabel("Register Supplier");

        // supplier registration form
        nameLbl = new JLabel("Organization Name");
        specialtyLbl = new JLabel("Specialty");
        emailAddressLbl = new JLabel("Email Address");
        phoneNoLbl = new JLabel("Phone Number");
        locationAddressLbl = new JLabel("Location Address");

        nameEntry = new JTextField();
        specialtyEntry = new JTextField();
        emailAddressEntry = new JTextField();
        phoneNoEntry = new JTextField();
        locationAddressEntry = new JTextField();

        widgets = new ArrayList<Object>();

        widgets.add(nameEntry);
        widgets.add(specialtyEntry);
        widgets.add(emailAddressEntry);
        widgets.add(phoneNoEntry);
        widgets.add(locationAddressEntry);

        submitBtn = new JButton("submit");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if (action()) {
                    JOptionPane.showMessageDialog(null,
                            "Stock Item Registration Successful!",
                            "Stock Item Registration",
                            JOptionPane.INFORMATION_MESSAGE);

                    FieldValidator.cleanUp(widgets);

                    ItemDatabaseManager itemManager = new ItemDatabaseManager();

                    Object[][] tableDataArray = suppliersTable.tableData(
                            suppliersTable.reset());
                    DefaultTableModel model = new DefaultTableModel(
                            tableDataArray, suppliersTable.tableColumns);
                    suppliersTable.setModel(model);
                }
            }
        });

        // add a separator
        separator = new JSeparator();

        // search section
        searchLbl = new JLabel("SEARCH");
        searchEntry = new JTextField();
        searchBtn = new JButton("submit");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                actionSearchSupplier();
            }
        });

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.2, 1.0, 1.0, 1.0};
        layout.columnWeights = new double[] {0.5, 0.5};

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets = new Insets(10, 10, 10, 10);
        gbc1.gridwidth = 2;
        this.add(titleLbl, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 10, 10, 10);
        this.add(nameLbl, gbc2);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(10, 10, 10, 10);
        this.add(nameEntry, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.fill = GridBagConstraints.BOTH;
        gbc4.insets = new Insets(10, 10, 10, 10);
        this.add(specialtyLbl, gbc4);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 1;
        gbc5.gridy = 2;
        gbc5.fill = GridBagConstraints.BOTH;
        gbc5.insets = new Insets(10, 10, 10, 10);
        this.add(specialtyEntry, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 3;
        gbc6.fill = GridBagConstraints.BOTH;
        gbc6.insets = new Insets(10, 10, 10, 10);
        this.add(emailAddressLbl, gbc6);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 1;
        gbc7.gridy = 3;
        gbc7.fill = GridBagConstraints.BOTH;
        gbc7.insets = new Insets(10, 10, 10, 10);
        this.add(emailAddressEntry, gbc7);

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 4;
        gbc8.fill = GridBagConstraints.BOTH;
        gbc8.insets = new Insets(10, 10, 10, 10);
        this.add(phoneNoLbl, gbc8);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 1;
        gbc9.gridy = 4;
        gbc9.fill = GridBagConstraints.BOTH;
        gbc9.insets = new Insets(10, 10, 10, 10);
        this.add(phoneNoEntry, gbc9);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0;
        gbc10.gridy = 5;
        gbc10.fill = GridBagConstraints.BOTH;
        gbc10.insets = new Insets(10, 10, 10, 10);
        this.add(locationAddressLbl, gbc10);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 1;
        gbc11.gridy = 5;
        gbc11.fill = GridBagConstraints.BOTH;
        gbc11.insets = new Insets(10, 10, 10, 10);
        this.add(locationAddressEntry, gbc11);

        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 0;
        gbc12.gridy = 6;
        gbc12.fill = GridBagConstraints.BOTH;
        gbc12.insets = new Insets(10, 10, 10, 10);
        gbc12.gridwidth = 2;
        this.add(submitBtn, gbc12);

        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 0;
        gbc13.gridy = 7;
        gbc13.fill = GridBagConstraints.BOTH;
        gbc13.insets = new Insets(10, 10, 10, 10);
        gbc13.gridwidth = 2;
        this.add(separator, gbc13);

        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 0;
        gbc14.gridy = 8;
        gbc14.fill = GridBagConstraints.BOTH;
        gbc14.insets = new Insets(10, 10, 10, 10);
        gbc14.gridwidth = 2;
        this.add(searchLbl, gbc14);

        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridx = 0;
        gbc15.gridy = 9;
        gbc15.fill = GridBagConstraints.BOTH;
        gbc15.insets = new Insets(10, 10, 10, 10);
        gbc15.gridwidth = 2;
        this.add(searchEntry, gbc15);

        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridx = 0;
        gbc16.gridy = 10;
        gbc16.insets = new Insets(10, 10, 10, 10);
        gbc16.fill = GridBagConstraints.BOTH;
        gbc16.gridwidth = 2;
        this.add(searchBtn, gbc16);

        this.setVisible(true);
    }

    private boolean action()
    {
        boolean success = false;
        if (FieldValidator.validate(widgets))
        {
            String name = nameEntry.getText().trim();
            String specialty = specialtyEntry.getText().trim();
            String emailAddress = emailAddressEntry.getText().trim();
            String phoneNo = phoneNoEntry.getText().trim();
            String locationAddress = locationAddressEntry.getText().trim();

            SupplierDatabaseManager supplierManager = new SupplierDatabaseManager();
            success = supplierManager.registerSupplier(name, specialty, emailAddress,
                    phoneNo, locationAddress);

            if (!(success))
            {
                JOptionPane.showMessageDialog(null, "Supplier Registration Failed!",
                        "Supplier Registration", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields",
                    "Supplier Registration", JOptionPane.WARNING_MESSAGE);
        }
        return success;
    }

    private void actionSearchSupplier()
    {
        String search = searchEntry.getText().trim();
        String SQL = "SELECT supplierId, name, specialty, " +
                "emailAddress, phoneNumber, locationAddress " +
                "FROM tbl_Supplier WHERE " +
                "name LIKE '%" + search + "%' OR " +
                "specialty LIKE '%" + search + "%' OR " +
                "emailAddress LIKE '%" + search + "%' OR " +
                "phoneNumber LIKE '%" + search + "%' OR " +
                "locationAddress LIKE ";

        Object[][] tableDataArray = suppliersTable.tableData(
                suppliersTable.filterTable(SQL, search));
        DefaultTableModel model = new DefaultTableModel(
                tableDataArray, suppliersTable.tableColumns);
        suppliersTable.setModel(model);
    }
}